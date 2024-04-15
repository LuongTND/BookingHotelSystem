/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dbcontext.DBContext;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User;
import static model.Validation.validateEmail;
import static model.Validation.validatePassword;


/**
 *
 * @author duclu
 */
@WebServlet(name = "ChangePassword", urlPatterns = {"/ChangePassword"})
public class ChangePassword extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String oldPassword = request.getParameter("OldPass");
        String newPassword = request.getParameter("NewPass");
        String confirmNewPassword = request.getParameter("ConfirmNewPass");

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("userA");
        String userName = user.getUserName();

         if (!validatePassword(newPassword )) {
                request.setAttribute("errorMessage", "Pass is required grather than 6 character ");
                request.getRequestDispatcher("ChangePassword.jsp").forward(request, response);
            } else  if (!newPassword.equals(confirmNewPassword)) {
            String errorMessage = "New password and confirm password do not match.";
            request.setAttribute("errorMessage", errorMessage);
            request.getRequestDispatcher("ChangePassword.jsp").forward(request, response);
            return;
        }

        // Validate the old password
        if (!checkOldPassword(userName, oldPassword)) {
            String errorMessage = "Incorrect old password.";
            request.setAttribute("errorMessage", errorMessage);
            request.getRequestDispatcher("ChangePassword.jsp").forward(request, response);
            return;
        }

        // Update the password in the database
        if (updateChangePassword(newPassword, userName)) {
            String successMessage = "Password has been changed successfully.";
            request.setAttribute("successMessage", successMessage);
            request.getRequestDispatcher("profile.jsp").forward(request, response);
        } else {
            String errorMessage = "Failed to update the password.";
            request.setAttribute("errorMessage", errorMessage);
            request.getRequestDispatcher("ChangePassword.jsp").forward(request, response);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private boolean checkOldPassword(String userName, String oldPassword) {
        try {
            // Thực hiện kiểm tra mật khẩu cũ trong cơ sở dữ liệu
            String sql = "SELECT Pass FROM Account WHERE UserName = ?";
            Connection con = DBContext.getConnection();
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, userName);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                String storedPassword = rs.getString("pass");
                return oldPassword.equals(storedPassword);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean updateChangePassword(String newPassword, String userName) {
        try {
            // Thực hiện cập nhật mật khẩu mới trong cơ sở dữ liệu
            String sql = "UPDATE Account SET Pass = ? WHERE UserName = ?";
            Connection con = DBContext.getConnection();
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, newPassword);
            statement.setString(2, userName);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

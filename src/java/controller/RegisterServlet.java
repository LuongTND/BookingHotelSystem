/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.UserDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;
import static model.Validation.*;

/**
 *
 * @author admin
 */
public class RegisterServlet extends HttpServlet {

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
        String fName = request.getParameter("fullname");
        String gender = request.getParameter("gender");
        String city = request.getParameter("city");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String user = request.getParameter("username");
        String pass = request.getParameter("password");
        String passCon = request.getParameter("confirm_password");
        String idrole = request.getParameter("idrole");
        UserDao dao = new UserDao();
        User ace = dao.checkAccountExist(user);
        User eme = dao.checkEmailExist(email);

       
        if (ace != null) {
            if (idrole.equals("1")) {
                request.setAttribute("mess", "Username already exists. Please try another user name");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            } else if (idrole.equals("3")) {
                request.setAttribute("mess", "Username already exists. Please try another user name");
                request.getRequestDispatcher("manager_account.jsp").forward(request, response);
            }
        } else {
            if (!validatePassword(pass)) {
                request.setAttribute("mess", "Pass is required grather than 6 character ");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            } else if (!passCon.equals(pass)) {

                if (idrole.equals("1")) {
                    request.setAttribute("mess", "Password not match!");
                    request.getRequestDispatcher("register.jsp").forward(request, response);
                } else if (idrole.equals("3")) {
                    request.setAttribute("mess", "Password not match!");
                    request.getRequestDispatcher("manager_account.jsp").forward(request, response);
                }
            } else if (!validateEmail(email)) {

                if (idrole.equals("1")) {
                    request.setAttribute("mess", "Email is required");
                    request.getRequestDispatcher("register.jsp").forward(request, response);
                } else if (idrole.equals("3")) {
                    request.setAttribute("mess", "Email is required");
                    request.getRequestDispatcher("manager_account.jsp").forward(request, response);
                }
            } else if (eme != null) {

                if (idrole.equals("1")) {
                    request.setAttribute("mess", "Email lready exists. Please try another Email");
                    request.getRequestDispatcher("register.jsp").forward(request, response);
                } else if (idrole.equals("3")) {
                    request.setAttribute("mess", "Email lready exists. Please try another Email");
                    request.getRequestDispatcher("manager_account.jsp").forward(request, response);
                }
            } else if (!validatePhoneNumber(phone)) {
                request.setAttribute("mess", "Phone is required 10 digit ");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            } else {
                dao.addAccount(user, pass, fName, gender, city, email, phone, idrole);
                request.setAttribute("loginFail", "You have successfully registered, Login now");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }

        }
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
        processRequest(request, response);
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

}

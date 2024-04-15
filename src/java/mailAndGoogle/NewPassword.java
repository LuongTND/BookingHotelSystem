/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package mailAndGoogle;

import dao.UserDao;
import dbcontext.DBContext;
import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import static model.Validation.validatePassword;

/**
 *
 * @author duclu
 */
@WebServlet(name = "NewPassword", urlPatterns = {"/NewPassword"})
public class NewPassword extends HttpServlet {

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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 HttpSession session = request.getSession();
               
        // Lấy giá trị từ trường nhập mật khẩu mới và xác nhận mật khẩu
        String newPassword = request.getParameter("password");
        String confirmPassword = request.getParameter("confPassword");
        
         if (!validatePassword(newPassword)) {
                request.setAttribute("error", "Pass is required grather than 6 character ");
                request.getRequestDispatcher("NewPassword.jsp").forward(request, response);
            } else
        // Kiểm tra xem mật khẩu mới và xác nhận mật khẩu có khớp nhau hay không
        if (newPassword.equals(confirmPassword)) {
            // Lấy ID người dùng từ session
            //      int userId = (int) request.getSession().getAttribute("IdAccount");
//            
            String emailfg = (String) request.getSession().getAttribute("emailforgot");
            // Thực hiện cập nhật mật khẩu mới trong cơ sở dữ liệu 
            updatePasswordInDatabase(emailfg,newPassword);
            // Chuyển hướng người dùng đến trang thành công
            response.sendRedirect("login.jsp");
        } else {
            // Mật khẩu mới và xác nhận mật khẩu không khớp
            // Gửi thông báo lỗi đến trang NewPassword.jsp
            request.setAttribute("error", "Password and Confirm Password do not match");
            request.getRequestDispatcher("NewPassword.jsp").forward(request, response);
        }
    }

    private void updatePasswordInDatabase(String emailfg ,String newPassword ) {
//        // Thông tin kết nối cơ sở dữ liệu MySQL
//       UserDao ud = new UserDao();

        try {

            // Câu lệnh SQL để cập nhật mật khẩu mới
            String sql = "UPDATE Account SET Pass = ? WHERE Email = ?"; //update Account set UserName=?, Pass=?, FullName=?, Gender=?, City=? , Email=?, Phone=?  where IDAccount = ?

            Connection con = DBContext.getConnection();
            PreparedStatement statement = con.prepareStatement(sql);

            // Thiết lập giá trị tham số trong câu lệnh SQL
            statement.setString(1, newPassword);
//            statement.setInt(2, userId);    // lỗi là vì lúc này chưa đăng nhập đc , phải lấy id từ đoạn nhập gmail để lấy lại pass
            statement.setString(2,emailfg );
//            statement.setInt(2, 1);
            // Thực hiện câu lệnh SQL để cập nhật mật khẩu
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Xử lý ngoại lệ khi không thể cập nhật mật khẩu trong cơ sở dữ liệu
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

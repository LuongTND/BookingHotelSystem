/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package mailAndGoogle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author duclu
 */
@WebServlet(name = "ValidateOTP", urlPatterns = {"/ValidateOTP"})
public class ValidateOTP extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();

        // Lấy mã OTP từ session và mã OTP người dùng nhập vào
        String otpFromSession = (String) session.getAttribute("otp");
        String otpFromUser = request.getParameter("otp");

        if (otpFromUser != null && otpFromSession != null && otpFromUser.equals(otpFromSession)) {
            // Mã OTP hợp lệ, chuyển đến trang index.jsp
            session.removeAttribute("otp"); // Xóa mã OTP từ session sau khi xác nhận
            response.sendRedirect("index.jsp");
        } else {
            // Mã OTP không hợp lệ, chuyển đến trang nhập lại mã OTP
            response.sendRedirect("EnterOTP.jsp?error=1");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package mailAndGoogle;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.Random;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
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
@WebServlet(name = "LoginOTPHandler", urlPatterns = {"/LoginOTPHandler"})
public class LoginOTPHandler extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();

        // Gửi mã OTP qua email
        String email = request.getParameter("email");
        String otp = generateOTP(); // Sinh mã OTP ngẫu nhiên
        sendOTPEmail(email, otp);

        // Lưu mã OTP vào session
        session.setAttribute("otp", otp);
        session.setAttribute("emailLogin", email);

        // Chuyển hướng đến trang nhập mã OTP
        response.sendRedirect("EnterOTPlogin.jsp");
    }

    // Hàm sinh mã OTP ngẫu nhiên
    private String generateOTP() {
        Random random = new Random();
        int otpLength = 6;
        StringBuilder otp = new StringBuilder();

        for (int i = 0; i < otpLength; i++) {
            otp.append(random.nextInt(10));
        }

        return otp.toString();
    }

    // Hàm gửi email chứa mã OTP
    private void sendOTPEmail(String toEmail, String otp) {
        final String fromEmail = "luongtndde160138@fpt.edu.vn";
        final String password = "fmncljydnqfbxrpd"; // Thay thế bằng mật khẩu của tài khoản gửi email

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            message.setSubject("G2Hotel Hello OTP Verification : Login with Google");
            message.setText("Your OTP is: " + otp);
//message.setSubject("uy tin chat luong ");
//             String htmlContent = "<div class=\"modal\" style=\"display:flex; justify-content:center; align-items:center;\">\n" +
//                           
//                            "    </div>";
//            message.setContent(htmlContent, "text/html");
            Transport.send(message);
            System.out.println("OTP email sent successfully!");
        } catch (MessagingException ex) {
            System.out.println("Error sending OTP email: " + ex.getMessage());
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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package mailAndGoogle;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
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
 * @author admin
 */
@WebServlet(name = "sendEmailBooking", urlPatterns = {"/sendEmailBooking"})
public class sendEmailBooking extends HttpServlet {

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
         HttpSession session = request.getSession();
         
         String IDTransaction =(String) session.getAttribute("IDTransaction");
        String TransInfo =(String) session.getAttribute("TransInfo");
        String Email =(String) session.getAttribute("Email");
        sendEmailBooking(Email,IDTransaction,TransInfo);
        
        response.sendRedirect("customer_home.jsp");
    }
     // Hàm gửi email chứa mã OTP
    private void sendEmailBooking(String toEmail, String IDTransaction ,String TransInfo) {
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
            message.setSubject("G2Hotel: Thank you booking 💕💕💕");
            message.setText("Your IDTransaction is: " + IDTransaction +"   Your TransInfo is: " +TransInfo);
            
//            String htmlContent = "<div class=\"modal\" style=\"display:flex; justify-content:center; align-items:center;\">\n" +
//                            "        <div class=\"container\" style=\"width: 600px; height: 808px;\">\n" +
//                            "            <h1 style=\"text-align:center\">G2 Hotel</h1>\n" +
//                            "            <p>If you want to find a place to relax and unwind, come to us, where the most wonderful things are held.\n" +
//                            "                 💕💕💕💕💕💕💕💕💕💕💕💕💕💕💕💕💕💕 \n" +
//                                           
//                            "            </p>\n" +
//                            "            <img class=\"image\" style=\"width: 600px;\" src=\"https://www.google.com/url?sa=i&url=https%3A%2F%2Fvinpearl.com%2Fvi%2Fhotels%2Fvinpearl-resort-golf-nam-hoi-an&psig=AOvVaw3TJ16WqNKbbr02Xq6KOa4S&ust=1689825674403000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCMjE1qvxmYADFQAAAAAdAAAAABAE\">\n" +
//                            "        </div>\n" +
//                            "       <h2> G2Hotel <a href=\"http://localhost:8080/G2HotelV1/customer_home.jsp\" target=\"_blank\" >Website</a> 😍 <h2> \">\n" +
//                            "    </div>";
//             message.setContent(htmlContent, "text/html");  
            Transport.send(message);
            System.out.println("OTP email sent successfully!");
        } catch (MessagingException ex) {
            System.out.println("Error sending email: " + ex.getMessage());
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

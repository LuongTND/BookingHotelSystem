/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.ManagerDao;
import dao.UserDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Booking;
import model.CheckRoomValid;
import model.Discount;
import model.RoomType;

/**
 *
 * @author admin
 */
public class CheckRoomValidServlet extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CheckRoomValidServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CheckRoomValidServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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

        response.setContentType("text/html");
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String formattedTime = currentTime.format(formatter);
        String checkInDateStr = request.getParameter("check_in");
        String checkOutDateStr = request.getParameter("check_out");

        UserDao udao = new UserDao();
        ManagerDao mDao = new ManagerDao();
        
        List<CheckRoomValid> l = udao.checkRoomValid(checkInDateStr, checkOutDateStr);
        List<RoomType> listSearchRoomType = mDao.getRoomType();
//        PrintWriter out = response.getWriter();
//        out.print("<h1>" + l.toString() + "</h1>");

        for (int i = 0; i < l.size(); i++) {
            if (l.get(i).getRoomValid() == 0) {
                listSearchRoomType.remove(i);
            } 
        }
        Discount discount = udao.getDiscountView(formattedTime);
        double discountValue = discount.getDiscountValue()*100;
        
//        PrintWriter out = response.getWriter();
//        out.print("<h1>"+ discount.toString() + "</h1>");

        HttpSession session = request.getSession();
        request.setAttribute("discountValue", discountValue);
        request.setAttribute("discount", discount);
        request.setAttribute("listRoom", listSearchRoomType);
        request.getRequestDispatcher("customer_room.jsp").forward(request, response);

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

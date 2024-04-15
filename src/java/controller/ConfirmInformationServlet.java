/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

//import com.sun.tools.javac.util.JCDiagnostic.Note;
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
import model.BookingDetails;
import model.CheckRoomValid;
import model.Discount;

/**
 *
 * @author admin
 */
public class ConfirmInformationServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ConfirmInformationServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ConfirmInformationServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the
    // + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        UserDao udao = new UserDao();
        ManagerDao mDao = new ManagerDao();

        // bookingtime
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedTime = currentTime.format(formatter);

        String IDAccount = request.getParameter("IDAccount");
        int idac = Integer.parseInt(IDAccount);

        String IDRoomType = request.getParameter("IDRoomType");
        int idrt = Integer.parseInt(IDRoomType);

        String FullName = request.getParameter("FullName");
        String Gender = request.getParameter("Gender");
        String Email = request.getParameter("Email");
        String Phone = request.getParameter("Phone");
        String NameRoomType = request.getParameter("NameRoomType");

        String adult = request.getParameter("Adult");
        int na = Integer.parseInt(adult);
        String child = request.getParameter("Child");
        int nc = Integer.parseInt(child);
        // get total day
        String checkInDateStr = request.getParameter("checkInDate");
        String checkOutDateStr = request.getParameter("checkOutDate");
        LocalDate checkInDate = LocalDate.parse(checkInDateStr);
        LocalDate checkOutDate = LocalDate.parse(checkOutDateStr);
        int numOfDays = (int) ChronoUnit.DAYS.between(checkInDate, checkOutDate);
        // get ngay hien tai de check Day
        LocalDate currentDate = LocalDate.now();

        String nRooms = request.getParameter("numRooms");
        int numRooms = Integer.parseInt(nRooms);

        String price = request.getParameter("Price");
        int tpi = Integer.parseInt(price);
        // double tp = Double.parseDouble(tprice);
        // Total Price
        double tp = numOfDays * numRooms * tpi;
        int idDiscount = 5;

        String DiscountCode = request.getParameter("DiscountCode");
        String mess = "Fail";
        int fail = 0;

        if (DiscountCode == null) {
            tp = numOfDays * numRooms * tpi;
        } else {
            boolean discountMatch = false;
            List<Discount> listDiscount = mDao.getDiscount();
            for (int i = 0; i < listDiscount.size(); i++) {
                String codeDis = listDiscount.get(i).getNote();

                if (DiscountCode.equalsIgnoreCase(codeDis)) {
                    idDiscount = listDiscount.get(i).getIDDiscount();
                    double value = listDiscount.get(i).getDiscountValue();
                    tp = (numOfDays * numRooms * tpi) * (1 - value);
                    discountMatch = true;
                    break;
                }
            }

            if (!discountMatch && DiscountCode.trim().length() > 0) {
                fail = 1;
                mess = "Discount code invalid";
            }
        }
        int totalPriceInt = (int) Math.ceil(tp);

        // out.print("<h1>" + a + "</h1>");

        String Note = "Not Yet";

        // check Room
        String ttRoom = request.getParameter("ttRoom");
        int ttR = Integer.parseInt(ttRoom);
        int checkRoom = ttR - numRooms;
        String cRoom = String.valueOf(checkRoom);

        List<CheckRoomValid> l = udao.checkRoomValid(checkInDateStr, checkOutDateStr);
        int cr = checkRoom;
        for (int i = 0; i < l.size(); i++) {
            if (idrt == l.get(i).getIDRoom()) {
                cr = l.get(i).getRoomValid();

            } else {
                cr = ttR;
            }
        }

        if (cr <= 0 || cr < numRooms) {
            request.setAttribute("messFail", "Not enough room! " + cr + " rooms available");
            request.getRequestDispatcher("form_test.jsp").forward(request, response);
        } else if (checkInDate.isBefore(currentDate) || checkOutDate.isBefore(checkInDate)) {
            request.setAttribute("messFail", "Day Invaild!");
            request.getRequestDispatcher("form_test.jsp").forward(request, response);
        } else if (fail == 1) {
            request.setAttribute("messFail", mess);
            request.getRequestDispatcher("form_test.jsp").forward(request, response);
        } else {
            BookingDetails bookingDt = new BookingDetails(idac, idDiscount, idrt, FullName, Gender, Email, Phone, na,
                    nc, checkInDateStr, checkOutDateStr, numRooms, tp, formattedTime, Note);
            HttpSession session = request.getSession();
            session.setAttribute("BookingDetails", bookingDt);
            request.setAttribute("roomName", NameRoomType);
            request.setAttribute("price", price);
            request.setAttribute("booking", bookingDt);
            request.setAttribute("totalPrice", totalPriceInt);
            request.getRequestDispatcher("form_payment.jsp").forward(request, response);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
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

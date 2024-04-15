/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ManagerDao;
import dao.UserDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.FAQ;

/**
 *
 * @author ptd
 */
public class ReplyFeedbackServlet extends HttpServlet {

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
//        String content = request.getParameter("content");
//        String feedbackId = request.getParameter("feedbackId");
//
//
//        ReplyFeedbackDAO dao = new ReplyFeedbackDAO();
//        String url = "error.jsp";
//        HttpSession session = request.getSession();
//        User user = (User) session.getAttribute("userA");
//        int id = user.getIDAccount();
//        String idStr = Integer.toString(id);
//        dao.addReplyFeedback(idStr, feedbackId, content);
//        request.getRequestDispatcher("showFeedback.jsp").forward(request, response);
//        

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        String content = request.getParameter("content");
        String feedbackId = request.getParameter("txtId");
        String status = "Done";

//        out.print("<h1>" + content+ feedbackId+"</h1>");
        ManagerDao d = new ManagerDao();
        d.updateReplyFeedback(feedbackId, content, status);

        List<FAQ> listFeedback = d.getFeedbacksAdmin();
        
        request.setAttribute("LIST_ADMIN_FFEDBACK", listFeedback);
        request.setAttribute("mess", "Reply success!");
        request.getRequestDispatcher("showFeedback.jsp").forward(request, response);

//        ReplyFeedbackDAO dao = new ReplyFeedbackDAO();
//        FeedbackDAO feedbackDAO = new FeedbackDAO();
//        String url = "error.jsp";
//
//        try {
//            HttpSession session = request.getSession();
//            User user = (User) session.getAttribute("userA");
//            boolean result = dao.insertReplyFeedback(new ReplyFeedback(0, Integer.parseInt(feedbackId), user.getIDAccount(), content));
//
//            if (result) {
//                boolean deleteResult = feedbackDAO.deleteFeedback(Integer.parseInt(feedbackId));
//
//                if (deleteResult) {
//                    List<Feedback> listFeedback = feedbackDAO.getAllFeedback();
//                    session.setAttribute("LIST_ADMIN_FFEDBACK", listFeedback);
//
//                    request.setAttribute("REPLY_SUCUESS", "success");
//                    url = "showFeedback.jsp";
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            request.getRequestDispatcher(url).forward(request, response);
//        }
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

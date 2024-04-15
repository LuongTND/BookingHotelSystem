///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
// */
//package controller;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// *
// * @author admin
// */
//@WebServlet(urlPatterns = { "/sendMail"
//})
//public class SendMailServlet extends HttpServlet {
//    private static final long serialVersionUID = 1L;
//
//    protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { 
//    req.getRequestDispatcher ("customer_contact.jsp") . forward(req, resp); 
//    }
//
//protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { 
//req.getRequestDispatcher ("customer_contact.jsp") . forward(req, resp);
//
//protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { |
//req.setCharacterEncoding ("utf-8"); 3
//resp.setCharacterEncoding ("utf-8"); 1
//
//final String username = "tgbinh@gmail.com"; |
//
//f£inal String password = "aaaaaaaaaaaaa"; §
//Properties props = new Properties();
//Props.put ("mail.smtp.host", "smtp.gmail.com”); 3
//props.put ("mail.smtp.port”, "587%); i
//props.put ("mail.smtp.auth”, "true"); §
//Pprops.put ("mail.smtp.starttls.enable”, "true"); i
<%@page import="model.BookingDetails"%>
<%@page import="model.User"%>
<%@page import="model.RoomType"%>
<%@page import="dao.UserDao"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.nio.charset.StandardCharsets"%>
<%@page import="config.Config"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <meta name="description" content="">
        <meta name="author" content="">
        <title>VNPAY RESPONSE</title>
        <!-- Bootstrap core CSS -->
        <link href="/vnpay_jsp/assets/bootstrap.min.css" rel="stylesheet"/>
        <!-- Custom styles for this template -->
        <link href="/vnpay_jsp/assets/jumbotron-narrow.css" rel="stylesheet"> 
        <script src="/vnpay_jsp/assets/jquery-1.11.3.min.js"></script>
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
            crossorigin="anonymous"
            />
        <style>
            @media only screen and (max-width: 800px) {
                #no-more-tables tbody, #no-more-tables tr, #no-more-tables td {
                    display: block;
                }
                #no-more-tables thead tr {
                    position: absolute;
                    top: -9999px;
                    left: -9999px;
                }

                #no-more-tables td {
                    position: relative;
                    padding-left: 40%;
                    border: none;
                }
                #no-more-tables td::before {
                    content: attr(data-title);
                    position: absolute;
                    left: 6px;
                    font-weight: bold;
                }

                #no-more-tables tr {
                    border-bottom: 1px solid #ccc;
                }
            }
        </style>
    </head>
    <body>
        <%
            //Begin process return from VNPAY
            Map fields = new HashMap();
            for (Enumeration params = request.getParameterNames(); params.hasMoreElements();) {
                String fieldName = URLEncoder.encode((String) params.nextElement(), StandardCharsets.US_ASCII.toString());
                String fieldValue = URLEncoder.encode(request.getParameter(fieldName), StandardCharsets.US_ASCII.toString());
                if ((fieldValue != null) && (fieldValue.length() > 0)) {
                    fields.put(fieldName, fieldValue);
                }
            }

            String vnp_SecureHash = request.getParameter("vnp_SecureHash");
            if (fields.containsKey("vnp_SecureHashType")) {
                fields.remove("vnp_SecureHashType");
            }
            if (fields.containsKey("vnp_SecureHash")) {
                fields.remove("vnp_SecureHash");
            }
            String signValue = Config.hashAllFields(fields);

        %>
        <!--Begin display -->
<form  action="sendEmailBooking" method="POST">
        <section class="bg-light p-5">
            <h3 class="pb-2 text-center">PAYMENT RESULT</h3>
            <div class="table-responsive" id="no-more-tables">
                <table class="table bg-white">
                    <thead class="bg-success text-light">
                        <tr>
                            <th>IDTransaction</th>
                            <th>Booking information</th>
                            <th>Amount</th>
                            <th>Bank</th>
                            <th>Pay Date</th>
                            <th>Payment status</th>
                        </tr>
                    </thead>
                    <tbody>
                    <td data-title="IDTransaction"><%=request.getParameter("vnp_TxnRef")%></td>
                    <td data-title="Booking information"><%=request.getParameter("vnp_OrderInfo")%></td>
                    <td data-title="Amount"><%=request.getParameter("vnp_Amount")%></td>
                    <td data-title="Bank"><%=request.getParameter("vnp_BankCode")%></td>
                    <td data-title="Pay Date"><%=request.getParameter("vnp_PayDate")%></td>
                    <td data-title="Payment status"><%

                        UserDao dao = new UserDao();
                        String IDTransaction = request.getParameter("vnp_TxnRef");
                        
                        session.setAttribute("IDTransaction", IDTransaction);
        //                            String IDBooking = request.getParameter(name);
                        String IDPayment = "1";
                        String TransInfo = request.getParameter("vnp_OrderInfo");
                       session.setAttribute("TransInfo", TransInfo);
                        session.getAttribute("TransInfo");
                        String TransTime = request.getParameter("vnp_PayDate");
                        String TransStatus = request.getParameter("vnp_TransactionStatus");
        //                            dao.addTransaction(IDTransaction, IDBooking, IDPayment, TransInfo, TransTime, TransStatus);
                        User account = (User) session.getAttribute("userA");
                        RoomType room = (RoomType) session.getAttribute("r");
                        String IDAccount = String.valueOf(account.getIDAccount());

                        String IDRoomType = String.valueOf(room.getIDRoomType());
                        String FullName = account.getFullName();
                        String Gender = account.getGender();
                        String Email = account.getEmail();
                        session.setAttribute("Email", Email);
                        String Phone = account.getPhone();
                        BookingDetails bookingDetails = (BookingDetails) session.getAttribute("BookingDetails");
                        String IDiscount = String.valueOf(bookingDetails.getIDDiscount());
                        String Adult = String.valueOf(bookingDetails.getAdult());
                        String Child = String.valueOf(bookingDetails.getChild());
                        String CheckIn = String.valueOf(bookingDetails.getCheckIn());
                        String CheckOut = String.valueOf(bookingDetails.getCheckOut());
                        String NumberOfRoom = String.valueOf(bookingDetails.getNumberOfRooms());
                        String TotalPrice = String.valueOf(request.getParameter("vnp_Amount"));
                        String BookingTime = String.valueOf(bookingDetails.getBookingTime());
                        String Note = String.valueOf(bookingDetails.getNote());
                        String status = "";
                        if (signValue.equals(vnp_SecureHash)) {
                            if ("00".equals(request.getParameter("vnp_TransactionStatus"))) {
                                out.print("Success");
                                status = "Success";
                                dao.addBookingDetails(IDAccount, IDiscount, IDRoomType, FullName, Gender, Email, Phone, Adult, Child, CheckIn, CheckOut, NumberOfRoom, TotalPrice, BookingTime, Note);
                                dao.addTransaction(IDTransaction, IDPayment, TransInfo, BookingTime, status);
                            } else {
                                out.print("Failed");
                                status = "Failed";
                            }

                        } else {
                            out.print("invalid signature");
                        }
                        %></td>
                    </tbody>
                </table>
            </div>
<!--            <a href="/G2HotelV1/customer_home.jsp" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Return home</a>-->
<button type="submit"  class="btn btn-primary btn-lg active" name="submit"   >Return homer</button>
        </section>
                               </form>
    </body>
</html>


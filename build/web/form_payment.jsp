<%-- 
    Document   : form_payment
    Created on : Jun 8, 2023, 9:20:49 PM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="icon" href="image/favicon.png" type="image/png">
        <title>G2 Hotel</title>
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="vendors/linericon/style.css">
        <link rel="stylesheet" type="text/css" href="css/font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="vendors/owl-carousel/owl.carousel.min.css">
        <link rel="stylesheet" type="text/css" href="vendors/bootstrap-datepicker/bootstrap-datetimepicker.min.css">
        <link rel="stylesheet" type="text/css" href="vendors/nice-select/css/nice-select.css">
        <link rel="stylesheet" type="text/css" href="vendors/owl-carousel/owl.carousel.min.css">
        <!-- main css -->
        <link rel="stylesheet" href="css/room_bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <link rel="stylesheet" type="text/css" href="css/responsive.css">

    </head>
    <body>
        <%@include file="/includes/header.jsp" %>
        <!--================Breadcrumb Area =================-->
        <section class="breadcrumb_area">
            <div class="overlay bg-parallax" data-stellar-ratio="0.8" data-stellar-vertical-offset="0" data-background=""></div>
            <div class="container">
                <div class="page-cover text-center">
                    <h2 class="page-cover-tittle">Payment</h2>
                    <ol class="breadcrumb">
                        <li><a href="index.html">Home</a></li>
                        <li class="active">About</li>
                    </ol>
                </div>
            </div>
        </section>
        <!--================Breadcrumb Area =================-->
        <br>

        <h1 style="text-align: center;">Payment Room</h1>

        <form action="ajaxServlet" id="bookingForm" class="col-md-9 m-auto" name="myForm" method="post">
            
            <input type="hidden" id="IDAccount" name="IDAccount" value="${booking.getIDAccount()}">
            <input type="hidden" id="IDRoomType" name="IDRoomType" value="${booking.getIDRoomType()}">
            <input type="hidden" id="IDDiscount" name="IDDiscount" value="${booking.getIDDiscount()}">
            
            <div class="row">
                <div class="form-group col-md-6 mb-3">
                    <label for="inputname">Name:</label>
                    <input type="text" class="form-control mt-1" id="FullName" name="FullName" placeholder="Name" value="${booking.getFullName()}" readonly>
                </div>
                <div class="form-group col-md-6 mb-3">
                    <label for="inputname">Gender:</label>
                    <input type="text" class="form-control mt-1" id="Gender" name="Gender" placeholder="Gender" value="${booking.getGender()}" readonly>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-md-6 mb-3">
                    <label for="inputname">Phone:</label>
                    <input type="text" class="form-control mt-1" id="Phone" name="Phone" placeholder="Phone" value="${booking.getPhone()}" readonly>
                </div>
                <div class="form-group col-md-6 mb-3">
                    <label for="inputname">Email:</label>
                    <input type="text" class="form-control mt-1" id="Email" name="Email" placeholder="Email" value="${booking.getEmail()}" readonly>
                </div>
            </div>
            <hr>
            
            <div class="row">
                <div class="form-group col-md-6">
                    <label for="inputname">Room Type:</label>
                    <input type="text" class="form-control mt-1" id="NameRoomType" name="NameRoomType" value="${requestScope.roomName}" readonly/>
                </div>
                <div class="form-group col-md-6 mb-3">
                    <label for="inputname">Price:</label>
                    <input type="text" class="form-control mt-1" id="Price" name="Price" placeholder="Price" value="${requestScope.price}" readonly/>
                </div>
            </div>

            <div class="row">
                <div class="form-group col-md-6">
                    <label for="inputname">Adult: (Old 13+)</label>
                    <input type="number" class="form-control mt-1" id="Adult" name="Adult" value="${booking.getAdult()}" readonly/>
                </div>
                <div class="form-group col-md-6 mb-3">
                    <label for="inputname">Child:Old 5-13</label>
                    <input type="number" class="form-control mt-1" id="Child" name="Child" value="${booking.getChild()}" readonly/>
                </div>
            </div>

            <div class="row">
                <div class="form-group col-md-6">
                    <label for="checkInDate">Check-In:</label><br>
                    <input type="date" class="form-control" name="checkInDate" id="check_in" value="${booking.getCheckIn()}"readonly />
                    <span id="checkInDate" style="color: red;" class="error"></span>
                </div>
                <div class="form-group col-md-6 mb-3">
                    <label for="checkOutDate">Check-Out:</label><br>
                    <input type="date" class="form-control" name="checkOutDate" id="check_out" value="${booking.getCheckOut()}" readonly/>
                </div>
            </div>


            <div class="row">
                <div class="form-group col-md-6">
                    <label for="numRooms">Quantity:</label><br>
                    <input type="number" class="form-control mt-1" id="numRooms" name="numRooms" value="${booking.getNumberOfRooms()}" readonly/>
                </div>


                <div class="form-group col-md-6 mb-3">
                    <label for="inputname">Total Price</label>
                    <input type="text" class="form-control mt-1" id="TotalPrice" name="TotalPrice" value="${requestScope.totalPrice}" readonly>
                </div>
            </div>


              <div class="row">
                <div class="col-md-12 form-group">
                    <h5>Payment method</h5>
                    <input type="radio" id="bankCode" name="bankCode" value="NCB" required>
                    <label for="bankCode">VNPAY</label><br>
                </div>
                <div class="col text-end mt-2">
                    <button type="submit" class="btn btn-success btn-lg px-3">Book Now</button>
                </div>           

            </div>

                
        </form>
        <br>
        <%@include file="/includes/footer.jsp" %>
        
        
        <!--<script src="js/formValidation.js" type="text/javascript"></script>-->
        <link href="https://pay.vnpay.vn/lib/vnpay/vnpay.css" rel="stylesheet" />
        <script src="https://pay.vnpay.vn/lib/vnpay/vnpay.min.js"></script>
        <script type="text/javascript">
            $("#bookingForm").submit(function() { //thực hiện hàm khi form có id frmCreateOrder đc submit
                //AJAX (asynchornous javascript and xml) phương thức java script cho phép gửi request http đến server bất đồng bộ và nhận phản hồi từ server mà 
                //KHÔNG CẦN TẢI LẠI
                var postData = $("#bookingForm").serialize(); //lấy dữ liệu từ form và biến đỏi thành định dạng phù hợp (serialize)
                var submitUrl = $("#bookingForm").attr("action"); //lấy dữ liệu từ attribute ACTION của form. cụ thể là đường dẫn đến submit url
                $.ajax({//yêu cầu ajax gửi đến server 
                    type: "POST",
                    url: submitUrl,
                    data: postData,
                    dataType: 'JSON',
                    success: function (x) { //sau khi nhận phản hồi từ server. hàm callback này đc thực thi
                        if (x.code === '00') { //phản hồi từ server. mã này xử lý dữ liệu trong hàm success
                            if (window.vnpay) { //nếu biến vnpay đc khai báo trong phạm vi toàn cục (global scope)
                                vnpay.open({width: 768, height: 600, url: x.data});
                            } else {
                                location.href = x.data;
                            }
                            return false;
                        } else {
                            alert(x.Message);
                        }
                    }
                });
                return false;
            });
        </script>      
        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="js/jquery-3.2.1.min.js"></script>
        <script src="js/popper.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="vendors/owl-carousel/owl.carousel.min.js"></script>
        <script src="js/jquery.ajaxchimp.min.js"></script>
        <script src="js/mail-script.js"></script>
        <script src="vendors/bootstrap-datepicker/bootstrap-datetimepicker.min.js"></script>
        <script src="vendors/nice-select/js/jquery.nice-select.js"></script>
        <script src="js/mail-script.js"></script>
        <script src="js/stellar.js"></script>
        <script src="vendors/lightbox/simpleLightbox.min.js"></script>
        <script src="js/custom.js"></script>
    </body>
</html>

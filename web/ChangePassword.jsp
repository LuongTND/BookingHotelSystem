<%-- 
    Document   : ChangePassword
    Created on : Jul 6, 2023, 5:27:41 PM
    Author     : duclu
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


        <c:if test="${sessionScope.userA.IDRole == 1}">
            <%@include file="/includes/header.jsp" %>
        </c:if>
        <c:if test="${sessionScope.userA.IDRole == 2}">
            <%@include file="/includes/manager_header.jsp" %>
        </c:if>
        <c:if test="${sessionScope.userA.IDRole == 3}">
            <%@include file="/includes/receptionist_header.jsp" %>
        </c:if>

        <!--================Breadcrumb Area =================-->
        <section class="breadcrumb_area">
            <div class="overlay bg-parallax" data-stellar-ratio="0.8" data-stellar-vertical-offset="0" data-background=""></div>
            <div class="container">
                <div class="page-cover text-center">
                    <h2 class="page-cover-tittle">My Profile</h2>
                    <ol class="breadcrumb">
                        <li><a href="index.html">Home</a></li>
                        <li class="active">About</li>
                    </ol>
                </div>
            </div>
        </section>
        <!--================Breadcrumb Area =================-->
        <br>
        <h2 style="color: green; text-align: center;" >${editProfile} </h2> 

        <form action="ChangePassword" method="post" >
            <div class="container rounded bg-white mt-5 mb-5">
                <div class="row">
                    <div class="col-md-3 border-right">
                        <div class="d-flex flex-column align-items-center text-center p-3 py-5"><img class="rounded-circle mt-5" width="150px" src="https://st3.depositphotos.com/15648834/17930/v/600/depositphotos_179308454-stock-illustration-unknown-person-silhouette-glasses-profile.jpg"><span class="font-weight-bold">${userA.getFullName()}</span><span class="text-black-50"></span><span> </span></div>
                    </div>
                    <div class="col-md-5 border-right">
                        <div class="p-3 py-5">
                            <div class="d-flex justify-content-between align-items-center mb-3">
                                <h4 class="text-right">Change Password</h4>
                                <c:if test="${not empty successMessage}">
                                    <div style="color: green; text-align: center;">${successMessage}</div>
                                </c:if>
                                <c:if test="${not empty errorMessage}">
                                    <div style="color: red; text-align: center;">${errorMessage}</div>
                                </c:if>
                            </div>

                            <div class="row mt-3">

                                <div class="card card-body">
                                    <div class="form-group">
                                        <label class="labels">Old Password</label>
                                        <input type="password"id="passwordField" name="OldPass" class="form-control">

                                    </div>
                                    <p class="text-sm">Do you <a href="forgotPassword.jsp" target="_blank"
                                                                 class="text-red-700 hover:underline">Forgot Password</a></p>
                                    <div class="form-group">
                                        <label class="labels">New Password</label>
                                        <input type="password" id="passwordField" name="NewPass" class="form-control">

                                    </div>
                                    <div class="form-group">
                                        <label class="labels">Confirm New Password</label>
                                        <input type="password" id="passwordField" name="ConfirmNewPass" class="form-control">
                                        <span id="passwordError"></span>
                                    </div>
                                    <div style="display: flex;">
                                        <input type="checkbox"id="showPasswordCheckbox" onclick="togglePasswordVisibility()" style="width: 2%;" >
                                        <lable for="showPasswordCheckbox" style="font-family: Arial, sans-serif;   font-size: 14px;">    Show Password </lable>
                                    </div>
                                    <button type="submit" style="background-color: wheat">Change Password</button>
                                </div>


                            </div>
                        </div>
                    </div>

                    <div class="col-md-4">
                        <div class="p-3 py-5">
                            <div class="d-flex justify-content-between align-items-center experience"><span>History Booking</span><span class="border px-3 p-1 add-experience"><a href="showRoomCustomer"><i class="fa fa-plus"></i>&nbsp;Booking</a></span></div><br>
                            <div class="col-md-12"><label class="labels">Start Day</label><input type="text" class="form-control" placeholder="Start Day" value=""></div> <br>
                            <div class="col-md-12"><label class="labels">End Day</label><input type="text" class="form-control" placeholder="End Day" value=""></div> <br>
                            <div class="col-md-12"><label class="labels">Room Type</label><input type="text" class="form-control" placeholder="Room Type" value=""></div> <br>
                            <div class="col-md-12"><label class="labels">Number Of Room</label><input type="text" class="form-control" placeholder="Number Of Room" value=""></div> <br>
                            <div class="col-md-12"><label class="labels">Total Price</label><input type="text" class="form-control" placeholder="Total Price" value=""></div> <br>
                        </div>
                    </div>
                </div>
            </div>
        </form>
        <br>

        <%@include file="/includes/footer.jsp" %>
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

    <script>



                                            function togglePasswordVisibility() {
                                                var passwordFields = document.querySelectorAll('input[type="password"]');
                                                var showPasswordCheckbox = document.getElementById("showPasswordCheckbox");

                                                var passwordFieldType = showPasswordCheckbox.checked ? "text" : "password";
                                                passwordFields.forEach(function (passwordField) {
                                                    passwordField.type = passwordFieldType;
                                                });
                                            }



    </script>

</html>

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
        <style>
            .required-field {
    color: red;
    font-weight: bold;
}
        </style>
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

        <form action="editProfile" method="get">

            <div class="container rounded bg-white mt-5 mb-5">
                <div class="row">
                    <div class="col-md-3 border-right">
                        <div class="d-flex flex-column align-items-center text-center p-3 py-5"><img class="rounded-circle mt-5" width="150px" src="https://st3.depositphotos.com/15648834/17930/v/600/depositphotos_179308454-stock-illustration-unknown-person-silhouette-glasses-profile.jpg"><span class="font-weight-bold">${userA.getFullName()}</span><span class="text-black-50"></span><span> </span></div>
                    </div>
                    <div class="col-md-5 border-right">
                        <div class="p-3 py-5">
                            <div class="d-flex justify-content-between align-items-center mb-3">
                                <h4 class="text-right">Profile Settings</h4>
                            </div>
                            
                            
                                                                 <div class="alert alert-danger" role="alert">
                            <p style="color: red; font-family: sans-serif"class="text-danger">${messP} </p>
                        </div>
                            

                            <div class="row mt-3">
                                <div class="col-md-12"><input type="hidden" name="IDAccount" class="form-control"  value="${userA.getIDAccount()}"></div>
                                <div class="col-md-12"><label class="labels">Full Name<span class="required-field">*</span></label><input type="text" name="FullName" class="form-control"  value="${userA.getFullName()}"></div>
                                <div class="col-md-12"><label class="labels">Phone Number<span class="required-field">*</span></label><input type="text" name="Phone" class="form-control"  value="${userA.getPhone()}"></div>
                                <div class="col-md-12"><label class="labels">Email<span class="required-field">*</span></label><input type="text" name="Email" class="form-control"value="${userA.getEmail()}"></div>
                                <div class="col-md-6"><label class="labels">City<span class="required-field">*</span></label><input type="text" name="City" class="form-control" value="${userA.getCity()}"></div>
<!--                                <div class="col-md-6"><label class="labels">Gender</label><input type="text" name="Gender" class="form-control" value="${userA.getGender()}" ></div>-->
                                <div class="col-md-6">
                                    <label class="labels">Gender</label>
                                    <select name="Gender" class="form-control " >
                                        <option value="female" ${userA.getGender() == 'female' ? 'selected' : ''}>Female</option>
                                        <option value="male" ${userA.getGender() == 'male' ? 'selected' : ''}>Male</option>
                                        <option value="others" ${userA.getGender() == 'others' ? 'selected' : ''}>Others</option>
                                    </select>
                                </div>

                            </div>
                            <div class="row mt-3">
                                 <div class="col-md-12"><label class="labels">User Name<span class="required-field">*</span></label><input type="text" name="UserName" class="form-control"value="${userA.getUserName() }"></div>
                                <div class="col-md-12">
                                    
                                    <label class="labels">Password</label>
<!--///////////////////////////    them nut thay doi mk-->
                                    <div class="input-group">
<!--                                        <input type="password" name="Pass" class="form-control" value="${userA.getPass()}" readonly>không thể họ nhìn thấy độ dài mật khẩu-->
                                        <input type="password" name="Pass" class="form-control" value="${userA.getPass()}"placeholder="*********" readonly>
                                        
             
                                        <div class="input-group-append">
                                            <a href="ChangePassword.jsp" class="btn btn-primary "  style="background-color : wheat"  >
                                                Change Password
                                            </a>
                                        </div>
                                    </div>
                              
                                </div>

                            </div>
                            <div class="mt-5 text-center"><button class="btn btn-primary profile-button" type="submit">Save Profile</button></div>
                        </div>
                    </div>

                    <div class="col-md-4">
                        <div class="p-3 py-5">
                            <div class="d-flex justify-content-between align-items-center experience"><span>History Booking</span><span class="border px-3 p-1 add-experience"><a href="viewBookingHistory"><i class="fa fa-plus"></i>&nbsp;Show history</a></span></div><br>
                            <!-- <div class="col-md-12"><label class="labels">Start Day</label><input type="text" class="form-control" placeholder="Start Day" value=""></div> <br>
                            <div class="col-md-12"><label class="labels">End Day</label><input type="text" class="form-control" placeholder="End Day" value=""></div> <br>
                            <div class="col-md-12"><label class="labels">Room Type</label><input type="text" class="form-control" placeholder="Room Type" value=""></div> <br>
                            <div class="col-md-12"><label class="labels">Number Of Room</label><input type="text" class="form-control" placeholder="Number Of Room" value=""></div> <br>
                            <div class="col-md-12"><label class="labels">Total Price</label><input type="text" class="form-control" placeholder="Total Price" value=""></div> <br> -->
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
</html>

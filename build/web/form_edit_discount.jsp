<%-- 
    Document   : form_edit_discount
    Created on : Jul 15, 2023, 12:18:34 AM
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
        <%@include file="/includes/manager_header.jsp" %>
        <!--================Breadcrumb Area =================-->
        <section class="breadcrumb_area">
            <div class="overlay bg-parallax" data-stellar-ratio="0.8" data-stellar-vertical-offset="0" data-background=""></div>
            <div class="container">
                <div class="page-cover text-center">
                    <h2 class="page-cover-tittle">Edit Room</h2>
                    <ol class="breadcrumb">
                        <li><a href="index.html">Home</a></li>
                        <li class="active">About</li>
                    </ol>
                </div>
            </div>
        </section>
        <!--================Breadcrumb Area =================-->
        <br>

        <h1 style="text-align: center;">Edit DISCOUNT</h1>

        <form action="editDiscount" class="col-md-9 m-auto" method="get" role="form">
            <div class="row">
                <div class="form-group col-md-6 mb-3">
                    <label for="inputname">ID</label><br>
                    <label for="inputname">${d.getIDDiscount()}</label>
                    <input type="hidden" name="IDDiscount" value="${d.getIDDiscount()}">
                </div>
                <div class="form-group col-md-6 mb-3">
                    <label for="inputname">Discount Name</label>
                    <input type="text" class="form-control mt-1" id="DiscountName" name="DiscountName" value="${d.getDiscountName()}" required>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-md-6 mb-3">
                    <label for="inputname">Discount Value</label>
                    <input type="text" class="form-control mt-1" id="DiscountValue" name="DiscountValue" value="${d.getDiscountValue()}" required>
                </div>
                <div class="form-group col-md-6 mb-3">
                    <label for="inputname">Code</label>
                    <input type="text" class="form-control mt-1" id="Note" name="Note" value="${d.getNote()}" required>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-md-6">
                    <div class="form-group">
                        <div class='input-group date' id='datetimepicker11'>
                            <input type='text' class="form-control" name="StartDay" value="${d.getStartDay()}"/>
                            <span class="input-group-addon">
                                <i class="fa fa-calendar" aria-hidden="true"></i>
                            </span>
                        </div>
                    </div>
                </div>                    
                <div class="form-group col-md-6 mb-3">
                    <div class="form-group">
                        <div class='input-group date' id='datetimepicker1' >
                            <input type='text' class="form-control" name="EndDay" value="${d.getEndDay()}"/>
                            <span class="input-group-addon">
                                <i class="fa fa-calendar" aria-hidden="true"></i>
                            </span>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col text-end mt-2">
                    <button type="submit" class="btn btn-success btn-lg px-3">Update Discount</button>
                </div>
            </div><br>
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

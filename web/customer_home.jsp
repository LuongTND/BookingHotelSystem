<%-- Document : customer_home Created on : May 29, 2023, 11:45:53 PM Author : TuaSan --%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@page contentType="text/html" pageEncoding="UTF-8" %>
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
                <link rel="stylesheet" type="text/css"
                    href="vendors/bootstrap-datepicker/bootstrap-datetimepicker.min.css">
                <link rel="stylesheet" type="text/css" href="vendors/nice-select/css/nice-select.css">
                <link rel="stylesheet" type="text/css" href="vendors/owl-carousel/owl.carousel.min.css">
                <!-- main css -->
                <link rel="stylesheet" type="text/css" href="css/style.css">
                <link rel="stylesheet" type="text/css" href="css/responsive.css">
            </head>

            <body>
                <%@include file="/includes/header.jsp" %>
                    <input type="hidden" class="form-control mt-1" id="IDAccount" name="IDAccount"
                        value="${sessionScope.idAccount}">
                    <section class="banner_area">
                        <div class="booking_table d_flex align-items-center">
                            <div class="overlay bg-parallax" data-stellar-ratio="0.9" data-stellar-vertical-offset="0"
                                data-background=""></div>
                            <div class="container">
                                <div class="banner_content text-center">
                                    <h3>Find Your Happiness & Peace</h3>
                                      <h6>There is no path to happiness</h6>
                                      <h6>Happiness is the path</h6>
                                </div>
                            </div>
                        </div>
                        <div class="hotel_booking_area position">
                            <div class="container">
                                <div class="hotel_booking_table">
                                    <%@include file="/includes/search_room.jsp" %>
                                </div>
                            </div>
                        </div>
                    </section>
                    <!--================Banner Area =================-->

                    <!--================ Facilities Area  =================-->
                    <%@include file="/includes/facilities.jsp" %>
                    <!--================ Facilities Area  =================-->

                    <!--================ View Discount  =================-->
                  
                    <!--================ View Discount  =================-->

                    <!--================ Testimonial Area  =================-->
                     <%@include file="/includes/testimonial.jsp" %>
                   <!--================ Testimonial Area  =================-->
                   

                    <!--================ Latest Blog Area  =================-->
                    <section class="latest_blog_area section_gap">
                        <div class="container">
                            <div class="section_title text-center">
                                <h2 class="title_color">Latest posts from blog</h2>
                                <p> From eco-friendly packing suggestions to supporting local communities, 
                                    we provide insights and actionable steps to help you embark on your next adventure with a clear conscience</p>
                            </div>
                            <div class="row mb_30">
                                <div class="col-lg-4 col-md-6">
                                    <div class="single-recent-blog-post">
                                        <div class="thumb">
                                            <img class="img-fluid blog-img" src="https://images.unsplash.com/photo-1615880484746-a134be9a6ecf?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=774&q=80" alt="post">
                                        </div>
                                        <div class="details">
                                            <div class="tags">
                                                <a href="#" class="button_hover tag_btn">Travel</a>
                                                <a href="#" class="button_hover tag_btn">Life Style</a>
                                            </div>
                                            <a href="#">
                                                <h4 class="sec_h4">Low Cost Advertising</h4>
                                            </a>
                                            <p>Acres of Diamonds… you’ve read the famous story, or at least had it
                                                related to you. A farmer.</p>
                                            <h6 class="date title_color">31st January,2023</h6>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-4 col-md-6">
                                    <div class="single-recent-blog-post">
                                        <div class="thumb">
                                            <img class="img-fluid blog-img" src="https://images.unsplash.com/photo-1600011689032-8b628b8a8747?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=774&q=80" alt="post">
                                        </div>
                                        <div class="details">
                                            <div class="tags">
                                                <a href="#" class="button_hover tag_btn">Travel</a>
                                                <a href="#" class="button_hover tag_btn">Life Style</a>
                                            </div>
                                            <a href="#">
                                                <h4 class="sec_h4">Creative Outdoor Ads</h4>
                                            </a>
                                            <p>Self-doubt and fear interfere with our ability to achieve or set goals.
                                                Self-doubt and fear are</p>
                                            <h6 class="date title_color">31st January,2023</h6>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-4 col-md-6">
                                    <div class="single-recent-blog-post">
                                        <div class="thumb">
                                            <img class="img-fluid blog-img" src="https://images.unsplash.com/photo-1606402179428-a57976d71fa4?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=774&q=80" alt="post">
                                        </div>
                                        <div class="details">
                                            <div class="tags">
                                                <a href="#" class="button_hover tag_btn">Travel</a>
                                                <a href="#" class="button_hover tag_btn">Life Style</a>
                                            </div>
                                            <a href="#">
                                                <h4 class="sec_h4">It S Classified How To Utilize Free</h4>
                                            </a>
                                            <p>Why do you want to motivate yourself? Actually, just answering that
                                                question fully can </p>
                                            <h6 class="date title_color">31st January,2023</h6>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </section>
                    <!--================ Recent Area  =================-->

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
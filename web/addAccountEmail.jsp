<%-- 
    Document   : addAccountEmail
    Created on : Jul 19, 2023, 12:53:42 AM
    Author     : duclu
--%>

<%--<%@page contentType="text/html" pageEncoding="UTF-8"%>--%>
<!--<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Cảm ơn bạn đã đăng nhập và trải nghiệm dịch vụ G2 Hotel. Hãy cập nhật thông tin tài khoản.</h1>
        
        <%-- Nút button "Cập nhật tài khoản" --%>
        <form action="profile.jsp" method="GET">
            <input type="submit" value="Cập nhật tài khoản">
        </form>
    </body>
</html>-->
        
        
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
                    <!--================Banner Area =================-->
                    <section class="banner_area">
                        <div class="booking_table d_flex align-items-center">
                            <div class="overlay bg-parallax" data-stellar-ratio="0.9" data-stellar-vertical-offset="0"
                                data-background=""></div>
                            <div class="container">
                                <div class="banner_content text-center">
                                    <h6>Away from monotonous life</h6>
                                    <h2>Update Ifnomation</h2>
                                    <p>Cảm ơn bạn đã đăng nhập và trải nghiệm dịch vụ G2 Hotel. Hãy cập nhật thông tin tài khoản..</p>
                                    <a href="profile.jsp" class="btn theme_btn button_hover">Update Profile</a>
                                </div>
                            </div>
                        </div>

                    </section>
                    <!--================Banner Area =================-->

                    <!--================ Accomodation Area  =================-->
                    <!-- <section class="accomodation_area section_gap">
                        <div class="container">
                            <div class="section_title text-center">
                                <h2 class="title_color">Our Room Type</h2>
                                <p>We all live in an age that belongs to the young at heart. Life that is becoming
                                    extremely fast, </p>
                            </div>
                            <div class="row mb_30">
                                <c:forEach items="${sessionScope.listRoom}" var="r">
                                    <div class="col-lg-3 col-sm-6">
                                        <div class="accomodation_item text-center">
                                            <div class="hotel_img">
                                                <img src="image/room1.jpg" alt="">
                                                <c:if test="${sessionScope.userA != null}">
                                                    <a class="btn theme_btn button_hover"
                                                        href="loadRoomToBook?IDRoomType=${r.getIDRoomType()}">Book Now</a>
                                                </c:if>
                                                <c:if test="${sessionScope.userA == null}">
                                                    <a class="btn theme_btn button_hover" href="login.jsp">Book Now</a>
                                                </c:if>
                                            </div>
                                            <a href="#">
                                                <h4 class="sec_h4">${r.getNameRoomType()}</h4>
                                            </a>
                                            <h5>${r.getPrice()}$<small>/night</small></h5>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                    </section> -->
                    <!--================ Accomodation Area  =================-->

                    <!--================ Facilities Area  =================-->
                    <section class="facilities_area section_gap">
                        <div class="overlay bg-parallax" data-stellar-ratio="0.8" data-stellar-vertical-offset="0"
                            data-background="">
                        </div>
                        <div class="container">
                            <div class="section_title text-center">
                                <h2 class="title_w">G2 Facilities</h2>
                                <p>Who are in extremely love with eco friendly system.</p>
                            </div>
                            <div class="row mb_30">
                                <div class="col-lg-4 col-md-6">
                                    <div class="facilities_item">
                                        <h4 class="sec_h4"><i class="lnr lnr-dinner"></i>Restaurant</h4>
                                        <p>Usage of the Internet is becoming more common due to rapid advancement of
                                            technology and power.</p>
                                    </div>
                                </div>
                                <div class="col-lg-4 col-md-6">
                                    <div class="facilities_item">
                                        <h4 class="sec_h4"><i class="lnr lnr-bicycle"></i>Sports CLub</h4>
                                        <p>Usage of the Internet is becoming more common due to rapid advancement of
                                            technology and power.</p>
                                    </div>
                                </div>
                                <div class="col-lg-4 col-md-6">
                                    <div class="facilities_item">
                                        <h4 class="sec_h4"><i class="lnr lnr-shirt"></i>Swimming Pool</h4>
                                        <p>Usage of the Internet is becoming more common due to rapid advancement of
                                            technology and power.</p>
                                    </div>
                                </div>
                                <div class="col-lg-4 col-md-6">
                                    <div class="facilities_item">
                                        <h4 class="sec_h4"><i class="lnr lnr-car"></i>Rent a Car</h4>
                                        <p>Usage of the Internet is becoming more common due to rapid advancement of
                                            technology and power.</p>
                                    </div>
                                </div>
                                <div class="col-lg-4 col-md-6">
                                    <div class="facilities_item">
                                        <h4 class="sec_h4"><i class="lnr lnr-construction"></i>Gymnesium</h4>
                                        <p>Usage of the Internet is becoming more common due to rapid advancement of
                                            technology and power.</p>
                                    </div>
                                </div>
                                <div class="col-lg-4 col-md-6">
                                    <div class="facilities_item">
                                        <h4 class="sec_h4"><i class="lnr lnr-coffee-cup"></i>Bar</h4>
                                        <p>Usage of the Internet is becoming more common due to rapid advancement of
                                            technology and power.</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </section>
                    <!--================ Facilities Area  =================-->

                    <!--================ About History Area  =================-->
                    <section class="about_history_area section_gap">
                        <div class="container">
                            <div class="row">
                                <div class="col-md-6 d_flex align-items-center">
                                    <div class="about_content ">
                                        <h2 class="title title_color">About Us <br>Our History<br>Mission & Vision</h2>
                                        <p>inappropriate behavior is often laughed off as “boys will be boys,” women
                                            face higher conduct standards especially in the workplace. That’s why it’s
                                            crucial that, as women, our behavior on the job is beyond reproach.
                                            inappropriate behavior is often laughed.</p>
                                        <a href="#" class="button_hover theme_btn_two">Request Custom Price</a>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <img class="img-fluid" src="image/about_bg.jpg" alt="img">
                                </div>
                            </div>
                        </div>
                    </section>
                    <!--================ About History Area  =================-->

                    <!--================ Testimonial Area  =================-->
                    <section class="testimonial_area section_gap">
                        <div class="container">
                            <div class="section_title text-center">
                                <h2 class="title_color">Testimonial from our Clients</h2>
                                <p>The French Revolution constituted for the conscience of the dominant aristocratic
                                    class a fall from </p>
                            </div>
                            <div class="testimonial_slider owl-carousel">
                                <div class="media testimonial_item">
                                    <img class="rounded-circle" src="image/testtimonial-1.jpg" alt="">
                                    <div class="media-body">
                                        <p>As conscious traveling Paupers we must always be concerned about our dear
                                            Mother Earth. If you think about it, you travel across her face, and She is
                                            the </p>
                                        <a href="#">
                                            <h4 class="sec_h4">Fanny Spencer</h4>
                                        </a>
                                        <div class="star">
                                            <a href="#"><i class="fa fa-star"></i></a>
                                            <a href="#"><i class="fa fa-star"></i></a>
                                            <a href="#"><i class="fa fa-star"></i></a>
                                            <a href="#"><i class="fa fa-star"></i></a>
                                            <a href="#"><i class="fa fa-star-half-o"></i></a>
                                        </div>
                                    </div>
                                </div>
                                <div class="media testimonial_item">
                                    <img class="rounded-circle" src="image/testtimonial-1.jpg" alt="">
                                    <div class="media-body">
                                        <p>As conscious traveling Paupers we must always be concerned about our dear
                                            Mother Earth. If you think about it, you travel across her face, and She is
                                            the </p>
                                        <a href="#">
                                            <h4 class="sec_h4">Fanny Spencer</h4>
                                        </a>
                                        <div class="star">
                                            <a href="#"><i class="fa fa-star"></i></a>
                                            <a href="#"><i class="fa fa-star"></i></a>
                                            <a href="#"><i class="fa fa-star"></i></a>
                                            <a href="#"><i class="fa fa-star"></i></a>
                                            <a href="#"><i class="fa fa-star-half-o"></i></a>
                                        </div>
                                    </div>
                                </div>
                                <div class="media testimonial_item">
                                    <img class="rounded-circle" src="image/testtimonial-1.jpg" alt="">
                                    <div class="media-body">
                                        <p>As conscious traveling Paupers we must always be concerned about our dear
                                            Mother Earth. If you think about it, you travel across her face, and She is
                                            the </p>
                                        <a href="#">
                                            <h4 class="sec_h4">Fanny Spencer</h4>
                                        </a>
                                        <div class="star">
                                            <a href="#"><i class="fa fa-star"></i></a>
                                            <a href="#"><i class="fa fa-star"></i></a>
                                            <a href="#"><i class="fa fa-star"></i></a>
                                            <a href="#"><i class="fa fa-star"></i></a>
                                            <a href="#"><i class="fa fa-star-half-o"></i></a>
                                        </div>
                                    </div>
                                </div>
                                <div class="media testimonial_item">
                                    <img class="rounded-circle" src="image/testtimonial-1.jpg" alt="">
                                    <div class="media-body">
                                        <p>As conscious traveling Paupers we must always be concerned about our dear
                                            Mother Earth. If you think about it, you travel across her face, and She is
                                            the </p>
                                        <a href="#">
                                            <h4 class="sec_h4">Fanny Spencer</h4>
                                        </a>
                                        <div class="star">
                                            <a href="#"><i class="fa fa-star"></i></a>
                                            <a href="#"><i class="fa fa-star"></i></a>
                                            <a href="#"><i class="fa fa-star"></i></a>
                                            <a href="#"><i class="fa fa-star"></i></a>
                                            <a href="#"><i class="fa fa-star-half-o"></i></a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </section>
                    <!--================ Testimonial Area  =================-->

                    <!--================ Latest Blog Area  =================-->
                    <section class="latest_blog_area section_gap">
                        <div class="container">
                            <div class="section_title text-center">
                                <h2 class="title_color">latest posts from blog</h2>
                                <p>The French Revolution constituted for the conscience of the dominant aristocratic
                                    class a fall from </p>
                            </div>
                            <div class="row mb_30">
                                <div class="col-lg-4 col-md-6">
                                    <div class="single-recent-blog-post">
                                        <div class="thumb">
                                            <img class="img-fluid" src="image/blog/blog-1.jpg" alt="post">
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
                                            <h6 class="date title_color">31st January,2018</h6>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-4 col-md-6">
                                    <div class="single-recent-blog-post">
                                        <div class="thumb">
                                            <img class="img-fluid" src="image/blog/blog-2.jpg" alt="post">
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
                                            <h6 class="date title_color">31st January,2018</h6>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-4 col-md-6">
                                    <div class="single-recent-blog-post">
                                        <div class="thumb">
                                            <img class="img-fluid" src="image/blog/blog-3.jpg" alt="post">
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
                                            <h6 class="date title_color">31st January,2018</h6>
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



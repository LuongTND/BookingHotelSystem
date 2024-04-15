<%-- 
    Document   : manager_header
    Created on : Jun 1, 2023, 1:45:44 PM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--================Header Area =================-->
<header class="header_area">
    <div class="container">
        <nav class="navbar  navbar-expand-lg bg-white">
            <!-- Brand and toggle get grouped for better mobile display -->
            <a style="width: 20%;" class="navbar-brand logo_h" href="customer_home.jsp"><img style="width: 150%;" src="image/logo1.png" alt=""></a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse offset" id="navbarSupportedContent">
                <ul class="nav navbar-nav menu_nav ml-auto">
                        <li class="nav-item"><a class="nav-link " href="manager_home.jsp">Home</a></li> 
                        <li class="nav-item"><a class="nav-link " href="showBooking">Manage bookings</a></li>
                        <li class="nav-item"><a class="nav-link " href="showRoomType">Manage room</a></li>
                        <li class="nav-item"><a class="nav-link " href="showContact">Contact</a></li>
                        <li class="nav-item"><a class="nav-link " href="showFeedback">Manage Feedback</a></li>
                        <!--<li class="nav-item"><a class="nav-link" href="customer_services.jsp">Services</a></li>-->
                        <li class="nav-item submenu dropdown">
                            <a href="#" class="nav-link dropdown-toggle " data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">More</a>
                            <ul class="dropdown-menu">
                                <li class="nav-item"><a class="nav-link text-dark" href="showDiscount">Discount</a></li>
                                <li class="nav-item"><a class="nav-link text-dark" href="showAccount">Account</a></li>
                            </ul>
                        </li> 
                    <c:if test="${sessionScope.userA != null}"> 
                        <li class="nav-item submenu dropdown">
                            <a href="#" class="nav-link dropdown-toggle " data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">${sessionScope.userA.getUserName()}</a>
                            <ul class="dropdown-menu">
                                <li class="nav-item"><a class="nav-link text-dark" href="profile.jsp">Profile</a></li>
                                <li class="nav-item"><a class="nav-link text-dark" href="logout">Log Out</a></li>
                            </ul>
                        </li> 
                    </c:if>
                        
                    <c:if test="${sessionScope.userA == null}">  
                        <li class="nav-item"><a class="nav-link text-light" href="login.jsp">Login</a></li>
                        </c:if>



                </ul>
            </div> 
        </nav>
    </div>
</header>

<script src="js/bootstrap.bundle.min.js"></script>
<script>
    var nav = document.querySelector('nav');
    var a = document.querySelectorAll('a');
    window.addEventListener('scroll', function()
    {
        if(window.pageYOffset > 100) {
            nav.classList.remove('bg-transparent');
            a.forEach(function(link) {
        link.classList.remove('text-light');
    });
        } else {
            nav.classList.add('bg-transparent');
            a.forEach(function(link) {
        link.classList.add('text-light');
    });
        }
    })
</script>

<!--================Header Area =================-->

<!--================Icon link=================-->
<script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
<script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>

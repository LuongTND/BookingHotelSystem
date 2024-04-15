<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>G2 Hotel</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"
        integrity="sha512-1ycn6IcaQQ40/MKBW2W4Rhis/DbILU74C1vSrLJxCq57o941Ym01SwNsOMqvEBFlcgUa6xLiPY/NS5R+E6ztJQ=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="css/viewDetails.css">
    <link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
    crossorigin="anonymous"
  />
    <link rel="icon" href="image/favicon.png" type="image/png">
    <title>Booking History</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="vendors/linericon/style.css">
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link rel="stylesheet" href="vendors/bootstrap-datepicker/bootstrap-datetimepicker.min.css">
    <link rel="stylesheet" href="vendors/nice-select/css/nice-select.css">
    <link rel="stylesheet" href="vendors/owl-carousel/owl.carousel.min.css">
    <!-- main css -->
    <link rel="stylesheet" href="css/room_bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/responsive.css">
    
</head>

<body>

    <%@include file="/includes/header.jsp" %>
    <section class="breadcrumb_area">
      <div class="overlay bg-parallax" data-stellar-ratio="0.8" data-stellar-vertical-offset="0" data-background=""></div>
      <div class="container">
          <div class="page-cover text-center">
              <h2 class="page-cover-tittle">My Profile</h2>
              <ol class="breadcrumb">
                  <li><a href="customer_home.jsp">Home</a></li>
                  <li class="active">About</li>
              </ol>
          </div>
      </div>
  </section>
    <section class="bg-light p-5">
      <h3 class="pb-2 text-center">BOOKING HISTORY</h3>
      <div class="table-responsive" id="no-more-tables">
        <table class="table bg-white">
          <thead class="bg-success text-light">
                <tr>
                  <th>Booking Code</th>
                  <th>Name</th>
                  <th>Email</th>
                  <th>Phone</th>
                  <th>Booking Information</th>
                  <th>Booking Time</th>
                  <th>Amount</th>
                  <th>Status</th>
                </tr>
              </thead>
              <tbody>
                  <c:forEach items="${requestScope.bookingDetails}" var="list">
                    <tr>
                      <td data-title="Booking Code">${list.getTransactionInfor().getIDTransaction()}</td>
                      <td data-title="Name">${list.getFullName()}</td>
                  <td data-title="Email">${list.getEmail()}</td>
                  <td data-title="Phone">${list.getPhone()}</td>
                  <td data-title="Booking Information">${list.getTransactionInfor().getTransInfo()}</td>
                  <td data-title="Booking Time">${list.getTransactionInfor().getTransTime()}</td>
                  <td data-title="Amount">${list.getTotalPrice()}</td>
                  <td data-title="Status">${list.getNote()}</td>
                    </tr>
                  
                    </c:forEach>
              </tbody>
          </tbody>
        </table>
      </div>

    </section>
        <%@include file="/includes/footer.jsp" %>
        <script src="js/jquery-3.2.1.min.js"></script>
        <script src="js/popper.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="vendors/owl-carousel/owl.carousel.min.js"></script>
        <script src="js/jquery.ajaxchimp.min.js"></script>
        <script src="vendors/bootstrap-datepicker/bootstrap-datetimepicker.min.js"></script>
        <script src="vendors/nice-select/js/jquery.nice-select.js"></script>
        <script src="js/mail-script.js"></script>
        <script src="js/stellar.js"></script>
        <script src="vendors/lightbox/simpleLightbox.min.js"></script>
        <script src="js/custom.js"></script>
</body>

</html>
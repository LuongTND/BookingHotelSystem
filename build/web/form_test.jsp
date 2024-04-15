<%-- Document : form_book_room Created on : Jun 8, 2023, 1:13:09 AM Author : admin --%>

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
        <link rel="stylesheet" href="css/room_bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <link rel="stylesheet" type="text/css" href="css/responsive.css">
        <style>
            body {
                font-family: Arial, sans-serif;
            }

            form {
                width: 300px;
                margin: 0 auto;
            }

            label {
                display: inline-block;
                width: 100px;
                text-align: right;
            }

            input[type="submit"] {
                margin-left: 100px;
            }

            h1 {
                text-align: center;
            }
        </style>

    </head>

    <body>
        <c:if test="${sessionScope.userA.IDRole == 1}">
            <%@include file="/includes/header.jsp" %>
        </c:if>
        <c:if test="${sessionScope.userA.IDRole == 3}">
            <%@include file="/includes/receptionist_header.jsp" %>
        </c:if>

        <!--================Breadcrumb Area =================-->
        <section class="breadcrumb_area">
            <div class="overlay bg-parallax" data-stellar-ratio="0.8" data-stellar-vertical-offset="0"
                 data-background=""></div>
            <div class="container">
                <div class="page-cover text-center">
                    <h2 class="page-cover-tittle">Booking Room</h2>
                    <ol class="breadcrumb">
                        <li><a href="index.html">Home</a></li>
                        <li class="active">About</li>
                    </ol>
                </div>
            </div>
        </section>
        <!--================Breadcrumb Area =================-->
        <br>
        <h2 style="color: red; text-align: center;">${messFail} </h2>

        <!--onsubmit="return validateForm()"-->

        <form action="confirmInformation" id="bookingForm" class="col-md-9 m-auto" name="myForm" method="get"
              role="form">
            <div class="row">
                <div class="form-group col-md-6 mb-3">
                    <label for="inputname">Name:</label>
                    <input type="hidden" class="form-control mt-1" id="IDRoomType" name="IDRoomType"
                           value="${r.getIDRoomType()}">
                    <input type="hidden" class="form-control mt-1" id="IDAccount" name="IDAccount"
                           value="${userA.getIDAccount()}">
                    <input type="text" class="form-control mt-1" id="FullName" name="FullName"
                           placeholder="Name" required value="${userA.getFullName()}">
                </div>
                <div class="form-group col-md-6 mb-3">
                    <label for="inputname">Gender:</label>
                    <input type="text" class="form-control mt-1" id="Gender" name="Gender"
                           placeholder="Gender" required value="${userA.getGender()}">
                </div>
            </div>
            <div class="row">
                <div class="form-group col-md-6 mb-3">
                    <label for="inputname">Phone:</label>
                    <input type="text" class="form-control mt-1" id="Phone" name="Phone" placeholder="Phone"
                           required value="${userA.getPhone()}">
                </div>
                <div class="form-group col-md-6 mb-3">
                    <label for="inputname">Email:</label>
                    <input type="text" class="form-control mt-1" id="Email" name="Email" placeholder="Email"
                           required value="${userA.getEmail()}">
                </div>
            </div>
                <hr>
        </p>
            <div class="row">
                <div class="form-group col-md-6">
                    <label for="inputname">Room Type:</label>
                    <label for="inputname"> ${r.getNameRoomType()}</label>
                    <input type="hidden" id="NameRoomType" name="NameRoomType" required
                           value="${r.getNameRoomType()}">
                </div>
                <div class="form-group col-md-6 mb-3">
                    <label for="inputname">Price:</label>
                    <label for="inputname"> ${r.getPrice()}$/Night</label>
                    <input type="hidden" id="Price" name="Price" placeholder="Price" required
                           value="${r.getPrice()}">
                    <input type="hidden" id="ttRoom" name="ttRoom" placeholder="ttRoom" required
                           value="${r.getTotalRoom()}">

                </div>
            </div>

            <div class="row">
                <div class="form-group col-md-6">
                    <input type="hidden" class="form-control mt-1" id="NumberOfBed" name="NumberOfBed"
                           value="${r.getNumberOfBed()}" onchange="updateQuantity()" readonly>
                    <label for="inputname">Adult: (Old 13+)</label>
                    <input type="number" class="form-control mt-1" id="Adult" name="Adult" min="1"
                           onchange="updateQuantity()" placeholder="Adult" required value="">
                </div>
                <div class="form-group col-md-6 mb-3">
                    <label for="inputname">Child:Old 5-13</label>
                    <input type="number" class="form-control mt-1" id="Child" name="Child" min="0"
                           onchange="updateQuantity()" placeholder="Child" required value="0">
                </div>
            </div>

            <div class="row">
                <div class="form-group col-md-6">
                    <label for="checkInDate">Check-In:</label><br>
                    <input type="date" class="form-control" name="checkInDate" id="check_in"
                           onchange="validateDates(); calculateTotalPrice();" required />
                    <span id="checkInDate" style="color: red;" class="error"></span>
                </div>
                <div class="form-group col-md-6 mb-3">
                    <label for="checkOutDate">Check-Out:</label><br>
                    <input type="date" class="form-control" name="checkOutDate" id="check_out"
                           onchange="validateDates(); calculateTotalPrice();" required />
                    <span id="checkOutDate" style="color: red;" class="error"></span>
                </div>
            </div>


            <div class="row">
                <div class="form-group col-md-6">
                    <label for="numRooms">Quantity:</label><br>
                    <input type="number" class="form-control mt-1" id="numRooms" name="numRooms" value=""
                           min="1" onchange="validateDates(); calculateTotalPrice();" required>
                    <span id="quantityError" style="color: red;"></span>
                </div>


                <div class="form-group col-md-6 mb-3">
                    <label for="inputname">Total Price</label>
                    <input type="text" class="form-control mt-1" id="TotalPrice" name="TotalPrice"
                           placeholder="TotalPrice" value="" readonly>
                </div>
            </div>

            <div class="row">
                <div class="form-group col-md-6 mb-3">
                    <label for="inputname">Discount</label>
                    <input type="text" class="form-control mt-1" id="DiscountCode" name="DiscountCode" placeholder="DiscountCode" value="">
                </div>
            </div>
                    
            <div class="col text-end mt-2">
                <button type="submit" class="btn btn-success btn-lg px-3">Book Now</button>
            </div>
        </form>

        <br>


        <%@include file="/includes/footer.jsp" %>

        <script type="text/javascript">
            // check validation time min
            var checkOutDate = document.getElementById("check_out");
            var date = new Date();
            var dateCrr = date.toISOString().split("T")[0];
            checkOutDate.setAttribute("min", dateCrr);
            var checkInDate = document.getElementById("check_in");
            checkInDate.setAttribute("min", dateCrr);

            function calculateTotalPrice() {
                var price = parseFloat(document.getElementById("Price").value);
                var checkInDate = new Date(document.getElementById("check_in").value);
                var checkOutDate = new Date(document.getElementById("check_out").value);
                var numRooms = parseInt(document.getElementById("numRooms").value);

                // Kiểm tra dữ liệu hợp lệ
                if (checkOutDate <= checkInDate) {
                    document.getElementById("checkOutDate").textContent = "Ngày check-out phải sau ngày check-in";
                    checkOutDateInput.value = '';
                    return;
                }

                // Tính số ngày đặt phòng
                var oneDay = 24 * 60 * 60 * 1000; // Số mili giây trong một ngày
                var numDays = Math.round(Math.abs((checkOutDate - checkInDate) / oneDay));

                // Tính tổng giá tiền
                var totalPrice = price * numDays * numRooms;

                // Hiển thị giá trong trường "TotalPrice"
                document.getElementById("TotalPrice").value = totalPrice.toFixed(2); // Giá trị làm tròn đến 2 chữ số thập phân

                // Xóa thông báo lỗi nếu dữ liệu hợp lệ
                document.getElementById("checkOutDate").textContent = "";
            }

            function validateDates() {
                var checkInDate = new Date(document.getElementById("check_in").value);
                var checkOutDate = new Date(document.getElementById("check_out").value);
                const currentDate = new Date();
                currentDate.setDate(currentDate.getDate() - 1);

                // Kiểm tra ngày check-out không được trước ngày check-in
                if (checkOutDate <= checkInDate) {
                    document.getElementById('checkOutDate').textContent = 'Your checkout date is less than or equal checkin date.';
                    document.getElementById('check_out').value = '';
                } else if (checkOutDate <= currentDate) {
                    document.getElementById('checkOutDate').textContent = 'Your checkout date is less than or equal currentDate.';
                    document.getElementById('check_out').value = '';
                } else {
                    document.getElementById('checkOutDate').textContent = '';
                }

                if (checkInDate <= currentDate) {
                    document.getElementById('checkInDate').textContent = 'Your checkin date is less than current date.';
                    document.getElementById('check_in').value = '';
                } else {
                    document.getElementById('checkInDate').textContent = '';
                }

                calculateTotalPrice();

            }

            function updateQuantity() {
                var adultInput = document.getElementById('Adult');
                var childInput = document.getElementById('Child');
                var quantityInput = document.getElementById('numRooms');
                var numberOfBedInput = document.getElementById('NumberOfBed');

                var adultCount = parseInt(adultInput.value);
                var childCount = parseInt(childInput.value);
                var numberOfBed = parseInt(numberOfBedInput.value);

                if (numberOfBed === 1) {
                    var maxAdultCount = 2;
                    var maxTotalCount = 3;
                    if (adultCount <= maxAdultCount && (adultCount + childCount) <= maxTotalCount) {
                        quantityInput.value = 1;
                    } else {
                        var totalPeopleCount = adultCount + childCount;
                        var quantity = Math.ceil(totalPeopleCount / maxTotalCount);

                        while (adultCount > maxAdultCount * quantity) {
                            quantity++;
                        }

                        quantityInput.value = quantity;
                    }
                } else if (numberOfBed === 2) {
                    var maxAdultCount = 4;
                    var maxTotalCount = 6;

                    if (adultCount <= maxAdultCount && (adultCount + childCount) <= maxTotalCount) {
                        quantityInput.value = 1;
                    } else {
                        var totalPeopleCount = adultCount + childCount;
                        var quantity = Math.ceil(totalPeopleCount / maxTotalCount);
                        while (adultCount > maxAdultCount * quantity) {
                            quantity++;
                        }
                        quantityInput.value = quantity;
                    }
                }
                calculateTotalPrice();

            }

// Lấy các phần tử HTML cần thiết
//            var checkInDateInput = document.getElementById('check_in');
//            var checkOutDateInput = document.getElementById('check_out');
//            var checkInDateError = document.getElementById('checkInDate');
//            var checkOutDateErroate = new Date(checkInDateInput.value);
//                var currentDate = new Date();
//
//                // Kiểm tra nếu r = document.getElementById('checkOutDate');
//
//// Lắng nghe sự kiện khi ngày check-in thay đổi
//            checkInDateInput.addEventListener('change', function () {
//                var checkInDngày check-in nhỏ hơn ngày hiện tại
//                if (checkInDate <= currentDate) {
//                    checkInDateError.innerHTML = 'Your checkin date is less than current date.';
//                    checkInDateInput.value = '';
//                } else {
//                    checkInDateError.innerHTML = '';
//                }
//
//                // Xóa thông báo lỗi ngày check-out nếu có
//                checkOutDateError.innerHTML = '';
//            });
//
//// Lắng nghe sự kiện khi ngày check-out thay đổi
//            checkOutDateInput.addEventListener('change', function () {
//                var checkInDate = new Date(checkInDateInput.value);
//                var checkOutDate = new Date(checkOutDateInput.value);
//
//                // Kiểm tra nếu ngày check-out nhỏ hơn ngày check-in
//                if (checkOutDate <= checkInDate) {
//                    checkOutDateError.innerHTML = 'Your checkout date is less than checkin date.';
//                    checkOutDateInput.value = '';
//                } else {
//                    checkOutDateError.innerHTML = '';
//                }
//            });
//
//
//
//            function decreaseQuantity() {
//                var quantityInput = document.getElementById("numRooms");
//                var currentQuantity = parseInt(quantityInput.value);
//
//                if (currentQuantity > 1) {
//                    quantityInput.value = currentQuantity - 1;
//                    document.getElementById("quantityError").innerHTML = "";
//                }
//            }
//
//            function increaseQuantity() {
//                var quantityInput = document.getElementById("numRooms");
//                var currentQuantity = parseInt(quantityInput.value);
//
//                if (currentQuantity < 5) {
//                    quantityInput.value = currentQuantity + 1;
//                    document.getElementById("quantityError").innerHTML = "";
//                } else {
//                    document.getElementById("quantityError").innerHTML = "Over the number of room available!";
//                }
//            }
        </script>


        <!--<script src="js/formValidation.js" type="text/javascript"></script>-->


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
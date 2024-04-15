<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<style>
     .coupon-row {
                        display: flex;
                        align-items: center;
                        margin: 25px auto;
                        width: fit-content;
                        background-color: #7158fe;
                    }

      #cpnCode {
                        border: 1px dashed #fff;
                        padding: 10px 20px;
                        border-right: 0;
                        font-weight: bold;
                        color: #fff;
                    }

                    #cpnBtn {
                        border: 1px solid #fff;
                        background: #7158fe;
                        padding: 10px 20px;
                        color: #fff;
                        cursor: pointer;
                    }
                    p {
                        color: black;
                    }
</style>
<section class="about_history_area section_gap">
    <div class="container">
        <div class="row">
            <div class="col-md-6 d_flex align-items-center">
                <div class="about_content ">
                    <h2 class="title title_color">About Us <br>Our History<br>Mission & Vision</h2>
                    <p>Our mission is to empower conscious travelers to explore the world 
                        in a way that respects and preserves our planet and its diverse cultures. 
                        We are committed to curating sustainable travel experiences that minimize our 
                        ecological footprint while maximizing the positive impact on local communities. 
                        Through responsible tourism practices, we strive to create a ripple effect of change, 
                        inspiring others to embrace mindful travel and contribute to a more sustainable future.</p>
                    <!-- <a href="#" class="button_hover theme_btn_two">Request Custom Price</a> -->
                    <div class="coupon-row">
                        <span id="cpnCode">THANG6</span>
                        <span id="cpnBtn">COPY CODE</span>
                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <img class="img-fluid" src="image/about_bg.jpg" alt="img">
            </div>
        </div>
    </div>
</section>
<script>
    var cpnBtn = document.getElementById("cpnBtn");
    var cpnCode = document.getElementById("cpnCode");

    cpnBtn.onclick = function () {
        navigator.clipboard.writeText(cpnCode.innerHTML);
        cpnBtn.innerHTML = "COPIED";
        setTimeout(function () {
            cpnBtn.innerHTML = "COPY CODE";
        }, 3000);
    }
</script>
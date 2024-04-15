<%-- 
    Document   : EnterOTPforgot
    Created on : Jun 29, 2023, 1:11:53 AM
    Author     : duclu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Enter OTP</title>
        <link rel="stylesheet" type="text/css" href="css/login.css">
    </head>
    <body>
        <div class="container">
            <div class="Login">
                <div class="logo-container">
                    <img style="width: 120% ; margin-bottom: 50px " src="image/logo1_2.png" alt="Logo">
                </div>
                <h2> G2Hotel has sent the otp code to your<a href="https://mail.google.com/" target="_blank" > Gmail</a> 😍 <h2>
                        <label style="font-size: 17px">You have not received the otp code</label>
<!--                        <div id="countdown"></div>-->
<button id="resendButton" onclick="resendOTP()" style="color: red">Resend</button>
                        
                        
                <form class="Login-form" action="ValidateOTPforgot" method="POST">
                    <label for="username">Enter OTP</label>
                    <input type="text" id="otp" name="otp" placeholder="******" required>

                    
                    
                    <button type="submit" >Send</button>
                     
                </form>
            </div>
            <div class="image">
                <img src="image/bglogin.png" alt="Image">
            </div>
        </div>
        

        
        
    </body>
    
    <script>
    function resendOTP() {
        // Gửi yêu cầu gửi lại mã OTP bằng Ajax
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
                // Xử lý phản hồi từ server (nếu cần)
                alert("OTP resent successfully!");
            }
        };
        xhttp.open("POST", "ResendOTP", true);
        xhttp.send();
    }
</script>
</html>


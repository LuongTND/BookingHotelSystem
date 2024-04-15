<%-- 
    Document   : forgotPassword
    Created on : Jul 6, 2023, 5:17:27 PM
    Author     : duclu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Forgot Password</title>
        <link rel="stylesheet" type="text/css" href="css/login.css">
    </head>
    <body>
        <div class="container">
            <div class="Login">
                <div class="logo-container">
                    <img style="width: 120%; margin-bottom: 40px" src="image/logo1_2.png" alt="Logo">
                </div>
                
                <form class="Login-form" action="ForgotPassword" method="POST">
                     <label style="font-size: 17px">G2Hotel will send an otp code to your email to verify your identity</label>
         
                                   <div class="alert alert-danger" role="alert">
                            <p style="color: red; font-family: sans-serif"class="text-danger">${messF} </p>
                        </div>
                    <label for="username">Please provide email</label>
                    <input type="text" id="email" name="email" placeholder="nguyenvana@gmail.com" required>

                    
                    
                    <button type="submit">Send</button>
                     
                </form>
            </div>
            <div class="image">
                <img src="image/bglogin.png" alt="Image">
            </div>
        </div>
    </body>
</html>
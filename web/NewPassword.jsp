<%-- 
    Document   : NewPassword
    Created on : Jun 7, 2023, 11:50:25 AM
    Author     : duclu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!doctype html>
<html>
    <head>
        <title>Reset Password</title>
        <link rel="stylesheet" type="text/css" href="css/login.css">
    </head>
    <body>
        <div class="container">
            <div class="Login">
                <div class="logo-container">
                    <img style="width: 120% ; margin-bottom: 50px " src="image/logo1_2.png" alt="Logo">
                </div>
                <h2 > Reset Password <h2>
                        
                               <div class="alert alert-danger" role="alert">
                            <p style="color: red; font-family: sans-serif"class="text-danger">${error} </p>
                        </div>
                <form class="Login-form" action="NewPassword" method="POST">
                    <label for="password">Password<span class="required-field">*</span></label>
                    <input type="password" id="password" name="password" required>

                    <label for="confirm_password">Confirm Password<span class="required-field">*</span></label>
                    <input type="password" id="confPassword" name="confPassword" required>
                    
                    <button type="submit" >Reset</button>
                     
                </form>
            </div>
            <div class="image">
                <img src="image/bglogin.png" alt="Image">
            </div>
        </div>
        

        
        
    </body>
</html>









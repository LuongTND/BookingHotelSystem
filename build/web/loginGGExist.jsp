<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
        <link rel="stylesheet" type="text/css" href="css/login.css">
        
        
        <style>
  .google-login-button {
    background-color: #dd4b39;
    color: white;
    padding: 10px 20px;
    border-radius: 4px;
    font-size: 16px;
    font-weight: bold;
    cursor: pointer;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.25);
    border: none;
    display: flex;
    align-items: center;
     text-decoration: none;
  }

  .google-login-button:hover {
    background-color: #c23321;
  }

  .google-login-button:active {
    background-color: #e74b37;
  }

  .google-login-button img {
    width: 16px;
    height: 16px;
    margin-right: 10px;
  }
</style>
    </head>
    <body>
        <div class="container">
            <div class="Login">
                <div class="logo-container">
                    <img style="width: 120%;" src="image/logo1_2.png" alt="Logo">
                </div>
                <h2>Login</h2>
                      <p style="color: red">This email is already in use. Are you <%= session.getAttribute("fullname") %>?   with User Name is (<%= session.getAttribute("username") %>) </p>


                <form class="Login-form" action="login" method="POST">
                    <div style="color: red;" class="alert alert-danger" role="alert">
                        <p class="text-danger">${loginFail} </p>
                    </div>
                    <label for="username">UserName<span class="required-field">*</span></label>
                    <input type="text" id="userName" name="userName" placeholder="Enter your username" value="<%= session.getAttribute("username") %>"required>

                    <label for="password">Password<span class="required-field">*</span></label>
                    <input type="password" id="password" name="password" placeholder="Enter your password " required>
      
                    
                       
                    
                    <button type="submit">Login</button>
                     <div class="mt-4 text-center">
                        <p class="text-sm">Do you <a href="forgotPassword.jsp"
                                                                      class="text-red-700 hover:underline">Forget Password</a></p>
                    </div>

                    <div class="mt-4 text-center">
                        <p class="text-sm">Do not have an account ? <a href="register.jsp"
                                                                      class="text-red-700 hover:underline">Register</a></p>
                    </div>

                    <div class="row">
  <div class="col-md-12">
    <a class="google-login-button" href="https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:8080/G2HotelV1/LoginWithGmail&response_type=code&client_id=111005015612-bqerf1kq54orha4bq60mdv1cl4js24v0.apps.googleusercontent.com&approval_prompt=force">
      <img src="https://img.icons8.com/color/16/000000/google-logo.png" alt="Google Logo">
      Login Using Google Others
    </a>
  </div>
</div>
   
                </form>
            </div>
            <div class="image">
                <img src="image/bglogin.png" alt="Image">
            </div>
        </div>
                  
    </body>
</html>

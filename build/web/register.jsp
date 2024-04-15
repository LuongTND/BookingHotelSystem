    <%-- 
        Document   : SignUpPage
        Created on : Jun 3, 2023, 2:22:20 AM
        Author     : duclu
    --%>

    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>
        <head>
            <title>Register</title>
            <link rel="stylesheet" type="text/css" href="css/register.css">
            <!--      phan show pass -->
            <style>
                .password-container {
                    position: relative;
                    display: inline-block;
                    width: 300px;
                }

                .password-toggle {
                    position: absolute;
                    top: 50%;
                    right: 5px;
                    transform: translateY(-50%);
                    cursor: pointer;
                }
            </style>
            <!--    ///-->
        </head>
        <body>
            <div class="container">
                <div class="registration">
                    <div class="logo-container">
                        <img src="image/logo1.png" alt="Logo">
                    </div>
                    <h2>Register</h2>
                    <form class="registration-form" action="register" method="POST">

                        <div class="alert alert-danger" role="alert">
                            <p style="color: red; font-family: sans-serif"class="text-danger">${mess} </p>
                        </div>

                        <label for="username">UserName<span class="required-field">*</span></label>
                        <input type="text" id="username"placeholder="nguyenvana" name="username" required>

                        <!--                    
                                            <label for="password">Password</label>
                                            <input type="password" id="password" name="password" required>
                                            <label for="confirm_password">Confirm Password</label>
                                            <input type="password" id="confirm_password" name="confirm_password" required>

                        -->
                        <!--////-->
                        <div>
                            <label for="password">Password<span class="required-field">*</span></label>
                            <div class="password-container">
                                <input type="password" id="password" name="password" placeholder="************"required>
                                <span class="password-toggle" onclick="togglePasswordVisibility('password')">&#128065;</span>
                            </div>

                            <label for="confirm_password">Confirm Password<span class="required-field">*</span></label>
                            <div class="password-container">
                                <input type="password" id="confirm_password" name="confirm_password" placeholder="************"required>
                                <span class="password-toggle" onclick="togglePasswordVisibility('confirm_password')">&#128065;</span>
                            </div>
                        </div>
                        <!--////-->


                        <label for="email">Email<span class="required-field">*</span></label>
                        <input type="email" id="email" placeholder="nguyenvana@gmail.com"name="email" required>

                        <label for="fullname">Full Name<span class="required-field">*</span></label>
                        <input type="text" id="fullname"placeholder="Nguyen Van A" name="fullname" required>

                        <label for="gender">Gender</label>
                        <select id="gender" name="gender" style="    font-size: 16px;
                                width: 314px;
                                padding: 6.5px;
                                  border: 1px solid  #ccc;" required>
                            <option value="" disabled selected>Select your gender</option>
                            <option value="female">Female</option>
                            <option value="male">Male</option>
                            <option value="other">Other</option>
                        </select>

                        <label for="city">City<span class="required-field">*</span></label>
                        <input type="text" id="city" placeholder="Ha Noi"name="city" required>



                        <label for="phone">Phone<span class="required-field">*</span></label>
                        <input type="text" id="phone"placeholder="+84|123456789" name="phone" required>


                        <input type="hidden" id="idrole" name="idrole" value="1">
                        <input type="checkbox" id="agreeCheckbox" required="required" ><lable for="agreeCheckbox" > I agree with <a href="hotel_policy.jsp" target="_blank"> the hotel policy<span class="required-field">*</span></a></lable>


                        <button type="submit"   id="registerButton" name="submit"   >Register</button>
                        <div class="mt-4 text-center">
                            <p class="text-sm">Do you already have an account ? <a href="login.jsp"
                                                                                   class="text-red-700 hover:underline">Login</a></p>
                        </div>
                    </form>
                </div>
                <div class="image">
                    <img src="image/bglogin.png" alt="Image">
                </div>
            </div>

            <!--       ///   phan showpass          -->
            <script>
                function togglePasswordVisibility(inputId) {
                    var passwordInput = document.getElementById(inputId);
                    var passwordToggle = passwordInput.nextElementSibling;

                    if (passwordInput.type === "password") {
                        passwordInput.type = "text";
                        passwordToggle.innerHTML = "&#128064;"; // Show Eye Icon
                    } else {
                        passwordInput.type = "password";
                        passwordToggle.innerHTML = "&#128065;"; // Hide Eye Icon
                    }
                }
            </script>
            <!--    ////-->
        </body>

        <script>
            var agreeCheckbox = document.getElementById('agreeCheckbox');
            var registerButton = document.getElementById('registerButton');

            agreeCheckbox.addEventListener('change', function () {
                if (agreeCheckbox.checked) {
                    registerButton.removeAttribute('disabled');
                    registerButton.classList.remove('disabled');
                } else {
                    registerButton.setAttribute('disabled', 'disabled');
                    registerButton.classList.add('disabled');
                }
            });
            registerButton.addEventListener('click', function (event) {
                if (!agreeCheckbox.checked) {
                    event.preventDefault();
                    alert('Please agree to the hotel policy.');
                }
            });

        </script>



    </html>

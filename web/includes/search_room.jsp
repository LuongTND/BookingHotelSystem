<!doctype html>
<html lang="en">
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    </head>
    <body class="">

        <form action="checkRoomValid" method="get" onsubmit="return validateForm()" name="myForm">
            <div class="row maindiv bg-white px-4 search-form">

                <div class="col-4">
                    <div>
                        <label><b class="text-dark">CHECK IN DATE</b></label>
                    </div>
                    <input type="date" class="form-control"  name="check_in" id="check_in"  required/>
                    <span id="checkin" class="error"></span>
                </div>
                <div class="col-4">
                    <div>
                        <label><b class="text-dark">CHECK OUT DATE</b></label>
                    </div>
                    <input type="date" class="form-control " name="check_out" id="check_out"  required />
                    <span id="checkout" class="error"></span>
                </div>

                <div class="col-2 mt-3 px-5 btn">
                    <input type="submit"  class="btn btn-outline-warning" value="Find available"/>
                </div>

            </div>
        </form>
        <style>
            .error {
                color: darkred;
                font-weight: bold;
            }
            .search-form {
                padding: 20px;
                margin-bottom: 20px;
            }
        </style>
        <script type="text/javascript">
            $(function () {
                var dtToday = new Date();

                var month = dtToday.getMonth() + 1;
                var day = dtToday.getDate();
                var year = dtToday.getFullYear();
                if (month < 10)
                    month = '0' + month.toString();
                if (day < 10)
                    day = '0' + day.toString();

                var maxDate = year + '-' + month + '-' + day;
                $('#check_in').attr('min', maxDate);
                $('#check_out').attr('min', maxDate);
            });

        </script>

<script type="text/javascript">

                                // check validation time min
                            var checkOutDate = document.getElementById("check_out");
                            var date = new Date();
                            var dateCrr = date.toISOString().split("T")[0];
                            checkOutDate.setAttribute("min", dateCrr);
                            var checkInDate = document.getElementById("check_in");
                            checkInDate.setAttribute("min", dateCrr);
    document.getElementById('check_in').addEventListener('change', handleDateChange);
    document.getElementById('check_out').addEventListener('change', handleDateChange);

    function handleDateChange() {
        const currentDate = new Date();
        currentDate.setDate(currentDate.getDate() - 1);
        var checkInDate = new Date(document.getElementById('check_in').value);
        var checkOutDate = new Date(document.getElementById('check_out').value);

        if (checkOutDate <= checkInDate) {
            document.getElementById('checkout').textContent = 'Your checkout date is less than or equal checkin date.';
            document.getElementById('check_out').value = '';
        }  else if (checkOutDate <= currentDate){
            document.getElementById('checkout').textContent = 'Your checkout date is less than or equal currentDate.';
            document.getElementById('check_out').value = '';
        }
        else {
            document.getElementById('checkout').textContent = '';
        }
        
        if (checkInDate <= currentDate) {
        document.getElementById('checkin').textContent = 'Your checkin date is less than current date.';
        document.getElementById('check_in').value = '';
    } else {
        document.getElementById('checkin').textContent = '';
    }
    }
</script>

        <script src="../js/formValidation.js" type="text/javascript"></script>

    </body>
</html>
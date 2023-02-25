<%-- 
    Document   : Login
    Created on : 29 Jan 2023, 1:09:03 am
    Author     : Ahmad Dannial Dzulkarnain bin Ahmad Sahmulaili
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Furniture Repairing Reservation System</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="css/newcss.css"/>
    </head>
    <script>
        function validate() {

            var username = document.form.username.value;
            var password = document.form.password.value;

            if (username == null || username == "") {

                alert("Username cannot be blank");
                return false;
            } else if (password == null || password == "") {

                alert("Password cannot be blank");
                return false;
            }
        }
    </script>
    <body>
        <nav class="navbar navbar-expand-lg bg-light">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">Dr. Sofa</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link" href="index.html">Home</a>
                        </li>
                        <!--                        <li class="nav-item">
                                                    <a class="nav-link" href="#">About</a>
                                                </li>
                                                <li class="nav-item">
                                                    <a class="nav-link" href="">Contact us</a>
                                                </li>-->
                    </ul>
                    <ul class="navbar-nav mb-2 mb-lg-0 d-flex">
                        <li class="nav-item">
                            <a class="nav-link" href="Register.jsp">Sign up</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="Login.jsp">Login</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <div class="header text-center mt-5 mb-5">
            <h1>Furniture Repairing Reservation System Login Page</h1> 
        </div>

        <div class="col-10 col-lg-4 mx-auto">
            <form name="form" action="LoginServlet" method="post" onsubmit="return validate()">
                <div class="row mb-3">
                    <div class="col-lg">
                        <label class="col-form-label">Username:</label>
                    </div>
                    <div class="col-lg">
                        <input type="text" name="username" class="form-control"/>
                    </div>
                </div>
                <div class="row mb-3">
                    <div class="col-lg">
                        <label class="col-form-label">Password:</label>
                    </div>
                    <div class="col-lg">
                        <input type="password" name="password" class="form-control"/>
                    </div>
                </div>
                <div class="row mb-3">
                    <div class="col-lg text-center">
                        <input type="submit" value="Login" class="btn btn-primary">
                        <input type="reset" value="Reset" class="btn btn-danger">
                    </div>
                </div>
                <div class="row mb-3">
                    <div class="col-lg">
                        <a href="index.html">Back</a>
                    </div>
                </div>
                <div class="text-center">
                    <span style="color:red" class="text-center"><%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage")%></span>
                </div>
            </form>
        </div>
    </body>
</html>

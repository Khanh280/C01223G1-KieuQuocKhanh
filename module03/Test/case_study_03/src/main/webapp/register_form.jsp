<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 30/04/2023
  Time: 8:18 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>IG1 Store</title>
    <link rel="stylesheet" href="register_css.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>

    <section class="vh-100 bg-image"
             style="background-image: url('https://mdbcdn.b-cdn.net/img/Photos/new-templates/search-box/img4.webp');">
        <div class="mask d-flex align-items-center h-100 gradient-custom-3">
            <div class="container h-100">
                <div class="row d-flex justify-content-center align-items-center h-100">
                    <div class="col-12 col-md-9 col-lg-7 col-xl-6">
                        <div class="card" style="border-radius: 15px;">
                            <div class="card-body p-5" style="height: 100vh">
                                <h4 class="text-uppercase text-center mb-2">Create an account</h4>
                                <form action="/account-servlet" method="post">
                                    <input type="text" name="action" value="register" hidden>
                                    <div class="form-outline mb-2">
                                        <input type="text" id="form3Example1cg" class="form-control form-control-lg" name="customerName" />
                                        <label class="form-label" for="form3Example1cg">User Name</label>
                                    </div>

                                    <div class="form-outline mb-2">
                                        <input type="email" id="form3Example2cg" class="form-control form-control-lg" name="email"/>
                                        <label class="form-label" for="form3Example2cg">Your Email</label>
                                    </div>
                                    <div class="form-outline mb-2">
                                        <input type="text" id="form3Example3cg" class="form-control form-control-lg" name="phoneNumber"/>
                                        <label class="form-label" for="form3Example3cg">Phone number</label>
                                    </div>
                                    <div class="form-outline mb-2">
                                        <input type="text" id="form3Example4cg" class="form-control form-control-lg" name="address"/>
                                        <label class="form-label" for="form3Example4cg">Address</label>
                                    </div>

                                    <div class="form-outline mb-2">
                                        <input oninput="checkPassword()" type="password" id="form3Example5cg" class="form-control form-control-lg"/>
                                        <label class="form-label" for="form3Example5cg">Password</label>
                                    </div>

                                    <div class="form-outline mb-2">
                                        <input oninput="checkPassword()" type="password" id="form3Example6cdg" class="form-control form-control-lg" name="password"/>
                                        <small id="check"></small>
                                        <label class="form-label" for="form3Example6cdg">Repeat your password</label>
                                    </div>

                                    <div class="d-flex justify-content-center">
                                        <button type="submit"
                                                class="btn btn-success btn-block btn-lg gradient-custom-4 text-body">Register</button>
                                    </div>

                                    <p class="text-center text-muted mt-5 mb-0">Have already an account? <a href="index.jsp" class="fw-bold text-body"><u>Login here</u></a></p>
                                </form>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <script>
        // function checkPassword() {
        //     let passwordFirst = document.getElementById("form3Example5cg").value;
        //     let passwordLast = document.getElementById("form3Example6cdg").value;
        //     if(passwordLast !== ""){
        //         if(passwordFirst === passwordLast){
        //             document.getElementById("check").innerText = "Trung khop";
        //         }else {
        //             document.getElementById("check").innerText = "khong trung";
        //         }
        //     }
        // }
    </script>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</html>

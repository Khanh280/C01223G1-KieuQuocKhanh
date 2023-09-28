<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <title>IG1 Store</title>
    <link rel="stylesheet" href="index.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <style>
        #bg-img {
            height: 100vh;
        }
    </style>
</head>
<body>
<c:redirect url="/account-servlet"></c:redirect>
<div id="bg-img" class="d-flex align-items-center">
    <div class="container-fluid d-flex justify-content-center align-items-center">
        <div class="row main-content bg-success text-center">
            <div class="col-md-4 text-center company__info">
                <img src="IG1 (1).gif" alt="" style="border-radius: 30px">
            </div>
            <div class="col-md-8 col-xs-12 col-sm-12 login_form ">
                <div class="container-fluid">
                    <div class="row">
                        <h2>Log In</h2>
                    </div>
                    <div class="row">
                        <form action="/account-servlet" method="post" control="" class="form-group">
                            <input type="text" name="action" value="login" hidden>
                            <div class="row">
                                <input type="text" name="userName" id="username" class="form__input"
                                       placeholder="Username"
                                       value="${userName}">
                            </div>
                            <div class="row">
                                <input type="password" name="password" id="password" class="form__input"
                                       placeholder="Password" value="${password}">
                                <small id="statusLogin" class="text-danger"></small>
                            </div>
                            <div class="row">
                                <label>
                                    <input type="checkbox" name="remember_me" id="remember_me" class="">
                                    Remember Me!
                                </label>
                            </div>
                            <div class="row">
                                <input type="submit" value="Submit" class="btn">
                            </div>
                        </form>
                    </div>
                    <div class="row">
                        <p>Don't have an account? <a href="/account/register_form.jsp">Register Here</a></p>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <c:set var="status" value="${statusLogin}"></c:set>
    <div id="canh-bao" style="display: none;"></div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
<script>
    let status = ${status};
    if(!status){
        statusLogin();
    }
    function statusLogin() {
        document.getElementById("statusLogin").innerText = "Incorrect username or password";
    }
</script>
</body>
</html>
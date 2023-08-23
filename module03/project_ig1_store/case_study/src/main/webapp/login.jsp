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
    #container {
      height: 100vh;
      background-image: url("https://img.freepik.com/free-vector/geometric-striped-background-with-halftone-border_1409-1446.jpg?w=2000&t=st=1683984702~exp=1683985302~hmac=44cfcc456aa85ce3a2e79e838c82ef6932f0d3f9621d2dcb0c043d1f995f75f3");
      background-size: 100%;
    }
    .main-content{
      width: 50%;
      border-radius: 20px;
      box-shadow: 0 5px 5px rgba(0,0,0,.4);
      margin: 5em auto;
      display: flex;
    }
    .company__info{
      background-color: #fa9a00;
      border-top-left-radius: 20px;
      border-bottom-left-radius: 20px;
      display: flex;
      flex-direction: column;
      justify-content: center;
      color: #fff;
    }
    .fa-android{
      font-size:3em;
    }
    @media screen and (max-width: 640px) {
      .main-content{width: 90%;}
      .company__info{
        display: none;
      }
      .login_form{
        border-top-left-radius:20px;
        border-bottom-left-radius:20px;
      }
    }
    @media screen and (min-width: 642px) and (max-width:800px){
      .main-content{width: 70%;}
    }
    .row > h2{
      color:#fa9a00;
    }
    .login_form{
      background-color: #fff;
      border-top-right-radius:20px;
      border-bottom-right-radius:20px;
      border-top:1px solid #ccc;
      border-right:1px solid #ccc;
    }
    form{
      padding: 0 2em;
    }
    .form__input{
      width: 100%;
      border:0px solid transparent;
      border-radius: 0;
      border-bottom: 1px solid #aaa;
      padding: 1em .5em .5em;
      padding-left: 2em;
      outline:none;
      margin:1.5em auto;
      transition: all .5s ease;
    }
    .form__input:focus{
      border-bottom-color: #fa9a00;
      box-shadow: 0 0 5px rgba(0,80,80,.4);
      border-radius: 4px;
    }
    .btn{
      transition: all .5s ease;
      width: 70%;
      border-radius: 30px;
      color:#fa9a00;
      font-weight: 600;
      background-color: #fff;
      border: 1px solid #fa9a00;
      margin-top: 1.5em;
      margin-bottom: 1em;
    }
    .btn:hover, .btn:focus{
      background-color: #fa9a00;
      color:#fff;
    }

  </style>
</head>
<body>
<div id="container">
  <div id="bg-img" class="d-flex align-items-center">
    <div class="container-fluid d-flex justify-content-center align-items-center">
      <div class="row main-content bg-success text-center">
        <div class="col-md-4 text-center company__info">
          <img src="IG1 (1).gif" alt="" style="border-radius: 30px">
        </div>
        <div class="col-md-8 col-xs-12 col-sm-12 login_form ">
          <div class="container-fluid">
            <div class="row">
              <h2 class="mt-3">Đăng nhập</h2>
            </div>
            <div class="row">
              <form action="/account-servlet" method="post" control="" class="form-group">
                <input type="text" name="action" value="login" hidden>
                <div class="row">
                  <input type="text" name="userName" id="username" class="form__input"
                         placeholder="Tên người dùng"
                         value="${userName}">
                </div>
                <div class="row">
                  <input type="password" name="password" id="password" class="form__input"
                         placeholder="Mật khẩu" value="${password}">
                  <small id="statusLogin" class="text-danger"></small>
                </div>
                <div class="row">
                  <label>
                    <input type="checkbox" name="remember_me" id="remember_me" class="">
                    Ghi nhớ!
                  </label>
                </div>
                <div class="row justify-content-center">
                  <input type="submit" value="Đăng nhập" class="btn">
                </div>
              </form>
            </div>
            <div class="row">
              <p>Bạn chưa có tài khoản? <a href="/account/register_form.jsp">Đăng ký tại đây</a></p>
            </div>
          </div>
        </div>
      </div>
    </div>
    <c:set var="status" value="${statusLogin}"></c:set>
    <div id="canh-bao" style="display: none;"></div>
  </div>
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
    document.getElementById("statusLogin").innerText = "Tên đăng nhập hoặc mật khẩu không đúng";
  }
</script>
</body>
</html>
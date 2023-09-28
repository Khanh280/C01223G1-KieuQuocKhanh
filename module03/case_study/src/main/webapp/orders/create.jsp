<%--
  Created by IntelliJ IDEA.
  User: TRUNG THIEN
  Date: 5/9/2023
  Time: 19:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm user</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<body>
<div class="container-fluid">
    <div class="row">
        <h1>Thêm mới user</h1>
    </div>
    <div class="row">
        <div>
            <form method="post" action="/customer?action=create">
                <label>Tên đăng nhập</label>
                <input class="form-control" type="text" name="userName"><br>
                <label>Mật khẩu</label>
                <input class="form-control" type="password" name="password"><br>
                <label>Họ và Tên</label>
                <input class="form-control" type="text" name="fullName"><br>
                <label>Email</label>
                <input class="form-control" type="email" name="email"><br>
                <label>Số điện thoại</label>
                <input class="form-control" type="number" name="phoneNumber"><br>
                <label>Địa chỉ</label>
                <input class="form-control" type="text" name="address"><br>
                <button class="btn btn-success">Thêm</button>
                <button class="btn btn-success" type="button" onclick="window.location.href='/customer'">Xem danh sách</button>
            </form>
            <p style="color: blue;font-weight: bold;justify-content: center">${mess}</p>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>


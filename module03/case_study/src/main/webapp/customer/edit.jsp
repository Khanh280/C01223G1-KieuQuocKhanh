<%--
  Created by IntelliJ IDEA.
  User: TRUNG THIEN
  Date: 5/11/2023
  Time: 01:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Sửa thông tin khách hàng</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="regex.css">
</head>
<body>
<nav class="navbar navbar-expand-lg bg-body-tertiary" style="background-color: orange">
    <div class="container-fluid">
        <a id="ig1-user-page" href="/product" class="navbar-brand">IG1 Store</a>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li clx ass="nav-item">
                    <a class="nav-link active" aria-current="page" href="/account-servlet?action=logout">Đăng xuất</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                       aria-expanded="false">
                        Quản lý
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" style="color: black" href="/product">Sản phẩm</a></li>
                        <li><a class="dropdown-item" style="color: black" href="/customer-servlet">Khách hàng</a></li>
                        <li><a class="dropdown-item" style="color: black" href="/order-servlet">Đặt hàng</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>
<%--<div class="container-fluid">--%>
<%--    <div class="row justify-content-center" >--%>
<%--        <div class="col-auto">--%>
<%--           <h2>Sửa thông tin khách hàng</h2>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--    <div class="row">--%>
<%--        <div class="col-3">--%>
<%--        </div>--%>
<%--        <div class="col-6">--%>

<%--        </div>--%>
<%--        <div class="col-3">--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>
<div class="container-fluid h-100">
    <div class="row d-flex justify-content-center">
        <div class="col-12 col-md-9 col-lg-7 col-xl-6">
            <div class="container p-5">
                <h2 class="text-uppercase text-center mb-5">SỬA THÔNG TIN KHÁCH HÀNG</h2>
                <form method="post" action="/customer-servlet?action=edit">
                    <input hidden type="text" name="id" value="${customer.getId()}"><br>
                    <label>Họ và tên</label>
                    <input class="form-control" required type="text" name="fullName" placeholder="Nhập họ và tên" value="${customer.getName()}"><br>
                    <label>Email</label>
                    <input class="form-control" required type="email" name="email" placeholder="Nhập email" value="${customer.getEmail()}"><br>
                    <label>Số điện thoại</label>
                    <input class="form-control" required type="number" name="phoneNumber" placeholder="Nhập số điện thoại" value="${customer.getPhoneNumber()}"><br>
                    <label>Địa chỉ</label>
                    <input class="form-control" required type="text" name="address" value="${customer.getAddress()}"><br>
                    <div class="mt-3">
                        <ul class="d-flex justify-content-between list-unstyled">
                            <li>
                                <button class="btn btn-warning">Sửa</button>
                            </li>
                            <li>
                                <button type="button" onclick="window.location.href='/customer-servlet'" class="btn btn-primary">Trở lại</button>
                            </li>
                        </ul>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<%--Modal thông báo--%>
<div class="modal fade" id="deleteResultModal3" tabindex="-1" aria-labelledby="deleteResultModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <c:if test="${check}">
                    <div class="d-flex justify-content-center">
                        <h5 style="color: darkgreen">Sửa thành công!</h5>
                    </div>
                </c:if>
                <c:if test="${check == false}">
                    <div>
                        <h5 style="color: red" class="d-flex justify-content-center">Sửa thất bại!</h5>
                    </div>
                </c:if>
            </div>
            <div class="modal-footer" style="height: 49px">
            </div>
        </div>
    </div>
</div>
<footer class="text-center text-lg-start bg-light text-muted" style=" bottom: 0;right: 0;left: 0">
    <div class="text-center p-4" style="background-color: orange; color: black">
        © 2023 Copyright:
        <a class="text-reset fw-bold" href="https://mdbootstrap.com/">ig1store.com</a>
    </div>
</footer>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous">
</script>
<c:if test="${check || check == false}">
    <script>
        let deleteResultModal = new bootstrap.Modal(document.getElementById('deleteResultModal3'));
        deleteResultModal.show();
    </script>
</c:if>
</body>
</html>

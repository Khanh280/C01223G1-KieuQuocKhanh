<%--
  Created by IntelliJ IDEA.
  User: TRUNG THIEN
  Date: 5/9/2023
  Time: 18:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Danh sách</title>
    <style>
        #ig1-user-page {
            color: black;
        }

        #ig1-user-page:hover {
            color: white;
        }

        #navbarSupportedContent ul li:hover a {
            color: white;
        }

        #navbarSupportedContent ul li a {
            color: black;
        }
    </style>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<body>

<nav class="navbar navbar-expand-lg bg-body-tertiary" style="background-color: orange">
    <div class="container-fluid">
        <a id="ig1-user-page" href="#" class="navbar-brand">IG1 Store</a>
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
                        <li><a class="dropdown-item" style="color: black" href="/accessory">Phụ kiện</a></li>
                        <li><a class="dropdown-item" style="color: black" href="/customer-servlet">Khách hàng</a></li>
                        <li><a class="dropdown-item" style="color: black" href="/order-servlet">Hóa đơn</a></li>
                    </ul>
                </li>
            </ul>
            <form class="d-flex m-0" role="search" action="/order-servlet" method="get">
                <input type="text" name="action" value="searchCustomerOrder" hidden>
                <input class="form-control me-2" type="search" placeholder="Tên khách hàng" aria-label="Search"
                       name="customerName" value="${customerName}">
                <input class="form-control me-2" type="search" placeholder="Số điện thoại" aria-label="Search"
                       name="phoneNumber" value="${phoneNumber}">
                <button class="btn btn-outline-dark" type="submit">Tìm</button>
            </form>
        </div>
    </div>
</nav>

<div class="row">
    <div class="container-fluid my-lg-2">
        <div class="row">
            <div class="col-1"></div>
            <div class="col-10">
                <h3 class="text-center">DANH SÁCH HÓA ĐƠN</h3>
                <hr>
                <div class="container text-left">
                    <table id="tableProduct" class="table table-striped table-bordered"
                           style="width:100%; margin-top: 20px">
                        <thead>
                        <tr>
                            <th scope="col">ID</th>
                            <th scope="col">Tên</th>
                            <th scope="col">Email</th>
                            <th scope="col">SĐT</th>
                            <th scope="col">Địa chỉ</th>
                            <th scope="col">Ngày mua hàng</th>
                            <th scope="col">Thao tác</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="limitDAOList" items="${limitDAOList}">
                            <tr>
                                <td>${limitDAOList.getId()}</td>
                                <td>${limitDAOList.getName()}</td>
                                <td>${limitDAOList.getEmail()}</td>
                                <td>${limitDAOList.getPhoneNumber()}</td>
                                <td>${limitDAOList.getAddress()}</td>
                                <td>${limitDAOList.getOrderDate()}</td>
                                <td>
                                    <button type="submit" class="btn btn-danger" data-bs-toggle="modal"
                                            data-bs-target="#exampleModal"
                                            onclick="window.location.href='/order-detail-servlet?action=orderDetail&customerId=${limitDAOList.getId()}'">
                                        Chi tiết đơn hàng
                                    </button>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="col-1"></div>
            </div>
        </div>

        <div id="pagination" class="row col-lg-12">
            <nav aria-label="Page navigation example" style="height: 100%; width: 100%">
                <ul class="pagination justify-content-center">
                    <li class="page-item">
                        <a class="page-link" href="#">Trước</a>
                    </li>
                    <c:forEach varStatus="i" begin="1" end="${Math.ceil(customerDAOListSize/6)}">
                        <li class="page-item"><a class="page-link"
                                                 href="/order-servlet?action=orderPage&page=${i.count}">${i.count}</a>
                        </li>
                    </c:forEach>
                    <li class="page-item">
                        <a class="page-link" href="#">Sau</a>
                    </li>
                </ul>
            </nav>
        </div>
        <footer class="text-center text-lg-start bg-light text-muted" style=" position: fixed; bottom: 0;right: 0;left: 0">
            <div class="text-center p-4" style="background-color: orange; color: black">
                © 2023 Copyright:
                <a class="text-reset fw-bold" href="https://mdbootstrap.com/">ig1store.com</a>
            </div>
        </footer>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
<%--&lt;%&ndash;--%>
<%--  Created by IntelliJ IDEA.--%>
<%--  User: Admin--%>
<%--  Date: 11/05/2023--%>
<%--  Time: 8:34 SA--%>
<%--  To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Title</title>--%>
<%--    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"--%>
<%--          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">--%>
<%--</head>--%>
<%--<body>--%>
<%--<nav class="navbar navbar-expand-lg bg-body-tertiary" style="background-color: orange">--%>
<%--    <div class="container-fluid">--%>
<%--        <a id="ig1-user-page" href="/products-servlet?action=displayUser" class="navbar-brand">IG1 Store</a>--%>
<%--        <div class="collapse navbar-collapse" id="navbarSupportedContent">--%>
<%--            <ul class="navbar-nav me-auto mb-2 mb-lg-0">--%>
<%--                <li class="nav-item">--%>
<%--                    <a class="nav-link active" aria-current="page" href="/order-servlet">Home</a>--%>
<%--                </li>--%>
<%--            </ul>--%>
<%--            <form class="d-flex m-0" role="search" action="/products-servlet" method="get">--%>
<%--                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" name="productName">--%>
<%--                <button class="btn btn-outline-dark" type="submit">Search</button>--%>
<%--            </form>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</nav>--%>
<%--<div>--%>
<%--    <c:if test="${statusOrderDetail == true}">--%>
<%--        <p>Mua thanh cong</p>--%>
<%--    </c:if>--%>
<%--    <c:if test="${statusOrderDetail == false}">--%>
<%--        <p>Mua that bai</p>--%>
<%--    </c:if>--%>
<%--</div>--%>
<%--<div>--%>
<%--    <table class="table table-hover">--%>
<%--        <thead>--%>
<%--        <tr>--%>
<%--            <th scope="col">ID</th>--%>
<%--            <th scope="col">Name</th>--%>
<%--            <th scope="col">Producs Type</th>--%>
<%--            <th scope="col">Describe</th>--%>
<%--            <th scope="col">Price</th>--%>
<%--            <th scope="col">Create At</th>--%>
<%--            <th scope="col">Update At</th>--%>
<%--            <th scope="col">Actions</th>--%>
<%--        </tr>--%>
<%--        </thead>--%>
<%--        <tbody>--%>
<%--        <c:forEach var="product" items="${productList}">--%>
<%--            <tr>--%>
<%--                <td>${product.getId()}</td>--%>
<%--                <td>${product.getName()}</td>--%>
<%--                <td>--%>
<%--                    <c:if test="${product.getProductType() == 1}">--%>
<%--                        Phone--%>
<%--                    </c:if>--%>
<%--                    <c:if test="${product.getProductType() == 2}">--%>
<%--                        Accessory--%>
<%--                    </c:if>--%>
<%--                </td>--%>
<%--                <td>${product.getDescribe()}</td>--%>
<%--                <td>${product.getPrice()}</td>--%>
<%--                <td>${product.getCreatAt()}</td>--%>
<%--                <td>${product.getUpdateAt()}</td>--%>
<%--                <td>--%>
<%--                    <button class="btn btn-warning"--%>
<%--                            onclick="window.location.href='/order-servlet?action=buy&productId=${product.getId()}&customerId=${customerId}'">--%>
<%--                        Buy--%>
<%--                    </button>--%>
<%--                </td>--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--        </c:forEach>--%>
<%--        </tbody>--%>
<%--    </table>--%>
<%--</div>--%>
<%--</body>--%>
<%--<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"--%>
<%--        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"--%>
<%--        crossorigin="anonymous"></script>--%>
<%--</html>--%>

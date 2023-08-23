<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 02/05/2023
  Time: 8:51 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>IG1 Store</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <style>
        #ig1-user-page{
            color: black;
        }
        #ig1-user-page:hover{
            color: white;
        }
        #navbarSupportedContent ul li:hover a{
            color: white;
        }

        #navbarSupportedContent ul li a {
            color: black;
        }
    </style>
</head>
<body>

<nav class="navbar navbar-expand-lg bg-body-tertiary" style="background-color: orange">
    <div class="container-fluid">
        <a id="ig1-user-page" href="/products-servlet?action=displayUser" class="navbar-brand">IG1 Store</a>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/admin/admin.jsp">Home</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Manager
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" style="color: black" href="/product-servlet">Products</a></li>
                        <li><a class="dropdown-item" style="color: black" href="/customer-servlet">Customers</a></li>
                        <li><a class="dropdown-item" style="color: black" href="/order-servlet">Order</a></li>
                    </ul>
                </li>
            </ul>
            <form class="d-flex m-0" role="search" action="/products-servlet" method="get">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" name="productName">
                <button class="btn btn-outline-dark" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>

<div class="my-3">
    <button type="button" class="btn btn-primary mx-2" onclick="window.location.href='/orders/create.jsp'">Create Order
    </button>
</div>

<div>
    <table class="table table-hover">
        <thead>
        <tr>
            <th scope="col">Order ID</th>
            <th scope="col">Customer</th>
            <th scope="col">Price</th>
            <th scope="col">Create Date</th>
            <th scope="col">Manipulate</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="orderList" items="${orderList}">
            <tr>
                <td>${orderList.getId()}</td>
                <td>${orderList.getCustomerName()}</td>
                <td>${orderList.getPrice()}</td>
                <td>${orderList.getOrderDate()}</td>
                <td>
                    <button type="submit" class="btn btn-danger" data-bs-toggle="modal"
                            data-bs-target="#exampleModal"
                            onclick="deleteOrder('${orderList.getId()}','${orderList.getCustomerName()}')">
                        Delete
                    </button>
                    <button class="btn btn-warning"
                            onclick="window.location.href='/order-servlet?action=update&id=${orderList.getId()}'">
                        Update
                    </button>
                    <button class="btn btn-info">Detail</button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<div class="modal fade" id="exampleModal" tabindex="-1"
     aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="exampleModalLabel">Delete Order</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal"
                        aria-label="Close"></button>
            </div>
            <form action="/order-servlet" method="post">
                <div class="modal-body">
                    <input type="text" name="action" value="delete" hidden>
                    <input type="text" id="orderId" name="id" hidden>
                    Do you want to delete the order <span id="customerName"></span> ?
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">No</button>
                    <button type="submit" class="btn btn-primary">
                        Yes
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>
<%--<nav aria-label="Page navigation example">--%>
<%--    <ul class="pagination justify-content-end">--%>
<%--        <li class="page-item">--%>
<%--            <a class="page-link" href="#">Previous</a>--%>
<%--        </li>--%>
<%--        <c:forEach varStatus="i" begin="1" end="${Math.ceil(productListSize/10.0)}">--%>
<%--            <li class="page-item"><a class="page-link"--%>
<%--                                     href="/products-servlet?action=displayPageAdmin&page=${i.count}">${i.count}</a>--%>
<%--            </li>--%>
<%--        </c:forEach>--%>
<%--        <li class="page-item">--%>
<%--            <a class="page-link" href="#">Next</a>--%>
<%--        </li>--%>
<%--    </ul>--%>
<%--</nav>--%>
<script>
    function deleteOrder(id, name) {
        document.getElementById("orderId").value = id;
        document.getElementById("customerName").innerText = name;
    }
</script>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</html>

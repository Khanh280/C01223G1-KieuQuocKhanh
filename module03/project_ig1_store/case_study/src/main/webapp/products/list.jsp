<%--
  Created by IntelliJ IDEA.
  User: lapto
  Date: 5/8/2023
  Time: 5:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
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
<body>
<%--<center>--%>
<%--    <h1>Products Of Management</h1>--%>
<%--    <h2>--%>
<%--        <a href="/product?action=create">Add New Product</a>--%>
<%--    </h2>--%>
<%--</center>--%>
<%--<div align="center">--%>
<%--    <form action="product?action=search" method="post">--%>
<%--        <input type="text" name="name" placeholder="Search follow name">--%>
<%--        <select name="price" id="">--%>
<%--            <option value="1">Dưới 5 triệu</option>--%>
<%--            <option value="2">5-10 triệu</option>--%>
<%--            <option value="3">10-15 triệu</option>--%>
<%--            <option value="3">Trên 15 triệu</option>--%>
<%--        </select>--%>
<%--        <input type="submit" value="Search">--%>
<%--    </form>--%>
<%--    <table border="1" cellpadding="5">--%>
<%--        <caption><h2>List of Users</h2></caption>--%>
<%--        <tr>--%>
<%--            <th>ID</th>--%>
<%--            <th>Name</th>--%>
<%--            <th>Producs Type</th>--%>
<%--            <th>Describe</th>--%>
<%--            <th>Price</th>--%>
<%--            <th>Image</th>--%>
<%--            <th>Create At</th>--%>
<%--            <th>Update At</th>--%>
<%--            <th>Actions</th>--%>
<%--        </tr>--%>
<%--        <c:forEach var="product" items="${productList}">--%>
<%--            <tr>--%>
<%--                <td>${product.getId()}</td>--%>
<%--                <td>${product.getName()}</td>--%>
<%--                <td>--%>
<%--                    <c:if test="${product.getProductType() == 1}">--%>
<%--                        Iphone--%>
<%--                    </c:if>--%>
<%--                    <c:if test="${product.getProductType() == 2}">--%>
<%--                        SamSung--%>
<%--                    </c:if>--%>
<%--                    <c:if test="${product.getProductType() == 3}">--%>
<%--                        Vivo--%>
<%--                    </c:if>--%>
<%--                    <c:if test="${product.getProductType() == 4}">--%>
<%--                        Asus--%>
<%--                    </c:if>--%>
<%--                    <c:if test="${product.getProductType() == 5}">--%>
<%--                        OPPO--%>
<%--                    </c:if>--%>
<%--                </td>--%>
<%--                <td>${product.getDescribe()}</td>--%>
<%--                <td>${product.getPrice()}</td>--%>
<%--                <td>${product.getProductImage()}</td>--%>
<%--                <td>${product.getCreatAt()}</td>--%>
<%--                <td>${product.getUpdateAt()}</td>--%>
<%--                <td>--%>
<%--                    <a href="/product?action=edit&id=${product.getId()}">Edit</a>--%>
<%--                    <form action="/product?action=delete" method="post">--%>
<%--                        <input name="id" value="${product.getId()}" hidden>--%>
<%--                        <button type="submit">Delete</button>--%>
<%--                    </form>--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--        </c:forEach>--%>
<%--    </table>--%>
<%--</div>--%>

<nav class="navbar navbar-expand-lg bg-body-tertiary" style="background-color: orange">
    <div class="container-fluid">
        <a id="ig1-user-page" href="/products-servlet?action=displayUser" class="navbar-brand">IG1 Store</a>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/admin/admin.jsp">Home</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                       aria-expanded="false">
                        Manager
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" style="color: black" href="/product-servlet">Products</a></li>
                        <li><a class="dropdown-item" style="color: black" href="/customer-servlet">Customers</a></li>
                        <li><a class="dropdown-item" style="color: black" href="/order-servlet">Order</a></li>
                    </ul>
                </li>
            </ul>
            <form class="d-flex m-0" role="search" action="/product-servlet?action=search" method="post">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search"
                       name="name">
                <select name="price" id="">
                    <option value="1">Dưới 5 triệu</option>
                    <option value="2">5-10 triệu</option>
                    <option value="3">10-15 triệu</option>
                    <option value="4">Trên 15 triệu</option>
                </select>
                <button class="btn btn-outline-dark" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>
<div class="my-3">
    <button type="button" class="btn btn-primary mx-2" onclick="window.location.href='/products/create.jsp'">
        Create Product
    </button>
</div>

<div>
    <table class="table table-hover">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Name</th>
            <th scope="col">Producs Type</th>
            <th scope="col">Describe</th>
            <th scope="col">Price</th>
<%--            <th scope="col">Image</th>--%>
            <th scope="col">Create At</th>
            <th scope="col">Update At</th>
            <th scope="col">Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="product" items="${productList}">
            <tr>
                <td>${product.getId()}</td>
                <td>${product.getName()}</td>
                <td>
                    <c:if test="${product.getProductType() == 1}">
                        Phone
                    </c:if>
                    <c:if test="${product.getProductType() == 2}">
                        Accessory
                    </c:if>
                </td>
                <td>${product.getPrice()}</td>
                <td>${product.getCreatAt()}</td>
                <td>${product.getUpdateAt()}</td>
                <td>
                    <button type="submit" class="btn btn-danger" data-bs-toggle="modal"
                            data-bs-target="#exampleModal"
                            onclick="deleteProduct('${product.getId()}','${product.getName()}')">
                        Delete
                    </button>
                    <button class="btn btn-warning"
                            onclick="window.location.href='/product-servlet?action=edit&id=${product.getId()}'">
                        Update
                    </button>
                    <button class="btn btn-info">Detail</button>
                </td>

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
                <h1 class="modal-title fs-5" id="exampleModalLabel">Delete Product</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal"
                        aria-label="Close"></button>
            </div>
            <form action="/product-servlet" method="post">
                <div class="modal-body">
                    <input type="text" name="action" value="delete" hidden>
                    <input type="text" id="productId" name="id" hidden>
                    Do you want to delete the product <span id="productName"></span> ?
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
<script>
    function deleteProduct(id, name) {
        document.getElementById("productId").value = id;
        document.getElementById("productName").innerText = name;
    }
</script>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</html>

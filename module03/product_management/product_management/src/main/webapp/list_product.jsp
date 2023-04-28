<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 28/04/2023
  Time: 10:10 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Product Management</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
</head>
<body>
<div style="text-align: center">
    <nav class="navbar navbar-light bg-light">
        <div class="container-fluid">
            <h2>Product List</h2>
            <form class="d-flex" action="/product-servlet" method="get">
                <input type="hidden" name="action" value="search"/>
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" name="productName" value="${productName}">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
        </div>
    </nav>
</div>
<button class="btn btn-primary" onclick="window.location.href='/create.jsp' ">Create</button>

<div>
    <table class="table table-hover">
        <tr>
            <th>ID</th>
            <th>Product Name</th>
            <th>Price ($)</th>
            <th>Manipulate</th>
        </tr>
        <c:forEach items="${productList}" var="productList">
            <tr>
                <td>${productList.getId()}</td>
                <td>${productList.getProductName()}</td>
                <td>${productList.getPrice()}</td>
                <td>
                    <button type="submit" class="btn btn-warning"
                            onclick="window.location.href='/product-servlet?action=update&id=${productList.getId()}'">
                        Update
                    </button>

                    <button type="submit" class="btn btn-danger" data-bs-toggle="modal"
                            data-bs-target="#exampleModal${productList.getId()}">
                        Delete
                    </button>
                    <div class="modal fade" id="exampleModal${productList.getId()}" tabindex="-1"
                         aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel">Delete Product</h5>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                                            aria-label="Close"></button>
                                </div>
                                <div class="modal-body">
                                    Do you want to delete the product ${productList.getProductName()} ?
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">No</button>
                                    <button type="button" class="btn btn-danger"
                                            onclick="window.location.href='/product-servlet?action=delete&id=${productList.getId()}'">
                                        Yes
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- Button trigger modal -->
                    <button type="button" class="btn btn-info" data-bs-toggle="modal" data-bs-target="#staticBackdrop${productList.getId()}">
                        Detail
                    </button>

                    <!-- Modal -->
                    <div class="modal fade" id="staticBackdrop${productList.getId()}" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="staticBackdropLabel">Product Detail</h5>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                </div>
                                <div class="modal-body">
                                    <p>Id :${productList.getId()}</p>
                                    <p>Product Name :${productList.getProductName()}</p>
                                    <p>Price :${productList.getPrice()}</p>
                                    <p>Product Detail :${productList.getProductDetail()}</p>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>

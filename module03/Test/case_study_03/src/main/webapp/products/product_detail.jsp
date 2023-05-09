<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 02/05/2023
  Time: 10:02 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>IG1 Store</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="../users/user.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <style>
        *{
            margin: 0px;
            padding: 0px;
            box-sizing: border-box;
        }
        #shopping-cart {
            display: flex;
            justify-content: center;
            height: 100%;
            width: 5vw;
        }

        #shopping-cart #shopping-icon {
            font-size: 30px;
            color: black;
        }
        #shopping-cart #shopping-icon:hover {
            color: white;
        }
        #detail-product{
            /*margin-top: 7vh;*/
        }
        #product-name{
            margin-top: 7vh;
        }
    </style>
</head>
<body>
<div id="header" class="row" style="height: 5vh;position: fixed; top:0px;right: 0px;left: 0px; z-index: 1">
    <nav class="navbar navbar-expand-lg" style="background-color: #d96640;">
        <div class="container-fluid">
            <a class="navbar-brand header-link" href="#">Navbar</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                    aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="header-link nav-link active" aria-current="page" href="#">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="header-link nav-link" href="#">Link</a>
                    </li>
                </ul>
                <form class="d-flex m-0" role="search" action="/products-servlet" method="get">
                    <input type="text" name="action" value="searchUser" hidden>
                    <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search"
                           name="productName">
                    <button class="btn btn-outline-dark" type="submit">Search</button>
                </form>
            </div>
            <div id="shopping-cart">
                <a id="shopping-icon" href="#"><i class="fa-solid fa-cart-shopping"></i></a>
            </div>
        </div>
    </nav>
</div>
<div class="container">
    <div id="product-name" class="row col-lg-12">
        <h1>Name product</h1>
    </div>
    <div id="detail-product" class="row col-lg-12 h-50 bg-dark" >
        <div class="col-lg-6 bg-primary"></div>
        <div class="col-lg-6"></div>
    </div>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</html>

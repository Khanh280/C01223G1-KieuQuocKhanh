<%@ page import="models.model.Account" %>
<%@ page import="models.model.Customer" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>IG1 Store</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>
    <style>
        .carousel {
            width: 100%;
            position: relative;
            margin-top: 70px;
        }

        .wrapper {
            max-width: 1170px;
        }

        h3 {
            font-size: 18px;
            padding: 10px 20px;
            display: inline-block;
            background-color: #dddddd;
            font-weight: 500;
            margin-bottom: 10px;
        }

        ul.products {
            display: flex;
            flex-wrap: wrap;
            list-style: none;
            width: 100%;
            margin-left: 75px;
            margin-bottom: 0;
        }

        ul.products li {
            flex-basis: 17%;
            padding: 0;
            box-sizing: border-box;
            margin: 10px 12.5px;
        }

        ul.products li .product-top {
            position: relative;
            overflow: hidden;
        }

        ul.products li .product-top .product-thumb {
            display: block;
            height: 20vw;
            padding-bottom: 100%;
            position: relative;
            overflow: hidden;
        }


        ul.products li:hover .product-top .product-thumb img {
            transform: scale(1.1);
            transition: 0.5s ease-in-out;
        }

        ul.products li .product-top .product-thumb img {
            display: block;
            width: 100%;
            height: 200px;
            position: absolute;
            top: auto;
            border-radius: 10px;
        }

        ul.products li .product-top a.buy-now {
            text-transform: uppercase;
            text-decoration: none;
            text-align: center;
            display: block;
            background-color: red;
            color: white;
            padding: 10px 0;
            position: absolute;
            width: 100%;
            bottom: -80px;
            transition: 0.5s ease-in-out;
            opacity: 0.75;
        }

        ul.products li:hover .product-top a.buy-now {
            bottom: 0;
        }

        ul.products li .product-info {
            padding: 10px 0;
        }

        ul.products li .product-info a {
            display: block;
            text-decoration: none;
        }

        ul.products li .product-info a.product-cat {
            font-size: 12px;
            text-transform: uppercase;
            padding: 3px 0;
        }

        ul.products li .product-info a.product-name {
            padding: 2px 0;
            font-weight: 600;
        }

        div.previous {
            width: 20px;
            padding-top: 90px;
            margin-right: 20px;
        }

        div.next {
            width: 20px;
            padding-top: 90px;
            margin-left: 20px;
        }

        a:hover {
            cursor: pointer;
        }

        .fade {
            transition: 0.5s ease-in-out;
        }

        .modal-header {
            background: linear-gradient(to bottom, orange, #FEB58A);
            text-align: center;
            border: none;
        }

        .modal-body {
            display: inline-block;
        }


        .modal-body .card {
            margin-left: 140px;
        }

        .modal-body .card {
            max-width: 200px;
            max-height: 300px;
        }

        .card-info ul li {
            list-style: none;
        }

        .card-info ul li span {
            display: block;
        }

        .modal-footer {
            background: linear-gradient(to bottom, #00c6ff, #aaaaaa);
            justify-content: center;
        }

        .modal-footer button {
            background-color: orange;
            color: black;
            border: none;
        }

        .modal-footer button:hover {
            background-color: yellow;
            box-shadow: white;
        }

        table, th, td {
            color: black;
        }

        table {
            border: 1px solid black;
            margin-top: 10px;
            border-collapse: collapse;
        }

        .card-info table tr th {
            padding: 5px 20px;
        }

        table th, td {
            border: 1px solid white;
        }

        .product img {
            border-radius: 0 !important;
        }

        .product {
            background-color: white;
            margin-left: 0;
        }

        a span {
            color: black;
            background-color: orange;
            height: 70px;
            border-radius: 20px;
            width: 33px;
        }

        .product-name {
            font-weight: 600;
        }

        @media (max-width: 1024px) {
            div.previous {
                width: 20px;
                padding-top: 90px;
                margin-right: 20px;
            }

            div.next {
                width: 20px;
                padding-top: 90px;
                margin-left: 20px;
            }

            ul.products {
                display: flex;
                flex-wrap: wrap;
                list-style: none;
                justify-content: center;
                width: 80%;
                margin-left: 50px;
                margin-bottom: 0;
            }

            ul.products li {
                flex-basis: 26%;
                padding: 0;
                box-sizing: border-box;
                margin: 10px 7.5px;
            }
        }

        @media (max-width: 600px) {
            div.previous {
                width: 20px;
                padding-top: 70px;
                margin-right: 20px;
            }

            div.next {
                width: 20px;
                padding-top: 70px;
                margin-left: 20px;
            }

            ul.products {
                display: flex;
                flex-wrap: wrap;
                list-style: none;
                justify-content: center;
                width: 80%;
                margin-left: 30px;
                margin-bottom: 0;
            }

            ul.products li {
                flex-basis: 26%;
                padding: 0;
                box-sizing: border-box;
                margin: 10px 7.5px;
            }
        }

        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: Arial;
        }


        header {
            width: 100%;
            height: 60px;
            display: flex;
            justify-content: space-between;
            align-items: center;
            position: fixed;
            z-index: 99;
            box-shadow: 0 0 10px orange;
            background-color: orange;
            margin-bottom: 30px;
        }

        #chk1 {
            display: none;
        }

        i {
            color: #fff;
            cursor: pointer;
        }

        header img {
            height: 45px;
            width: 200px;
            margin-left: 2vw;
        }

        header .logo {
            flex: 1;
            color: #fff;
            text-transform: uppercase;
            margin-left: 10px;
            display: flex;
        }

        header .search-box {
            flex: 1;
            position: relative;
            /*margin-left: -20px;*/
        }

        .search-box {
            flex: 1;
            position: relative;
        }

        .search-box input {

            height: 40px;
            border: none;
            outline: none;
            background: #f2f2f2;
            border-radius: 30px;
            color: gray;
            font-size: 18px;
            text-align: left;
            padding-left: 5px;
            padding-right: 40px;
            color: black;
            font-weight: 300;
            width: 400px;
            margin-left: 10px;
        }

        .search-box button {
            cursor: pointer;
            width: 40px;
            height: 40px;
            border-radius: 30px;
            border: none;
            position: absolute;
            top: 0;
            right: 0;
            transform: scale(0.9);
            background: orange;
        }

        header ul {
            flex: 2;
            display: flex;
            justify-content: space-evenly;
        }

        header ul li {
            list-style: none;
            padding: 10px;
        }

        header ul li:hover {
            background-color: orange;
        }

        header ul li a {
            text-decoration: none;
            color: black;
            font-weight: 600;
            text-transform: uppercase;
            padding: 10px 15px 12px;
        }

        header ul li a:hover {
            cursor: pointer;
        }

        header .menu {
            font-size: 2.5em;
            display: none;
            margin-right: 10px;
        }

        header img:hover {
            cursor: pointer;
        }

        div.dropdown-row > a.dropdown-item {
            display: inline-block;
            width: 40%;
            padding: 60px 0;
            vertical-align: top;
        }

        .iconm {
            color: white;
            height: 25px;
            width: 25px;
        }

        /*--------------------------------------------------------------*/
        .nut_dropdown {
            color: black;
            font-size: 16px;
            border: none;
        }

        .nut_dropdown:hover {
            padding-bottom: 10px;
        }

        .dropdown {
            position: relative;
            display: inline-block;
        }

        /* Nội dung Dropdown */
        .noidung_dropdown {
            top: 35px;
            left: -10px;
            display: none;
            position: absolute;
            background-color: orange;
            width: 550px;
            box-shadow: 0 8px 16px 0 rgba(0, 0, 0, 0.2);
            z-index: 1;
        }

        /* Thiết kế style cho các đường dẫn tronng Dropdown */
        .noidung_dropdown a {
            color: black;
            text-decoration: none;
        }

        /* thay đổi màu background khi hover vào đường dẫn */
        .noidung_dropdown a:hover {
            background-color: orange;
        }

        /* hiển thị nội dung dropdown khi hover */
        .dropdown:hover .noidung_dropdown {
            display: block;
        }

        /* Thay đổi màu background cho nút khi được hover */
        .dropdown:hover .nut_dropdown {
            background: orange;
        }

        /*Dùng Để hiển thị nội dung*/
        .hienThi {
            display: inline-block;
        }

        header ul li div a {
            text-decoration: none;
            color: black;
            font-weight: 600;
            text-transform: uppercase;
            padding: 10px 15px;
        }

        /*-------------------------------------------  */
        @media (max-width: 1024px) {
            .search-box {
                position: absolute;
            }

            header {
                width: 100%;
                display: flex;
                justify-content: left;
                align-items: center;
            }

            header ul {
                position: fixed;
                top: 80px;
                left: -100%;
                background: orange;
                width: 40%;
                height: 400px;
                flex-direction: column;
                transition: 0.5s ease-in-out;
            }

            header .menu {
                display: block;
                width: 70px;
                text-align: center;
            }

            header .menu label svg:hover {
                cursor: pointer;
            }

            #chk1:checked ~ ul {
                left: 0;
                transition: 0.5s ease-in-out;
            }

            header ul li {
                padding: 20px 0;
                margin: 0;
            }

            .search-box input {
                height: 60px;
                border: none;
                outline: none;
                background: orange;
                border-radius: 30px;
                color: gray;
                font-size: 30px;
                text-align: left;
                padding-left: 5px;
                padding-right: 0;
                color: black;
                font-weight: 400;
                width: 660px;
                margin-left: 20px;
            }

            .search-box button {
                width: 60px;
                height: 60px;
                right: 150px;
            }
        }

        @media (max-width: 800px) {

            header .logo {
                font-size: 10px;
                margin-left: 8px;
            }

            header ul {
                width: 60%;
                position: fixed;
                left: -100%;
                background: orange;
                height: 400px;
                flex-direction: column;
                transition: 0.5s ease-in-out;
            }

            .search-box input {
                display: block;
            }

            .search-box input {
                height: 60px;
                border: none;
                outline: none;
                background: #f2f2f2;
                border-radius: 30px;
                color: gray;
                font-size: 30px;
                text-align: left;
                padding-left: 5px;
                padding-right: 0;
                color: black;
                font-weight: 400;
                width: 600px;
            }

            .search-box button {
                width: 60px;
                height: 60px;
                right: 0;
            }
        }

        @media (max-width: 600px) {
            .search-box input {
                height: 60px;
                border: none;
                outline: none;
                background: #f2f2f2;
                border-radius: 30px;
                color: gray;
                font-size: 30px;
                text-align: left;
                padding-left: 5px;
                padding-right: 0;
                color: black;
                font-weight: 400;
                width: 400px;
            }

            .search-box button {
                width: 60px;
                height: 60px;
                right: 0;
            }
        }

        @media (max-width: 400px) {
            header {
                height: 200px;
            }

            header ul {
                top: 100px;
            }

            header ul {
                position: fixed;
                top: 200px;
                background: orange;
                width: 100%;
                height: 600px;
                flex-direction: column;
                transition: right 0.5s linear;
            }

            .search-box button {
                width: 60px;
                height: 60px;
                right: 100px;
            }

        }

        body {
            font-family: 'Muli', sans-serif;
            height: 100% !important;
            background-color: #fff !important;
            padding-bottom: 0 !important;
            margin-bottom: 0 !important;
            color: #000
        }

        .row-1 p {
            font-size: calc(12px + (14 - 12) * ((100vw - 360px) / (1600 - 360))) !important;
            text-align: center;
            color: #2CB8FE
        }

        h5 {
            font-size: calc(16px + (22 - 16) * ((100vw - 360px) / (1600 - 360))) !important
        }

        li {
            margin-top: 8px;
            margin-bottom: 8px;
            cursor: pointer
        }

        .carousel-indicators li {
            cursor: pointer;
            border-radius: 50% !important;
            width: 10px;
            height: 10px;
            opacity: 0.5;
            margin: -30px 15px 0 15px !important;
            color: #333;
            background-color: #333 !important;
            top: 50px !important;
            position: relative
        }

        .carousel-inner {
            border-radius: 15px !important
        }

        .card {
            color: #383431 !important;
            background-color: #FFFFFF !important
        }


        .bottom-row {
            color: #aaaaaa
        }

        i {
            font-size: 25px !important;
            margin-left: calc(15px + (24 - 20) * ((100vw - 360px) / (1600 - 360))) !important;
            cursor: pointer
        }


        .logo {
            height: calc(70px + (100 - 70) * ((100vw - 360px) / (1600 - 360))) !important;
            width: calc(90px + (134 - 90) * ((100vw - 360px) / (1600 - 360))) !important
        }

        .mobile-img {
            width: calc(200px + (234 - 200) * ((100vw - 360px) / (1600 - 360))) !important;
            height: calc(200px + (234 - 200) * ((100vw - 360px) / (1600 - 360))) !important
        }

        li {
            font-size: calc(15px + (18 - 15) * ((100vw - 360px) / (1600 - 360))) !important
        }

        li a {
            color: #000000;
        }

        li a:hover {
            color: white;
        }
    </style>
</head>
<body>
<c:set var="customerId" value="<%= ((Customer)session.getAttribute(\"userSession\")).getId() %>"></c:set>
<header class="sticky-top">
    <input type="checkbox" name="" id="chk1">
    <a href="/account-servlet?action=homeUser"><img src="../coollogo_com-32663401.png"></a>
    <div class="logo">
        <div class="search-box">
            <form action="/product?action=searchUser" method="post">
                <input style="margin-top: 30px" type="text" id="search" name="productName"
                       placeholder="Tìm kiếm theo tên điện thoại: Iphone...">
                <button style="margin-top: 30px">
                    <svg class="iconm" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512">
                        <path d="M416 208c0 45.9-14.9 88.3-40 122.7L502.6 457.4c12.5 12.5 12.5 32.8 0 45.3s-32.8 12.5-45.3 0L330.7 376c-34.4 25.2-76.8 40-122.7 40C93.1 416 0 322.9 0 208S93.1 0 208 0S416 93.1 416 208zM208 352a144 144 0 1 0 0-288 144 144 0 1 0 0 288z"></path>
                    </svg>
                </button>
            </form>
        </div>
    </div>
    <ul style="margin-top: 25px">
        <li style="cursor: pointer">
            <a href="/order-servlet?action=orderDetail&customerId=${customerId}">
                <svg class="iconm" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 576 512">
                    <path d="M0 24C0 10.7 10.7 0 24 0H69.5c22 0 41.5 12.8 50.6 32h411c26.3 0 45.5 25 38.6 50.4l-41 152.3c-8.5 31.4-37 53.3-69.5 53.3H170.7l5.4 28.5c2.2 11.3 12.1 19.5 23.6 19.5H488c13.3 0 24 10.7 24 24s-10.7 24-24 24H199.7c-34.6 0-64.3-24.6-70.7-58.5L77.4 54.5c-.7-3.8-4-6.5-7.9-6.5H24C10.7 48 0 37.3 0 24zM128 464a48 48 0 1 1 96 0 48 48 0 1 1 -96 0zm336-48a48 48 0 1 1 0 96 48 48 0 1 1 0-96z"></path>
                </svg>
                <span style="height: 15px; width: 15px;position: absolute"
                      class="badge rounded-pill badge-notification bg-danger"></span>Giỏ hàng
            </a>
        </li>
        <li (click)="checkProfile()"><a href="#">
            <svg class="iconm" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 448 512">
                <path d="M224 256A128 128 0 1 0 224 0a128 128 0 1 0 0 256zm-45.7 48C79.8 304 0 383.8 0 482.3C0 498.7 13.3 512 29.7 512H418.3c16.4 0 29.7-13.3 29.7-29.7C448 383.8 368.2 304 269.7 304H178.3z"></path>
            </svg>
            <%=((Customer) session.getAttribute("userSession")).getName()%>
        </a></li>
        <li style="cursor: pointer">
            <a href="/account-servlet?action=logout">
            Đăng xuất</a>
        </li>
    </ul>
    <div class="menu">
        <label for="chk1">
            <svg class="iconm" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 448 512">
                <path d="M0 96C0 78.3 14.3 64 32 64H416c17.7 0 32 14.3 32 32s-14.3 32-32 32H32C14.3 128 0 113.7 0 96zM0 256c0-17.7 14.3-32 32-32H416c17.7 0 32 14.3 32 32s-14.3 32-32 32H32c-17.7 0-32-14.3-32-32zM448 416c0 17.7-14.3 32-32 32H32c-17.7 0-32-14.3-32-32s14.3-32 32-32H416c17.7 0 32 14.3 32 32z"></path>
            </svg>
        </label>
    </div>
</header>
<div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel" style="margin-top: -2vw">
    <div class="carousel-inner">
        <div class="carousel-item">
            <img style="height: 500px"
                 src="https://cdn.hoanghamobile.com/i/home/Uploads/2023/05/06/web-galaxy-z-fold4-z-flip4-03.jpg"
                 class="d-block w-100" class="d-block w-100" alt="...">
        </div>
        <div class="carousel-item active">
            <img style="height: 500px"
                 src="https://cdn.hoanghamobile.com/i/home/Uploads/2023/05/08/redmi-note-12-series-pc.png" alt="...">
        </div>
        <div class="carousel-item">
            <img style="height: 500px"
                 src="https://cdn.hoanghamobile.com/i/home/Uploads/2023/05/10/14prm-pc_638193094251696370.png"
                 class="d-block w-100" alt="...">
        </div>
    </div>
    <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Previous</span>
    </button>
    <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Next</span>
    </button>
</div>

<div class="product row h-25">
    <img width="100%" height="100" loading="lazy" class=" lazyloaded"
         data-src="https://images.fpt.shop/unsafe/fit-in/1200x100/filters:quality(90):fill(white)/fptshop.com.vn/Uploads/Originals/2023/5/10/638193055769462434_H7_1200x100.png"
         src="https://images.fpt.shop/unsafe/fit-in/1200x100/filters:quality(90):fill(white)/fptshop.com.vn/Uploads/Originals/2023/5/10/638193055769462434_H7_1200x100.png">
    <div class="wrapper">
        <ul class="products">
            <c:forEach var="product" items="${productList}">
                <li>
                    <div class="product-item">
                        <div class="product-top">
                            <a href="/order-servlet?action=buy&productId=${product.getId()}&customerId=${customerId}" class="product-thumb">
                                <img style="margin-top: 1vw" src="${product.getProductImage()}">
                            </a>
                            <a href="/order-servlet?action=buy&productId=${product.getId()}&customerId=${customerId}"
                               class="buy-now" data-toggle="modal"
                               data-target="#detail">Mua ngay</a>
                        </div>
                    </div>
                    <div class="product-info">
                        <a href="" class="product-cart"></a>
                        <a href="/order-servlet?action=buy&productId=${product.getId()}&customerId=${customerId}" class="product-name">${product.getName()}</a>
                        <div class="product-price">${product.getPrice()}</div>
                    </div>
                </li>
            </c:forEach>
        </ul>
    </div>
</div>

<div id="pagination" class="row col-lg-12">
    <nav aria-label="Page navigation example" style="height: 100%; width: 100%">
        <ul class="pagination justify-content-center">
            <li class="page-item">
                <a class="page-link" href="#">Previous</a>
            </li>
            <c:forEach varStatus="i" begin="1" end="${Math.ceil(productListSize/15)}">
                <li class="page-item"><a class="page-link"
                                         href="/product?action=displayPageUser&page=${i.count}">${i.count}</a>
                </li>
            </c:forEach>
            <li class="page-item">
                <a class="page-link" href="#">Next</a>
            </li>
        </ul>
    </nav>
</div>

<div class="container-fluid mt-5 pt-5 " style="background-color: orange">
    <footer class="ml-xl-5 ml-md-4 ml-3 ">
        <div class="row justify-content-end">
            <div class=" col-12">
                <div class="row pt-2">
                    <div class="col-xl-4 col-12 mr-auto">
                        <div class="media flex-sm-row flex-column "><img class="align-self-center img-fluid mobile-img "
                                                                         src="https://i.imgur.com/unD7BGU.png">
                        </div>
                    </div>
                    <div class="col-xl-8 col-lg-12 col-md-12 col-sm-12 my-auto ">
                        <div class="row justify-content-around">
                            <div class="col-md-3 col-12 mt-md-0 mt-3">
                                <ul class="list-unstyled text-muted">
                                    <li><a style="color:black">Giới thiệu về công ty</a></li>
                                    <li><a style="color:black">Chính sách bảo mật</a></li>
                                    <li><a style="color:black">Quy chế hoạt động</a></li>
                                    <li><a style="color:black">Kiểm tra hóa đơn điện tử</a></li>
                                    <li><a style="color:black">Tra cứu thông tin bảo hành</a></li>
                                    <li><a style="color:black">Câu hỏi thường gặp mua hàng</a></li>
                                </ul>
                            </div>
                            <div class="col-md-3 col-12 mt-md-0 mt-3">
                                <ul class="list-unstyled text-muted">
                                    <li><a style="color:black">Tin tuyển dụng</a></li>
                                    <li><a style="color:black">Tin khuyến mãi</a></li>
                                    <li><a style="color:black">Hướng dẫn mua online</a></li>
                                    <li><a style="color:black">Hướng dẫn mua trả góp</a></li>
                                    <li><a style="color:black">Chính sách trả góp</a></li>
                                </ul>
                            </div>
                            <div class="col-md-auto col-12">
                                <ul class="list-unstyled text-muted">
                                    <li style="color:black">Tư vấn mua hàng (Miễn phí)</li>
                                    <li><a><span style="color: red">1800 6601</span></a></li>
                                    <li style="color:black">Góp ý, khiếu nại (8h00 - 22h00)</li>
                                    <li><a><span style="color: red;">1800 6616</span></a></li>
                                    <li style="color:black">Hỗ trợ thanh toán:</li>
                                    <li><img
                                            src="https://firebasestorage.googleapis.com/v0/b/c0822g1-mobile-shop-d949d.appspot.com/o/ho%20tro%20thanh%20toan.PNG?alt=media&amp;token=c70032a8-c5f0-40a1-a67f-3a9011ee772d">
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row mt-4 bottom-row justify-content-between">
                    <div class="col-sm-auto mr-sm-4 my-auto pt-sm-0 pt-3 ">
                        <p><span><i class="fa fa-instagram" aria-hidden="true"></i></span> <span><i
                                class="fa fa-twitter" aria-hidden="true"></i></span> <span><i class="fa fa-facebook"
                                                                                              aria-hidden="true"></i></span>
                            <span><i class="fa fa-linkedin" aria-hidden="true"></i></span></p>
                    </div>
                </div>
            </div>
        </div>
    </footer>
</div>
</body>
</html>
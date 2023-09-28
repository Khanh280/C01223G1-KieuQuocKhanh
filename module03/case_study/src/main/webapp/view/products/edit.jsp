<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>
    <style>
        #imageContainer {
            width: 50px;
            height: 50px;
        }

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
                        <li><a class="dropdown-item" style="color: black" href="/accessory">Phụ kiện</a></li>
                        <li><a class="dropdown-item" style="color: black" href="/customer-servlet">Khách hàng</a></li>
                        <li><a class="dropdown-item" style="color: black" href="/order-servlet">Hóa đơn</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>
<br>
<div class="container col-md-5">
    <div class="card border-5">
        <div class="card-body">
            <form  method="post" action="/product?action=edit">
                <caption>
                    <h2 style="text-align: center">
                        CHỈNH SỬA THÔNG TIN
                    </h2>
                </caption>
                <c:if test="${product != null}">
                    <input class="form-control" type="hidden" name="id" value="${product.getId()}"/><br>
                </c:if>
                <fieldset class="form-group">
                    <label>Tên sản phẩm :</label><input class="form-control" type="text" name="name"
                                                        value="${product.getName()}" required><br>
                </fieldset>

                <fieldset class="form-group">
                    <label hidden>Loại :</label> <select hidden class="form-control" name="productType" id=""  value="${product.getName()}">
                    <option value="1">Phone</option>
                </select>
                </fieldset>

                <fieldset class="form-group">
                    <label>Mô tả :</label><input class="form-control" type="text" name="describe"
                                                 value="${product.getDescribe()}" required><br>
                </fieldset>

                <fieldset class="form-group">
                    <label>Giá(VNĐ) :</label><input class="form-control" type="number" name="price"
                                                    value="${product.getPrice()}" required><br>
                </fieldset>

                <fieldset class="form-group">
                    <label>Ảnh :</label>
                    <div>
                        <input class="form-control" name="productImage" type="text" id="imageUrlInput"
                               placeholder="Nhập URL hình ảnh" value="${product.getProductImage()}"
                               oninput="showImage()" required>
                    </div>
                    <div id="imageContainer"></div>
                </fieldset>
                <button type="button" class="btn btn-outline-primary " onclick="window.location.href='/product'">Quay
                    lại
                </button>
                <button type="submit" class="btn btn-success" style="margin-left: 26vw" value="Save">Lưu</button>
            </form>
        </div>
    </div>
</div>

<script>
    function showImage() {
        var imageUrl = document.getElementById("imageUrlInput").value;
        var imageContainer = document.getElementById("imageContainer");
        var imgElement = document.createElement("img");
        imgElement.src = imageUrl;
        imgElement.alt = "Hình ảnh";
        imgElement.style.width = "100px";
        imgElement.style.height = "100px";
        imageContainer.innerHTML = "";
        imageContainer.appendChild(imgElement);
    }
</script>
</body>
</html>

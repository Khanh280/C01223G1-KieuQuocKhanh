<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 02/05/2023
  Time: 9:40 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>IG1 Store</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div align="center">
    <h1>Create Products</h1>
    <button class="btn btn-primary" onclick="window.location.href='/products-servlet'">Xem danh sach</button>
    <c:if test="${checkSuccess}">
        <p>Them moi thanh cong</p>
    </c:if>
    <c:if test="${checkSuccess == false}">
        <p>Them moi that bai</p>
    </c:if>
</div>
<div style="width: 100vw; height: 100vh">
    <div style="height: 100vh;display: flex;justify-content: center;align-items: center">
        <form action="/products-servlet" method="post" style="text-align: center">
            <fieldset style="width: 25vw;border: 1px solid black">
                <legend>Create Product</legend>
                <input type="text" name="action" value="create" hidden>
                <table>
                    <tr>
                        <td>Product ID :</td>
                        <td>
                            <input type="text" name="productId">
                        </td>
                    </tr>
                    <tr>
                        <td>Product Name :</td>
                        <td>
                            <input type="text" name="productName">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Product Type :
                        </td>
                        <td>
                            <select name="productTypeId">
                                <option value="1">Iphone</option>
                                <option value="2">SamSung</option>
                                <option value="3">Vivo</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Describe :
                        </td>
                        <td>
                            <textarea name="describe"  cols="20" rows="5"></textarea>
                        </td>
                    </tr>
                    <tr>
                        <td>Price(VND) :</td>
                        <td>
                            <input type="text" name="price">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Product Image :
                        </td>
                        <td>
                            <textarea name="imageUrl" cols="20" rows="5"></textarea>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <button class="btn btn-outline-success">Create</button>
                        </td>
                    </tr>
                </table>
            </fieldset>
        </form>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>

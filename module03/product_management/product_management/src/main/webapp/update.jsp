<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 28/04/2023
  Time: 11:33 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product Management</title>
</head>
<body>
<form action="/product-servlet?action=update" method="post">
    <fieldset style="width: 30vw">
        <legend>Product Info</legend>
        <table>
            <tr>
                <td>ID :</td>
                <td>
                    <input class="form-control" type="text" name="id" value="${id}" disabled>
                </td>
            </tr>
            <tr>
                <td>Product Name :</td>
                <td>
                    <input class="form-control" type="text" name="productName" value="${productName}">
                </td>
            </tr>
            <tr>
                <td>Price :</td>
                <td>
                    <input class="form-control" type="text" name="price" value="${price}">
                </td>
            </tr>
            <tr>
                <td>Product Detail :</td>
                <td>
                    <textarea class="form-control" name="productDetail" rows="3">${productDetail}</textarea>
                </td>
            </tr>
        </table>
        <button type="submit">Submit</button>
    </fieldset>
</form>
</body>
</html>
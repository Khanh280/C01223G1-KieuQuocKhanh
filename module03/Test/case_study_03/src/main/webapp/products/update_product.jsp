<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 02/05/2023
  Time: 9:40 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>IG1 Store</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div style="width: 100vw; height: 100vh">
  <div style="height: 100vh;display: flex;justify-content: center;align-items: center">
    <form action="/products-servlet" method="post" style="text-align: center">
      <fieldset style="width: 25vw;border: 1px solid black">
        <legend>Update Product</legend>
        <input type="text" name="action" value="update" hidden>
        <table>
          <tr>
            <td>Product ID :</td>
            <td>
              <input type="text" name="productId" value="${productId}" readonly>
            </td>
          </tr>
          <tr>
            <td>Product Name :</td>
            <td>
              <input type="text" name="productName" value="${productName}">
            </td>
          </tr>
          <tr>
            <td>
              Product Type :
            </td>
            <td>
              <select name="productType">
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
              <textarea name="describe" id="" cols="20" rows="5" >${describe}</textarea>
            </td>
          </tr>
          <tr>
            <td>Price(VND) :</td>
            <td>
              <input type="text" name="price" value="${price}">
            </td>
          </tr>
          <tr>
            <td>
              Product Image :
            </td>
            <td>
              <textarea name="imageUrl" cols="20" rows="5">${imageUrl}</textarea>
            </td>
          </tr>
          <tr>
            <td></td>
            <td>
              <button type="submit" class="btn btn-outline-success">Update</button>
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

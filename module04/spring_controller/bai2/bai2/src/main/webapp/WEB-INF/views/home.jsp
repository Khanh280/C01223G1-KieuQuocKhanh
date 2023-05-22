<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 19/05/2023
  Time: 11:07 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>
<div align="center">
    <h1>[Bài tập] Máy tính cá nhân</h1>
</div>
<div align="center">
    <form action="/caculate" method="post">
        <table class="mb-3" border="1" style="border-collapse: collapse">
            <tr>
                <td>
                    <label for="firstValue"> First Value</label>
                </td>
                <td>
                    <input type="text" id="firstValue" name="firstValue" value="${firstValue}" required>
                </td>
            </tr>
            <tr>
                <td>
                    <label for="secondValue">Second Value</label>
                </td>
                <td>
                    <input type="text" name="secondValue" id="secondValue" value="${secondValue}" required>
                </td>
            </tr>
        </table>
        <button class="btn btn-outline-primary" name="operator" value="+">Addition(+)</button>
        <button class="btn btn-outline-primary" name="operator" value="-">Subtraction(-)</button>
        <button class="btn btn-outline-primary" name="operator" value="x">Multiplication(x)</button>
        <button class="btn btn-outline-primary" name="operator" value="/">Division(/)</button>
    </form>
</div>
<div align="center" class="mt-3"><p>Result : ${result}</p></div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</html>

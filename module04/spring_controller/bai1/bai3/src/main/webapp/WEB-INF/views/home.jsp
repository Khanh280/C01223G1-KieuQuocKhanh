<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 19/05/2023
  Time: 10:11 SA
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
<div align="center"><h1>[Bài tập] Ứng dụng hiển thị gia vị với Sandwich</h1></div>
<div align="center">
    <h1>Sandwich Condiments</h1>
    <form action="/save" method="post">
        <div class="btn-group" role="group" aria-label="Basic checkbox toggle button group">
            <input type="checkbox" class="btn-check" id="btncheck1" autocomplete="off" name="spice" value="Lettuce">
            <label class="btn btn-outline-primary" for="btncheck1">Lettuce</label>

            <input type="checkbox" class="btn-check" id="btncheck2" autocomplete="off" name="spice" value="Tomato">
            <label class="btn btn-outline-primary" for="btncheck2">Tomato</label>

            <input type="checkbox" class="btn-check" id="btncheck3" autocomplete="off" name="spice" value="Mustard">
            <label class="btn btn-outline-primary" for="btncheck3">Mustard</label>
            <input type="checkbox" class="btn-check" id="btncheck4" autocomplete="off" name="spice" value="Sprouts">
            <label class="btn btn-outline-primary" for="btncheck4">Sprouts</label>
        </div>
        <button class="btn btn-primary">Save</button>
    </form>
    <h1>Spice Sandwich</h1>
    <hr width="30%">
    <c:forEach var="spice" items="${spice}">
        <p>${spice}</p>
    </c:forEach>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</html>

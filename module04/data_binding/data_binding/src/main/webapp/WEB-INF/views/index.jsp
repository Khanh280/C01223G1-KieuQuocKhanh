<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 22/05/2023
  Time: 10:29 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div align="center"><h1>[Bài tập] Chương trình lưu giữ cấu hình hòm thư điện tử</h1></div>
<div align="center">
    <button class="btn btn-sm btn-outline-primary" onclick="window.location.href='/home'">Settings</button>
    <c:if test="${emailSettings != null}" >
        <button class="btn btn-sm btn-outline-primary" onclick="window.location.href='/currentConfiguration'">Current configuration</button>
    </c:if>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</html>

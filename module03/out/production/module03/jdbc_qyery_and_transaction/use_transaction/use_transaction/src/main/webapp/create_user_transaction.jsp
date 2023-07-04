<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 04/05/2023
  Time: 12:21 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Title</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div align="center">
  <c:if test="${checkCreateTransaction}">
    <p>Them moi thanh cong</p>
  </c:if>
  <c:if test="${!checkCreateTransaction}">
    <p>Them moi that bai</p>
  </c:if>
  <button class="btn btn-primary" onclick="window.location.href='/user-servlet?action=displayList'">Xem danh sach</button>
</div>
<div align="center">
  <form action="/user-servlet" method="post">
    <fieldset style="width: 30vw;border: 1px solid black" >
      <legend>Create User</legend>
      <input type="text" name="action" value="createTransaction" hidden>
      <table>
        <tr>
          <td>Name :</td>
          <td>
            <input type="text" name="name" value="${name}" required>
          </td>
        </tr>
        <tr>
          <td>Email :</td>
          <td>
            <input type="text" name="email" value="${email}" required>
          </td>
        </tr>
        <tr>
          <td>Country :</td>
          <td>
            <input type="text" name="country" value="${country}" required>
          </td>
        </tr>
        <tr>
          <td></td>
          <td>
            <button class="btn btn-primary">Create</button>
          </td>
        </tr>
      </table>
    </fieldset>
  </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>

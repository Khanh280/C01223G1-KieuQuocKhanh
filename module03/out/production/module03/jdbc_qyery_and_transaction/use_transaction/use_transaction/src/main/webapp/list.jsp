<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 04/05/2023
  Time: 11:14 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
</head>
<body>
<nav class="navbar bg-body-tertiary">
    <div class="container-fluid" style="background-color: gray">
        <button type="submit" onclick="window.location.href='/user-servlet'"><i class="fa-solid fa-house"></i></button>
        <button class="btn btn-primary" onclick="window.location.href='/create_user.jsp'">Create User</button>
        <button class="btn btn-primary" onclick="window.location.href='/create_user_transaction.jsp'">Create User Transaction</button>
        <button class="btn btn-primary" onclick="window.location.href='/user-servlet?action=displayByName'">Display by name</button>
        <form action="/user-servlet" method="get">
            <input type="text" name="action" value="search" hidden>
            <input type="text" name="country" value="${country}" placeholder="Search">
            <button type="submit" class="btn btn-primary">Search</button>
        </form>
    </div>
</nav>
<table class="table table-hover">
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Country</th>
        <th>Manipulate</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="userList" items="${userList}">
        <tr>
            <td>${userList.getId()}</td>
            <td>${userList.getName()}</td>
            <td>${userList.getEmail()}</td>
            <td>${userList.getCountry()}</td>
            <td>
                <button type="button" onclick="deleteUser('${userList.getId()}','${userList.getName()}')" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModal">
                    Delete
                </button>
                <button class="btn btn-warning" onclick="window.location.href='/user-servlet?action=update&id=${userList.getId()}'">Update</button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="exampleModalLabel">Delete User</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="/user-servlet" method="get">
                <div class="modal-body">
                    <input type="text" name="action" value="delete" hidden>
                    <input type="text" name="id" id="id" hidden>
                    Do you want to delete a user <span id="nameDelete"></span> ?
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">No</button>
                    <button type="submit" class="btn btn-primary">Yes</button>
                </div>
            </form>
        </div>
    </div>
</div>
<script>
    function deleteUser(id,name) {
        document.getElementById("id").value = id;
        document.getElementById("nameDelete").innerText = name;
    }
</script>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 21/05/2023
  Time: 8:05 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <style>
        * {
            box-sizing: border-box;
        }
    </style>
</head>
<body>
<div align="center"><h1>[Bài tập] Chương trình lưu giữ cấu hình hòm thư điện tử</h1></div>
<div align="center">
    <form:form method="post" modelAttribute="emailSettings" action="/saveSettings">
            <legend align="center">Current configuration</legend>
            <table border="1" style="border-collapse: collapse" >
                <tr>
                    <td>Languages</td>
                    <td>
                        <form:select path="languasges">
                            <form:options items="${languages}"/>
                        </form:select>
                    </td>
                </tr>
                <tr>
                    <td>Page Size : </td>
                    <td>Show
                        <form:select path="pageSize">
                            <form:options items="${pageSize}"/>
                        </form:select>
                        email per page
                    </td>
                </tr>
                <tr>
                    <td>Spams fillter :</td>
                    <td>
                        <form:checkbox path="spamsFillter"/>
                        Enable spams fillter
                    </td>
                </tr>
                <tr>
                    <td>Signature : </td>
                    <td>
                        <form:textarea path="signature"/>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td style="width: 100%; display: flex" >
                        <button class="btn btn-sm btn-outline-primary" style="flex: 1">Set</button>
                        <button class="btn btn-sm btn-outline-warning" type="button" style="flex: 1" onclick="window.location.href='/'">Cancel</button>
                    </td>
                </tr>
            </table>
    </form:form>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</html>

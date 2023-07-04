<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 27/04/2023
  Time: 10:00 SA
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        table {
            border-collapse: collapse;
            border: gray 1px solid;
        }

        td,th {
            border-bottom: 1px solid gray;
            text-align: center;
        }

        div {
            text-align: center;
        }

    </style>
</head>
<body>
<div>
    <button><a href="/customer-servlet" style="text-decoration: none;color: black">Display List Customer</a></button>
    <div style="display: flex;justify-content: center; margin-top: 5%">
        <table width="500px">
            <tr>
                <th>Tên</th>
                <th>Ngày sinh</th>
                <th>Địa chỉ</th>
                <th>Ảnh</th>
            </tr>
            <c:forEach var="customer" items="${customerList}">
                <tr>
                    <td>${customer.getName()}</td>
                    <td>${customer.getBirthday()}</td>
                    <td>${customer.getAddress()}</td>
                    <td>
                        <img src="${customer.getImage()}" alt="" width="100px">
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>

</div>
</body>
</html>

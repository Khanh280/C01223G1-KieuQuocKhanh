<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 18/05/2023
  Time: 11:19 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div align="center">
    <h1>[Bài tập] Ứng dụng chuyển đổi tiền tệ</h1>
</div>
<div class="row h-75 align-items-center">
    <div class="col-3"></div>
    <div class="col-6 d-flex justify-content-center">
        <form action="/dictionary" method="post" class="d-flex justify-content-center"
              style="border: 2px solid black; border-radius: 3px; width: 26vw;height: 20vh">
               <table>
                   <tr>
                       <td>English</td>
                       <td>
                           <input type="text" name="english" value="${english}" placeholder="search">
                       </td>
                   </tr>
                   <tr>
                       <td>Vietnamese :</td>
                       <td>
                           ${vietnamese}
                       </td>
                   </tr>
                   <tr>
                       <td colspan="2">
                           <button type="submit" class="btn btn-primary btn-small" style="width: 100%">Search</button>
                       </td>
                   </tr>
               </table>
        </form>
    </div>
    <div class="col-3"></div>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</html>

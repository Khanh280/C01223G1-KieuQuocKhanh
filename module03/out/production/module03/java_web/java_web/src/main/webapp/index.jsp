<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 26/04/2023
  Time: 11:41 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        input{
            border: none;
        }

    </style>
</head>
<body>
<div style="text-align: center">
    <h1>[Bài tập] Ứng dụng Product Discount Calculator</h1>
    <div style="display: flex;justify-content: center">
        <form action="/display-discount" method="get">
            <table border="1" style="border-collapse:collapse">
                <tr>
                    <td>
                        Mô tả sản phẩm
                    </td>
                    <td>
                        <input type="text" name="description" value="${description}" >
                    </td>
                </tr>
                <tr>
                    <td>
                        Giá niêm yết
                    </td>
                    <td>
                        <input type="text" name="price" value="${price}">
                    </td>
                </tr>
                <tr>
                    <td>
                        Tỷ lệ chiết khấu
                    </td>
                    <td>
                        <input type="text" name="discount" value="${discount}">
                    </td>

                </tr>
                <tr>
                    <td>
                        <button type="submit">Calculate Discount</button>
                    </td>
                </tr>
            </table>
            <table>
                <tr>
                    <td>
                        Description : ${description}
                    </td>
                </tr>
                <tr>
                    <td>
                        Discount Amount : ${discountAmount}
                    </td>
                </tr>
                <tr>
                    <td>
                        Discount Price : ${discountPrice}
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
</html>

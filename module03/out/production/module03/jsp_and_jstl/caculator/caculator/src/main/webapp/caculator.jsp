<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 27/04/2023
  Time: 11:20 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Simple Caculator</h1>
<form action="/caculator-servlet"  method="get">
    <fieldset style="width: 30vw">
        <legend>Caculator</legend>
        <table>
            <tr>
                <td>First operand</td>
                <td>
                    <input type="text" name="firstOperator" value="${firstOperator}">
                </td>
            </tr>
            <tr>
                <td>Operator</td>
                <td>
                    <select name="operator">
                        <option value="+" >+</option>
                        <option value="-">-</option>
                        <option value="*">*</option>
                        <option value="/">/</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Second operator</td>
                <td>
                    <input type="text" name="secondOperator" value="${secondOperator}">
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <button>Calculate</button>
                </td>
            </tr>
            <tr>
                <td>Result :</td>
                <td>
                    ${result}
                </td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>

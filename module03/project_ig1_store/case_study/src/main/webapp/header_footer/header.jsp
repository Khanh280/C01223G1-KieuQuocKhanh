<%--
  Created by IntelliJ IDEA.
  User: TRUNG THIEN
  Date: 5/11/2023
  Time: 10:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-expand-lg bg-body-tertiary" style="background-color: orange">
  <div class="container-fluid">
    <a id="ig1-user-page" href="/product" class="navbar-brand">IG1 Store</a>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li clx ass="nav-item">
          <a class="nav-link active" aria-current="page" href="/admin/admin.jsp">Trang chủ</a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
             aria-expanded="false">
            Quản lý
          </a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" style="color: black" href="/product">Sản phẩm</a></li>
            <li><a class="dropdown-item" style="color: black" href="/accessory">Phụ kiện</a></li>
            <li><a class="dropdown-item" style="color: black" href="/customer-servlet">Khách hàng</a></li>
            <li><a class="dropdown-item" style="color: black" href="/order-servlet">Hóa đơn</a></li>
          </ul>
        </li>
      </ul>
    </div>
  </div>
</nav>

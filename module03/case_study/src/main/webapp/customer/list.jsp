<%--
  Created by IntelliJ IDEA.
  User: TRUNG THIEN
  Date: 5/9/2023
  Time: 18:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List customer</title>
    <link rel="stylesheet" href="/bootstrap520/css/bootstrap.css"/>
    <link rel="stylesheet" href="datatables/css/dataTables.bootstrap5.min.css"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="/customer/regex.css">
    <style>
        #ig1-user-page{
            color: black;
        }
        #ig1-user-page:hover{
            color: white;
        }
        #navbarSupportedContent ul li:hover a{
            color: white;
        }

        #navbarSupportedContent ul li a {
            color: black;
        }
    </style>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<body>
<nav class="navbar navbar-expand-lg bg-body-tertiary" style="background-color: orange">
    <div class="container-fluid">
        <a id="ig1-user-page" href="#" class="navbar-brand">IG1 Store</a>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/account-servlet?action=logout">Đăng xuất</a>
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
            <form action="/customer-servlet" class="d-flex my-0"style="height: 5vh">
                <input type="hidden" name="action" value="search">
                <input class="form-control me-2" type="text" placeholder="Nhập tên cần tìm" aria-label="Search"
                       name="nameCustomer" value="${name}">
                <input class="form-control me-2" type="text" placeholder="Nhập địa chỉ cần tìm" aria-label="Search"
                       name="addressCustomer" value="${address}">
                <input class="form-control me-2" type="text" placeholder="Nhập số điện thoại " aria-label="Search"
                       name="phone" value="${phoneNumber}">
                <button style="margin-right:5px ;width: 20vw" class="btn btn-info btn-rounded" type="submit">Tìm kiếm</button>
            </form>
        </div>
    </div>
</nav>
<div class="container-fluid my-lg-2">
    <div class="row">
        <div class="col-1"></div>
        <div class="col-10">
            <div class="d-flex justify-content-center">
                <h3>Danh sách khách hàng</h3>
                <hr>
            </div>
            <div>
                <button type="button" class="btn btn-success btn-rounded "
                        onclick="window.location.href='/customer-servlet?action=create'">Thêm mới
                </button>
            </div>
            <table id="tableCustomer" class="table table-striped table-bordered" >
                <thead>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Tên</th>
                    <th scope="col">Email</th>
                    <th scope="col">Số điện thoại</th>
                    <th scope="col">Địa chỉ</th>
                    <th scope="col">Thao tác</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="customer" items="${customerList}">
                    <tr>
                        <td>${customer.getId()}</td>
                        <td>${customer.getName()}</td>
                        <td>${customer.getEmail()}</td>
                        <td>${customer.getPhoneNumber()}</td>
                        <td>${customer.getAddress()}</td>
                        <td>
                            <button type="submit" class="btn btn-warning"
                                    onclick="window.location.href='/customer-servlet?action=edit&customerId=${customer.getId()}'">
                                Sửa
                            </button>
                            <button class="btn btn-danger" type="button" data-bs-toggle="modal"
                                    data-bs-target="#deleteModal"
                                    onclick="infoDelete('${customer.getId()}','${customer.getName()}','${customer.getAccount().getId()}')">
                                Xóa
                            </button>
                            <button class="btn btn-info" type="button" data-bs-toggle="modal"
                                    data-bs-target="#deleteModal1"
                                    onclick="infoDetail('${customer.getId()}','${customer.getName()}','${customer.getCreateAt()}','${customer.getUpdateAt()}')">
                                Chi tiết
                            </button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="col-1"></div>
    </div>
</div>
<%--Modal delete--%>
<div class="modal fade" id="deleteModal" tabindex="-1"
     aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Xóa khách hàng</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal"
                        aria-label="Close"></button>
            </div>
            <form action="/customer-servlet?action=delete" method="post">
                <div class="modal-body">
                    <input hidden id="customerId" name="customerId">
                    <input hidden id="accountUserID" name="accountUserID">
                    <span>Bạn có muốn xóa khách hàng có tên </span><span id="deleteName"
                                                                         style="color: red"></span><span> không?</span>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Không
                    </button>
                    <button type="submit" class="btn btn-primary">
                        Có
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>
<%--Modal detail--%>
<div class="modal" id="deleteModal1" tabindex="-1"
     aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel1">Chi tiết khách hàng</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal"
                        aria-label="Close"></button>
            </div>
            <form action="/customer-servlet?action=delete" method="post">
                <div class="modal-body">
                    <p>ID khách hàng: <span id="customerIdDetail"></span></p>
                    <p>Tên khách hàng: <span id="customerNameDetail"></span></p>
                    <p>Ngày thêm: <span id="customerCreateAtDetail"></span></p>
                    <p>Ngày sửa: <span id="customerUpdateAtDetail"></span></p>
                </div>
            </form>
        </div>
    </div>
</div>
<!-- Modal status delete -->
<div class="modal fade" id="deleteResultModal2" tabindex="-1" aria-labelledby="deleteResultModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <c:if test="${check}">
                    <div class="d-flex justify-content-center">
                        <h5 style="color: darkgreen">Xóa thành công!</h5>
                    </div>
                </c:if>
                <c:if test="${check == false}">
                    <div>
                        <h5 style="color: red" class="d-flex justify-content-center">Xóa thất bại!</h5>
                    </div>
                </c:if>
            </div>
            <div class="modal-footer" style="height: 49px">
            </div>
        </div>
    </div>
</div>
<footer class="text-center text-lg-start bg-light text-muted" style=" bottom: 0;right: 0;left: 0">
    <div class="text-center p-4" style="background-color: orange; color: black">
        © 2023 Copyright:
        <a class="text-reset fw-bold" href="https://mdbootstrap.com/">ig1store.com</a>
    </div>
</footer>
<script>
    function infoDelete(id, name, accountID) {
        document.getElementById("customerId").value = id;
        document.getElementById("accountUserID").value = accountID;
        document.getElementById("deleteName").innerText = name;
    }

    function infoDetail(id, name, createAt, updateAt) {
        document.getElementById("customerIdDetail").innerText = id;
        document.getElementById("customerNameDetail").innerText = name;
        document.getElementById("customerCreateAtDetail").innerText = createAt;
        document.getElementById("customerUpdateAtDetail").innerText = updateAt;
    }
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
<script src="jquery/jquery-3.5.1.min.js"></script>
<script src="datatables/js/jquery.dataTables.min.js"></script>
<script src="datatables/js/dataTables.bootstrap5.min.js"></script>
<script>
    $(document).ready(function () {
        $('#tableCustomer').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 10,
            "language": {
                "paginate": {
                    "previous": "Trước",
                    "next": "Sau"
                }
            }
        });
    });
</script>
<%--Để dưới link js bootstrap--%>
<c:if test="${check || check == false}">
    <script>
        let deleteResultModal = new bootstrap.Modal(document.getElementById('deleteResultModal2'));
        deleteResultModal.show();
    </script>
</c:if>
</body>
</html>
<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 5/12/2023
  Time: 12:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>List of Accessory</title>
    <link rel="stylesheet" href="/bootstrap520/css/bootstrap.css"/>
    <link rel="stylesheet" href="datatables/css/dataTables.bootstrap5.min.css"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <style>
        #ig1-user-page {
            color: black;
        }

        #ig1-user-page:hover {
            color: white;
        }

        #navbarSupportedContent ul li:hover a {
            color: white;
        }

        #navbarSupportedContent ul li a {
            color: black;
        }
    </style>

</head>
<body>
<nav class="navbar navbar-expand-lg bg-body-tertiary" style="background-color: orange">
    <div class="container-fluid">
        <a id="ig1-user-page" href="/product" class="navbar-brand">IG1 Store</a>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li clx ass="nav-item">
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
            <form class="d-flex m-0" role="search" action="/accessory?action=search" method="post">
                <input class="form-control me-2" type="search" placeholder="Nhập tên sản phẩm" aria-label="Search"
                       name="name" id="searchInput" oninput="saveSearchInput()">
                <select name="price" id="" class="form-control me-2">
                    <option value="1">--Chọn giá--</option>
                    <option value="1">Dưới 100.000</option>
                    <option value="2">Từ 100.000-500.000</option>
                    <option value="3">500.000-1 triệu</option>
                    <option value="4">Trên 1 triệu</option>

                </select>
                <button type="submit" class="btn btn-outline-primary"
                        style="background: white; width: 200px;height: auto; color: black">
                    Tìm kiếm
                </button>
            </form>
        </div>
    </div>
</nav>
<br>


<div class="row">
    <div class="container-fluid my-lg-2">
        <div class="row">
            <div class="col-1"></div>
            <div class="col-10">
                <h3 class="text-center">DANH SÁCH PHỤ KIỆN</h3>
                <hr>
                <div class="container text-left">

                    <button type="button" class="btn btn-success btn-rounded"
                            onclick="window.location.href='/accessory?action=create'">Thêm phụ kiện
                    </button>
                </div>
                <div class="container text-left">
                    <table id="tableProduct" class="table table-striped table-bordered"
                           style="width:100%; margin-top: 20px">
                        <thead>
                        <tr>
                            <th scope="col">STT</th>
                            <th scope="col">Tên</th>
                            <th scope="col">Loại</th>
                            <th scope="col" hidden>Mô tả</th>
                            <th scope="col">Giá(VNĐ)</th>
                            <th scope="col" hidden>Ảnh</th>
                            <th scope="col">Ngày tạo</th>
                            <th scope="col">Ngày cập nhật</th>
                            <th scope="col">Thao tác</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="product" items="${productList}">
                            <td>${product.getId()}</td>
                            <td>${product.getName()}</td>
                            <td>
                                <c:if test="${product.getProductType() == 2}">
                                    Accessory
                                </c:if>
                            </td>
                            <td hidden>${product.getDescribe()}</td>
                            <td>${product.getPrice()}</td>
                            <td hidden>${product.getProductImage()}</td>
                            <td>${product.getCreatAt()}</td>
                            <td>${product.getUpdateAt()}</td>
                            <td>
                                <button class="btn btn-warning"
                                        onclick="window.location.href='/accessory?action=edit&id=${product.getId()}'">
                                    Sửa
                                </button>
                                <button type="submit" class="btn btn-danger" data-bs-toggle="modal"
                                        data-bs-target="#exampleModal"
                                        onclick="deleteProduct('${product.getId()}','${product.getName()}')">
                                    Xóa
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
        <footer class="text-center text-lg-start bg-light text-muted" style=" bottom: 0;right: 0;left: 0">
            <div class="text-center p-4" style="background-color: orange; color: black">
                © 2023 Copyright:
                <a class="text-reset fw-bold" href="https://mdbootstrap.com/">ig1store.com</a>
            </div>
        </footer>
        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h1 class="modal-title fs-5" id="exampleModalLabel">XÓA SẢN PHẨM</h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <form action="/accessory" method="post">
                        <div class="modal-body">
                            <input type="text" name="action" value="delete" hidden>
                            <input type="text" id="id" name="id" hidden>
                            Bạn có chắc chắn muốn xóa phụ kiện <span style="color: red" id="name"></span> này không ?
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Đóng</button>
                            <button type="submit" class="btn btn-primary" style="background: red">Đồng ý
                            </button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    function deleteProduct(id, name) {
        document.getElementById("id").value = id;
        document.getElementById("name").innerText = name;
    }
</script>
<script>
    // Lấy giá trị từ localStorage (nếu có)
    window.addEventListener('load', function () {
        var searchInput = localStorage.getItem('searchInput');
        if (searchInput) {
            document.getElementById('searchInput').value = searchInput;
        }
    });

    // Lưu giá trị khi người dùng nhập vào
    function saveSearchInput() {
        var input = document.getElementById('searchInput').value;
        localStorage.setItem('searchInput', input);
    }
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
<script src="jquery/jquery-3.5.1.min.js"></script>
<script src="datatables/js/jquery.dataTables.min.js"></script>
<script src="datatables/js/dataTables.bootstrap5.min.js"></script>

<div class="modal fade" id="exampleModal4" tabindex="-1" aria-labelledby="deleteResultModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <c:if test="${checkRemove}">
                    <div class="d-flex justify-content-center">
                        <h5 style="color: darkgreen">Xóa thành công</h5>
                    </div>
                </c:if>
                <c:if test="${checkRemove == false}">
                    <div>
                        <h5 style="color: red" class="d-flex justify-content-center">Xóa thất bại</h5>
                    </div>
                </c:if>
            </div>
            <div class="modal-footer" style="height: 49px">
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="exampleModal5" tabindex="-1" aria-labelledby="deleteResultModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <c:if test="${checkCreate}">
                    <div class="d-flex justify-content-center">
                        <h5 style="color: darkgreen">Thêm thành công</h5>
                    </div>
                </c:if>
                <c:if test="${checkCreate == false}">
                    <div>
                        <h5 style="color: red" class="d-flex justify-content-center">Thêm thất bại</h5>
                    </div>
                </c:if>
            </div>
            <div class="modal-footer" style="height: 49px">
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="editResultModal" tabindex="-1" aria-labelledby="editResultModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <c:if test="${checkEdit}">
                    <div class="d-flex justify-content-center">
                        <h5 style="color: darkgreen">Sửa thành công!</h5>
                    </div>
                </c:if>
                <c:if test="${checkEdit == false}">
                    <div>
                        <h5 style="color: red" class="d-flex justify-content-center">Sửa thất bại!</h5>
                    </div>
                </c:if>
            </div>
            <div class="modal-footer" style="height: 49px">
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous">
</script>

<c:if test="${checkEdit || checkEdit == false}">
    <script>
        let editResultModal = new bootstrap.Modal(document.getElementById('editResultModal'));
        editResultModal.show();
    </script>
</c:if>

<c:if test="${checkCreate || checkCreate == false}">
    <script>
        let deleteResultModal = new bootstrap.Modal(document.getElementById('exampleModal5'));
        deleteResultModal.show();
    </script>
</c:if>

<c:if test="${checkRemove || checkRemove == false}">
    <script>
        let deleteResultModal = new bootstrap.Modal(document.getElementById('exampleModal4'));
        deleteResultModal.show();
    </script>
</c:if>



<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
<script>
    $(document).ready(function () {
        $('#tableProduct').dataTable({
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

</body>
</html>

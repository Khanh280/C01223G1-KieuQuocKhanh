<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>List of Producs</title>
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
        <a id="ig1-user-page" href="#" class="navbar-brand">IG1 Store</a>
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
            <form class="d-flex m-0" role="search" action="/product?action=search" method="post" style="height: 5vh">
                <input class="form-control me-2" type="search" placeholder="Nhập tên sản phẩm" aria-label="Search"
                       name="name" id="searchInput" oninput="saveSearchInput()">
                <select name="price" id="" class="form-control me-2">
                    <option value="1">--Chọn giá--</option>
                    <option value="1">Dưới 5 triệu</option>
                    <option value="2">5-10 triệu</option>
                    <option value="3">10-15 triệu</option>
                    <option value="4">Trên 15 triệu</option>
                </select>
                <button type="submit" class="btn btn-outline-primary"
                        style="background: white; width: 203px;height: auto; color: black">
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
                <h3 class="text-center">DANH SÁCH SẢN PHẨM</h3>
                <hr>
                <div class="container text-left">

                    <button type="button" class="btn btn-success btn-rounded"
                            onclick="window.location.href='/product?action=create'">Thêm sản phẩm
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
                                <c:if test="${product.getProductType() == 1}">
                                    Phone
                                </c:if>
                            </td>
                            <td hidden>${product.getDescribe()}</td>
                            <td>${product.getPrice()}</td>
                            <td hidden>${product.getProductImage()}</td>
                            <td>${product.getCreatAt()}</td>
                            <td>${product.getUpdateAt()}</td>
                            <td>
                                <button class="btn btn-warning"
                                        onclick="window.location.href='/product?action=edit&id=${product.getId()}'">
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
                    <form action="/product?action=delete" method="post">
                        <div class="modal-body">
                            <input type="text" name="action" value="delete" hidden>
                            <input type="text" id="id" name="id" hidden>
                            Bạn có chắc chắn muốn xóa sản phẩm <span style="color: red" id="name"></span> không ?
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

        <div class="modal fade" id="deleteResultModal2" tabindex="-1" aria-labelledby="deleteResultModalLabel"
             aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <c:if test="${checkRemove}">
                            <div class="d-flex justify-content-center">
                                <h5 style="color: darkgreen">Xóa thành công!</h5>
                            </div>
                        </c:if>
                        <c:if test="${checkRemove == false}">
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
<%--Để dưới link js bootstrap--%>
<c:if test="${checkRemove || checkRemove == false}">
    <script>
        let deleteResultModal = new bootstrap.Modal(document.getElementById('deleteResultModal2'));
        deleteResultModal.show();
    </script>
</c:if>

<%--Để dưới link js bootstrap--%>
<c:if test="${checkCreate || checkCreate == false}">
    <script>
        let createResultModal = new bootstrap.Modal(document.getElementById('createResultModal'));
        createResultModal.show();
    </script>
</c:if>

<%--Để dưới link js bootstrap--%>
<c:if test="${checkEdit || checkEdit == false}">
    <script>
        let editResultModal = new bootstrap.Modal(document.getElementById('editResultModal'));
        editResultModal.show();
    </script>
</c:if>
</body>
</html>
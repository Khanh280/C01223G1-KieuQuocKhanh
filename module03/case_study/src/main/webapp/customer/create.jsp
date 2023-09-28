<%--
  Created by IntelliJ IDEA.
  User: TRUNG THIEN
  Date: 5/9/2023
  Time: 19:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Thêm mới khách hàng</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<body>
<jsp:include page="/header_footer/header.jsp"></jsp:include>
<div class="container-fluid h-100">
    <div class="row d-flex justify-content-center">
        <div class="col-12 col-md-9 col-lg-7 col-xl-6">
            <div class="container p-5">
                <h2 class="text-uppercase text-center mb-5">THÊM MỚI KHÁCH HÀNG</h2>
                <form method="post" action="/customer-servlet?action=create" class="align-items-center mt-lg-5 mb-0">
                    <div class="fom-control mb-3">
                        <label>Tên đăng nhập</label>
                        <input required oninput="checkUser()" class="form-control" id="user"
                               placeholder="Nhập tên đăng nhập" type="text" name="userName">
                        <small id="user1" style="color: red;font-weight: bolder "></small>
                        <span></span>
                    </div>
                    <div class="fom-control mb-3">
                        <label>Mật khẩu</label>
                        <input required oninput="checkPassword()" class="form-control" id="password"
                               placeholder="Nhập mật khẩu" type="password" name="password">
                    </div>
                    <div class="fom-control mb-3">
                        <label>Xác nhận lại mật khẩu</label>
                        <input required oninput="checkPassword()" class="form-control" id="confirm-password"
                               placeholder="Nhập lại mật khẩu" type="password" name="password">
                        <small id="pass1" style="color: red;font-weight: bolder "></small>
                        <span></span>
                    </div>
                    <div class="fom-control mb-3">
                        <label>Họ và tên</label>
                        <input required oninput="checkFullName()" class="form-control" id="fullName"
                               placeholder="Nhập họ và tên" type="text" name="fullName">
                        <small id="fullName1" style="color: red;font-weight: bolder "></small>
                        <span></span>
                    </div>
                    <div class="fom-control mb-3">
                        <label>Email</label>
                        <input required oninput="checkEmail()" class="form-control" id="email"
                               placeholder="Vui lòng nhập email" type="email" name="email">
                        <small id="email1" style="color: red;font-weight: bolder"></small>
                        <span></span>
                    </div>
                    <div class="fom-control mb-3">
                        <label>Số điện thoại</label>
                        <input required oninput="checkPhoneNumber()" class="form-control" id="phoneNumber"
                               placeholder="Vui lòng nhập số điện thoại" type="text" name="phoneNumber">
                        <small id="phone1" style="color: red;font-weight: bolder "></small>
                        <span></span>
                    </div>
                    <div class="fom-control mb-3">
                        <label>Địa chỉ</label>
                        <input required class="form-control" placeholder="Vui lòng nhập địa chỉ"
                               type="text"
                               name="address">
                    </div>
                    <div class="mt-5">
                        <ul class="d-flex justify-content-lg-between list-unstyled m-0">
                            <li>
                                <button class="btn btn-success" data-bs-toggle="modal"
                                        data-bs-target="#deleteResultModal4">Thêm mới
                                </button>
                            </li>
                            <li>
                                <button type="button" onclick="window.location.href='/customer-servlet'"
                                        class="btn btn-primary">Trở lại
                                </button>
                            </li>
                        </ul>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<%--Modal create --%>
<div class="modal fade" id="deleteResultModal4" tabindex="-1" aria-labelledby="deleteResultModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <c:if test="${check}">
                    <div class="d-flex justify-content-center">
                        <h5 style="color: darkgreen">Thêm mới thành công!</h5>
                    </div>
                </c:if>
                <c:if test="${check == false}">
                    <div>
                        <h5 style="color: red" class="d-flex justify-content-center">Thêm mới thất bại!</h5>
                    </div>
                </c:if>
                <c:if test="${check == null}">
                    <div>
                        <h5 class="d-flex justify-content-center text-bg-warning text-warning">Vui lòng nhập thông
                            tin</h5>
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
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>

<c:if test="${check || check == false}">
    <script>
        let deleteResultModal = new bootstrap.Modal(document.getElementById('deleteResultModal4'));
        deleteResultModal.show();
    </script>
</c:if>
<script>
    function checkPassword() {
        let passwordFirst = document.getElementById("password").value;
        let passwordLast = document.getElementById("confirm-password").value;
        if (passwordLast !== "") {
            if (passwordFirst === passwordLast) {
                document.getElementById("pass1").innerText = "";
            } else {
                document.getElementById("pass1").innerText = "Mật khẩu không trùng";
            }
        }
    }

    function checkUser() {
        let name = document.getElementById("user").value;
        let regexName = /^[a-z]{5,}[0-9]*[a-z]*$/;
        if (regexName.test(name)) {
            document.getElementById("user1").innerText = "";
        } else {
            document.getElementById("user1").innerText = "Chưa đúng định dạng kiểu tên đăng nhập!";
        }
    }
    function checkFullName() {
        let name = document.getElementById("fullName").value;
        let regexName = /^([\p{L}\s]{2,30}\s)?([\p{L}\s]{2,30}\s)+[\p{L}\s]{2,30}$/u;
        if (regexName.test(name)) {
            document.getElementById('fullName1').innerText = '';
        } else {
            document.getElementById('fullName1').innerText = "Chữ cái đầu viết hoa và ít nhất 2 từ";
        }
    }
        function checkEmail() {
            let name = document.getElementById("email").value;
            let regexName = /^[a-z]\w{5,}\@[a-z]{3,5}\.[a-z]{2,5}$/;
            if (regexName.test(name)) {
                document.getElementById("email1").innerText = "";
            } else {
                document.getElementById("email1").innerText = "Chưa đúng định dạng email(x@y.z)";
            }
        }
        function checkPhoneNumber() {
            let name = document.getElementById("phoneNumber").value;
            let regexPhone = /^((\+84)|0)[0-9]{9,10}$/;
            if (regexPhone.test(name)) {
                document.getElementById("phone1").innerText = "";
            } else {
                document.getElementById("phone1").innerText = "Số điện thoại bắt đầu từ 0,+84 phải 9 hoặc 10 số";
            }
        }
</script>
</body>
</html>


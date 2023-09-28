<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 30/04/2023
  Time: 8:18 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>IG1 Store</title>
    <link rel="stylesheet" href="register_css.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <style>
        .gradient-custom-3 {
            /* fallback for old browsers */
            background: #f57627;

            /* Chrome 10-25, Safari 5.1-6 */
            background: -webkit-linear-gradient(to right, rgba(250, 199, 132, 0.5), rgba(244, 151, 143, 0.5));

            /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
            background: linear-gradient(to right, rgba(250, 199, 132, 0.5), rgba(244, 151, 143, 0.5))
        }

        .gradient-custom-4 {
            /* fallback for old browsers */
            background: #e75704;

            /* Chrome 10-25, Safari 5.1-6 */
            background: -webkit-linear-gradient(to right, rgba(231, 87, 4, 0.87), rgba(255, 193, 68, 0.8));

            /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
            background: linear-gradient(to right, rgba(231, 87, 4, 0.87), rgba(255, 193, 68, 0.8))
        }
    </style>
</head>

<body>
<section class="vh-100 bg-image"
         style="background-image: url('https://mdbcdn.b-cdn.net/img/Photos/new-templates/search-box/img4.webp');">
    <div class="mask d-flex align-items-center h-100 gradient-custom-3">
        <div class="container h-100">
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col-12 col-md-9 col-lg-7 col-xl-6">
                    <div class="card" style="border-radius: 15px;">
                        <div class="card-body p-5" style="height: 100vh">
                            <h4 class="text-uppercase text-center mb-2">Đăng ký tài khoản</h4>
                            <form method="post" action="/account-servlet?action=register"
                                  class="align-items-center mt-lg-5 mb-0">
                                <div class="fom-control mb-3">
                                    <label>Tên đăng nhập</label>
                                    <input required oninput="checkUser()" class="form-control" id="user"
                                           placeholder="Nhập tên đăng nhập" type="text" name="userName">
                                    <small id="user1" class="mt-1" style="color: red;font-weight: bolder "></small>
                                    <span></span>
                                </div>
                                <div class="fom-control mb-3">
                                    <label>Mật khẩu</label>
                                    <input required oninput="checkPassword()" class="form-control" id="password"
                                           placeholder="Nhập mật khẩu" type="password">
                                </div>
                                <div class="fom-control mb-3">
                                    <label>Xác nhận lại mật khẩu</label>
                                    <input required oninput="checkPassword()" class="form-control" id="confirm-password"
                                           placeholder="Nhập lại mật khẩu" type="password" name="password">
                                    <small class="mt-1" id="pass1" style="color: red;font-weight: bolder "></small>
                                    <span></span>
                                </div>
                                <div class="fom-control mb-3">
                                    <label>Họ và tên</label>
                                    <input required oninput="checkFullName()" class="form-control" id="fullName"
                                           placeholder="Nhập họ và tên" type="text" name="customerName">
                                    <small class="mt-1" id="fullName1" style="color: red;font-weight: bolder "></small>
                                    <span></span>
                                </div>
                                <div class="fom-control mb-3">
                                    <label>Email</label>
                                    <input required oninput="checkEmail()" class="form-control" id="email"
                                           placeholder="Vui lòng nhập email" type="email" name="email">
                                    <small id="email1" class="mt-1" style="color: red;font-weight: bolder"></small>
                                    <span></span>
                                </div>
                                <div class="fom-control mb-3">
                                    <label>Số điện thoại</label>
                                    <input required oninput="checkPhoneNumber()" class="form-control" id="phoneNumber"
                                           placeholder="Vui lòng nhập số điện thoại" type="text" name="phoneNumber">
                                    <small class="mt-1" id="phone1" style="color: red;font-weight: bolder "></small>
                                    <span></span>
                                </div>
                                <div class="fom-control mb-3">
                                    <label>Địa chỉ</label>
                                    <input required class="form-control" placeholder="Vui lòng nhập địa chỉ"
                                           type="text"
                                           name="address">
                                </div>
                                <div class="d-flex justify-content-center">
                                    <button type="submit"
                                            class="btn btn-success btn-block btn-lg gradient-custom-4 text-body">Đăng ký
                                    </button>
                                </div>
                                <p class="text-center text-muted mt-3 mb-0">Bạn đã có tài khoản?
                                    <a href="/login.jsp" class="fw-bold text-body"><u>Đăng nhập</u></a></p>
                                <div class="mt-3 d-flex"></div>
                            </form>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>


<div class="modal fade" id="deleteResultModal4" tabindex="-1" aria-labelledby="deleteResultModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <c:if test="${statusRegister}">
                    <div class="d-flex justify-content-center">
                        <h5 style="color: darkgreen">Thêm mới thành công!</h5>
                    </div>
                </c:if>
                <c:if test="${statusRegister == false}">
                    <div>
                        <h5 style="color: red" class="d-flex justify-content-center">Thêm mới thất bại!</h5>
                    </div>
                </c:if>
                <c:if test="${statusRegister == null}">
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
<script src="/bootstrap-5.3.0-alpha3-dist/js/bootstrap.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
<c:if test="${statusRegister || statusRegister == false}">
    <script>
        let deleteResultModal = new bootstrap.Modal(document.getElementById('deleteResultModal4'));
        deleteResultModal.show();
    </script>
</c:if>

</body>

</html>
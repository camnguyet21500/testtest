<%-- 
    Document   : giohang
    Created on : 11-Jun-2020, 9:01:14 AM
    Author     : home
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <link rel="stylesheet" href="css/bootstrap.min.css">
        <script src="js/jquery-3.3.1.slim.min.js" ></script>
        <script src="js/popper.min.js" ></script>
        <script src="js/bootstrap.min.js" ></script>
    </head>
    <style>
        body{
            background-color: black;
            color: #DAA520;
        }
        nav{
            background-color: black !important;
            background-image: url('images/15162927-dsc0499_cover_2000x1335.jpg');
        }
        table{
            background-color: black !important;
        }
        footer{
            padding-left: 20px;
            background-image: url('images/2.png') !important;
            color: black !important;
        }
        body{
        background-color:black;
        background-image:radial-gradient(white, rgba(255,255,255,.2) 2px, transparent 40px),radial-gradient(white, rgba(255,255,255,.15) 1px, transparent 30px),radial-gradient(white, rgba(255,255,255,.1) 2px, transparent 40px),radial-gradient(rgba(255,255,255,.4), rgba(255,255,255,.1) 2px, transparent 30px);
        background-size: 550px 550px, 350px 350px, 250px 250px, 150px 150px; 
        background-position: 0 0, 40px 60px, 130px 270px, 70px 100px;
        }
    </style>
    <body>
    <center>
        <div class="container">

            <nav class="navbar navbar-expand-sm">
                <!-- Brand/logo -->
                <a class="navbar-brand" href="#">
                    <img class="rounded-circle" src="images/logo.jpg" alt="logo" style="width:40px;">
                </a>

                <!-- Links -->
                <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                    <li class="nav-item">
                        <a class="nav-link" style="color: white" href="showSanPhamTheoHang.jsp">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" style="color: white" href="showSanPham.jsp">Menu</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" style="color: white" href="insertSP.jsp">Insert Product</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" style="color: white" href="giohang.jsp">Cart</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" style="color: white" href="updateSP.jsp">Update Product</a>
                    </li>
                </ul>
                <form class="form-inline my-2 my-lg-0">
                    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                </form>
            </nav>

            <div class="row mt-3">
                <div class="col-md-3">
                    <div class="list-group">

                        <a href="showSanPhamTheoHang.jsp" class="list-group-item list-group-item-action list-group-item-dark">Home</a>
                        <a href="showSanPham.jsp" class="list-group-item list-group-item-action list-group-item">Menu</a>
                        <a href="insertSP.jsp" class="list-group-item list-group-item-action list-group-item">Insert Product</a>
                        <a href="giohang.jsp" class="list-group-item list-group-item-action list-group-item">Cart</a>
                        <a href="updateSP.jsp" class="list-group-item list-group-item-action list-group-item">Update Product</a>
                    </div>
                </div>
                <div class="col-md-9">
                    <center>
                        <h1>CART</h1>

                        <table border="1" style="text-align: center" class="table table-hover table-dark">
                            <thead>
                                <tr>
                                    <th>Product code</th>
                                    <th>Product name</th>
                                    <th>Image</th>
                                    <th>Price</th>
                                    <th>Amount</th>
                                    <th>Money</th>
                                    <th>Delete</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="i" items="${giohang}">
                                    <tr>
                                        <td id="productCode${i.getSanpham().getMaSP()}">${i.getSanpham().getMaSP()}</td>
                                        <td>${i.getSanpham().getTenSP()}</td>
                                        <td><img src="images/${i.getSanpham().getHinh()}" width="80px;" height="100px;" /></td>
                                        <td>${i.getSanpham().getDonGia()}</td>
                                        <td>
                                            <a class="btn btn-warning" href="GioHangServlet?yeucau=tang&txtmasp=${i.getSanpham().getMaSP()}" style="width: 0%">+</a>
                                            ${i.getSoluong()}
                                            <a class="btn btn-warning" href="GioHangServlet?yeucau=giam&txtmasp=${i.getSanpham().getMaSP()}" style="width: 0%">-</a>
                                        </td>
                                        <td>${i.getSanpham().getDonGia() * i.getSoluong()}</td>

                                        <td> <a href="GioHangServlet?yeucau=bosp&txtmasp=${i.getSanpham().getMaSP()}">Delete</a> </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        <h3>Total: ${tongtien}</h3>

                        <br/> <a class="btn btn-warning" href="showSanPham.jsp">Mua Hàng Tiếp</a>
                        <a class="btn btn-danger" href="GioHangServlet?yeucau=xoatatca">Xóa tất cả</a><hr>
                        <form action="GioHangServlet?yeucau=thanhtoan" method="post">
                            <!-- Button to Open the Modal -->
                            <button type="button" class="btn btn-info" data-toggle="modal" data-target="#myModal">Thanh toán</button>
                            <h5 class="font-weight-bold text-uppercase mt-3 mb-4"> </h5>

                            <!-- The Modal -->
                            <div class="modal" id="myModal">
                                <div class="modal-dialog">
                                    <div class="modal-content">

                                        <!-- Modal Header -->
                                        <div class="modal-header">
                                            <h4 class="modal-title">Please enter your information!</h4>
                                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                                        </div>

                                        <!-- Modal body -->
                                        <div class="modal-body">
                                            <div class="form-group" style="text-align: left">
                                                <label for="hoten">Fullname:</label>
                                                <input type="text" class="form-control" placeholder="Enter fullname" name="ct-name">
                                            </div>
                                            <div class="form-group" style="text-align: left">
                                                <label for="diachi">Address:</label>
                                                <input type="text" class="form-control" placeholder="Enter address" name="ct-address">
                                            </div>
                                            <div class="form-group" style="text-align: left">
                                                <label for="sdt">Phone number:</label>
                                                <input type="text" class="form-control" placeholder="Enter phone number" name="ct-phone-num">
                                            </div>
                                        </div>

                                        <!-- Modal footer -->
                                        <div class="modal-footer">
                                            <button type="submit" class="btn btn-warning" name="yeucau" value="ct-buy-product" >Save changes</button>
                                            <button type="button" class="btn btn-danger" data-dismiss="modal" >Close</button>
                                        </div>
                                        
                                    </div>
                                </div>
                            </div>
                        </form>
                    </center>
                </div>
            </div>
        </div>
    </center>
                        <!-- Footer -->
    <footer class="page-footer font-small stylish-color-dark pt-4">

        <!-- Footer Links -->
        <div class="container text-center text-md-left">

            <!-- Grid row -->
            <div class="row">

                <!-- Grid column -->
                <div class="col-md-4 mx-auto">

                    <!-- Content -->
                    <h5 class="font-weight-bold text-uppercase mt-3 mb-4">Footer Content</h5>
                    <p><b><i>Here you can use rows and columns to organize your footer content. Lorem ipsum dolor sit amet,
                        consectetur
                        adipisicing elit.</i></b></p>

                </div>
                <!-- Grid column -->

                <hr class="clearfix w-100 d-md-none">

                <!-- Grid column -->
                <div class="col-md-2 mx-auto">

                    <!-- Links -->
                    <h5 class="font-weight-bold text-uppercase mt-3 mb-4">Links</h5>

                    <ul class="list-unstyled">
                        <li>
                            <a style="color: black" href="showSanPhamTheoHang.jsp"><b><i>Home</a>
                        </li>
                        <li>
                            <a style="color: black" href="showSanPham.jsp">Menu</a>
                        </li>
                        <li>
                            <a style="color: black" href="insertSP.jsp">Insert</a>
                        </li>
                        <li>
                            <a style="color: black" href="giohang.jsp">Cart</a></b></i>
                        </li>
                    </ul>

                </div>
                <!-- Grid column -->

                <hr class="clearfix w-100 d-md-none">

                <!-- Grid column -->
                <div class="col-md-2 mx-auto">

                    <!-- Links -->
                    <h5 class="font-weight-bold text-uppercase mt-3 mb-4">Links</h5>

                    <ul class="list-unstyled">
                        <li>
                            <a style="color: black" href="updateSP.jsp"><b><i>Update</a>
                        </li>
                        <li>
                            <a style="color: black" href="showSanPham.jsp">Menu</a>
                        </li>
                        <li>
                            <a style="color: black" href="insertSP.jsp">Insert</a>
                        </li>
                        <li>
                            <a style="color: black" href="giohang.jsp">Cart</a></b></i>
                        </li>
                    </ul>

                </div>
                <!-- Grid column -->

                <hr class="clearfix w-100 d-md-none">

                <!-- Grid column -->
                <div class="col-md-2 mx-auto">

                    <!-- Links -->
                    <h5 class="font-weight-bold text-uppercase mt-3 mb-4">Links</h5>

                    <ul class="list-unstyled" >
                        <li>
                            <a style="color: black" href="updateSP.jsp"><b><i>Update</a>
                        </li>
                        <li>
                            <a style="color: black" href="showSanPham.jsp">Menu</a>
                        </li>
                        <li>
                            <a style="color: black" href="insertSP.jsp">Insert</a>
                        </li>
                        <li>
                            <a style="color: black" href="giohang.jsp">Cart</a></b></i>
                        </li>
                    </ul>

                </div>
                <!-- Grid column -->

            </div>
            <!-- Grid row -->

        </div>
        <!-- Footer Links -->

        <hr>

        <!-- Call to action -->
        <ul class="list-unstyled list-inline text-center py-2">
            <li class="list-inline-item">
                <h5 class="mb-1">Register for free</h5>
            </li>
            <li class="list-inline-item">
                <a href="insert.jsp" class="btn btn-warning btn-rounded">Sign up!</a>
            </li>
        </ul>
        <!-- Call to action -->

        <hr>

        <!-- Social buttons -->
        <ul class="list-unstyled list-inline text-center">
            <li class="list-inline-item">
                <a class="btn-floating btn-fb mx-1" href="https://www.facebook.com/">
                    <i class="fab fa-facebook-f" > 
                        <img src="images/facebook.png" alt="facebook.com" style="width:30px;">
                    </i>
                </a>
            </li>
            <li class="list-inline-item">
                <a class="btn-floating btn-tw mx-1" href="https://twitter.com/explore">
                    <i class="fab fa-twitter"> 
                        <img src="images/twitter.png" alt="twitter.com" style="width:30px;">
                    </i>
                </a>
            </li>
            <li class="list-inline-item">
                <a class="btn-floating btn-gplus mx-1" href="https://www.google.com/">
                    <i class="fab fa-google-plus-g"> 
                        <img src="images/shapes-and-symbols.png" alt="google.com" style="width:30px;">
                    </i>
                </a>
            </li>
            <li class="list-inline-item">
                <a class="btn-floating btn-li mx-1" href="https://www.instagram.com/?hl=vi">
                    <i class="fab fa-linkedin-in"> 
                        <img src="images/instagram-sketched.png" alt="instagram.com" style="width:30px;">
                    </i>
                </a>
            </li>
            <li class="list-inline-item">
                <a class="btn-floating btn-dribbble mx-1" href="https://www.weibo.com/login.php">
                    <i class="fab fa-dribbble"> 
                        <img src="images/weibo.png" alt="instagram.com" style="width:30px;">
                    </i>
                </a>
            </li>
        </ul>
        <!-- Social buttons -->

        <!-- Copyright -->
        <div class="footer-copyright text-center py-3"><b>© 2020 Design
                <a style="color: black" href="https://www.facebook.com/camnguyet.215"><i> CamNguyet</i></b></a>
        </div>
        <!-- Copyright -->

    </footer>
    <!-- Footer -->
</body>
</html>

<%-- 
    Document   : showSanPham
    Created on : May 28, 2019, 8:56:58 AM
    Author     : home
--%>

<%@page import="model.SanPhamModel"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            color: #DAA520;
            color: white;
            background-color:black;
            background-image:radial-gradient(white, rgba(255,255,255,.2) 2px, transparent 40px),radial-gradient(white, rgba(255,255,255,.15) 1px, transparent 30px),radial-gradient(white, rgba(255,255,255,.1) 2px, transparent 40px),radial-gradient(rgba(255,255,255,.4), rgba(255,255,255,.1) 2px, transparent 30px);
            background-size: 550px 550px, 350px 350px, 250px 250px, 150px 150px; 
            background-position: 0 0, 40px 60px, 130px 270px, 70px 100px;
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
    </style>
    <body>
    <center>
        <div class="container">
            <nav class="navbar navbar-expand-sm ">
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
            <center>
                <form action="DeleteSPServlet?yeucau=xoanhieu" method="post" >
                    <center><h1>Menu</h1></center>
                    <table border="1" style="text-align: center" class="table table-hover table-dark">
                        <thead>
                            <tr>
                                <th>Tick</th>
                                <th>Product code</th>
                                <th>Product name</th>
                                <th>Price</th>
                                <th>Amount</th>
                                <th>Image</th>
                                <th>Type</th>
                                <th>Delete</th>
                                <th>Update</th>
                                <th>Buy</th>
                            </tr>
                            <% ArrayList listSP = new SanPhamModel().getList();%>
                        </thead>
                        <tbody>
                            <c:forEach items="<%= listSP%>" var="sp">
                                <tr>
                                    <td><input type="checkbox" name="chon" value="${sp.getMaSP()}" /> </td>
                                    <td>${sp.getMaSP()}</td>
                                    <td>${sp.getTenSP()}</td>
                                    <td>${sp.getDonGia()}</td>
                                    <td>${sp.getSoLuong()}</td>
                                    <td><img class="rounded" src="images/${sp.getHinh()}" width="100px" height="150px"></td>
                                    <td>${sp.getMaDM()}</td>

                                    <td><a class="btn btn-warning" href="DeleteSPServlet?yeucau=delete&txtmasp=${sp.getMaSP()}">Delete</a></td>
                                    <td><a class="btn btn-warning" href="SanPhamServlet2?yeucau=laythongtin&txtmasp=${sp.getMaSP()}">Update</a></td>
                                    <td><a class="btn btn-warning" href="GioHangServlet?yeucau=muasp&txtmasp=${sp.getMaSP()}">Buy Now</a></td>

                                </tr>
                            </c:forEach>

                        </tbody>
                    </table>
                    <input type="submit" class="btn btn-warning" value="Delete" />
                    <h5 class="font-weight-bold text-uppercase mt-3 mb-4"> </h5>
                </form>
            </center>
        </div>
    </div>
</div>
</center>
<footer class="page-footer font-small stylish-color-dark pt-4">
        <div class="container text-center text-md-left">
            <div class="row">
                <div class="col-md-4 mx-auto">
                    <h5 class="font-weight-bold text-uppercase mt-3 mb-4">Footer Content</h5>
                    <p><b><i>Here you can use rows and columns to organize your footer content. Lorem ipsum dolor sit amet,
                        consectetur
                        adipisicing elit.</i></b></p>

                </div>
                <hr class="clearfix w-100 d-md-none">
                <div class="col-md-2 mx-auto">
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
                <hr class="clearfix w-100 d-md-none">
                <div class="col-md-2 mx-auto">
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
                <hr class="clearfix w-100 d-md-none">
                <div class="col-md-2 mx-auto">
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
            </div>
        </div>
        <hr>
        <ul class="list-unstyled list-inline text-center py-2">
            <li class="list-inline-item">
                <h5 class="mb-1">Register for free</h5>
            </li>
            <li class="list-inline-item">
                <a href="insert.jsp" class="btn btn-warning btn-rounded">Sign up!</a>
            </li>
        </ul>
        <hr>
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
        <div class="footer-copyright text-center py-3"><b>© 2020 Design
            <a style="color: black" href="https://www.facebook.com/camnguyet.215"><i> CamNguyet</i></b></a>
        </div>
    </footer>
</body>
</html>

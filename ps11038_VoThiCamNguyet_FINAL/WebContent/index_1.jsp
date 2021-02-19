<%-- 
    Document   : index
    Created on : Jun 5, 2020, 3:59:19 PM
    Author     : Ahihi
--%>

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
            background-color: #343a40
        }
    </style>
    <body>
        <div class="container">
            <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
                <!-- Brand/logo -->
                <a class="navbar-brand" href="#">
                    <img class="rounded-circle" src="images/logo.jpg" alt="logo" style="width:40px;">
                </a>

                <!-- Links -->
                <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                    <li class="nav-item">
                        <a class="nav-link" href="showSanPhamTheoHang.jsp">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="showSanPham.jsp">Menu</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="insertSP.jsp">Insert Product</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="giohang.jsp">Cart</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="updateSP.jsp">Update Product</a>
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

                        <a href="index_1.jsp" class="list-group-item list-group-item-action list-group-item-dark">Home</a>
                        <a href="showSanPham.jsp" class="list-group-item list-group-item-action list-group-item">Menu</a>
                        <a href="insertSP.jsp" class="list-group-item list-group-item-action list-group-item">Insert Product</a>
                        <a href="giohang.jsp" class="list-group-item list-group-item-action list-group-item">Cart</a>
                        <a href="updateSP.jsp" class="list-group-item list-group-item-action list-group-item">Update Product</a>
                    </div>
                </div>
                <div class="col-md-9">
                    <img src="images/meo.gif" alt="">
                </div>

            </div>
        </div>
    </body>
</html>

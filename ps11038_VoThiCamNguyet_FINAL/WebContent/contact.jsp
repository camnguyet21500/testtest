<%-- 
    Document   : contact
    Created on : Jun 20, 2020, 10:28:22 AM
    Author     : Ahihi
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            background-color: black;
            color: #DAA520;
        }
        nav{
            background-color: black !important;
            background-image: url('images/15162927-dsc0499_cover_2000x1335.jpg');
        }
        iframe{
            transform: translate(75%, 10%);
            margin-bottom: 70px;
        }

        .noidung ul li{
            color: #696969;
            text-align: center;
            font-size: 50px;
            font-family: 'Times New Roman', Times, serif;
        }

        .noidung ul li:hover{
            color: #818753;
        }

        .noidung ul li i{
            color: #696969;
            text-align: center;
            font-size: 30px;
            font-family: 'Times New Roman', Times, serif;
        }

        .noidung ul li i:hover{
            color: #818753;
        }

        .lienhe ul li{
            text-align: center;
            color: #696969;
            margin-top: 20px;
            font-family: 'Times New Roman', Times, serif;
            font-size: 19px;
        }

        .lienhe ul li span{
            font-weight: bold;
            font-size: 21px;
            font-family: 'Times New Roman', Times, serif;
        }

        .lienhe ul li a{
            font-size: 19px;
            font-family: 'Times New Roman', Times, serif;
        }
    </style>
    <body>
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

            <div class="row mt-3">

                <div class="col-md-9">
                    <div class="noidung">
                        <ul>
                            Beauty Perfume</li><br>
                            <i>Perfume is a symphony, it has a beginning, middle and an end.</i></li>
                        </ul>
                    </div>

                    <div class="lienhe">
                        <ul>
                            Hotline: 215-144-1967
                           Address: Otok Galesnjak, Croatia.
                           Email: beautyperfume@gmail.com
                           Facebook: <a href="https://www.facebook.com/camnguyet.215">Beauty perfume</a></li>
                        </ul>
                    </div>

                    <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2871.073389267009!2d15.381118065459308!3d43.978531829111546!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x4761e04f538c63e7%3A0x50f2a3d385586140!2sGale%C5%A1njak!5e0!3m2!1svi!2s!4v1585290667419!5m2!1svi!2s" width="600" height="450" frameborder="0" style="border:0;" allowfullscreen="" aria-hidden="false" tabindex="0"></iframe>
                </div>
                </body>
                </html>

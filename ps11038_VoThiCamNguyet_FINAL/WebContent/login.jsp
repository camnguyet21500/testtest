<%-- 
    Document   : login
    Created on : Jun 18, 2020, 12:32:15 AM
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
        #left{
            background-image: url('images/15162927-dsc0499_cover_2000x1335.jpg');
            height:722px;
            width:40%;
            float:left;
        }
        #right{
            text-shadow: rgba(238,238,0,1) -1px -2px 1em;
/*            height:400px;
            width:40%;*/
            background-color: white;
            float:right;
            padding-right: 300px;
            padding-top: 230px;
        }
    </style>
    <body>
        <div id="left">

        </div>
        <div id="right">
            <center>
                <h2 style="color: #FF9900">Moonie Restaurant</h2>
                <div class="container">
                    <form action="AccountServlet" method="POST">
                        <div class="form-group">
                            <label style="color: #FF9900" for="uname">U s e r n a m e </label>
                            <input type="text" class="form-control" name="txtUsername" placeholder="Enter username" required>
                            <div class="valid-feedback">Valid.</div>
                            <div class="invalid-feedback">Please fill out this field.</div>
                        </div>
                        <div class="form-group">
                            <label style="color: #FF9900" for="pwd">P a s s w o r d</label>
                            <input type="password" class="form-control" name="txtPassword" placeholder="Enter password" required>
                            <div class="valid-feedback">Valid.</div>
                            <div class="invalid-feedback">Please fill out this field.</div>
                        </div>
                        <button type="submit" class="btn btn-warning">Submit</button>
                    </form>
                </div>
            </center>
        </div>
    </body>
</html>

<%-- 
    Document   : insert
    Created on : May 22, 2019, 8:59:38 PM
    Author     : home
--%>

<%@page import="entities.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Update Account!</h1>
        <form action="AccountServlet2?yeucau=Update" method="post">
            
            <%
                Account account = (Account)session.getAttribute("acc");
            %>
            <table border="1">
                <tbody>
                    <tr>
                        <td>UserName : </td>
                        <td><input type="text" name="txtname" readonly  value="<%= account.getUsername()%>" /></td>
                    </tr>
                    <tr>
                        <td>Password : </td>
                        <td><input type="password" name="txtpass" value="<%= account.getPassword()%>" /></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="Update" name="yeucau" /></td>
                    </tr>
                </tbody>
            </table>

        </form>
    </body>
</html>

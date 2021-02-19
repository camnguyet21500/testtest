<%-- 
    Document   : View
    Created on : May 17, 2019, 6:58:16 PM
    Author     : home
--%>

<%@page import="entities.Account"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <h1>
            <!--Xuat ra gia tri attribute ra-->
            <%= request.getAttribute("thongbao")%>
        </h1>
        <h1>DANH SÁCH TÀI KHOẢN</h1>
        <table border="1">
            <tr>
                <th>Account</th>
                <th>Password</th>
            </tr>
            <%
                ArrayList list = (ArrayList)session.getAttribute("accountList");
                for(Object a:list)
                {
                    Account acc = (Account) a;
                
            %>
            <tr>
                <td> <%=acc.getUsername()%></td>
                <td> <%=acc.getPassword()%></td>
                
                <td> <a href="AccountServlet2?yeucau=delete&txtname=<%=acc.getUsername()%>">Delete</a></td>
            </tr>
            <% } %>
        </table>
        
        <h3><a href="insert.jsp">Insert</a></h3>
    </body>
</html>

<%@ page import="Database.CarsDTO" %>
<%@ page import="Database.Car_ParkDAO" %>
<%@ page import="java.sql.Timestamp" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="Database.Employees_DTO" %>
<%@ page import="Database.Employees_DAO" %>
<%@ page import="Admin.AdminAccount" %><%--
  Created by IntelliJ IDEA.
  User: beadyoasis
  Date: 2020/08/20
  Time: 12:37 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="CSS/result_Emp.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <title>90 Car Park</title>

</head>

<body>
<%
    if (session.getAttribute("AdminID") == null) {
        response.sendRedirect("AccessDeny.jsp");
    }
%>

<header>
    <a href="index.jsp">
        <div class="header_left">
            90 factory Car Park
            <i class="fa fa-lock" aria-hidden="true"></i>
        </div>
    </a>
    <div class="admin">
        Good day <%= AdminAccount.getInputID() %>!
        <form action="/AdminLogout" method="post">
            <input type="submit" value="Logout" class="admin_logout">
        </form>
    </div>

</header>

<main>
    <div class="mainbox">
        <div class="main_title">
            ID<br>
            <i class="fa fa-arrow-down" aria-hidden="true"></i><br>
            <span><%= Employees_DAO.outempID() %></span>
        </div>

        <div class="main_title">
            Name<br>
            <i class="fa fa-arrow-down" aria-hidden="true"></i><br>
            <span><%= Employees_DAO.outEmpName() %></span>
        </div>

        <div class="main_title">
            Car Number <br>
            <i class="fa fa-arrow-down" aria-hidden="true"></i><br>
            <span><%= Employees_DTO.getEmpCar_number() %></span>
        </div>

    </div>
    </div>
</main>

<footer>
    <div class="footer_left">
        Made By Hyeonseok Kim
    </div>
    <div class="footer_right">
        90 FACTORY
    </div>
</footer>
</body>
</html>

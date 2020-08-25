<%@ page import="Database.Employees_DTO" %>
<%@ page import="Admin.AdminAccount" %><%--
  Created by IntelliJ IDEA.
  User: beadyoasis
  Date: 2020/08/24
  Time: 2:19 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>90 Car Park</title>
    <link rel="stylesheet" href="CSS/resultedit.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

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
            Update Success!
        </div>
        <div class="select_box">
            <div class="enter_number">
                <span>ID</span>
            </div>

            <div class="enter_number">
                <span>Name</span>
            </div>

            <div class="enter_number">
                <span>Car Number</span>
            </div>

            <div class="enter_number2">
                <span><%= Employees_DTO.getEmp_ID() %></span>
            </div>

            <div class="enter_number2">
                <span><%= Employees_DTO.getEmp_name() %></span>
            </div>

            <div class="enter_number2">
                <span><%= Employees_DTO.getEmpCar_number() %></span>
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

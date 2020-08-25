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
    <link rel="stylesheet" href="CSS/SuccessAddEmp.css">
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
            Add<br>
            Finish!
        </div>
        <div class="select_box">
            <div class="car_num">
                <div class="enter_car1">
                    ID
                </div>
                <div class="out_car1">
                    <%= Employees_DAO.outempID() %>
                </div>
            </div>

            <div class="car_num">
                <div class="enter_car1">
                    Name
                </div>
                <div class="out_car1">
                    <%= Employees_DTO.getEmp_name() %>
                </div>
            </div>

            <div class="car_num">
                <div class="enter_car2">
                    Car <br>
                    Number
                </div>
                <div class="out_car2">
                    <%= Employees_DTO.getEmpCar_number() %>
                </div>

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

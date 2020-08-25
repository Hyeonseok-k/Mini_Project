<%@ page import="Database.CarsDTO" %>
<%@ page import="Database.Car_ParkDAO" %>
<%@ page import="java.sql.Timestamp" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.sql.SQLOutput" %><%--
  Created by IntelliJ IDEA.
  User: beadyoasis
  Date: 2020/08/20
  Time: 12:37 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="CSS/SuccessEnterCar.css">
    <title>90 Car Park</title>

</head>

<body>

<%!
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy. MM. dd. \t HH: mm: ss");
%>

<header>
    <a href="index.jsp">
        <div class="header_left">
            90 factory Car Park
        </div>
    </a>

</header>

<main>
    <div class="mainbox">
        <div class="main_title">
            Enter<br>
            Success!
        </div>
        <div class="select_box">
            <div class="car_num">
                <div class="enter_car1">
                    Number
                </div>
                <div class="out_car1">
                    <%= CarsDTO.getCar_Number() %>
                </div>
            </div>
            <div class="in_time">
                <div class="enter_car2">
                    In-Time
                </div>
                <div class="out_car2">
                    <%= sdf.format(Car_ParkDAO.getInTime()) %>
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

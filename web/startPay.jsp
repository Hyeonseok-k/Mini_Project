<%@ page import="Database.CarsDTO" %>
<%@ page import="Database.Car_ParkDAO" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.sql.Timestamp" %>
<%@ page import="java.util.Date" %>
<%@ page import="Payment.FeeCalcu" %><%--
  Created by IntelliJ IDEA.
  User: beadyoasis
  Date: 2020/08/20
  Time: 3:09 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>90 Car Park</title>
    <link rel="stylesheet" href="/CSS/startpay.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

</head>

<body>
<%!
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy. MM. dd. HH: mm: ss");
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
            Please Check!
        </div>
        <div class="select_box">
            <div class="enter_number">
                <span>Car Number</span>
                <i class="fa fa-arrow-down" aria-hidden="true"></i>
            </div>
            <div class="enter_number2">
                <span>In-Time</span>
                <i class="fa fa-arrow-down" aria-hidden="true"></i>
            </div>
            <div class="enter_number">
                <span>Out-Time</span>
                <i class="fa fa-arrow-down" aria-hidden="true"></i>
            </div>
            <div class="enter_number2">
                <span>Usage Time</span>
                <i class="fa fa-arrow-down" aria-hidden="true"></i>
            </div>
            <div class="enter_number">
                <span>Fee </span>
                <i class="fa fa-arrow-down" aria-hidden="true"></i>
            </div>
            <div class="enter_number2">
                <span><%= CarsDTO.getCar_Number() %></span>
            </div>
            <div class="enter_number">
                <span><%= sdf.format(Car_ParkDAO.getInTime()) %></span>
            </div>
            <div class="enter_number2">
                <span><%= sdf.format(Car_ParkDAO.getOutTime()) %></span>
            </div>
            <div class="enter_number">
                <span><%= FeeCalcu.timeCal() %> <br>Seconds</span>
            </div>
            <div class="enter_number2">
                <span><%= FeeCalcu.feeCal() %><br> Won</span>
            </div>
        </div>
        <a href="discount_fee.jsp" class="main_title">
            <div>
                Start Pay!
            </div>
        </a>
        </form>
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

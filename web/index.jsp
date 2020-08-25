<%@ page import="Database.Car_ParkDAO" %>
<%@ page import="java.net.http.HttpClient" %><%--
  Created by IntelliJ IDEA.
  User: beadyoasis
  Date: 2020/08/15
  Time: 10:57 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="ko">


<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="CSS/index.css">
    <title>90 Car Park</title>
</head>

<body>

<header>
    <a href="index.jsp">
        <div class="header_left">
            90 factory Car Park
        </div>
    </a>
    <a href="adminLogin.jsp">
        <div class="admin">
            Admin
        </div>
    </a>
</header>

<main>
    <div class="mainbox">
        <div class="main_title">
            90 Factory<br>
            Car Park <br>
            <span>Available Space : <%= 100 - Car_ParkDAO.getSpace() %></span>
        </div>
        <div class="select_box">
            <form action="/enter" method="post">
            <a href="enter_car.jsp">
                <div class="enter_car">
                    In
                </div>
            </a>
            </form>
            <form action="/out" method="post">
            <a href="out_car.jsp">
                <div class="out_car">
                    Out
                </div>
            </a>
            </form>
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
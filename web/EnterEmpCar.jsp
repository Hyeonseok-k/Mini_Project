<%@ page import="Database.Employees_DAO" %><%--
  Created by IntelliJ IDEA.
  User: beadyoasis
  Date: 2020/08/19
  Time: 3:36 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>90 Car Park</title>
    <link rel="stylesheet" href="CSS/index.css">
</head>

<body>

<header>
    <a href="index.jsp">
        <div class="header_left">
            90 factory Car Park
        </div>
    </a>

</header>

<main>
    <div class="Success_mainbox">
        <div class="Success_main_title">
            GoodDay <br> <%= Employees_DAO.outEmpName() %>!
        </div>
        <div class="Success_main_title2">
            Have a Nice Day!
        </div>
        <div class="select_box">
            <a href="enter_car.html">
            </a>
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
</body

</body>
</html>

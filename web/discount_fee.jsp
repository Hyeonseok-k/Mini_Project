<%--
  Created by IntelliJ IDEA.
  User: beadyoasis
  Date: 2020/08/20
  Time: 3:56 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>90 Car Park</title>
    <link rel="stylesheet" href="CSS/discount_fee.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

</head>

<body>
<script type="text/javascript" src="JS/Javascript.js"></script>

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
            Check Your Discount!
        </div>
        <div class="select_box">
            <div class="enter_number">
                <span>Your Spent Money</span>
                <i class="fa fa-arrow-down" aria-hidden="true"></i>
            </div>
            <form action="/discount" method="POST">
                <input type="text" class="input_number" placeholder="Spent Money" name="spend_money"
               onkeypress="return checkNum(event)">
        </div>
        <input type="submit" value="Enter!" class="main_submit">
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

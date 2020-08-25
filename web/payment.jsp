<%@ page import="Payment.FeeCalcu" %>
<%@ page import="Discount.Discount" %><%--
  Created by IntelliJ IDEA.
  User: beadyoasis
  Date: 2020/08/20
  Time: 4:38 오후
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
            Payment
        </div>
        <div class="select_box">
            <div class="enter_number">
                <span >Your Fee is
                    <%= FeeCalcu.feeCal() - (int)(FeeCalcu.feeCal() * Discount.getRate()) %> Won</span>
            </div>
            <form action="/payment" method="POST">
                <input type="text" class="input_number" placeholder="Write Your Fee" name="input_fee"
           onkeypress="return checkNum(event)">
        </div>
        <input type="submit" value="Pay!" class="main_submit">
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

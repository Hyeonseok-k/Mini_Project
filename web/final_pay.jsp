<%@ page import="Payment.FeeCalcu" %>
<%@ page import="Discount.Discount" %><%--
  Created by IntelliJ IDEA.
  User: beadyoasis
  Date: 2020/08/20
  Time: 4:07 오후
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
            <div class="enter_number2">
                <span>Before Discount</span>
                <i class="fa fa-arrow-down" aria-hidden="true"></i>
            </div>
            <div class="enter_number">
                <span>Spent Money</span>
                <i class="fa fa-arrow-down" aria-hidden="true"></i>
            </div>
            <div class="enter_number2">
                <span>Discount Rate</span>
                <i class="fa fa-arrow-down" aria-hidden="true"></i>
            </div>
            <div class="enter_number">
                <span>Discounted Fee</span>
                <i class="fa fa-arrow-down" aria-hidden="true"></i>
            </div>
            <div class="enter_number2">
                <span>Final Fee</span>
                <i class="fa fa-arrow-down" aria-hidden="true"></i>
            </div>
            <div class="enter_number">
                <span><%= FeeCalcu.feeCal() %><br>Won</span>
            </div>
            <div class="enter_number2">
                <span><%= Discount.getSpendMoney() %><br>Won</span>
            </div>
            <div class="enter_number">
                <span><%= (int)(Discount.getRate() * 100) %><br>Percent</span>
            </div>
            <div class="enter_number2">
                <span><%=(int)(FeeCalcu.feeCal() * Discount.getRate()) %> <br>Won</span>
            </div>
            <div class="enter_number">
                <span><%= FeeCalcu.feeCal() - (int)(FeeCalcu.feeCal() * Discount.getRate()) %><br>Won</span>
            </div>
            <%
                Discount.setFinalFee(FeeCalcu.feeCal() - (int)(FeeCalcu.feeCal() * Discount.getRate()));
            %>
        </div>
        <a href="/Final_payment" class="main_title">
            <div>
                Pay!
            </div>
        </a>
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

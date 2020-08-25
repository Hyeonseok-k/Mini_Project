<%--
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
    <link rel="stylesheet" href="CSS/enter_car.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <title>90 Car Park</title>


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
            Start
            Pay!
        </div>
        <div class="select_box">
            <div class="enter_number">
                <span>Your Car Number</span>
                <i class="fa fa-arrow-down" aria-hidden="true"></i>
            </div>
            <form action="/startPay" method="POST">
                <input type="text" maxlength="8" class="input_number" placeholder="Your Number" name="Car_Number">
        </div>
        <input type="submit" value="Check!" class="main_submit">
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
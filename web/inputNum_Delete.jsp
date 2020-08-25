<%@ page import="Admin.AdminAccount" %><%--
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
            <i class="fa fa-trash-o" aria-hidden="true"></i><br>
            Delete
        </div>
        <div class="select_box">
            <div class="enter_number">
                <span>Who's data?</span>
                <i class="fa fa-arrow-down" aria-hidden="true"></i>
            </div>
            <form action="/deleteEmp" method="POST">
                <input type="text" maxlength="8" class="input_number" placeholder="Car Number" name="Car_Number">
        </div>
        <input type="submit" value="Delete!" class="main_submit">
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
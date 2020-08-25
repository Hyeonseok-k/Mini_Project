<%--
  Created by IntelliJ IDEA.
  User: beadyoasis
  Date: 2020/08/21
  Time: 4:06 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>90 Car Park</title>
    <link rel="stylesheet" href="CSS/adminLogin.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

</head>
<body>
<%
    if (session.getAttribute("AdminID") != null) {
        response.sendRedirect("admin_main.jsp");
    }
%>

<header>
    <a href="index.jsp">
        <div class="header_left">
            90 factory Car Park
            <i class="fa fa-lock" aria-hidden="true"></i>
        </div>
    </a>

</header>

<main>
    <div class="mainbox">
        <div class="main_title">
            <i class="fa fa-lock" aria-hidden="true"></i><br>
            Admin
        </div>
        <div class="select_box">
            <form action="/adminLogin" method="POST">
                <input type="text" class="input_number" placeholder="ID" name="admin_ID">
                <input type="password" class="input_number" placeholder="PASSWORD" name="admin_password">
        </div>
        <input type="submit" value="Login" class="main_submit">
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

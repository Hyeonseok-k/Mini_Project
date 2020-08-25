<%@ page import="Admin.AdminAccount" %><%--
  Created by IntelliJ IDEA.
  User: beadyoasis
  Date: 2020/08/21
  Time: 5:18 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>90 Car Park</title>
    <link rel="stylesheet" href="CSS/employees_main.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
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
        <a href="Search_Emp.jsp" class="main_title">
            <div>
                <i class="fa fa-search" aria-hidden="true"></i><br>
                Search<br>
            </div>
        </a>

        <a href="addEmp.jsp" class="main_title">
            <div>
                <i class="fa fa-plus" aria-hidden="true"></i><br>
                Add<br>
            </div>
        </a>

        <a href="inputNum_Edit.jsp" class="main_title">
            <div>
                <i class="fa fa-pencil" aria-hidden="true"></i><br>
                Edit<br>
            </div>
        </a>

        <a href="inputNum_Delete.jsp" class="main_title">
            <div>
                <i class="fa fa-trash-o" aria-hidden="true"></i><br>
                Delete<br>
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

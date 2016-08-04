<%-- 
    Document   : user_login
    Created on : Mar 3, 2016, 6:52:11 PM
    Author     : Djole
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Login Page</title>
    </head>
    <style>
        .body
        {
            background-color: #dfe3ee;
            
        }
        .table
        {
            background-color: #8b9dc3;
            margin-left: 550px;
            margin-right: 550px;
        }
    </style>
    <body class="body">
    <center>
        <h2>User Login:</h2>
        <form:form action="user_login.htm" method="post" name="loginForm">
            <div class="table">
                <table>
                    <tr><td>&nbsp</td></tr>
                    <tr><td>Username: </td><td><input name="userName" type="textbox"></td></tr>
                    <tr><td>Password: </td><td><input name="password" type="password"></td></tr>
                    <tr><td colspan="2" align="center"><input type="submit" value="Submit"></td></tr>
                    <tr><td>&nbsp</td></tr>
                </table>
            </div>
            <div style="color:red">${error}</div>
        </form:form>
    </center>
</body>
</html>

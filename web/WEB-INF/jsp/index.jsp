<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Web Shop</title>
    </head>
    <style>
        .body
        {
            background-color: #dfe3ee;

        }
        .table
        {
            background-color: #8b9dc3;
            padding-left: 10px;
            padding-right: 10px;
            padding-top: 5px;
            padding-bottom: 5px;
        }
    </style>
    <body class="body">
        <div class="table">
            <h2 align="center">WEB-SHOP</h2>
        </div>
        <a href="admin_login.htm"> Admin login</a></br>
        <a href="user_login.htm"> User login</a>

        </br>
        <center>
            <h3>List of our products:</h3><br/>

            <%-- Prikaz svih utisaka (upotreba expression jezika)--%>
            <textarea id="product_list" rows="40" cols="100" readonly>${products}</textarea>
        </center>
    </body>
</html>


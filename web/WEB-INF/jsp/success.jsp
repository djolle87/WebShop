<%-- 
    Document   : success
    Created on : Mar 4, 2016, 5:32:12 PM
    Author     : Djole
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Success</title>
    </head>
    <style>
        .body
        {
            background-color: #dfe3ee;

        }
        .block
        {
            background-color: #8b9dc3;
            margin-left: 500px;
            margin-right: 500px;
        }
    </style>
    <body class="body">
    <center>
        </br>
        </br>
        <h2>Shopping result:</h2>
        <div class="block">
            <h4>Success!</h4>
            <p>You have successfully bought ${quantity} item(s) of product Id:${id}.</p>
            <p>If you want to make another purchase, please click <a href="buy_product.htm">here</a>.</p>
            </br>
        </div>
    </center>
</body>
</html>

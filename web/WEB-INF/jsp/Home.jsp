<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Tools</title>
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
        <h4>Wellcome back ${userInfo}!</h4>
    <center>
        </br>
        </br>
        <h2>Management tools:</h2>
        <div class="block">
            <h4>User management</h4>
            <p>If you want to manage users (add, delete, update), please click <a href="user_managment.htm">here</a>.</p>
            </br>
        </div>
        </br>
        <div class="block">
            <h4>Product management</h4>
            <p>If you want to manage products (add, delete, update), please click <a href="product_managment.htm">here.</a></p>
            </br>
        </div>
    </center>
</body>
</html>


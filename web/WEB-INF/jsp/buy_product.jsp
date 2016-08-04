<%-- 
    Document   : product_managment
    Created on : Mar 4, 2016, 10:10:33 AM
    Author     : Djole
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping portal</title>
    </head>
    <style>
        .body
        {
            background-color: #dfe3ee;
        }
        .block
        {
            margin-left: 300px;
            margin-right: 300px;
            margin: calc;
        }
        .table
        {
            background-color: #8b9dc3;
            padding-left: 44px;
            padding-right: 44px; 

            border: #3b5998;
            border-width: 5px;
            border-style: solid;

        }
    </style>
    <body class="body">
    <center>
        <h1>Shopping portal:</h1>
        </br>

        <div class="block">
            <table>
                <tr>
                    <td class="table">            
                        <h4>Buy product:</h4>
                        <form:form action="buy_product.htm" method="post" commandName="product">
                            <form:label path="id">Product Id:</form:label></br>
                            <form:input id="id" type="text" path="id" placeholder="Product Id..."></form:input></br></br>
                            <form:label path="quantity">Quantity:</form:label></br>
                            <form:input id="id" type="text" path="quantity" placeholder="Number of items..."></form:input>
                                </br></br>
                                <input type="submit" value="Buy"/></br></br>
                        </form:form>
                    </td>
            </table>
        </div>
        </br>
        <label for="product_list" id="product_list_label">List of existing products in database:</label><br/>


        <textarea id="product_list" rows="30" cols="100" readonly>${products}</textarea>
    </center>
</html>

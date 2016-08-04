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
        <title>Product management</title>
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
        <h1>Product management:</h1>
        </br>

        <div class="block">
            <table>
                <tr>
                    <td class="table">            
                        <h4>Add new product:</h4>
                        <form:form action="product_managment.htm" method="post" commandName="product">
                            <form:label path="name">Product name:</form:label></br>
                            <form:input id="name" type="text" path="name" placeholder="New product..."></form:input></br></br>
                            <form:label path="brand">Product brand:</form:label></br>
                            <form:input id="brand" type="text" path="brand" placeholder="Brand..."></form:input></br></br>
                            <form:label path="model">Product model:</form:label></br>
                            <form:input id="model" type="text" path="model" placeholder="Model..."></form:input></br></br>
                            <form:label path="price">Product price:</form:label></br>
                            <form:input id="price" type="text" path="price" placeholder="Price..."></form:input></br></br>
                            <form:label path="quantity">Product quantity:</form:label></br>
                            <form:input id="quantity" type="text" path="quantity" placeholder="Quantity..."></form:input></br></br></br></br></br></br>
                                <input type="submit" value="Add"/> </br></br>         
                        </form:form>
                    </td>
                    <td class="table">            
                        <h4>Delete product:</h4>
                        <form:form action="product_delete.htm" method="post" commandName="product">
                            <form:label path="id">Product Id:</form:label></br>
                            <form:input id="id" type="text" path="id" placeholder="Product Id..."></form:input>
                                </br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br>
                                <input type="submit" value="Delete"/></br></br>      
                        </form:form>
                    </td>
                    <td class="table">            
                        <h4>Update product:</h4>
                        <form:form action="product_edit.htm" method="post" commandName="product">
                            <form:label path="id">Product Id:</form:label></br>
                            <form:input id="id" type="text" path="id" placeholder="Product Id..."></form:input></br></br>
                            <form:label path="name">Product name:</form:label></br>
                            <form:input id="name" type="text" path="name" placeholder="Change product..."></form:input></br></br>
                            <form:label path="brand">Product brand:</form:label></br>
                            <form:input id="name" type="text" path="brand" placeholder="Change brand..."></form:input></br></br>
                            <form:label path="model">Product model:</form:label></br>
                            <form:input id="name" type="text" path="model" placeholder="Change model..."></form:input></br></br>
                            <form:label path="price">Product price:</form:label></br>
                            <form:input id="name" type="text" path="price" placeholder="Change price..."></form:input></br></br>
                            <form:label path="quantity">Product quantity:</form:label></br>
                            <form:input id="name" type="text" path="quantity" placeholder="Change quantity..."></form:input></br></br>
                                </br>
                                <input type="submit" value="Update"/></br></br>       
                        </form:form>
                    </td>
                </tr>
            </table>
        </div>
        </br>
        <label for="product_list" id="product_list_label">List of existing products in database:</label><br/>


        <textarea id="product_list" rows="20" cols="100" readonly>${products}</textarea>
    </center>
</html>

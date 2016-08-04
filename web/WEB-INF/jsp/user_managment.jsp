<%-- 
    Document   : user_managment
    Created on : Mar 1, 2016, 5:06:44 PM
    Author     : Djole
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User management</title>
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
        <h1>User management:</h1>
        </br>

        <div class="block">

            <table>
                <tr>
                    <td class="table">            
                        <h4>Add new user:</h4>
                        <form:form action="user_managment.htm" method="post" commandName="user">
                            <form:label path="username">Username:</form:label></br>
                            <form:input id="name" type="text" path="username" placeholder="New username..."></form:input></br></br>
                            <form:label path="password">Password:</form:label></br>
                            <form:input id="user" type="password" path="password" placeholder="New password..."></form:input>
                                </br></br></br></br></br>
                                <input type="submit" value="Add"/> </br></br>         
                        </form:form>
                    </td>
                    <td class="table">            
                        <h4>Delete user:</h4>
                        <form:form action="user_delete.htm" method="post" commandName="user">
                            <form:label path="id">User Id:</form:label></br>
                            <form:input id="id" type="text" path="id" placeholder="User Id..."></form:input>
                                </br></br></br></br></br></br></br></br>
                                <input type="submit" value="Delete"/></br></br>      
                        </form:form>
                    </td>
                    <td class="table">            
                        <h4>Update user:</h4>
                        <form:form action="user_edit.htm" method="post" commandName="user">
                            <form:label path="id">User Id:</form:label></br>
                            <form:input id="id" type="text" path="id" placeholder="User Id..."></form:input></br></br>
                            <form:label path="username">Username:</form:label></br>
                            <form:input id="name" type="text" path="username" placeholder="Change username..."></form:input></br></br>
                            <form:label path="password">Password:</form:label></br>
                            <form:input id="user" type="password" path="password" placeholder="Change password..."></form:input>
                                </br></br>
                                <input type="submit" value="Update"/></br></br>       
                        </form:form>
                    </td>
                </tr>
            </table>
        </div>
        </br>
        <label for="user_list" id="user_list_label">List of existing users in database:</label><br/>


        <textarea id="user_list" rows="20" cols="89" readonly>${users}</textarea>
    </center>
</body>
</html>

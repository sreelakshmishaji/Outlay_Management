<%-- 
    Document   : HomePage
    Created on : Aug 4, 2018, 12:52:23 PM
    Author     : sree
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean class="database.ConnectionClass" id="obj"></jsp:useBean>
<%@page import="java.sql.ResultSet"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home page</title>
        <style>
#customers {
    font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

#customers td, #customers th {
    border: 1px solid #ddd;
    padding: 8px;
}

#customers tr:nth-child(even){background-color: #f2f2f2;}

#customers tr:hover {background-color: #ddd;}

#customers th {
    padding-top: 12px;
    padding-bottom: 12px;
    text-align: left;
    background-color: #4CAF50;
    color: white;
}
</style>
    </head>
     <body>
         <table id="customers">
  <tr>
    <th><a href="HomePage.jsp">Home</a></th>
    <th><a href="ChangePassword.jsp">Change Password</a></th>
    <th><a href="State.jsp">State</a></th>
    <th><a href="District.jsp">District</a></th>
    <th><a href="Place.jsp">Place</a></th>
    <th><a href="IncomeType.jsp">Income Type</a></th>
    <th><a href="ExpenseType.jsp">Expense Type</a></th>
    
  </tr>
    </table>
    </body>
</html>

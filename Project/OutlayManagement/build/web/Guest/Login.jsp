<%-- 
    Document   : Login
    Created on : Aug 4, 2018, 11:45:41 AM
    Author     : sree
--%>

<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean class="database.ConnectionClass" id="obj"></jsp:useBean>
<%@page import="java.sql.ResultSet"%>
<html>
     <%
        if(request.getParameter("submit")!=null)
        {
            String name=request.getParameter("username");
            String pswd=request.getParameter("password");
            String select="select admin_id from tbl_admin where admin_username='"+name+"' and admin_pswd='"+pswd+"'";
            out.println(select);
            ResultSet rs=obj.select(select);
            if(rs.next())
          
                session.setAttribute("UserID", rs.getString("admin_id"));
                response.sendRedirect("../Admin/HomePage.jsp");
            }
            else
               
            {
             System.out.println("Invalid Login");   
            }
           
        
            %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <html>
<style>
input[type=text],input[type=password], select {
    width: 50%;
    padding: 12px 25px;
    margin: 8px 15px;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
}

input[type=submit] {
    width: 50%;
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 50px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

input[type=submit]:hover {
    background-color: #45a049;
}
input[type=reset] {
    width: 20%;
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 10px 50px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}
input[type=reset]:hover {
    background-color: #45a049;
}

#main {
    border-radius: 5px;
    background-color: #f2f2f2;
    padding: 20px;
    margin-left: 350px;
    margin-top: 100px;
    width: 30%;
}
</style>
<body>


<div id="main">
  <form >
      <div>
    <label for="username">User Name</label>
    <input type="text" id="uname" name="username" placeholder="Enter your user name">
      </div>
      <div>
    <label for="password">Password</label>
    &nbsp;&nbsp;<input type="password" id="pwd" name="password" placeholder="Enter your password"> 
      </div>
    <input type="submit" name="submit" value="Login">
    <input type="reset" name="cancel" value="CANCEL">
  </form>
</div>

</body>
</html>

    
</html>

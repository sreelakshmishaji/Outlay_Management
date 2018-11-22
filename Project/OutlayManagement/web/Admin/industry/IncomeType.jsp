<%-- 
    Document   : IncomeType
    Created on : Aug 21, 2018, 1:00:17 PM
    Author     : sree
--%>
<%@include file="AdminHeader.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean class="database.ConnectionClass" id="obj"></jsp:useBean>
<%@page import="java.sql.ResultSet"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Income Type</title>
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
    background-color: grey;
    color: white;
}
</style>
    </head>
   <style>
input[type=text], select {
    width: 50%;
    padding: 12px 25px;
    margin: 10px 20px;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
}

input[type=submit] {
    width: 20%;
    background-color: grey;
    color: white;
    padding: 10px 8px;
    margin: 10px 30px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

input[type=submit]:hover {
    background-color: #45a049;
}
input[type=reset] {
    width: 20%;
    background-color: grey;
    color: white;
    padding: 10px 8px;
    margin: 10px 30px;
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
    width: 60%;
}

</style>
<body>
  
    <%
         String id = "";
         String intypeid="";
         
         
        if(request.getParameter("submit")!=null)
        {
            String name=request.getParameter("incometype");
            String idd=request.getParameter("hid");
            if(!idd.equals(""))
            {
              String update="update tbl_intype set intype_name='"+name+"' where intype_id='"+idd+"'";
            if (obj.insert(update))
           {
               %>
            <script>
                alert("Updated Successfully!!");
                setTimeout(function(){window.location.href='IncomeType.jsp'},100);
                </script>
                <%
               
           }
            }
            
           else 
            
            
            {
            String insert="insert into tbl_intype(intype_name) values('"+name+"')";
            boolean b=obj.insert(insert);
            if (b)
           { %>
            <script>
                alert("Successfully inserted");
                setTimeout(function(){window.location.href='IncomeType.jsp'},100);
                </script>
                <%
                
            }   
            else
            {
               System.out.println("Insertion Failed");  
            }
                    
        }
        }
         if(request.getParameter("delid")!=null)
        {
        String a=request.getParameter("delid");
        String del="delete  from tbl_intype where intype_id='"+a+"'";
        if (obj.insert(del))
       { %>
            <script>
                alert("Successfully deleted");
                setTimeout(function(){window.location.href='IncomeType.jsp'},100);
                </script>
                <%
                
            }   
        else
        {
            System.out.println("Deletion Failed");
            
        }
        }
         if(request.getParameter("editid")!=null)
         {
             id=request.getParameter("editid");
             String sel="select intype_name from tbl_intype where intype_id="+id ;
             ResultSet rs=obj.select(sel);
             if(rs.next())
             {
               intypeid=rs.getString("intype_name");

             }
         }     
        
        %>
    
    
    
    
    
    
   <form> 
          
<div id="main">
  
      <div>
    <label for="state">Income Name</label>
    <input type="text" id="incometype" name="incometype" placeholder="Enter Income name" size="30" pattern="[A-Za-z ]{1,30}" required="" value="<%=intypeid%>">
    <input type="hidden" name="hid" value="<%=id%>">
      </div>
      
   &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="submit" name="submit" value="submit">
   <input type="reset" name="cancel" value="Cancel">
       <table id="customers">
       <tr>
                    <th>No</th>
                    <th>Income Name</th>
                    <th>Delete</th>
                    <th>Edit</th>
                </tr>
                  <%
        String s ="select * from tbl_intype";
        ResultSet r = obj.select(s);
        int i=1;
        while (r.next())
        {
        String n=r.getString("intype_name");
        %>   
          <tr>
            <td><%=i%> </td>
            <td><%=n%></td>   
            <td><a href ="IncomeType.jsp?delid=<%=r.getString("intype_id")%>"><img src="../../Design/Icon/delete1.jpg" width="35" height="35"></a></td> 
            <td><a href ="IncomeType.jsp?editid=<%=r.getString("intype_id")%>"><img src="../../Design/Icon/edit1.jpg" width="35" height="35"></a></td>
        </tr>
        <% i++;
        
        }
        
        %>
            </table>
</div>
          
</form>     
</body>
</html>
<%@include file="AdminFooter.jsp" %>
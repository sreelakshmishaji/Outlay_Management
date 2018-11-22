<%-- 
    Document   : Place
    Created on : Aug 4, 2018, 2:15:08 PM
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
        <title>Place</title>
        <script src="jquery.js" type="text/javascript"></script>
        <script>
            function getDistrict(id)
            {
                $.ajax(
                        {
                            url: "AjaxPlace.jsp?id="+id,
                            success: function (result) {
                            $("#districtid").html(result);
                        
                        
                    }
                        });
            }
        </script>
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
    </head>
<body>
      <%
          String id="";
          String stateid="";
          String distid="";
          String placeid="";
          String pin1="";
        if(request.getParameter("submit")!=null)
        {
            String place=request.getParameter("place");
            String district=request.getParameter("district");
            String pin=request.getParameter("pin");
            String idd=request.getParameter("hid");
            if(!idd.equals(""))
            {
            String update="update tbl_place set place_name='"+place+"',place_pin='"+pin+"',dist_id='"+district+"' where place_id='"+idd+"'";
            if (obj.insert(update))
           {
               %>
            <script>
                alert("Updated Successfully!!");
                 setTimeout(function(){window.location.href='Place.jsp'},100);
                </script>
                <%
               
           }
            }
            else
            
        {
            
             String insert="insert into tbl_place(place_name,dist_id,place_pin)values('"+place+"','"+district+"','"+pin+"')";
         
            
            boolean b=obj.insert(insert);
            if (b)
            { %>
            <script>
                alert("Successfully inserted");
                 setTimeout(function(){window.location.href='Place.jsp'},100);
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
        String del="delete  from tbl_place where place_id='"+a+"'";
        if (obj.insert(del))
         { %>
            <script>
                alert("Successfully deleted");
                 setTimeout(function(){window.location.href='Place.jsp'},100);
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
             String sel="select place_name,p.dist_id,place_pin,state_id from tbl_place p inner join tbl_dist d on p.dist_id=d.dist_id where place_id="+id;
             System.out.println(sel);
             ResultSet rs=obj.select(sel);
             if(rs.next())
             {
                 placeid=rs.getString("place_name");
                 distid=rs.getString("dist_id");
                 stateid=rs.getString("state_id");
                 pin1=rs.getString("place_pin");
             }
         }
        
        %>
    <form>
        <div id="main">
  
      <div>
    <label for="state">State</label>&nbsp&nbsp&nbsp&nbsp;
    <select name="state" onchange="getDistrict(this.value)" required="">
<option selected="selected" value="" >select</option>
<%
    String s ="select * from tbl_state ";
     ResultSet r = obj.select(s);
        
        while (r.next())
        {
       
%>
<option <%if(stateid.equals(r.getString("state_id"))){%>selected="" <%}%>value="<%=r.getString("state_id")%>"><%=r.getString("state_name")%></option>
<%

}
        %>
    </select>
      </div>
     <div>
    <label for="district">District</label>
     <select name="district" id="districtid" required="">
<option selected="selected" value="" >select</option>
<%
    String d ="select * from tbl_dist";
     ResultSet r1 = obj.select(d);
        
        while (r1.next())
        {
       
%>
<option <%if(distid.equals(r1.getString("dist_id"))){%>selected="" <%}%>value="<%=r1.getString("dist_id")%>"><%=r1.getString("dist_name")%></option>
<%

}
        %>
        </select>
      </div>
        <div>
    <label for="place">Place</label>&nbsp&nbsp&nbsp;
    <input type="text" id="place" name="place" placeholder="Enter your place" size="30" pattern="[A-Za-z ]{1,30}" required="" value="<%=placeid%>">
      </div>    
        <div>
           
    <label for="pin">Pin No</label>&nbsp;
    <input type="text" id="pin" name="pin" placeholder="Enter your pin" size="30" pattern="[0-9]{6}" required=""  value="<%=pin1%>">
     <input type="hidden" name="hid" value="<%=id%>">
      </div>    
    &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="submit" name="submit" value="submit">
    <input type="reset" name="cancel" value="Cancel">    
   
      <table id="customers">
  <tr>
    <th>No</th>  
    <th>Place</th>
    <th>District</th>
    <th>State</th>
    <th>Pin</th>
    <th>Delete</th>
    <th>Edit</th>
    </tr>
               
<%
        String p ="select * from tbl_place p inner join tbl_dist d on p.dist_id=d.dist_id inner join tbl_state s on d.state_id=s.state_id";
        ResultSet r2 = obj.select(p);
        int i=1;
        while (r2.next())
        {
        String n=r2.getString("place_name");
        %>
        <tr>
            <td><%=i%> </td>
            <td><%=n%></td>  
             
            <td><%=r2.getString("dist_name")%></td> 
            <td><%=r2.getString("state_name")%></td> 
            <td><%=r2.getString("place_pin")%></td> 
            <td><a href ="Place.jsp?delid=<%=r2.getString("place_id")%>"><img src="../../Design/Icon/delete1.jpg" width="35" height="35"></a></td>
            <td><a href ="Place.jsp?editid=<%=r2.getString("place_id")%>"><img src="../../Design/Icon/edit1.jpg" width="35" height="35"></a></td>
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
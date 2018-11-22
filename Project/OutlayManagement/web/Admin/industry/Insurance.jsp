<%-- 
    Document   : Insurance
    Created on : Aug 29, 2018, 2:44:31 PM
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
        <title>Insurance</title>
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
    padding: 14px 20px;
    margin: 10px 50px;
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
    margin-left: 160px;
    margin-top: 100px;
    width: 83%;
}
</style>
<body>
      <%
         
          String id="";
          String ins1="";
          String companyid="";
          String instypeid="";
          String amount1="";
          String intrest1="";
          String des1="";
          String duration1="";
          
        if(request.getParameter("submit")!=null)
        {
            String insurance=request.getParameter("ins");
            String company=request.getParameter("cmpy");
            String instype=request.getParameter("instype");
            String amount=request.getParameter("amt");
            String intrest=request.getParameter("inst");
            String des=request.getParameter("des");
            String duration=request.getParameter("duration");
            String idd=request.getParameter("hid");
            if(!idd.equals(""))
            {
            String update="update tbl_insurance set insurance_name='"+insurance+"',company_id='"+company+"',instype_id='"+instype+"',insurance_amount='"+amount+"',insurance_intrest='"+intrest+"',insurance_dis='"+des+"',insurance_duration='"+duration+"' where insurance_id='"+idd+"'";
            if (obj.insert(update))
           {
               %>
            <script>
                alert("Updated Successfully!!");
                setTimeout(function(){window.location.href='Insurance.jsp'},100);
                </script>
                <%
               
           }
            }
             else
            
        {
            String insert="insert into tbl_insurance(insurance_name,company_id,instype_id,insurance_amount,insurance_intrest,insurance_duration,insurance_dis) values('"+insurance+"','"+company+"','"+instype+"','"+amount+"','"+intrest+"','"+duration+"','"+des+"')";
            boolean b=obj.insert(insert);
            if (b)
            { %>
            <script>
                alert("Successfully inserted");
                setTimeout(function(){window.location.href='Insurance.jsp'},100);
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
        String del="delete  from tbl_insurance where insurance_id='"+a+"'";
        if (obj.insert(del))
         { %>
            <script>
                alert("Successfully deleted");
                setTimeout(function(){window.location.href='Insurance.jsp'},100);
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
             String sel="select insurance_name,company_id,instype_id,insurance_amount,insurance_intrest,insurance_duration,insurance_dis from tbl_insurance where insurance_id="+id;
             System.out.println(sel);
             ResultSet rs=obj.select(sel);
             if(rs.next())
             {
                 
                 ins1=rs.getString("insurance_name");
                 companyid=rs.getString("company_id");
                 instypeid=rs.getString("instype_id");
                 amount1=rs.getString("insurance_amount");
                 intrest1=rs.getString("insurance_intrest");
                 duration1=rs.getString("insurance_duration");
                 des1=rs.getString("insurance_dis");
                 
                 
                 
             }
         }
            
            
        
        %>
         <form> 
           
        
<div id="main">
  <form > 
      <div>
    <label for="district">Insurance Name</label>
    <input type="text" id="ins" name="ins" placeholder="Enter Insurance Name" size="30" pattern="[A-Za-z ]{1,30}" required="" value="<%=ins1%>">
    <input type="hidden" name="hid" value="<%=id%>">
      </div>    
      <div>
    <label for="bank">Company</label>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp;
    <select name="cmpy" required="">
<option selected="selected" value="" >select</option>
<%
    String s ="select * from tbl_company ";
     ResultSet r = obj.select(s);
        
        while (r.next())
        {
       
%>
<option <%if(companyid.equals(r.getString("company_id"))){%>selected="" <%}%>value="<%=r.getString("company_id")%>"><%=r.getString("company_name")%></option>
<%

}
        %>
    </select>
      </div>
    <div>
    <label for="loantype">Insurance Type</label>&nbsp;
    <select name="instype" required="">
<option selected="selected" value="" >select</option>
<%
    String s1 ="select * from tbl_insurancetype ";
     ResultSet r4 = obj.select(s1);
        
        while (r4.next())
        {
       
%>
<option <%if(instypeid.equals(r4.getString("instype_id"))){%>selected="" <%}%>value="<%=r4.getString("instype_id")%>"><%=r4.getString("instype_name")%></option>
<%

}
        %>
    </select>
      </div>
    <div>
    <label for="amount">Amount</label>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp;
    <input type="number" id="amt" name="amt" placeholder="Enter amount" size="30"  required="" value="<%=amount1%>">
    </div>
    <div>
    <label for="intrest">Intrest</label>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp;
    <input type="text" id="inst" name="inst" placeholder="Enter intrest" size="30"  required="" value="<%=intrest1%>">
    </div>
     <div>
    <label for="duration">Duration</label>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp;
    <input type="number" id="duration" name="duration" placeholder="Enter duration" size="30"  required="" value="<%=duration1%>">
    </div>
    <div>
    <label for="dis">Discription</label>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp;
    <textarea id="des" name="des" placeholder="Enter insurance details" size="30" required="" ><%=des1%></textarea>
      </div>   
      <input type="submit" name="submit" value="submit">
      <input type="reset" name="cancel" value="Cancel">
        <table id="customers">
  <tr>
    <th>No</th>  
    <th>Insurance Name</th>
    <th>Company Name</th>
    <th>Insurance Type</th>
    <th>Amount</th>
    <th>Intrest</th>
    <th>Duration</th>
    <th>Discription</th>
    <th>Delete</th>
    <th>Edit</th>
    </tr>
    <%
        String s3 ="select * from tbl_insurance l inner join tbl_company b on l.company_id=b.company_id inner join tbl_insurancetype lt on l.instype_id=lt.instype_id";
        ResultSet r1 = obj.select(s3);
        int i=1;
        while (r1.next())
        {
        String n=r1.getString("insurance_amount");
        %>   
          <tr>
            <td><%=i%> </td>
            <td><%=r1.getString("insurance_name")%></td>
            <td><%=r1.getString("company_name")%></td>
            <td><%=r1.getString("instype_name")%></td>
            <td><%=n%></td>
            <td><%=r1.getString("insurance_intrest")%></td>
            <td><%=r1.getString("insurance_duration")%></td>
            <td><%=r1.getString("insurance_dis")%></td>
            <td><a href ="Insurance.jsp?delid=<%=r1.getString("insurance_id")%>"><img src="../../Design/Icon/delete1.jpg" width="35" height="35"></a></td> 
            <td><a href ="Insurance.jsp?editid=<%=r1.getString("insurance_id")%>"><img src="../../Design/Icon/edit1.jpg" width="35" height="35"></a></td>
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
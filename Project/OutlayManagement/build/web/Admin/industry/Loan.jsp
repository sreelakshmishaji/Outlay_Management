 <%-- 
    Document   : Loan
    Created on : Aug 29, 2018, 12:04:42 PM
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
        <title>Loan</title>
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
         
          String id="";
          String loan1="";
          String bankid="";
          String loantypeid="";
          String amount1="";
          String intrest1="";
          String des1="";
          String duration1="";
          
        if(request.getParameter("submit")!=null)
        {
            String loan=request.getParameter("loan");
            String bank=request.getParameter("bank");
            String loantype=request.getParameter("loantype");
            String amount=request.getParameter("amt");
            String intrest=request.getParameter("inst");
            String des=request.getParameter("des");
            String duration=request.getParameter("duration");
            String idd=request.getParameter("hid");
            if(!idd.equals(""))
            {
            String update="update tbl_loan set loan_name='"+loan+"',bank_id='"+bank+"',loantype_id='"+loantype+"',loan_amount='"+amount+"',loan_intrest='"+intrest+"',loan_dis='"+des+"',loan_duration='"+duration+"' where loan_id='"+idd+"'";
            if (obj.insert(update))
           {
               %>
            <script>
                alert("Updated Successfully!!");
                setTimeout(function(){window.location.href='Loan.jsp'},100);
                </script>
                <%
               
           }
            }
             else
            
        {
            String insert="insert into tbl_loan(loan_name,bank_id,loantype_id,loan_amount,loan_intrest,loan_duration,loan_dis) values('"+loan+"','"+bank+"','"+loantype+"','"+amount+"','"+intrest+"','"+duration+"','"+des+"')";
            boolean b=obj.insert(insert);
            if (b)
            { %>
            <script>
                alert("Successfully inserted");
                setTimeout(function(){window.location.href='Loan.jsp'},100);
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
        String del="delete  from tbl_loan where loan_id='"+a+"'";
        if (obj.insert(del))
         { %>
            <script>
                alert("Successfully deleted");
                setTimeout(function(){window.location.href='Loan.jsp'},100);
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
             String sel="select loan_name,bank_id,loantype_id,loan_amount,loan_intrest,loan_duration,loan_dis from tbl_loan where loan_id="+id;
             System.out.println(sel);
             ResultSet rs=obj.select(sel);
             if(rs.next())
             {
                 
                 loan1=rs.getString("loan_name");
                 bankid=rs.getString("bank_id");
                 loantypeid=rs.getString("loantype_id");
                 amount1=rs.getString("loan_amount");
                 intrest1=rs.getString("loan_intrest");
                 duration1=rs.getString("loan_duration");
                 des1=rs.getString("loan_dis");
                 
                 
                 
             }
         }
            
            
        
        %>
         <form> 
           
        
<div id="main">
  
      <div>
    <label for="district">Loan Name</label>
    <input type="text" id="loan" name="loan" placeholder="Enter Loan Name" size="30" pattern="[A-Za-z ]{1,30}" required="" value="<%=loan1%>">
    <input type="hidden" name="hid" value="<%=id%>">
      </div>    
      <div>
    <label for="bank">Bank</label>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp;
    <select name="bank" required="">
<option selected="selected" value="" >select</option>
<%
    String s ="select * from tbl_bank ";
     ResultSet r = obj.select(s);
        
        while (r.next())
        {
       
%>
<option <%if(bankid.equals(r.getString("bank_id"))){%>selected="" <%}%>value="<%=r.getString("bank_id")%>"><%=r.getString("bank_name")%></option>
<%

}
        %>
    </select>
      </div>
    <div>
    <label for="loantype">Loan Type</label>&nbsp;
    <select name="loantype" required="">
<option selected="selected" value="" >select</option>
<%
    String s1 ="select * from tbl_loantype ";
     ResultSet r4 = obj.select(s1);
        
        while (r4.next())
        {
       
%>
<option <%if(loantypeid.equals(r4.getString("loantype_id"))){%>selected="" <%}%>value="<%=r4.getString("loantype_id")%>"><%=r4.getString("loantype_name")%></option>
<%

}
        %>
    </select>
      </div>
    <div>
    <label for="amount">Amount</label>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp;
    <input type="number" id="amt" name="amt" placeholder="Enter amount" size="30"  required="" value="<%=amount1%>">
    </div>
    <div>
    <label for="intrest">Intrest</label>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp;
    <input type="text" id="inst" name="inst" placeholder="Enter intrest" size="30"  required="" value="<%=intrest1%>">
    </div>
     <div>
    <label for="duration">Duration</label>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp;
    <input type="number" id="duration" name="duration" placeholder="Enter duration" size="30"  required="" value="<%=duration1%>">
    </div>
    <div>
    <label for="dis">Discription</label>&nbsp&nbsp&nbsp&nbsp&nbsp;
    <textarea id="des" name="des" placeholder="Enter loan details" size="30" required="" ><%=des1%></textarea>
      </div>   
      &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="submit" name="submit" value="submit">
   <input type="reset" name="cancel" value="Cancel">
        <table id="customers">
  <tr>
    <th>No</th>  
    <th>Loan Name</th>
    <th>Bank Name</th>
    <th>Loan Type</th>
    <th>Amount</th>
    <th>Intrest</th>
    <th>Duration</th>
    <th>Discription</th>
    <th>Delete</th>
    <th>Edit</th>
    </tr>
    <%
        String s3 ="select * from tbl_loan l inner join tbl_bank b on l.bank_id=b.bank_id inner join tbl_loantype lt on l.loantype_id=lt.loantype_id";
        ResultSet r1 = obj.select(s3);
        int i=1;
        while (r1.next())
        {
        String n=r1.getString("loan_amount");
        %>   
          <tr>
            <td><%=i%> </td>
            <td><%=r1.getString("loan_name")%></td>
            <td><%=r1.getString("bank_name")%></td>
            <td><%=r1.getString("loantype_name")%></td>
            <td><%=n%></td>
            <td><%=r1.getString("loan_intrest")%></td>
            <td><%=r1.getString("loan_duration")%></td>
            <td><%=r1.getString("loan_dis")%></td>
            <td><a href ="Loan.jsp?delid=<%=r1.getString("Loan_id")%>"><img src="../../Design/Icon/delete1.jpg" width="35" height="35"></a></td> 
            <td><a href ="Loan.jsp?editid=<%=r1.getString("Loan_id")%>"><img src="../../Design/Icon/edit1.jpg" width="35" height="35"></a></td>
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
<%-- 
    Document   : ForgetPassword
    Created on : Aug 30, 2018, 11:02:34 AM
    Author     : sree
--%>

<%@page import="java.util.Random"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean class="database.ConnectionClass" id="obj"></jsp:useBean>
<jsp:useBean class="database.mailconnection" id="obj1"></jsp:useBean>
<%@page import="java.sql.ResultSet"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Forget Password</title>
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
    width: 30%;
    background-color: #4CAF50;
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
    <%
        if(request.getParameter("submit")!=null)
        {
            String mail=request.getParameter("mail");
            String insert="insert into tbl_admin(admin_email) values('"+mail+"')";
            boolean b=obj.insert(insert);
            if (b)
           { %>
            <script>
                alert("Successfully inserted");
                setTimeout(function(){window.location.href='ForgetPassword.jsp'},100);
                </script>
                <%
                
            }   
            else
            {
               System.out.println("Insertion Failed");  
            }
                    
        }
         
        %>
        
        
        <%
        if(request.getParameter("submit")!=null)
        {
            String sel="select admin_username from tbl_admin where admin_email='"+request.getParameter("mail")+"'";
            System.out.println(sel);
            ResultSet rs= obj.select(sel);
            if(rs.next())
            {
                Random r=new Random();
                int otp=r.nextInt(1111)+999;
                session.setAttribute("otp", otp);
                String to[]={request.getParameter("mail")};
                String subject="New Password";
                String newpass=rs.getString("admin_username")+"_"+otp;
                String text="Outlay Manager new password "+newpass;
                
                String update="update tbl_admin set admin_pswd='"+newpass+"' where admin_email='"+request.getParameter("mail")+"'";
                boolean b1=obj.insert(update);
                System.out.println(update);
                System.out.println("try to mail");
                boolean b = obj1.sendMail(to,subject,text);
                if(b)
                {
                    %>
                    <script>
                        
                    <%
                response.sendRedirect("LoginPage.jsp");
                
            }
                else
                        {
                            out.println("failed");
                        }
                      
                
            }
            else
            {
                %>
                <script>
                    alert("incorrect mailid");
                    </script>
                    <%
                    
                    
            }
        }
        
        %>
     <form> 
            <div id="main">
  
    <div>
    <label for="state">Enter Email Id</label>
    <input type="text" id="mail" name="mail" placeholder="Enter your mail id" size="30" required="">
    </div>
    &nbsp&nbsp&nbsp&nbsp&nbsp;<input type="submit" name="submit" value="Send OTP">
   
    </div>
            </div>
    </form> 
     
          
</body>
</html>


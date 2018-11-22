<%-- 
    Document   : AjaxPin
    Created on : Aug 28, 2018, 12:30:35 PM
    Author     : sree
--%>

<jsp:useBean class="database.ConnectionClass" id="obj"></jsp:useBean>
<%@page import="java.sql.ResultSet"%>

<%
  String id=request.getParameter("id");
  String sel="select place_pin from tbl_place where place_id="+id;
  System.out.println(sel);
  ResultSet rs=obj.select(sel);
  if(rs.next())
  {
     
      %>
       <label for="pin">Pin No</label>&nbsp;
      <input type="text" name="pinno" id="pinno" value="<%=rs.getString("place_pin")%>">
      <%
  }
    
    %>

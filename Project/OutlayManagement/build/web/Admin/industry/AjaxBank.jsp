<%-- 
    Document   : AjaxBank
    Created on : Aug 28, 2018, 11:22:05 AM
    Author     : sree
--%>

<jsp:useBean class="database.ConnectionClass" id="obj"></jsp:useBean>
<%@page import="java.sql.ResultSet"%>
<option value="">select</option>
<%
  String id=request.getParameter("id");
  String sel="select place_id,place_name from tbl_place where dist_id="+id;
  ResultSet rs=obj.select(sel);
  while(rs.next())
  {
      %>
      <option value="<%=rs.getString("place_id")%>"><%=rs.getString("place_name")%></option>
      <%
  }
    
    %>

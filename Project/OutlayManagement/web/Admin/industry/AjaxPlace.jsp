<%-- 
    Document   : AjaxPlace
    Created on : Aug 12, 2018, 11:22:32 AM
    Author     : sree
--%>

<jsp:useBean class="database.ConnectionClass" id="obj"></jsp:useBean>
<%@page import="java.sql.ResultSet"%>
<option value="">select</option>
<%
  String id=request.getParameter("id");
  String sel="select dist_id,dist_name from tbl_dist where state_id="+id;
  ResultSet rs=obj.select(sel);
  while(rs.next())
  {
      %>
      <option value="<%=rs.getString("dist_id")%>"><%=rs.getString("dist_name")%></option>
      <%
  }
    
    %>

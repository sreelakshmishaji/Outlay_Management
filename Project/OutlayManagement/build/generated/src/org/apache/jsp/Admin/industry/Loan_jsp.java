package org.apache.jsp.Admin.industry;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;

public final class Loan_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/Admin/industry/AdminHeader.jsp");
    _jspx_dependants.add("/Admin/industry/AdminFooter.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write(' ');
      out.write('\n');
      out.write("    <html lang=\"zxx\" class=\"no-js\">\n");
      out.write("\t<head>\n");
      out.write("\t\t<!-- Mobile Specific Meta -->\n");
      out.write("\t\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("\t\t<!-- Favicon-->\n");
      out.write("\t\t<link rel=\"shortcut icon\" href=\"img/fav.png\">\n");
      out.write("\t\t<!-- Author Meta -->\n");
      out.write("\t\t<meta name=\"author\" content=\"codepixer\">\n");
      out.write("\t\t<!-- Meta Description -->\n");
      out.write("\t\t<meta name=\"description\" content=\"\">\n");
      out.write("\t\t<!-- Meta Keyword -->\n");
      out.write("\t\t<meta name=\"keywords\" content=\"\">\n");
      out.write("\t\t<!-- meta character set -->\n");
      out.write("\t\t<meta charset=\"UTF-8\">\n");
      out.write("\t\t<!-- Site Title -->\n");
      out.write("\t\t<title>Industry</title>\n");
      out.write("\n");
      out.write("\t\t<link href=\"https://fonts.googleapis.com/css?family=Poppins:100,200,400,300,500,600,700\" rel=\"stylesheet\"> \n");
      out.write("\t\t\t<!--\n");
      out.write("\t\t\tCSS\n");
      out.write("\t\t\t============================================= -->\n");
      out.write("\t\t\t<link rel=\"stylesheet\" href=\"css/linearicons.css\">\n");
      out.write("\t\t\t<link rel=\"stylesheet\" href=\"css/font-awesome.min.css\">\n");
      out.write("\t\t\t<link rel=\"stylesheet\" href=\"css/bootstrap.css\">\n");
      out.write("\t\t\t<link rel=\"stylesheet\" href=\"css/magnific-popup.css\">\n");
      out.write("\t\t\t<link rel=\"stylesheet\" href=\"css/nice-select.css\">\t\n");
      out.write("\t\t\t<link rel=\"stylesheet\" href=\"css/hexagons.min.css\">\t\t\t\t\t\t\t\n");
      out.write("\t\t\t<link rel=\"stylesheet\" href=\"css/animate.min.css\">\n");
      out.write("\t\t\t<link rel=\"stylesheet\" href=\"css/owl.carousel.css\">\n");
      out.write("\t\t\t<link rel=\"stylesheet\" href=\"css/main.css\">\n");
      out.write("\t\t</head>\n");
      out.write("\t\t<body>\t\n");
      out.write("\t\t\t  <header id=\"header\" id=\"home\">\n");
      out.write("\t\t  \t\t<div class=\"header-top\">\n");
      out.write("\t\t  \t\t\t<div class=\"container\">\n");
      out.write("\t\t\t\t  \t\t<div class=\"row\">\n");
      out.write("\t\t\t\t  \t\t\t<div class=\"col-lg-6 col-sm-6 col-4 header-top-left no-padding\">\n");
      out.write("\t\t\t\t  \t\t\t\t<ul>\n");
      out.write("\t\t\t\t\t\t\t\t\t<li><a href=\"#\"><i class=\"fa fa-facebook\"></i></a></li>\n");
      out.write("\t\t\t\t\t\t\t\t\t<li><a href=\"#\"><i class=\"fa fa-twitter\"></i></a></li>\n");
      out.write("\t\t\t\t\t\t\t\t\t<li><a href=\"#\"><i class=\"fa fa-dribbble\"></i></a></li>\n");
      out.write("\t\t\t\t\t\t\t\t\t<li><a href=\"#\"><i class=\"fa fa-behance\"></i></a></li>\n");
      out.write("\t\t\t\t  \t\t\t\t</ul>\n");
      out.write("\t\t\t\t  \t\t\t</div>\n");
      out.write("\t\t\t\t  \t\t\t<div class=\"col-lg-6 col-sm-6 col-8 header-top-right no-padding\">\n");
      out.write("\t\t\t\t  \t\t\t\t<a href=\"tel:8800123654\">8800123654 </a>\n");
      out.write("\t\t\t\t  \t\t\t\t<a href=\"mailto:admin@gmail.com\">admin@gmail.com</a>\t\t\t\t\n");
      out.write("\t\t\t\t  \t\t\t</div>\n");
      out.write("\t\t\t\t  \t\t</div>\t\t\t  \t\t\t\t\t\n");
      out.write("\t\t  \t\t\t</div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t    <div class=\"container main-menu\">\n");
      out.write("\t\t\t    \t<div class=\"row align-items-center justify-content-between d-flex\">\n");
      out.write("\t\t\t\t      <div id=\"logo\">\n");
      out.write("\t\t\t\t        <a href=\"index.html\"><img src=\"img/images42.jpg\" alt=\"\" title=\"\" /></a>\n");
      out.write("\t\t\t\t      </div>\n");
      out.write("\t\t\t\t      <nav id=\"nav-menu-container\">\n");
      out.write("\t\t\t\t        <ul class=\"nav-menu\">\n");
      out.write("\t\t\t\t          <li class=\"menu-active\"><a href=\"AdminHome.jsp\">Home</a></li>\n");
      out.write("\t\t\t\t          <li class=\"menu-has-children\"><a href=\"\">Address</a>\n");
      out.write("                                          <ul>\n");
      out.write("\t\t\t\t              <li><a href=\"State.jsp\">State</a></li>\n");
      out.write("\t\t\t\t              <li><a href=\"District.jsp\">District</a></li>\n");
      out.write("                                              <li><a href=\"Place.jsp\">Place</a></li>\n");
      out.write("\t\t\t\t            </ul>\n");
      out.write("                                          </li>\n");
      out.write("                                          <li class=\"menu-has-children\"><a href=\"\">Income</a>\n");
      out.write("                                          <ul>\n");
      out.write("\t\t\t\t              <li><a href=\"IncomeType.jsp\">Income Type</a></li>\n");
      out.write("\t\t\t\t            </ul>\n");
      out.write("                                          </li>\n");
      out.write("                                          <li class=\"menu-has-children\"><a href=\"\">Expence</a>\n");
      out.write("                                          <ul>\n");
      out.write("\t\t\t\t              <li><a href=\"ExpenseType.jsp\">Expence Type</a></li>\n");
      out.write("\t\t\t\t            </ul>\n");
      out.write("                                          </li>\n");
      out.write("\t\t\t\t          <li class=\"menu-has-children\"><a href=\"\">Bank Loans</a>\n");
      out.write("\t\t\t\t            <ul>\n");
      out.write("\t\t\t\t              <li><a href=\"Loan.jsp\">Loan</a></li>\n");
      out.write("\t\t\t\t              <li><a href=\"LoanType.jsp\">Loan Type</a></li>\n");
      out.write("                                              <li><a href=\"Bank.jsp\">Bank</a></li>\n");
      out.write("\t\t\t\t            </ul>\n");
      out.write("\t\t\t\t          </li>\t\n");
      out.write("                                          <li class=\"menu-has-children\"><a href=\"\">Insurances</a>\n");
      out.write("\t\t\t\t            <ul>\n");
      out.write("\t\t\t\t              <li><a href=\"Insurance.jsp\">Insurance</a></li>\n");
      out.write("\t\t\t\t              <li><a href=\"InsuranceType.jsp\">Insurance Type</a></li>\n");
      out.write("                                              <li><a href=\"InsuranceCompany.jsp\">Insurance Company</a></li>\n");
      out.write("\t\t\t\t            </ul>\n");
      out.write("\t\t\t\t          </li>\t\n");
      out.write("                                           <li class=\"menu-has-children\"><a href=\"\">Settings</a>\n");
      out.write("                                               <ul>\n");
      out.write("\t\t\t\t          <li><a href=\"ChangePassword.jsp\">Change Password</a></li>\n");
      out.write("                                          <li><a href=\"../../Guest/Login_v9/LoginPage.jsp\">Logout</a></li>\n");
      out.write("                                               </ul>\n");
      out.write("\t\t\t\t        </ul>\n");
      out.write("\t\t\t\t      </nav><!-- #nav-menu-container -->\t\t    \t\t\n");
      out.write("\t\t\t    \t</div>\n");
      out.write("\t\t\t    </div>\n");
      out.write("\t\t\t  </header><!-- #header -->\n");
      out.write("    </html>\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      database.ConnectionClass obj = null;
      synchronized (_jspx_page_context) {
        obj = (database.ConnectionClass) _jspx_page_context.getAttribute("obj", PageContext.PAGE_SCOPE);
        if (obj == null){
          obj = new database.ConnectionClass();
          _jspx_page_context.setAttribute("obj", obj, PageContext.PAGE_SCOPE);
        }
      }
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("   \n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Loan</title>\n");
      out.write("    <style>\n");
      out.write("#customers {\n");
      out.write("    font-family: \"Trebuchet MS\", Arial, Helvetica, sans-serif;\n");
      out.write("    border-collapse: collapse;\n");
      out.write("    width: 100%;\n");
      out.write("}\n");
      out.write("\n");
      out.write("#customers td, #customers th {\n");
      out.write("    border: 1px solid #ddd;\n");
      out.write("    padding: 8px;\n");
      out.write("}\n");
      out.write("\n");
      out.write("#customers tr:nth-child(even){background-color: #f2f2f2;}\n");
      out.write("\n");
      out.write("#customers tr:hover {background-color: #ddd;}\n");
      out.write("\n");
      out.write("#customers th {\n");
      out.write("    padding-top: 12px;\n");
      out.write("    padding-bottom: 12px;\n");
      out.write("    text-align: left;\n");
      out.write("    background-color: grey;\n");
      out.write("    color: white;\n");
      out.write("}\n");
      out.write("</style>\n");
      out.write("    </head>\n");
      out.write("   <style>\n");
      out.write("input[type=text], select {\n");
      out.write("    width: 50%;\n");
      out.write("    padding: 12px 25px;\n");
      out.write("    margin: 10px 20px;\n");
      out.write("    display: inline-block;\n");
      out.write("    border: 1px solid #ccc;\n");
      out.write("    border-radius: 4px;\n");
      out.write("    box-sizing: border-box;\n");
      out.write("}\n");
      out.write("\n");
      out.write("input[type=submit] {\n");
      out.write("    width: 20%;\n");
      out.write("    background-color: grey;\n");
      out.write("    color: white;\n");
      out.write("    padding: 10px 8px;\n");
      out.write("    margin: 10px 30px;\n");
      out.write("    border: none;\n");
      out.write("    border-radius: 4px;\n");
      out.write("    cursor: pointer;\n");
      out.write("}\n");
      out.write("\n");
      out.write("input[type=submit]:hover {\n");
      out.write("    background-color: #45a049;\n");
      out.write("}\n");
      out.write("input[type=reset] {\n");
      out.write("    width: 20%;\n");
      out.write("    background-color: grey;\n");
      out.write("    color: white;\n");
      out.write("    padding: 10px 8px;\n");
      out.write("    margin: 10px 30px;\n");
      out.write("    border: none;\n");
      out.write("    border-radius: 4px;\n");
      out.write("    cursor: pointer;\n");
      out.write("}\n");
      out.write("input[type=reset]:hover {\n");
      out.write("    background-color: #45a049;\n");
      out.write("}\n");
      out.write("\n");
      out.write("#main {\n");
      out.write("    border-radius: 5px;\n");
      out.write("    background-color: #f2f2f2;\n");
      out.write("    padding: 20px;\n");
      out.write("    margin-left: 350px;\n");
      out.write("    margin-top: 100px;\n");
      out.write("    width: 60%;\n");
      out.write("}\n");
      out.write("</style>\n");
      out.write("<body>\n");
      out.write("      ");

         
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
               
      out.write("\n");
      out.write("            <script>\n");
      out.write("                alert(\"Updated Successfully!!\");\n");
      out.write("                setTimeout(function(){window.location.href='Loan.jsp'},100);\n");
      out.write("                </script>\n");
      out.write("                ");

               
           }
            }
             else
            
        {
            String insert="insert into tbl_loan(loan_name,bank_id,loantype_id,loan_amount,loan_intrest,loan_duration,loan_dis) values('"+loan+"','"+bank+"','"+loantype+"','"+amount+"','"+intrest+"','"+duration+"','"+des+"')";
            boolean b=obj.insert(insert);
            if (b)
            { 
      out.write("\n");
      out.write("            <script>\n");
      out.write("                alert(\"Successfully inserted\");\n");
      out.write("                setTimeout(function(){window.location.href='Loan.jsp'},100);\n");
      out.write("                </script>\n");
      out.write("                ");

                
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
         { 
      out.write("\n");
      out.write("            <script>\n");
      out.write("                alert(\"Successfully deleted\");\n");
      out.write("                setTimeout(function(){window.location.href='Loan.jsp'},100);\n");
      out.write("                </script>\n");
      out.write("                ");

                
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
            
            
        
        
      out.write("\n");
      out.write("         <form> \n");
      out.write("           \n");
      out.write("        \n");
      out.write("<div id=\"main\">\n");
      out.write("  \n");
      out.write("      <div>\n");
      out.write("    <label for=\"district\">Loan Name</label>\n");
      out.write("    <input type=\"text\" id=\"loan\" name=\"loan\" placeholder=\"Enter Loan Name\" size=\"30\" pattern=\"[A-Za-z ]{1,30}\" required=\"\" value=\"");
      out.print(loan1);
      out.write("\">\n");
      out.write("    <input type=\"hidden\" name=\"hid\" value=\"");
      out.print(id);
      out.write("\">\n");
      out.write("      </div>    \n");
      out.write("      <div>\n");
      out.write("    <label for=\"bank\">Bank</label>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp;\n");
      out.write("    <select name=\"bank\" required=\"\">\n");
      out.write("<option selected=\"selected\" value=\"\" >select</option>\n");

    String s ="select * from tbl_bank ";
     ResultSet r = obj.select(s);
        
        while (r.next())
        {
       

      out.write("\n");
      out.write("<option ");
if(bankid.equals(r.getString("bank_id"))){
      out.write("selected=\"\" ");
}
      out.write("value=\"");
      out.print(r.getString("bank_id"));
      out.write('"');
      out.write('>');
      out.print(r.getString("bank_name"));
      out.write("</option>\n");


}
        
      out.write("\n");
      out.write("    </select>\n");
      out.write("      </div>\n");
      out.write("    <div>\n");
      out.write("    <label for=\"loantype\">Loan Type</label>&nbsp;\n");
      out.write("    <select name=\"loantype\" required=\"\">\n");
      out.write("<option selected=\"selected\" value=\"\" >select</option>\n");

    String s1 ="select * from tbl_loantype ";
     ResultSet r4 = obj.select(s1);
        
        while (r4.next())
        {
       

      out.write("\n");
      out.write("<option ");
if(loantypeid.equals(r4.getString("loantype_id"))){
      out.write("selected=\"\" ");
}
      out.write("value=\"");
      out.print(r4.getString("loantype_id"));
      out.write('"');
      out.write('>');
      out.print(r4.getString("loantype_name"));
      out.write("</option>\n");


}
        
      out.write("\n");
      out.write("    </select>\n");
      out.write("      </div>\n");
      out.write("    <div>\n");
      out.write("    <label for=\"amount\">Amount</label>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp;\n");
      out.write("    <input type=\"number\" id=\"amt\" name=\"amt\" placeholder=\"Enter amount\" size=\"30\"  required=\"\" value=\"");
      out.print(amount1);
      out.write("\">\n");
      out.write("    </div>\n");
      out.write("    <div>\n");
      out.write("    <label for=\"intrest\">Intrest</label>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp;\n");
      out.write("    <input type=\"text\" id=\"inst\" name=\"inst\" placeholder=\"Enter intrest\" size=\"30\"  required=\"\" value=\"");
      out.print(intrest1);
      out.write("\">\n");
      out.write("    </div>\n");
      out.write("     <div>\n");
      out.write("    <label for=\"duration\">Duration</label>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp;\n");
      out.write("    <input type=\"number\" id=\"duration\" name=\"duration\" placeholder=\"Enter duration\" size=\"30\"  required=\"\" value=\"");
      out.print(duration1);
      out.write("\">\n");
      out.write("    </div>\n");
      out.write("    <div>\n");
      out.write("    <label for=\"dis\">Discription</label>&nbsp&nbsp&nbsp&nbsp&nbsp;\n");
      out.write("    <textarea id=\"des\" name=\"des\" placeholder=\"Enter loan details\" size=\"30\" required=\"\" >");
      out.print(des1);
      out.write("</textarea>\n");
      out.write("      </div>   \n");
      out.write("      &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type=\"submit\" name=\"submit\" value=\"submit\">\n");
      out.write("   <input type=\"reset\" name=\"cancel\" value=\"Cancel\">\n");
      out.write("        <table id=\"customers\">\n");
      out.write("  <tr>\n");
      out.write("    <th>No</th>  \n");
      out.write("    <th>Loan Name</th>\n");
      out.write("    <th>Bank Name</th>\n");
      out.write("    <th>Loan Type</th>\n");
      out.write("    <th>Amount</th>\n");
      out.write("    <th>Intrest</th>\n");
      out.write("    <th>Duration</th>\n");
      out.write("    <th>Discription</th>\n");
      out.write("    <th>Delete</th>\n");
      out.write("    <th>Edit</th>\n");
      out.write("    </tr>\n");
      out.write("    ");

        String s3 ="select * from tbl_loan l inner join tbl_bank b on l.bank_id=b.bank_id inner join tbl_loantype lt on l.loantype_id=lt.loantype_id";
        ResultSet r1 = obj.select(s3);
        int i=1;
        while (r1.next())
        {
        String n=r1.getString("loan_amount");
        
      out.write("   \n");
      out.write("          <tr>\n");
      out.write("            <td>");
      out.print(i);
      out.write(" </td>\n");
      out.write("            <td>");
      out.print(r1.getString("loan_name"));
      out.write("</td>\n");
      out.write("            <td>");
      out.print(r1.getString("bank_name"));
      out.write("</td>\n");
      out.write("            <td>");
      out.print(r1.getString("loantype_name"));
      out.write("</td>\n");
      out.write("            <td>");
      out.print(n);
      out.write("</td>\n");
      out.write("            <td>");
      out.print(r1.getString("loan_intrest"));
      out.write("</td>\n");
      out.write("            <td>");
      out.print(r1.getString("loan_duration"));
      out.write("</td>\n");
      out.write("            <td>");
      out.print(r1.getString("loan_dis"));
      out.write("</td>\n");
      out.write("            <td><a href =\"Loan.jsp?delid=");
      out.print(r1.getString("Loan_id"));
      out.write("\"><img src=\"../../Design/Icon/delete1.jpg\" width=\"35\" height=\"35\"></a></td> \n");
      out.write("            <td><a href =\"Loan.jsp?editid=");
      out.print(r1.getString("Loan_id"));
      out.write("\"><img src=\"../../Design/Icon/edit1.jpg\" width=\"35\" height=\"35\"></a></td>\n");
      out.write("        </tr>\n");
      out.write("        ");
 i++;
        
        }
        
        
      out.write("\n");
      out.write("    \n");
      out.write("    \n");
      out.write("    \n");
      out.write("      </table>\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("  </form>\n");
      out.write("\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("\t<!DOCTYPE html>\n");
      out.write("\t<html lang=\"zxx\" class=\"no-js\">\n");
      out.write("\t<head>\n");
      out.write("\t\t<!-- Mobile Specific Meta -->\n");
      out.write("\t\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("\t\t<!-- Favicon-->\n");
      out.write("\t\t<link rel=\"shortcut icon\" href=\"img/fav.png\">\n");
      out.write("\t\t<!-- Author Meta -->\n");
      out.write("\t\t<meta name=\"author\" content=\"codepixer\">\n");
      out.write("\t\t<!-- Meta Description -->\n");
      out.write("\t\t<meta name=\"description\" content=\"\">\n");
      out.write("\t\t<!-- Meta Keyword -->\n");
      out.write("\t\t<meta name=\"keywords\" content=\"\">\n");
      out.write("\t\t<!-- meta character set -->\n");
      out.write("\t\t<meta charset=\"UTF-8\">\n");
      out.write("\t\t<!-- Site Title -->\n");
      out.write("\t\t<title>Industry</title>\n");
      out.write("\n");
      out.write("\t\t<link href=\"https://fonts.googleapis.com/css?family=Poppins:100,200,400,300,500,600,700\" rel=\"stylesheet\"> \n");
      out.write("\t\t\t<!--\n");
      out.write("\t\t\tCSS\n");
      out.write("\t\t\t============================================= -->\n");
      out.write("\t\t\t<link rel=\"stylesheet\" href=\"css/linearicons.css\">\n");
      out.write("\t\t\t<link rel=\"stylesheet\" href=\"css/font-awesome.min.css\">\n");
      out.write("\t\t\t<link rel=\"stylesheet\" href=\"css/bootstrap.css\">\n");
      out.write("\t\t\t<link rel=\"stylesheet\" href=\"css/magnific-popup.css\">\n");
      out.write("\t\t\t<link rel=\"stylesheet\" href=\"css/nice-select.css\">\t\n");
      out.write("\t\t\t<link rel=\"stylesheet\" href=\"css/hexagons.min.css\">\t\t\t\t\t\t\t\n");
      out.write("\t\t\t<link rel=\"stylesheet\" href=\"css/animate.min.css\">\n");
      out.write("\t\t\t<link rel=\"stylesheet\" href=\"css/owl.carousel.css\">\n");
      out.write("\t\t\t<link rel=\"stylesheet\" href=\"css/main.css\">\n");
      out.write("\t\t</head>\n");
      out.write("                <footer class=\"footer-area section-gap\">\n");
      out.write("\t\t\t\t<div class=\"container\">\n");
      out.write("\t\t\t\t\t<div class=\"row\">\n");
      out.write("\t\t\t\t\t\t<div class=\"col-lg-5 col-md-6 col-sm-6\">\n");
      out.write("\t\t\t\t\t\t\t<div class=\"single-footer-widget\">\n");
      out.write("\t\t\t\t\t\t\t\t<h6></h6>\n");
      out.write("\t\t\t\t\t\t\t\t<p>\n");
      out.write("\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t</p>\n");
      out.write("\t\t\t\t\t\t\t\t<p class=\"footer-text\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->\n");
      out.write("Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class=\"fa fa-heart-o\" aria-hidden=\"true\"></i> by <a href=\"https://colorlib.com\" target=\"_blank\">Colorlib</a>\n");
      out.write("<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->\n");
      out.write("\t\t\t\t\t\t\t\t</p>\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t<div class=\"col-lg-5  col-md-6 col-sm-6\">\n");
      out.write("\t\t\t\t\t\t\t<div class=\"single-footer-widget\">\n");
      out.write("\t\t\t\t\t\t\t\t<h6></h6>\n");
      out.write("\t\t\t\t\t\t\t\t<p></p>\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"\" id=\"mc_embed_signup\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<form target=\"_blank\" novalidate=\"true\" action=\"https://spondonit.us12.list-manage.com/subscribe/post?u=1462626880ade1ac87bd9c93a&amp;id=92a4423d01\" method=\"get\" class=\"form-inline\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<!--<input class=\"form-control\" name=\"EMAIL\" placeholder=\"Enter Email\" onfocus=\"this.placeholder = ''\" onblur=\"this.placeholder = 'Enter Email '\" required=\"\" type=\"email\">-->\n");
      out.write("\t\t\t                            <!--\t<button class=\"click-btn btn btn-default\"><i class=\"fa fa-long-arrow-right\" aria-hidden=\"true\"></i></button>-->\n");
      out.write("\t\t\t                            \t<div style=\"position: absolute; left: -5000px;\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<input name=\"b_36c4fd991d266f23781ded980_aefe40901a\" tabindex=\"-1\" value=\"\" type=\"text\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"info\"></div>\n");
      out.write("\t\t\t\t\t\t\t\t\t</form>\n");
      out.write("\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t</div>\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t<div class=\"col-lg-2 col-md-6 col-sm-6 social-widget\">\n");
      out.write("\t\t\t\t\t\t\t<div class=\"single-footer-widget\">\n");
      out.write("\t\t\t\t\t\t\t\t<h6></h6>\n");
      out.write("\t\t\t\t\t\t\t\t<p></p>\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"footer-social d-flex align-items-center\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<a href=\"#\"><i class=\"fa fa-facebook\"></i></a>\n");
      out.write("\t\t\t\t\t\t\t\t\t<a href=\"#\"><i class=\"fa fa-twitter\"></i></a>\n");
      out.write("\t\t\t\t\t\t\t\t\t<a href=\"#\"><i class=\"fa fa-dribbble\"></i></a>\n");
      out.write("\t\t\t\t\t\t\t\t\t<a href=\"#\"><i class=\"fa fa-behance\"></i></a>\n");
      out.write("\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t</div>\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</footer>\t\n");
      out.write("\t");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

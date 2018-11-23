/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author sree
 */
@WebService(serviceName = "WebServiceOutlay")
public class WebServiceOutlay {

    ConnectionClass con = new ConnectionClass();

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "registration")
    public String insertcustomer(@WebParam(name = "Name") String Name, @WebParam(name = "Gender") String Gender, @WebParam(name = "Email") String Email, @WebParam(name = "Phone") String Phone, @WebParam(name = "House") String House, @WebParam(name = "Userid") String Userid, @WebParam(name = "Password") String Password) {
        //TODO write your implementation code here:
        String insert = "insert into tbl_person(person_name,person_gender,person_email,person_phn,person_hname,person_username,person_pswd)values('" + Name + "','" + Gender + "','" + Email + "','" + Phone + "','" + House + "','" + Userid + "','" + Password + "')";
        System.out.println("ins:\t" + insert);
        boolean b = con.insert(insert);
        String a = "false";
        if (b) {
            a = "true";
        }
        return a;

    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "select")
    public String select(@WebParam(name = "Userid") String Userid, @WebParam(name = "Password") String Password) {
        //TODO write your implementation code here:
        String sel = "select * from tbl_person where person_username='" + Userid + "' and person_pswd='" + Password + "'";
        System.out.println(sel);
        ResultSet rs = con.select(sel);
        String s = "false";
        try {
            if (rs.next()) {
                s = rs.getString("person_id");
                s = s + ",true";
            }

        } catch (SQLException ex) {
        }
        return s;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "fetch")
    public String fetch(@WebParam(name = "Id") String Id) {
        JSONArray ja = new JSONArray();
        try {
            //TODO write your implementation code here:
            String fth = "select person_name,person_gender,person_email,person_phn,person_hname from tbl_person where person_id='" + Id + "'";
            ResultSet r = con.select(fth);
            System.out.println(fth);
            if (r.next()) {

                JSONObject jo = new JSONObject();

                String n1 = r.getString("person_name");
                String n2 = r.getString("person_gender");
                String n3 = r.getString("person_email");
                String n4 = r.getString("person_phn");
                String n5 = r.getString("person_hname");

                jo.put("Name", n1);
                jo.put("Gender", n2);
                jo.put("Email", n3);
                jo.put("Phone", n4);
                jo.put("Housename", n5);
                ja.put(jo);

            }
        } catch (Exception ex) {
            Logger.getLogger(WebServiceOutlay.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ja.toString();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "update")
    public String update(@WebParam(name = "Id") String Id, @WebParam(name = "Name") String Name, @WebParam(name = "Gender") String Gender, @WebParam(name = "Email") String Email, @WebParam(name = "Phone") String Phone, @WebParam(name = "House") String House) {
        //TODO write your implementation code here:
        String upd = "update tbl_person set person_name='" + Name + "',person_gender='" + Gender + "',person_email='" + Email + "',person_phn='" + Phone + "',person_hname='" + House + "' where person_id='" + Id + "'";
        System.out.println(upd);
        boolean b1 = con.insert(upd);
        String ab = "false";
        if (b1) {
            ab = "true";
        }
        return ab;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "incomeadd")
    public String incomeadd(@WebParam(name = "Income") String Income, @WebParam(name = "Amount") String Amount, @WebParam(name = "Date") String Date, @WebParam(name = "id") String id) {
        //TODO write your implementation code here:
        String add = "insert into tbl_income(intype_id,income_amt,income_date,person_id)values('" + Income + "','" + Amount + "','" + Date + "','" + id + "')";
        System.out.println("ins:\t" + add);
        boolean b1 = con.insert(add);
        String ab = "false";
        if (b1) {
            ab = "true";
        }
        return ab;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "selectIncome")
    public String selectIncome() {
        JSONArray ji = new JSONArray();
        JSONObject jos = null;
        try {
            //  select * from tbl_intype  intype_id intype_name
            String sel = "select * from tbl_intype";
            ResultSet r1 = con.select(sel);
            System.out.println(sel);

            while (r1.next()) {

                jos = new JSONObject();

                String n1 = r1.getString("intype_id");
                String n2 = r1.getString("intype_name");

                System.out.println(n1 + "," + n2);
                jos.put("Id", n1);
                jos.put("Name", n2);
                ji.put(jos);
            }
        } catch (Exception e) {

        }
        System.out.println("JSON:\t" + ji.toString());
        return ji.toString();
    }

    /**
     * Web service operation
     */
    /**
     * Web service operation
     */
    @WebMethod(operationName = "ebillservice")
    public String ebill(@WebParam(name = "Personid") String Personid, @WebParam(name = "Serviceno") String Serviceno) {
        //TODO write your implementation code here:
//        String sel="select ebill_id  from tbl_electricitybill where person_id='"+Personid +"'and ebill_serviceno='"+Serviceno+"'";
//        System.out.println(sel);
//        ResultSet rs=con.select(sel);
//        String s="false";
//        try{
//            if (rs.next())
//            {
//              s=rs.getString("ebill_id") ;
//              
//           }
//            
//        }catch (SQLException ex){
//    }
//        return s;
        JSONArray ji = new JSONArray();
        try {
            //select ebill_amount,ebill_duedate,ebill_no from tbl_electricitybill where ebill_serviceno=

//select person_name,place_name from tbl_person p inner join tbl_place pl on p.place_id=pl.place_id where person_id
            JSONObject jos = null;
            String sel = "select ebill_status,ebill_amount,ebill_duedate,ebill_no,person_name from tbl_person p inner join tbl_electricitybill eb on p.person_id=eb.person_id where ebill_serviceno='" + Serviceno + "' and eb.person_id=" + Personid;
            System.out.println(sel);
            ResultSet rs = con.select(sel);

            if (rs.next()) {

                jos = new JSONObject();
                String billno = rs.getString("ebill_no");
                String amt = rs.getString("ebill_amount");
                String duedate = rs.getString("ebill_duedate");
                String status = rs.getString("ebill_status");
                String person = "";

                person = rs.getString("person_name");

                jos.put("BillNo", billno);
                jos.put("Amount", amt);
                jos.put("Due", duedate);
                jos.put("Person", person);
                jos.put("Status", status);

                ji.put(jos);
            } else {
                jos = new JSONObject();
                jos.put("BillNo", "0");
                ji.put(jos);
            }

        } catch (Exception ex) {
            Logger.getLogger(WebServiceOutlay.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ji.toString();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "save")
    public String save(@WebParam(name = "CardNo") String CardNo, @WebParam(name = "Month") String Month, @WebParam(name = "Year") String Year, @WebParam(name = "Personid") String Personid) {
        //TODO write your implementation code here:
        String insert = "insert into tbl_debitcard(card_no,card_month,card_year,person_id)values('" + CardNo + "','" + Month + "','" + Year + "','" + Personid + "')";
        System.out.println("ins:\t" + insert);
        boolean b = con.insert(insert);
        String a = "false";
        if (b) {
            a = "true";
        }
        return a;

    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addexpense")
    public String addexpense(@WebParam(name = "Amount") String Amount, @WebParam(name = "Personid") String Personid, @WebParam(name = "Billno") String Billno) {
        //TODO write your implementation code here:

        String update = "update tbl_electricitybill set ebill_status=1 where ebill_no='" + Billno + "'";
        System.out.println(update);

        con.insert(update);
        String insert = "insert into tbl_expenses(expense_amt,person_id,expense_date,extype_id)values('" + Amount + "','" + Personid + "',curdate(),5)";

        System.out.println("ins:\t" + insert);
        boolean b = con.insert(insert);
        String a = "false";
        if (b) {
            a = "true";
        }
        return a;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "carddetails")
    public String carddetails(@WebParam(name = "Personid") String Personid) {
        JSONArray ja = new JSONArray();
        try {
            //TODO write your implementation code here:
            String selt = "select card_no,card_month,card_year from tbl_debitcard where person_id='" + Personid + "'";
            ResultSet r = con.select(selt);
            System.out.println(selt);
            if (r.next()) {

                JSONObject jo = new JSONObject();

                String n1 = r.getString("card_no");
                String n2 = r.getString("card_month");
                String n3 = r.getString("card_year");

                jo.put("CardNo", n1);
                jo.put("Month", n2);
                jo.put("Year", n3);
                ja.put(jo);

            }
        } catch (Exception ex) {
            Logger.getLogger(WebServiceOutlay.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ja.toString();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "budgetline")
    public String budgetline(@WebParam(name = "income") String income, @WebParam(name = "personid") String personid) {
        JSONArray ja = new JSONArray();
        int tot = 0;
        String budject = "";
        try {
            //TODO write your implementation code here
            String slt = "select income_amt from tbl_income where person_id='" + personid + "'";
            ResultSet r = con.select(slt);
            System.out.println(slt);
            while (r.next()) {
                tot = tot + Integer.parseInt(r.getString("income_amt"));
            }
            //SELECT * FROM your_table ORDER BY your_auto_increment_field DESC LIMIT 1
            String sel = "select budget_amt from tbl_budget  where person_id='" + personid + "' ORDER BY budget_id DESC LIMIT 1";
            System.out.println(sel);
            ResultSet rs = con.select(sel);
            if (rs.next()) {
                budject = rs.getString("budget_amt");
            } else {
                budject = "0";

            }

            JSONObject jo = new JSONObject();
            jo.put("income", tot);

            jo.put("budget", budject);
            ja.put(jo);

            System.out.println("income" + ja);
        } catch (Exception ex) {
            Logger.getLogger(WebServiceOutlay.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ja.toString();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getbudget")
    public String getbudget(@WebParam(name = "Amount") String Amount, @WebParam(name = "Personid") String Personid) {
        //TODO write your implementation code here:
        String insert = "insert into tbl_budget(budget_amt,person_id)values('" + Amount + "','" + Personid + "')";
        System.out.println("ins:\t" + insert);
        boolean b = con.insert(insert);
        String a = "false";
        if (b) {
            a = Amount;
        }
        return a;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "expenseadd")
    public String expenseadd(@WebParam(name = "Expense") String Expense, @WebParam(name = "Amount") String Amount, @WebParam(name = "Date") String Date, @WebParam(name = "id") String id) {
        //TODO write your implementation code here:
        String add = "insert into tbl_expenses(extype_id,expense_amt,expense_date,person_id)values('" + Expense + "','" + Amount + "','" + Date + "','" + id + "')";
        System.out.println("ins:\t" + add);
        boolean b1 = con.insert(add);
        String ab = "false";
        if (b1) {
            ab = "true";
        }
        return ab;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "selectexpense")
    public String selectexpense() {
        JSONArray ji = new JSONArray();
        JSONObject jos = null;
        try {
            //TODO write your implementation code here:
            String sel = "select * from tbl_extype";
            ResultSet r1 = con.select(sel);
            System.out.println(sel);

            while (r1.next()) {

                jos = new JSONObject();

                String n1 = r1.getString("extype_id");
                String n2 = r1.getString("extype_name");

                System.out.println(n1 + "," + n2);
                jos.put("Id", n1);
                jos.put("Name", n2);
                ji.put(jos);
            }
        } catch (Exception e) {

        }
        System.out.println("JSON:\t" + ji.toString());
        return ji.toString();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "monthlyreview")
    public String monthlyreview(@WebParam(name = "personid") String personid) {

        JSONArray ji = new JSONArray();
        JSONObject jos = null;

        try {
            //TODO write your implementation code here:

            String expense = "";
            String income = "";
            int bal = 0;

            Date date = new Date();
            LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            int month = localDate.getMonthValue();
            System.out.println(month);

            String sel = "select sum(expense_amt) as sum from tbl_expenses where person_id='" + personid + "' and MONTH(expense_date)=" + month;
            ResultSet rs = con.select(sel);
            System.out.println(sel);
            if (rs.next()) {
                expense = rs.getString("sum");
                if (expense == null) {
                    expense = "0";
                }
            }
            String sel2 = "select sum(income_amt) as sum from tbl_income where person_id='" + personid + "' and MONTH(income_date)=" + month;
            ResultSet rss = con.select(sel2);
            System.out.println(sel2);
            if (rss.next()) {
                income = rss.getString("sum");
                if (income == null) {
                    income = "0";
                }
            }
            bal = Integer.parseInt(income) - Integer.parseInt(expense);
            System.out.println(bal + "balance");
            jos = new JSONObject();
            jos.put("income", income);
            jos.put("expense", expense);
            jos.put("savings", bal);
            ji.put(jos);

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return ji.toString();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "notification")
    public String notification(@WebParam(name = "Personid") String Personid) {
        String budject = "";
        String notification = "";
         JSONArray ji = new JSONArray();
        JSONObject jn = null;
        try {
            //TODO write your implementation code here:
            String expense = "";
            int ex = 0;
            int bd = 0;

            Date date = new Date();
            LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            int month = localDate.getMonthValue();
            System.out.println(month);

            String sel = "select sum(expense_amt) as sum from tbl_expenses where MONTH(expense_date)=" + month;
            ResultSet rs = con.select(sel);
            if (rs.next()) {
                expense = rs.getString("sum");
            }
            String slt = "select budget_amt from tbl_budget  where person_id='" + Personid + "' ORDER BY budget_id DESC LIMIT 1";
            System.out.println(slt);
            ResultSet rs1 = con.select(slt);
            if (rs.next()) {
                budject = rs1.getString("budget_amt");
            } else {
                budject = "0";

            }
            ex = Integer.parseInt(expense);
            bd = Integer.parseInt(budject);
            if (ex > bd) {
                notification = "You have crossed your budject line.Be carefull.For more details check review.";
                String ins = "insert into tbl_notify(notify_name,notify_date,person_id)values('" + notification + "',curdate(),'" + Personid + "')";
                System.out.println("ins:\t" + ins);
                boolean b1 = con.insert(ins);
            } else if (ex <= bd - 1000) {
                notification = "You are near to the budget line.Make limit on your spending.For more details check review.";
                String ins = "insert into tbl_notify(notify_name,notify_date,person_id)values('" + notification + "',curdate(),'" + Personid + "')";
                System.out.println("ins:\t" + ins);
                boolean b1 = con.insert(ins);
            }
       
         
        } catch (Exception e) {
            System.out.println(e);
        }
         String nty = "select * from tbl_notify where person_id='" + Personid + "'";
        ResultSet rss = con.select(nty);
        
            System.out.println(nty);
        try {
            if (rss.last()) {
                
                jn = new JSONObject();
                
                String n1 = rss.getString("notify_name");
                String n2 = rss.getString("notify_date");

                System.out.println(n1 + "," + n2);
                jn.put("Name", n1);
                jn.put("Date", n2);
                ji.put(jn);
            }    
                return ji.toString();
                
               } catch (SQLException ex) {
            Logger.getLogger(WebServiceOutlay.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(WebServiceOutlay.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return ji.toString();
            
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "messagetracking")
    public String messagetracking(@WebParam(name = "Personid") String Personid, @WebParam(name = "Extype") String Extype, @WebParam(name = "Amount") String Amount, @WebParam(name = "Date") String Date) {
         String ab = "false";
         String expense_type_id="";
        try {
           
            //TODO write your implementation code here:
            String fth = "select * from tbl_extype where extype_name='" + Extype + "'";
            ResultSet r = con.select(fth);
            System.out.println(fth);
            if (r.next()) {
                expense_type_id = r.getString("extype_id");
            }
            else{
               String ins="insert into tbl_extype(extype_name)values('"+Extype+"')";
                System.out.println("ins:\t" + ins);
                boolean b2 = con.insert(ins);
                String bb = "false";
                if (b2) {
                        String fth1 = "select * from tbl_extype where extype_name='" + Extype + "'";
                        ResultSet r1 = con.select(fth1);
                        System.out.println(fth1);
                        if (r1.next()) {
                            expense_type_id = r1.getString("extype_id");
                        }
                }
       
            }
         String add = "insert into tbl_expenses(extype_id,expense_amt,expense_date,person_id)values('" + expense_type_id + "','" + Amount + "','" + Date + "','" + Personid + "')";
                System.out.println("ins:\t" + add);
                boolean b1 = con.insert(add);
               
                if (b1) {
                    ab = "true";
                }
        
        
        } catch (SQLException ex) {
            Logger.getLogger(WebServiceOutlay.class.getName()).log(Level.SEVERE, null, ex);
        }
    return ab;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "notifyexpense")
    public String notifyexpense(@WebParam(name = "personid") String personid) {
        //TODO write your implementation code here:
         JSONArray jii = new JSONArray();
        try {
           
         JSONObject joss = null;
        String selct = "select * from tbl_expenses e inner join tbl_extype et on e.extype_id=et.extype_id where e.person_id='" + personid+"'";
        System.out.println(selct);
            ResultSet rs = con.select(selct);
              while (rs.next()) {

                joss = new JSONObject();
                String date = rs.getString("expense_date");
                String amt = rs.getString("expense_amt");
                String id = rs.getString("extype_id");
                String name = rs.getString("extype_name");
                String person = "";
               

                joss.put("Date", date);
                joss.put("Amount", amt);
                joss.put("Id", id);
                joss.put("Name",name);
                joss.put("Person",person);
               

                jii.put(joss);
            } 
        } catch (Exception ex) {
            Logger.getLogger(WebServiceOutlay.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(jii.toString());
        
        return jii.toString();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "updatenotify")
    public String updatenotify(@WebParam(name = "expensetypeid") String expensetypeid, @WebParam(name = "name") String name) {
        //TODO write your implementation code here:
         String update = "update tbl_extype set extype_name='"+name+"' where extype_id='" + expensetypeid + "'";
        System.out.println(update);
        boolean b1 = con.insert(update);
               
                if (b1) {
                     return "true";
                }
        return "false";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "updatenameexp")
    public String updatenameexp(@WebParam(name = "id") String id, @WebParam(name = "text") String text) {
        //TODO write your implementation code here:
        String update="update tbl_extype set extype_name='"+text+"' where extype_id='"+id+"'";
        System.out.println(update);
        boolean b1 = con.insert(update);
               
                if (b1) {
                     return "true";
                }
        return "false";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "graph")
    public String graph(@WebParam(name = "Personid") String Personid, @WebParam(name = "Fromdate") String Fromdate, @WebParam(name = "Todate") String Todate) {
        JSONArray ji = new JSONArray();
        JSONObject jos = null;
        //TODO write your implementation code here:
       try {
         String expense = "";
         String income = "";
        int bal = 0;
        
         String sel = "select sum(expense_amt) as sum from tbl_expenses where person_id='" + Personid + "' and  expense_date between '"+Fromdate+"' and '"+Todate+"' ";
            ResultSet rs = con.select(sel);
            System.out.println("Graph:\t"+sel);
            if (rs.next()) {
                expense = rs.getString("sum");
                if (expense == null) {
                    expense = "0";
                }
            }
        
            String sel2 = "select sum(income_amt) as sum from tbl_income where person_id='" + Personid + "' and  income_date between '"+Fromdate+"' and '"+Todate+"' ";
            ResultSet rss = con.select(sel2);
            System.out.println("Graph:\t"+sel2);
            if (rss.next()) {
                income = rss.getString("sum");
                if (income == null) {
                    income = "0";
                }
            }
        bal = Integer.parseInt(income) - Integer.parseInt(expense);
            System.out.println(bal + ":balance");
            jos = new JSONObject();
            jos.put("income", income);
            jos.put("expense", expense);
            jos.put("savings", bal);
            ji.put(jos);

        } catch (Exception ex) {
            System.out.println(ex);
        }
       System.out.println(ji);
        return ji.toString();
            
            
            
            
       
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "mobilerecharge")
    public String mobilerecharge(@WebParam(name = "amount") String amount, @WebParam(name = "phone") String phone) {
        //TODO write your implementation code here:
        
        String insert = "insert into tbl_recharge(recharge_amt,recharge_no)values('" + amount + "','" + phone + "')";
        System.out.println("ins:\t" + insert);
        boolean b = con.insert(insert);
        String a = "false";
        if (b) {
            a = "true";
        }
        return a;

    
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "wbillservice")
    public String wbillservice(@WebParam(name = "Personid") String Personid, @WebParam(name = "Serviceno") String Serviceno) {
        //TODO write your implementation code here:
        JSONArray ji = new JSONArray();
        try { 
            JSONObject jos = null;
            String sel = "select wbill_status,wbill_amt,wbill_duedate,wbill_no,person_name from tbl_person p inner join tbl_waterbill eb on p.person_id=eb.person_id where wbill_serviceno='" + Serviceno + "' and eb.person_id=" + Personid;
            System.out.println(sel);
            ResultSet rs = con.select(sel);

            if (rs.next()) {

                jos = new JSONObject();
                String billno = rs.getString("wbill_no");
                String amt = rs.getString("wbill_amount");
                String duedate = rs.getString("wbill_duedate");
                String status = rs.getString("wbill_status");
                String person = "";

                person = rs.getString("person_name");

                jos.put("BillNo", billno);
                jos.put("Amount", amt);
                jos.put("Due", duedate);
                jos.put("Person", person);
                jos.put("Status", status);

                ji.put(jos);
            } else {
                jos = new JSONObject();
                jos.put("BillNo", "0");
                ji.put(jos);
            }

        } catch (Exception ex) {
            Logger.getLogger(WebServiceOutlay.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ji.toString();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "loan")
    public String loan(@WebParam(name = "Personid") String Personid) {
        JSONArray ji = new JSONArray();
        JSONObject jos = null;
        //TODO write your implementation code here:
        try {
         String expense = "";
         String income = "";
        int bal = 0;
        
         String sel = "select sum(expense_amt) as sum from tbl_expenses where person_id='" + Personid + "' and  year(expense_date)=year(curdate()) ";
            ResultSet rs = con.select(sel);
            System.out.println(sel);
            if (rs.next()) {
                expense = rs.getString("sum");
                if (expense == null) {
                    expense = "0";
                }
            }
        
            String sel2 = "select sum(income_amt) as sum from tbl_income where person_id='" + Personid + "'  and  year(income_date)=year(curdate()) ";
            ResultSet rss = con.select(sel2);
            System.out.println(sel2);
            if (rss.next()) {
                income = rss.getString("sum");
                if (income == null) {
                    income = "0";
                }
            }
        bal = Integer.parseInt(income) - Integer.parseInt(expense);
        int a= bal-80000;
        int b= bal+80000;
            System.out.println(bal + "balance");
            
String loan = "select * from tbl_loan l inner join tbl_bank b on b.bank_id=l.bank_id  where loan_amount between "+a+" and  "+b+"";
jos = new JSONObject();
System.out.println(loan);
            ResultSet rs12 = con.select(loan);
    while (rs12.next()) {
         String id=rs12.getString("loan_id");
         String amount= rs12.getString("loan_amount");
         String name= rs12.getString("loan_name");
         String intrest= rs12.getString("loan_intrest");
         String duration= rs12.getString("loan_duration");
         String bank= rs12.getString("bank_name");
         String phone= rs12.getString("bank_phn");
         String email= rs12.getString("bank_email");
         String link= rs12.getString("bank_link");
            jos = new JSONObject();
            jos.put("amount", amount);
            jos.put("name", name);
            jos.put("id", id);
            jos.put("intrest",intrest);
            jos.put("duration",duration);
            jos.put("bank",bank);
            jos.put("phone",phone);
            jos.put("email",email);
            jos.put("link","");
            ji.put(jos);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        System.out.println("LOans::"+ji);
        return ji.toString();
            
            
            
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "insurance")
    public String insurance(@WebParam(name = "Personid") String Personid) {
        JSONArray ji = new JSONArray();
        JSONObject jos = null;
        //TODO write your implementation code here:
         try {
         String expense = "";
         String income = "";
        int bal = 0;
        
         String sel = "select sum(expense_amt) as sum from tbl_expenses where person_id='" + Personid + "' and  year(expense_date)=year(curdate()) ";
            ResultSet rs = con.select(sel);
            System.out.println(sel);
            if (rs.next()) {
                expense = rs.getString("sum");
                if (expense == null) {
                    expense = "0";
                }
            }
        
            String sel2 = "select sum(income_amt) as sum from tbl_income where person_id='" + Personid + "'  and  year(income_date)=year(curdate()) ";
            ResultSet rss = con.select(sel2);
            System.out.println(sel2);
            if (rss.next()) {
                income = rss.getString("sum");
                if (income == null) {
                    income = "0";
                }
            }
        bal = Integer.parseInt(income) - Integer.parseInt(expense);
        int a= bal-80000;
        int b= bal+80000;
            System.out.println(bal + "balance");
            String insurance = "select * from tbl_insurance i inner join tbl_company c on c.company_id=i.company_id  where insurance_amount between "+a+" and  "+b+"";
            jos = new JSONObject();
System.out.println(insurance);
            ResultSet rs12 = con.select(insurance);
    while (rs12.next()) {
         String id=rs12.getString("insurance_id");
         String amount= rs12.getString("insurance_amount");
         String name= rs12.getString("insurance_name");
         String duration= rs12.getString("insurance_duration");
         String company= rs12.getString("company_name");
         String phone= rs12.getString("company_phn");
         String email= rs12.getString("company_mail");
       
            jos = new JSONObject();
            jos.put("amount", amount);
            jos.put("name", name);
            jos.put("id", id);
            jos.put("duration",duration);
            jos.put("company",company);
            jos.put("phone",phone);
            jos.put("email",email);
            ji.put(jos);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        System.out.println("INSurance::"+ji);
        return ji.toString();
            
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "expensebarchart")
    public String expensebarchart(@WebParam(name = "Personid") String Personid, @WebParam(name = "Fromdate") String Fromdate, @WebParam(name = "Todate") String Todate) {
         JSONArray ja = new JSONArray();
        try {
        //TODO write your implementation code here:
            String etype="select * from tbl_extype";
            ResultSet rr=con.select(etype);
            while(rr.next()){
             JSONObject jo = new JSONObject();
                int examt=0;
        String ebr = "select * from tbl_expenses ex inner join tbl_extype et on et.extype_id=ex.extype_id where person_id='" + Personid + "' and  expense_date between '"+Fromdate+"' and '"+Todate+"' and et.extype_id='"+rr.getString("extype_id")+"'";
            ResultSet r32 = con.select(ebr);
            System.out.println(ebr);
           while (r32.next()) {
                examt=examt+Integer.parseInt(r32.getString("expense_amt"));
               
                //String n2 = r32.getString("expense_amt");
           } if(examt!=0){
                String n1 = rr.getString("extype_name");
                jo.put("Name", n1);
                jo.put("Amount", examt);
                
                ja.put(jo);
           } 
            }
        
    }catch (Exception ex) {
            Logger.getLogger(WebServiceOutlay.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(ja);
        return ja.toString();
    
    
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "incomebarchart")
    public String incomebarchart(@WebParam(name = "Personid") String Personid, @WebParam(name = "Fromdate") String Fromdate, @WebParam(name = "Todate") String Todate) {
        JSONArray ja = new JSONArray();
        try {
//TODO write your implementation code here:
             String ibr = "select * from tbl_income inc inner join tbl_intype it on it.intype_id=inc.intype_id where person_id='" + Personid + "' and  income_date between '"+Fromdate+"' and '"+Todate+"' ";
        ResultSet r42 = con.select(ibr);
            System.out.println(ibr);
             while(r42.next()) {

                JSONObject jo = new JSONObject();

                String n1 = r42.getString("intype_name");
                String n2 = r42.getString("income_amt");
                jo.put("Name", n1);
                jo.put("Amount", n2);
                ja.put(jo);

            }
            }catch (Exception ex) {
            Logger.getLogger(WebServiceOutlay.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ja.toString();
    }
}


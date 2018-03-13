package com.namratha.com;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UpdateServlet extends HttpServlet {

     @Override
    public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException 
    {
        res.setContentType("text/html");
        PrintWriter out=res.getWriter();
        String sid=req.getParameter("sid");
        String semail=req.getParameter("semail");
        String newsemail=req.getParameter("newsemail");
        try
        {
           Class.forName("oracle.jdbc.driver.OracleDriver");
           Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
           Statement st=con.createStatement();
           String s="update register set semail='"+newsemail+"' where sid='"+sid+"'";
           ResultSet rs=st.executeQuery(s);
           if(rs.next())
           {
               out.println("UPDATED");
           }
           else
           {
               
               out.println("NOT UPDATED");
               
           }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}

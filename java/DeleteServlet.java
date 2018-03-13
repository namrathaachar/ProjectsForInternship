package com.namratha.com;



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DeleteServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException 
    {
        res.setContentType("text/html");
        PrintWriter out=res.getWriter();
        String sid=req.getParameter("sid");
        String semail=req.getParameter("semail");
        try
        {
           Class.forName("oracle.jdbc.driver.OracleDriver");
           Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
           Statement st=con.createStatement();
           String s1=" select * from register where semail='"+semail+"' ";
           ResultSet rs=st.executeQuery(s1);
           if(rs.next())
           {
                      String s="delete from register where semail='"+semail+"'";
           int s2=st.executeUpdate(s);
           if(s2>0)
           {
               out.println("DELETED");
           }
           
        }
            else
            {
                out.println("NOT FOUND");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

}

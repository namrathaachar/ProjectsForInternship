package com.namratha.com;


import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException
    {
        res.setContentType("text/html");
        PrintWriter out=res.getWriter();
        String sid=req.getParameter("sid");
        String sname=req.getParameter("sname");
        String semail=req.getParameter("semail");
       int sage=Integer.parseInt(req.getParameter("sage"));
        String spassword=req.getParameter("spwd");
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
            Statement st=con.createStatement();
            
            String s="insert into register values('"+sid+"','"+sname+"','"+semail+"','"+sage+"','"+spassword+"')";
            int c=st.executeUpdate(s);
            if(c>0)
            {
                out.println("User Registered Successfully");
            }
            else
            {
                out.println("Not Registered");
            }
        }
        catch(Exception e)
                    {
                    e.printStackTrace();
                    }
        }
    }
   
    


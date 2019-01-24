package com.abc;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="NewServlet",urlPatterns={"/NewServlet"})

public class NewServlet extends HttpServlet
{
    private Connection con;
     Statement stmt;
    ResultSet rs;
    ServletContext ct;

    String me;
    public void init()
    {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con=DriverManager.getConnection("jdbc:derby://localhost:1527/logindetails","app","app");
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(NewServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @Override
    protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
        try {
            String s1=req.getParameter("txtun");
            String s2=req.getParameter("txtpwd");
            res.setContentType("text/html");
            PrintWriter out=res.getWriter();
            ct=getServletContext();
            ct.setAttribute("uid", s1);
            
            Class.forName("org.apache.derby.jdbc.ClientDriver");
           // con=DriverManager.getConnection("jdbc:derby://localhost:1527/logindetails", "app", "app");
            ct.setAttribute("con1", con);
            stmt=con.createStatement();
            rs=stmt.executeQuery("select * from logins where USERID='"+s1+"'");
            while(rs.next())
            {
                
                
                if(rs.getString(1).equals(s1) && rs.getString(2).equals(s2)){
                    RequestDispatcher d=ct.getRequestDispatcher("/SuccessServlet");
                    d.forward(req, res);
                    
                   
                }
                
               
            }
            RequestDispatcher d=ct.getRequestDispatcher("/index.html");
            out.println("Invalid Username and Password");
            d.include(req, res);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(NewServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
    }
}

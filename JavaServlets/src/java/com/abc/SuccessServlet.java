package com.abc;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name="SuccessServlet",urlPatterns={"/SuccessServlet"})
public class SuccessServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException{
        Statement stmt;
        ResultSet rs;
        Connection con;
        res.setContentType("text/html");
        PrintWriter out=   res.getWriter();
        ServletContext ct=getServletContext();
        String s1=ct.getAttribute("uid").toString();
       // out.println(s1);
        con=(Connection)ct.getAttribute("con1");
       // out.println(con);
        try {
            
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            
            stmt=con.createStatement();
            
            rs=stmt.executeQuery("select * from logins where UserId='"+s1+"'");
            
            while(rs.next())
            {
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Hello</title>");
                out.println("</head>");
                out.println("<body bgcolor='cyan'>");
                out.println("<h1>Welcom "+rs.getString(1)+"</h1><br/>");
                out.println("UserId:"+rs.getString(1)+"<br/>");
                out.println("RegdNo:"+rs.getString(3)+"<br/>");
                out.println("</body>");
                out.println("</htzml>");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(SuccessServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
}
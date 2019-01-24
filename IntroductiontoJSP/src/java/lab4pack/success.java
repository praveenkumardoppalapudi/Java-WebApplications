package lab4pack;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
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
@WebServlet(name="success",urlPatterns={"/success"})
public class success extends HttpServlet{

    
    @Override
    protected void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException
    {
        PrintWriter out=res.getWriter();
        String un=req.getParameter("un");
        String password=req.getParameter("pwd");
        res.setContentType("text/html");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>");
        
        out.println("</title>");
        out.println("<link href='logincss.css' rel='stylesheet'/>");
        out.println("</head>");
        out.println("<body class='success'>");
        
        out.println("<center>");
            
        ServletContext ct=getServletContext();
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/logindetails","app","app");
           Statement stmt=con.createStatement();
           ResultSet rs=stmt.executeQuery("select * from logins where userid='"+un+"'");
           while(rs.next()){
               out.println("<div>");
               out.println("<h1 class='fsz'>Welcome to "+rs.getString("userid")+"</h1>");
               out.println("<h3 class='fsz'><u>User Details</u></h3>");
               out.println("<b class='fsz'>UserId:</b><h4>"+rs.getString(1)+"</h4>");
               out.println("<br/><b class='fsz'>RegdNo:</b><h4>"+rs.getString(3)+"</h4> ");
               out.println("</div>");
           }
           con.close();
           
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(NewServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        out.println("</center>");
        out.println("</body>");
        out.println("</html>");
    }
}
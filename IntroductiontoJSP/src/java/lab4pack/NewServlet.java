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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name="NewServlet",urlPatterns={"/NewServlet"})
public class NewServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
    {
        PrintWriter out=res.getWriter();
        String un=req.getParameter("un");
        String password=req.getParameter("pwd");
        res.setContentType("text/html");
        out.println("<html>");
        out.println("<body>");
            
        ServletContext ct=getServletContext();
        if(un!=null & password!=null)
        {
            try {
                Class.forName("org.apache.derby.jdbc.ClientDriver");
                Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/logindetails","app","app");
               Statement stmt=con.createStatement();
               ResultSet rs=stmt.executeQuery("select * from logins where userid='"+un+"' and password='"+password+"'");
               while(rs.next()){
                   RequestDispatcher d=ct.getRequestDispatcher("/success");
                   d.forward(req, res);
               }
               con.close();

               RequestDispatcher d=ct.getRequestDispatcher("/ERROR.jsp");
               d.include(req, res);

            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(NewServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
        {
            out.println("Please enter Username and Password");
        }
        out.println("</body>");
        out.println("</html>");
    }
}
package abc;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet(name="/Payment",urlPatterns={"/Payment"})
public class Payment extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
    {
       
        //out.println("hii");
        HttpSession session=req.getSession();
        /*String s= session.getAttribute("lang").toString();
        String s1= session.getId();
        out.println("Id"+s1);*/
      //out.println(session.getMaxInactiveInterval());
      res.setContentType("text/html");
      PrintWriter out=res.getWriter();
      out.println("<html>");
      out.println("<body>");
      out.println("<center>");
        if(session.getAttribute("lang")==null)
        {
            //out.println("<h3>Your Session is Expired Try again</h4>");
            ServletContext ct=getServletContext();
            RequestDispatcher disp=ct.getRequestDispatcher("/index.html");
            out.println("<h3 style='color:red'>Your Session is Expired</h3>");
            disp.include(req, res);
            //out.println("<a href='Cp.html'>Click Here to Payment again</a>");
            
            
        }
        else 
        {
            try {
                ServletContext ct=getServletContext();
                String c=ct.getAttribute("bookcost").toString();
                int cost=Integer.parseInt(c);
                String card=ct.getAttribute("card").toString();
                String cvv=ct.getAttribute("cvv").toString();
                String password=ct.getAttribute("password").toString();
                
                Class.forName("org.apache.derby.jdbc.ClientDriver");
                Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/BankDataBase", "app", "app");
                Statement stmt=con.createStatement();
               
                ResultSet rs=stmt.executeQuery("select balance,cardno,cvv,password from CUSTOMERS where cardno='"+card+"'");
                
               
                    while(rs.next())
                    {

                        if(rs.getString("cvv").equals(cvv) & rs.getString("password").equals(password))
                        {
                            if(rs.getDouble("balance")>=cost)
                            {

                                int i1=  rs.getInt("balance");
                                stmt.executeUpdate("update CUSTOMERS set balance="+(i1-cost)+" where cardno='"+card+"'");
                                out.println("<h2>Payment done</h2>");
                                Random rand=new Random();
                                int i=rand.nextInt(1000000000);
                                out.println("<h4>Payment ID :"+Math.abs(i)+"</h4>");
                                out.println("<h3>Thank You!Visit again</h3>");
                                session.invalidate();
                            }
                            else
                            {
                                out.println("<h1>Insufficent funds in your account</h1><br>");
                                session.invalidate();
                                out.println("<a href='index.html'>Click Here For MainPage</a>");
                            }
                        }
                        
                    
                    
                }
                
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
        out.println("</center>");
        out.println("</body>");
        
        out.println("</html>");
        
    }
}

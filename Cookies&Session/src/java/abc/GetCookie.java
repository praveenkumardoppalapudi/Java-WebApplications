
package abc;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "GetCookie", urlPatterns = {"/GetCookie"})
public class GetCookie extends HttpServlet {
   
      @Override
      protected void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
      {
         String s=null;
         
        
        
       Cookie[] k= req.getCookies();
         for(int i=0;i<k.length;i++)
         {
             Cookie org=k[i];
            s= org.getValue();
         }
             
         PrintWriter out=res.getWriter();
         ServletContext ct=getServletContext();
         
         //con=DriverManager.getConnection("","app","app");
         
         ct.setAttribute("sub", s);
         res.setContentType("text/html");
         //String lang=ct.getAttribute("sub").toString();
         out.println("<body style='background-color:cyan'>");
         out.println("<center>");
         out.println("<br/><h1>Welcome to"+s+"  Books</h1>");
         out.println("<marquee direction='left' style='color:red'><h2>Buy more then one book get 40% discount</h2></marquee>");
         RequestDispatcher disp=ct.getRequestDispatcher("/"+s+".html");
         disp.include(req, res);
         
         out.println("</center>");
         out.println("</body>");
         
             
       
      }
}
package abc;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name="PaymentServlet",urlPatterns={"/PaymentConfirm"})
public class PaymentConfirm extends HttpServlet{
        @Override
        protected void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException{
           PrintWriter out= res.getWriter();
           ServletContext ct=getServletContext();
           out.println("<html>");
           out.println("<body>");
           out.println("<div>");
           out.println("<center>");
           
           
           String s=req.getParameter("card");
          if(s.length()>=15)
          {
              out.println("<h2><u>Payment Details</u></h2>");
           out.print("<h3><b>Name</b>:"+req.getParameter("na")+"</h3>");      
              String s1= s.substring(0, 4);
                    String s2= s.substring(11, s.length());
           
            out.println("<h3><b>CardNo</b>  :"+s1+"XXXXXXXX"+s2+"</h3>");
           String c=ct.getAttribute("bookcost").toString();
            out.println("<h3><b>Amount</b>  :"+c+"</h3>");
            out.println("<form>");
            out.println("<br/><input type='submit' value='Procede' formaction='Payment' />");
            out.println("</form>");
          }
          else
          {
             out.println("<h3 style='color:black'>Enter Valid CardNo</h3>");
              RequestDispatcher disp=ct.getRequestDispatcher("/sbi.html");
             disp.include(req, res);
             
          }
         
          out.println("<center>");
          
           out.println("</body>");
           out.println("</div>");
           out.println("</html>");
           ct.setAttribute("card",s);
          ct.setAttribute("password", req.getParameter("password")); 
           ct.setAttribute("cvv", req.getParameter("cvv")); 
        }
}
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
import javax.servlet.http.HttpSession;
@WebServlet(name="/Addtocart",urlPatterns={"/Addtocart"})
public class Addtocart extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
    {
        
        PrintWriter out=res.getWriter();
       //String[] str= req.getParameterValues("chk");
      
        ServletContext ct=getServletContext();
        
           
        
      
       res.setContentType("text/html");
       out.println("<html>");
       out.println("<body>");
       out.println("<center>"); 
       out.println("<form>");
       int count=0;
       if(req.getParameterValues("chk") != null)
       {
           String[] str=req.getParameterValues("chk");
           
           int cost=0;
           int[] costarray=new int[str.length];
           String[] booknamearray=new String[str.length];
           for(int i=0;i<str.length;i++)
           {
               int len=Integer.parseInt(str[i].substring(0, 2));
               //out.println(len);
               String bookname= str[i].substring(2, len-1);
               booknamearray[i]=bookname;
               //out.println(bookname);
               int c=Integer.parseInt(str[i].substring(len-1,str[i].length()));
               costarray[i]=c;
           }
           
           out.println("<table border='1px'>");
               out.println("<tr>");
               out.println("<th>BookName</th>");
               out.println("<th>BookCost</th>");
               out.println("</tr>");
           for(int i=0;i<str.length;i++)
           {
               out.println("<tr>");
               out.println("<td>"+booknamearray[i]+"</td>");
               out.println("<th>"+costarray[i]+"</th>");
               out.println("</tr>");
               cost=cost+costarray[i];
               //out.println(cost);
               count=count+1;
           }
           out.println("</table>");
           
          if(count>1)
           {
                cost=(int) (cost*0.60);
                out.println("<h2>Congratulations you got 40% discount</h2>");
           }
           else
           
           {
                out.println("<h2>You Missed 40% discount offer</h2>");
           }
          
            out.println("<br/>Your Cart Amount is <h2>"+cost+"</h2>"); 
          //ct.setAttribute("bookname", booknamearray);
           ct.setAttribute("bookcost", cost);
           //ct.setAttribute("count",count);
           HttpSession session=req.getSession(true);
            String lang=  ct.getAttribute("sub").toString();
            session.setAttribute("lang",lang);
            session.setMaxInactiveInterval(30);
           out.println("<input type='submit' value='Procede to Payment' formaction='bank.html'/>");
           
          
       }
       else{
              String s=ct.getAttribute("sub").toString();
              RequestDispatcher disp=ct.getRequestDispatcher("/GetCookie");
              out.println("<h2>Please select atleast one book</h2>");
              disp.include(req, res);
          }
       
       
      
       out.println("</form>");
       out.println("</center>");
       out.println("</body>");
       out.println("<html>");
       HttpSession session=req.getSession(true);
       String lang=  ct.getAttribute("sub").toString();
       session.setAttribute("lang",lang);
       session.setMaxInactiveInterval(30);
       
    }
}
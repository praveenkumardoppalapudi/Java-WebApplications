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
import javax.servlet.http.HttpSession;

@WebServlet(name="MainServlet",urlPatterns={"/MainServlet"})
public class MainServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
    {
        String lang=req.getParameter("drop");
        PrintWriter out=res.getWriter();
        //HttpSession s=req.getSession();
        //s.setAttribute("lang",lang);
        //s.setMaxInactiveInterval(1*60);
        Cookie c=new Cookie("lang",lang);
        ServletContext ct=getServletContext();
        ct.setAttribute("lang", lang);
        //c.setMaxAge(60);
        res.addCookie(c);
        
        res.setContentType("text/html");
        
        //RequestDispatcher disp=ct.getRequestDispatcher("/GetCookie");
        out.println("<body>");
        out.println("<h1>WelCome to Store You are Selected "+lang+" Click Button to See Books</h1>");
        out.println("<form action='GetCookie'>");
        out.println("<input type='submit' value='continue'/>");
        out.println("</form>");
        out.println("</body>");
    }
}
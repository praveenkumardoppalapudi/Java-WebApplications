
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class SuccessServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException{
        String s1=req.getParameter("uid");
        String s2=req.getParameter("pwd");
        
        res.setContentType("video/mp4");
       PrintWriter out= res.getWriter();
       
       String fileName = req.getParameter("filename");

    fileName = "/"+fileName + ".mp4";

    ServletContext ct = getServletContext();

    InputStream input = ct.getResourceAsStream(fileName);

    //response.setContentType("video/quicktime"); //Use this for VLC player

    



    res.setHeader("Content-Disposition", "inline; filename=\""

        + fileName + "\"");

    OutputStream output = res.getOutputStream();



    byte[] buffer = new byte[9000];

    int read = 0;

    while ((read = input.read(buffer)) != -1) {

      output.write(buffer, 0, read);

    }

    input.close();

    output.flush();

    output.close();
       /*
       ServletContext ct=getServletContext();
       RequestDispatcher d1=ct.getRequestDispatcher("/NewServlet");
       
       */
       
       //out.println("User Id"+s1+",password:"+s2);
       //d1.forward(req, res);
    }
}
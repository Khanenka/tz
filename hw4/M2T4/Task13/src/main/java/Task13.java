import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(name="task13Servlet",urlPatterns = "/task13")
public class Task13 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cookieName="session_id";
        Cookie sessionId = new Cookie("cookieName", "123");
        PrintWriter printWriter=response.getWriter();
        response.addCookie(sessionId);
        response.setContentType("text/html");
        File file=new File("D:/M2T4/task13.txt");
        Cookie[] cookies = request.getCookies();
        PrintWriter pw=new PrintWriter(file);
Integer count=0;
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                pw.write("Name:" + cookies[i].getName() + " count=" + count++ + ";" +"\n");
if(cookies!=null & !cookies[i].getName().equals(cookieName)){
    pw.write("new cookie"+ count++ +"\n");
}

            }
        }



        pw.close();
    }
    }



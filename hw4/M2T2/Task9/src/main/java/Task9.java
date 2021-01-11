import javax.imageio.IIOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;

@WebServlet(name="task9servlet",urlPatterns = "/task9")
public class Task9  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws FileNotFoundException {
        HttpSession session=req.getSession();
        Integer count= (Integer) session.getAttribute("count");
        File file=new File("D:/M2T2/task9.txt");
        PrintWriter pw=new PrintWriter(file);
        try {


            if (count==null) {
                session.setAttribute("count", 1);
                count=1;
              pw.write(String.valueOf(file));

            }
            session.setAttribute("count", count+1);
            PrintWriter printWriter = resp.getWriter();
            printWriter.println("Hello your count is" + count);
            pw.println("Hello your count is" + count);
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }


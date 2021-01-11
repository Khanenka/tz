import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Task8 extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {
        PrintWriter printWriter=response.getWriter();
        printWriter.println("<html>");
        printWriter.println("<h1>Hello task 8 servlet</h1>");
        printWriter.println("</html>");
    }


}
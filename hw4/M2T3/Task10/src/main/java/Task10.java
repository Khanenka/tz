import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(name="formServletTask10",urlPatterns = "/task10.html")
public class Task10 extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {


PrintWriter printWriter=response.getWriter();
        Enumeration enumeration;
        enumeration=request.getParameterNames();


            String name = request.getParameter("name");
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");


            if (name.isEmpty() || phone.isEmpty() || email.isEmpty()) {
               printWriter.println("error");
            }
            else
            {
               printWriter.println(name+phone+email);
            }

        }}
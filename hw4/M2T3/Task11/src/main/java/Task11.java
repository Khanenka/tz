import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.UserAgent;
import eu.bitwalker.useragentutils.Version;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="formServletTask10",urlPatterns = "/task11")
public class Task11 extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response){

    try {
        response.setContentType("text/html; charset=UTF-8"); response.setCharacterEncoding("UTF-8");
        PrintWriter printWriter=response.getWriter();
        UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
        Browser browser = userAgent.getBrowser();

        String browserName = browser.getName();
        //or
        // String browserName = browser.getGroup().getName();
        Version browserVersion = userAgent.getBrowserVersion();
        printWriter.println("<h1>"+"Приветствую тебя пользователь " + browserName + " - version " + browserVersion+"<h1>");

    } catch (IOException e) {
        e.printStackTrace();
    }



}

}

import javax.imageio.ImageIO;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;

import java.io.IOException;


@WebServlet(name = "task12Servlet",urlPatterns = "/task12")
public class Task12 extends HttpServlet {
    private int hitCount;

    public void init() {
        // Reset hit counter.
        hitCount = 0;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Set response content type
        response.setContentType("text/html");

        // This method executes whenever the servlet is hit
        // increment hitCount
        hitCount++;

        response.setContentType("image/jpeg");
        BufferedImage image = new BufferedImage(500, 200,
                BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();
        graphics.setFont(new Font("Serif", Font.ITALIC, 48));
        graphics.setColor(Color.green);
        graphics.drawString(String.valueOf("yor session: "+hitCount), 100, 100);
        ServletOutputStream sos = response.getOutputStream();
        ImageIO.write(image, "jpeg", sos);



    }

}
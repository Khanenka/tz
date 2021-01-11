package it.academy.servlet;

import it.academy.data.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;





public class Task14 extends HttpServlet {
    String url;
    String user;
    String password;

    @Override
    public void init() throws ServletException {
        super.init();


    ServletConfig servletConfig = getServletConfig();
    url =servletConfig.getInitParameter("url");
    user =servletConfig.getInitParameter("user");
    password =servletConfig.getInitParameter("password");
}
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final PrintWriter writer = resp.getWriter();
        try {
            DaoFactory daoFactory=new DaoFactory();
            ExpensesDao expensesDao=null;
            expensesDao=daoFactory.getExpensesDao(url,user,password);



expensesDao.readAll(writer);

        } catch (Exception e) {
            e.printStackTrace();
            writer.println("Error: " + e.getMessage());
        }
    }
}


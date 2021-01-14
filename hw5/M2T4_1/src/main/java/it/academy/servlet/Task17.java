package it.academy.servlet;

import it.academy.data.DaoFactory;
import it.academy.data.ExpensesDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;



@WebServlet(name = "task15servlet", urlPatterns = "/task17")
public class Task17 extends HttpServlet {
    String url;
    String user;
    String password;

    @Override
    public void init() throws ServletException {
        super.init();


    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            DaoFactory daoFactory = new DaoFactory();

            ExpensesDao expensesDao = null;

            req.setAttribute("expenses", DaoFactory.getExpensesDao("jdbc:mysql://localhost:3306/expenses?serverTimezone=UTC", "root", "root").readAll());
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/task17.jsp");
            dispatcher.forward(req, resp);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }
}



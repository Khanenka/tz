package it.academy.servlet;

import it.academy.data.DaoFactory;
import it.academy.data.Expenses;
import it.academy.data.ExpensesDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
@WebServlet(name="taskservlet15",urlPatterns = "/task15")
public class Task15 extends HttpServlet {
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
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/task15.jsp");
            dispatcher.forward(req, resp);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }
}

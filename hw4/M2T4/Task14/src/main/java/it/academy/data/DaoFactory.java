package it.academy.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoFactory {

    private static DaoFactory daoFactory;

    public DaoFactory() throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
    }

    public ExpensesDao getExpensesDao(String url,String root, String password) throws SQLException {
        Connection  connection = DriverManager.getConnection(url,
        root,
        password);

        return new ExpensesDaoImpl(connection);
    }



}
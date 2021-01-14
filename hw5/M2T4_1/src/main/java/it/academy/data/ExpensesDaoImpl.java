package it.academy.data;

import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ExpensesDaoImpl implements ExpensesDao {
    private Connection connection;

    public ExpensesDaoImpl(Connection connection) {
        this.connection = connection;
    }

    public ExpensesDaoImpl() {

    }

    public void create(Expenses expenses) {

        try (PreparedStatement preparedStatement =connection.prepareStatement("insert into expenses"+"(num,paydate,receiver,value)"+
                "values(?, ? ,?,?)")){
            preparedStatement.setInt(1,expenses.getNum());
            preparedStatement.setDate(2,expenses.getPaydate());
            preparedStatement.setInt(3,expenses.getReceiver());
            preparedStatement.setFloat(4,expenses.getValue());

        }catch(SQLException e){
            e.printStackTrace();
        }


    }


    @Override
    public List<Expenses> readAll() {
        List<Expenses> expensesArrayList = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("select * from expenses")) {
            while (resultSet.next()) {
                Expenses expenses = new Expenses();
                expenses.setNum(resultSet.getInt( "num"));
                expenses.setPaydate(resultSet.getDate("paydate"));
                expenses.setReceiver(resultSet.getInt("receiver"));
                expenses.setValue(resultSet.getFloat("value"));
                expensesArrayList.add(expenses);
                expensesArrayList.toArray().toString();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return expensesArrayList;
    }

    @Override
    public void update(Expenses expenses) {

    }

    @Override
    public void delete(Expenses expenses) {

    }

    @Override
    public List<Expenses> readAll(PrintWriter writer) {
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     "SELECT " +
                             " num," +
                             " paydate," +

                             " receiver," +
                             " value" +
                             " FROM" +
                             " expenses")) {
            while (resultSet.next()) {
                writer.println("num: " + resultSet.getInt("num")
                        + ", paydate: " + resultSet.getDate("paydate")
                        + ", receiver: " + resultSet.getInt("receiver")
                        + ", value: " + resultSet.getFloat("value")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return null;
    }
    public List<Expenses> readAllJSP(PrintWriter writer) {
        List<Expenses> expensesList=new LinkedList<>();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     "SELECT " +
                             " num," +
                             " paydate," +

                             " receiver," +
                             " value" +
                             " FROM" +
                             " expenses")) {
            while (resultSet.next()) {
                Expenses exp=new Expenses();
                exp.setNum(resultSet.getInt("num"));
                exp.setPaydate (resultSet.getDate("paydate"));
                exp.setReceiver(resultSet.getInt("receiver"));
                exp.setValue(resultSet.getFloat("value"));
                expensesList.add(exp);
            }
        } catch (SQLException e) {
            writer.println("error");

        }
        return expensesList;
    }

}


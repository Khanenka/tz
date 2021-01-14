package it.academy.data;

import java.io.PrintWriter;
import java.util.List;

public interface ExpensesDao {
    void create(Expenses expenses);
    List<Expenses> readAll();
    void update(Expenses expenses);
    void delete(Expenses expenses);

    List<Expenses> readAll(PrintWriter writer);


    List<Expenses>  readAllJSP(PrintWriter out);
}

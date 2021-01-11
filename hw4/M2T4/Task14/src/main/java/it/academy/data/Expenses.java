package it.academy.data;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

public class Expenses implements Serializable {
    private int num;
    private Date paydate;
    private int receiver;
    private float value;

    public Expenses(){

    }
    public Expenses(int num, Date paydate, int receiver, float value) {
        this.num = num;
        this.paydate = paydate;
        this.receiver = receiver;
        this.value = value;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Date getPaydate() {
        return paydate;
    }

    public void setPaydate(Date paydate) {
        this.paydate = paydate;
    }

    public int getReceiver() {
        return receiver;
    }

    public void setReceiver(int receiver) {
        this.receiver = receiver;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Expenses{" +
                "num=" + num +
                ", paydate='" + paydate + '\'' +
                ", receiver=" + receiver +
                ", value=" + value +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Expenses expenses = (Expenses) o;
        return num == expenses.num &&
                receiver == expenses.receiver &&
                Float.compare(expenses.value, value) == 0 &&
                Objects.equals(paydate, expenses.paydate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(num, paydate, receiver, value);
    }
}


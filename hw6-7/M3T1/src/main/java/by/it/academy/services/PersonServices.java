package by.it.academy.services;

import by.it.academy.pojos.Address;
import by.it.academy.pojos.Family;
import by.it.academy.pojos.Person;
import by.it.academy.util.HibernateUtil;
import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.Serializable;

public class PersonServices {
    private static HibernateUtil hibernateUtil;

    public PersonServices() {
        hibernateUtil = new HibernateUtil();
    }


    SessionFactory sessionFactory;


    public Serializable save(Person person) {

        Session session = hibernateUtil.getSession();

        session.beginTransaction();
        Serializable id = session.save(person);
        session.getTransaction().commit();

        session.close();

        return id;
    }

    public Family searchFamily(Serializable id) {
        Family family;
        try {
            Session session = hibernateUtil.getSession();
            family = session.get(Family.class, 1);
            System.out.println("family id="+id);
        } catch (Exception e) {
            System.out.println("Inncorrect id" + id);
            return null;
        }
        return family;
    }



    public Person load(Serializable id) {
        Session session = hibernateUtil.getSession();
        Person loadedPerson = session.load(Person.class, 2);
        return loadedPerson;
    }

    public  Person search(Serializable id) {
        Person person;
        try {
            Session session = hibernateUtil.getSession();
            person = session.get(Person.class, 1);

        } catch (Exception e) {
            System.out.println("Inncorrect id" + id);
            return null;
        }
        return person;
    }

    public void delete(Serializable id) {
        Session session = hibernateUtil.getSession();
        session.beginTransaction();
        Person personForDelete = session.get(Person.class, id);
        session.getTransaction().commit();
        session.close();

    }

    public void flush(Person person) {
        Session session = hibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        session.save(person);
        session.flush();
        tx.commit();

    }

}

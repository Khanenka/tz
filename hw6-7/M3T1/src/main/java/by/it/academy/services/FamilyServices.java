package by.it.academy.services;

import by.it.academy.pojos.Address;
import by.it.academy.pojos.Family;
import by.it.academy.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.Serializable;

public class FamilyServices {
    private static HibernateUtil hibernateUtil;

    public FamilyServices() {
        hibernateUtil = new HibernateUtil();
    }




    public Serializable saveFamily(Family family) {

        Session session = hibernateUtil.getSession();

        session.beginTransaction();
        Serializable id = session.save(family);
        session.getTransaction().commit();
        System.out.println("family id ="+family.getIdFamily());
        session.close();

        return id;
    }
}

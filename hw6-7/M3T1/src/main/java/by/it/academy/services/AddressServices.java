package by.it.academy.services;

import by.it.academy.pojos.Address;
import by.it.academy.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.Serializable;

public class AddressServices {
    private static HibernateUtil hibernateUtil;

    public AddressServices() {
        hibernateUtil = new HibernateUtil();
    }




    public Serializable saveAddress(Address address) {

        Session session = hibernateUtil.getSession();

        session.beginTransaction();
        Serializable id = session.save(address);
        session.getTransaction().commit();
        System.out.println("address id = "+address.getIdAddress());
        session.close();

        return id;
    }

}

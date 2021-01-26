package by.it.academy.loader;

import by.it.academy.pojos.Person;
import by.it.academy.util.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import java.io.Serializable;

public class PersonLoader {
Session session;


    public static void main(String[] args) {
        //task1
        Person person=new Person(null,35,"Yulli","Slabko");
        EntityManager entityManager= HibernateUtil.getSession();
        entityManager.getTransaction().begin();
        entityManager.persist(person);
        entityManager.getTransaction().commit();
        HibernateUtil.getSession().close();

       //task2//save,load,delete,search
       PersonServices personServices=new PersonServices();
       Serializable id=personServices.save(new Person(2,3,"Urii","Vertixov"));
       personServices.load(2);
        personServices.search(2);
       personServices.save(person);
       personServices.delete(2);
        System.out.println(person);
        //task3,void flush();
        personServices.flush(person);





    }

}

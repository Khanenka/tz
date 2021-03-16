package it.academy;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class PersonDaoImpl implements PersonDao {


    private SessionFactory sessionFactory;

    @Autowired
    public PersonDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public String save(Person person) {

        Session session = sessionFactory.getCurrentSession();

        String id = (String) session.save(person);

        return id;


    }


    @Override
    public Person getOnePerson(String id) {

        Session session = sessionFactory.getCurrentSession();

        Person person = session.get(Person.class, id);

        return person;
    }


}





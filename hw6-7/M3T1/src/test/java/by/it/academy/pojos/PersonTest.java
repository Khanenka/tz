package by.it.academy.pojos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.After;
import org.junit.FixMethodOrder;
import org.junit.Test;

import java.io.Serializable;
import java.sql.Date;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
@FixMethodOrder
public class PersonTest {
    private SessionFactory factory;



        @org.junit.Before
        public void setUp() {
            StandardServiceRegistry registry =
                    new StandardServiceRegistryBuilder()
                            .configure("hibernate.cfg.test.xml")
                            .build();
            factory = new MetadataSources(registry)
                    .buildMetadata()
                    .buildSessionFactory();
        }

        @Test
        public void create() {
            //Given
            Person person = new Person();
            person.setId(1);
            person.setAge(23);
            person.setName("Ivan");
            person.setSurname("Ileev");

            //When
            Session session = factory.openSession();
            Transaction tx = null;
            Serializable id;
            try {
                tx = session.beginTransaction();
                //do some work
                id = session.save(person);
                tx.commit();
            } catch (Exception e) {
                if (tx != null) tx.rollback();
                throw e;
            } finally {
                session.close();
            }

            //Then
            assertNotNull(id);
        }
    @Test
    public void search(){
        Session session=factory.openSession();
        Person person = session.get(Person.class, 1);


        //When
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            //do some work
            session.find(Person.class,1);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }

        // Then



        assertNotNull(session.get(Person.class, 1));
        session.close();
    }

    @Test
        public void save(){
        Session session = factory.openSession();
            Person person=new Person();
            person.setId(2);
            person.setAge(23);
            person.setName("Ivan");
            person.setSurname("Ileev");

        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            //do some work
            session.save(person);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
        assertNotNull(Person.class);


        }

        @Test
        public void delete() {
            //Given
            Session session = factory.openSession();
            Person person = session.get(Person.class, 1);

            //When
            Transaction tx = null;
            try {
                tx = session.beginTransaction();
                //do some work
                session.delete(person);
                tx.commit();
            } catch (Exception e) {
                if (tx != null) tx.rollback();
                throw e;
            }

            // Then
            assertNull(session.get(Person.class, 1));
            session.close();
        }


        @org.junit.After
        public void tearDown() {
            factory.close();
        }
    }

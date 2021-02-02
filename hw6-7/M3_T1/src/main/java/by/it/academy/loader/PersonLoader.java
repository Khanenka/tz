package by.it.academy.loader;

import by.it.academy.pojos.Address;
import by.it.academy.pojos.Family;
import by.it.academy.pojos.Hobby;
import by.it.academy.pojos.Person;
import by.it.academy.services.AddressServices;
import by.it.academy.services.FamilyServices;
import by.it.academy.services.PersonServices;
import by.it.academy.util.HibernateUtil;
import org.hibernate.Session;


import javax.persistence.EntityManager;
import java.io.Serializable;

public class PersonLoader {
    Session session;


    public static void main(String[] args) {
        task1_3();
        task4_7();


    }

        public static void task1_3() {

        //task1
            Person person = new Person(null, 35, "Yulli", "Slabko");


        EntityManager entityManager = HibernateUtil.getSession();
        entityManager.getTransaction().begin();
        entityManager.persist(person);
        entityManager.getTransaction().commit();
        HibernateUtil.getSession().close();

    //task2//save,load,delete,search
    PersonServices personServices = new PersonServices();
    Serializable id = personServices.save(new Person(2, 3, "Urii", "Vertixov"));
    personServices.load(2);
    personServices.search(2);
    personServices.save(person);
    personServices.delete(2);
    System.out.println(person);

        //task3,void flush();
        personServices.flush(person);

    }

    public static void task4_7(){
        AddressServices as=new AddressServices();
        Address address = new Address();
        Hobby hobby=new Hobby("PC",2);
        FamilyServices fs=new FamilyServices();
        Family family = new Family(null,"Ivanovi",3,hobby);


        //task4-5
        address.setCity("Minsk");
        address.setStreet("Rokossovskogo");
        family.setFamilyName("Ivanovi");
        family.setQuantity(3);



        as.saveAddress(address);
        fs.saveFamily(family);


    }


}

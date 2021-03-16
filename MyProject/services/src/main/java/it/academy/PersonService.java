package it.academy;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
public class PersonService {


    @Autowired
    private PersonDao personDao;


    @Transactional
    public String saveNewClient(Person person) {
        return personDao.save(person);
    }





}


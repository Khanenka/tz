package it.academy;

import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
     PersonService personService;

    @PostMapping(value = "/person", consumes = "application/json")
    @ApiOperation("create person")
    public ResponseEntity<Person>createPerson(@RequestBody Person person) {
        personService.saveNewClient(person);
        return new ResponseEntity<Person>(person, HttpStatus.CREATED);

    }





}



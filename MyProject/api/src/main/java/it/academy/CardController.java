package it.academy;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class CardController {

    @Autowired
    CardService cardService;
    PersonService personService;


    @PostMapping(value = "/card", consumes = "application/json")
    @ApiOperation("create card")
    public ResponseEntity<Card> createCard(@RequestBody Card card) {
        cardService.saveCard(card);
        if (card == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(card, HttpStatus.CREATED);
    }



    @PostMapping(value = "/card_client")
    public ResponseEntity<Card> clientCard(@RequestParam String personId, Card card) {
        Card c = cardService.saveNewCardToPerson1(card, personId);
        if (c == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(c, HttpStatus.CREATED);
    }





    @GetMapping("/type_currency")
    public  ResponseEntity readTypeCurrency(
            @RequestParam("pageNum") Integer pageNum,
            @RequestParam("pageSize") Integer pageSize,
            @RequestParam("currency") Currency currency,
            @RequestParam("typeCard") TypeCard typeCard
    ) {

        List<String> phones = cardService.getAllPhones(typeCard, currency);
        if (phones == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }




        return new ResponseEntity<>(String.valueOf(phones), HttpStatus.OK);
    }
}



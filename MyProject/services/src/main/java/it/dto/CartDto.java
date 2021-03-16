package it.dto;

import it.academy.Currency;
import it.academy.TypeCard;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CartDto {

    private String idCard;


    private String numberCard;


    private Currency currency;

    private TypeCard typeCard;

}

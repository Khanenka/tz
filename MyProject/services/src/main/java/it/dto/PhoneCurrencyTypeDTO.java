package it.dto;

import it.academy.Currency;
import it.academy.TypeCard;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PhoneCurrencyTypeDTO {
   private List<String> phones;

}

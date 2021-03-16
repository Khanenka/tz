package it.academy;


import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;


@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Card implements Serializable {

    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator_card", strategy = "uuid")
    @Id
    @Column
    @NonNull
    private String idCard;

    @Column
    private String numberCard;

    @Column(columnDefinition = "enum('BYN','EUR' , 'USD')")
    @Enumerated(EnumType.STRING)
    private Currency currency;

    @Column(columnDefinition = "enum('Classic','Gold' , 'Platinum')")
    @Enumerated(EnumType.STRING)
    private TypeCard typeCard;

    @Column

    String id_Person;

}

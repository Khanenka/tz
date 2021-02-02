package by.it.academy.pojos;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
@Embeddable
public class Family  {

    @Id
    @GeneratedValue(generator = "identity")

    @Column
    private Long idFamily;

    @Column
    private String familyName;
    @Column
    private Integer quantity;
    @Embedded
    private Hobby hobby;


}

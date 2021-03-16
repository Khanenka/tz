package it.academy;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Person implements Serializable {

    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    @Id
    @Column
    @NonNull
    private String personId;

    @Column
    private String personFirstName;

    @Column
    private String personMiddleName;

    @Column
    private String personLastName;

    @Column
    @NonNull
    private String personPhone;

    @Column
    private String personEMail;



    @Column
    private  Status status;

}

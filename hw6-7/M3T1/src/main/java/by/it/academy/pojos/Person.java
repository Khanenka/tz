package by.it.academy.pojos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


import  javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table
public class Person implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;
    @Column
    private Integer age;
    @Column
    private String name;
    @Column
    private String surname;






}




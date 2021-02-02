package by.it.academy.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;


@Data
@Entity
@Table

public class Address implements Serializable {
    @Transient
    private String idAddress;


    @Access(AccessType.FIELD)
    private String city;


    private String street;



    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Access(AccessType.PROPERTY)
    public String getIdAddress() {
        return idAddress;
    }

    public void setId(String idAddress) {
        this.idAddress = idAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    @Access(AccessType.PROPERTY)
    public String getStreet() {
        return street;
    }

    @Access(AccessType.PROPERTY)
    public void setStreet(String street) {
        this.street = street;
    }
}


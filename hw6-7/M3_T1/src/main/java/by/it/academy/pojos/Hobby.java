package by.it.academy.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Embeddable
public class Hobby {

    private String nameHobby;

    private Integer quantityHobby;

    public String getNameHobby() {
        return nameHobby;
    }

    public void setNameHobby(String nameHobby) {
        this.nameHobby = nameHobby;
    }

    public Integer getQuantityHobby() {
        return quantityHobby;
    }

    public void setQuantityHobby(Integer quantityHobby) {
        this.quantityHobby = quantityHobby;
    }
}

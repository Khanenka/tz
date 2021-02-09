package it.academy.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;




@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Component
public class Soccer implements SportRule {
    @Value("1")
    private Integer id;
    @Value("white-black")
    private String colorBall;
    @Value("11")
    private String quantityPlayers;

    @Override


    public String getRule() {
        return "Play with my legs:this is Soccer";
    }

    public String getYourSport() {
        return "Soccer id"+id+", color ball "+colorBall+", quantity players "+quantityPlayers;
    }
}

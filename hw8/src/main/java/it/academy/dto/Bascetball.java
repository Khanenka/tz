package it.academy.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Component
public class Bascetball implements SportRule {
    @Value("1")
    private Long id;
    @Value("orange")
    private String colorBall;
    @Value("5")
    private String quantityPlayers;

    @Override


    public String getRule() {
        return "Play with my hands:this is Bascet";
    }

    @Override
    public String getYourSport() {
        return "Bascet id "+id+", color ball "+colorBall+", quantityPlayers= "+quantityPlayers+"\n";
    }

}

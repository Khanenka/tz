package it.academy.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ReadRules {

        private SportRule sportRule1;
        private SportRule sportRule2;

        @Autowired
        public ReadRules(@Qualifier("bascetball") SportRule sportRule1,
                           @Qualifier("soccer") SportRule sportRule2) {
            this.sportRule1 = sportRule1;
            this.sportRule2 = sportRule2;
        }

        public String AllSports(){
            return "Sports : "+sportRule1.getYourSport()+" " +sportRule2.getYourSport();
        }


        public String readAllRules() {
            return "Rule: " + sportRule1.getRule() + "\n" + sportRule2.getRule();
        }

    }


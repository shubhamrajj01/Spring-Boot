package com.luv2code.util;

import com.luv2code.util.Coach;
import org.springframework.stereotype.Component;

@Component // @Component annotation makes the class available for the dependency injecion
public class CricketCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes!!!!";
    }
}

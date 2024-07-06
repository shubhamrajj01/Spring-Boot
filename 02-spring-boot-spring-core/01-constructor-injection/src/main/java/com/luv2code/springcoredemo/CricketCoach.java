package com.luv2code.springcoredemo;

import org.springframework.stereotype.Component;

@Component // @Component annotation makes the class available for the dependency injecion
public class CricketCoach implements Coach{

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes!!!!";
    }
}

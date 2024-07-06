package com.luv2code.springcoredemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class BaseballCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Speed 30 minutes in batting practice";
    }
}

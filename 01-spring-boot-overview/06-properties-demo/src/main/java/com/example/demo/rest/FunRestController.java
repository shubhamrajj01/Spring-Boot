package com.example.demo.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    // inject property for: coach.name and team.name

    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    // expose the endpoint for "teamInfo"

    @GetMapping("/teaminfo")
    public String getTeamInfo(){
        return "Coach: " + coachName + ", Team name: " + teamName;
    }

    // expose "/" that returns "Hello World"

    @GetMapping("")
    public String sayHello(){
        return "Hello World!";

    }
    // expose a new endpoint for "about"
    @GetMapping("/About")
    public String About(){
        return "This is our About section";
    }

    //expose a new endpoint for "workout"
    @GetMapping("/workout")
    public String getDailyWorkout(){
        return "Run 5km daily!";
    }

    @GetMapping("/info")
    public String demo(){
        return "Prakhar ko demo de rhe hai";
    }
}

package com.cydeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mentor")
public class MentorController {


    @RequestMapping("/register") //locathost:8080/mentor/register
    public String register() {

        return "mentor/mentor-register";
    }

    @RequestMapping("/mentor/drop") //locathost:8080/mentor/drop
    public String drop(){

        return "mentor/register";

    }


}

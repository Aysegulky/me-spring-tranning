package com.cydeo.controller;

import com.cydeo.bootstrap.DataGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/student")
@Controller
public class StudentController {

    @RequestMapping("/register") //locathost:8080/student/register
    public String register(Model model){

        model.addAttribute("students", DataGenerator.createStudent());

        return "student/register";

    }

    @RequestMapping("/drop") //locathost:8080/student/drop
    public String drop(){

        return "student/register";

    }

    @RequestMapping("/welcome") //locathost:8080/student/welcome?name=Ozzy
    public String welcome(){


        return "student/welcome";

    }
}

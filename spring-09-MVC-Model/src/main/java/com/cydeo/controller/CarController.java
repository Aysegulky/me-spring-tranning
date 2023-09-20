package com.cydeo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CarController {

    //localhost:8080/info?make=Honda
    @RequestMapping("/info")
    public String CarInfo(@RequestParam String make, Model model) {

        model.addAttribute("make", make);

        return "car/car-info";
    }

    //localhost:8080/info2 (Volvo)
    @RequestMapping("/info2")
    public String CarInfo2(@RequestParam (value = "make", required = false, defaultValue = "Volvo") String make, Model model){

            model.addAttribute("make", make);

        return "car/car-info";
    }

    //localhost:8080/info3?make=Volvo&year=2015
    @RequestMapping("/info3")
    public String CarInfo3(@RequestParam String make, @RequestParam int year, Model model){

        model.addAttribute("make", make);
        model.addAttribute("year", year);

        return "car/car-info";
    }

    //localhost:8080/info/Volvo/2015
    @RequestMapping("/info/{make}/{year}")
    public String getCarInfo(@PathVariable String make,@PathVariable int year){

        System.out.println(make);
        System.out.println(year);

        return "car/car-info";
    }



}

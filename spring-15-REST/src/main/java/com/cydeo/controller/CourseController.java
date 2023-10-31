package com.cydeo.controller;

import com.cydeo.dto.CourseDTO;
import com.cydeo.service.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //@Controller + @ResponseBody //***2*** ////@RequestMapping("/courses") ==>error
@RequestMapping("/courses/api/v1")
public class CourseController { //***P1***

    private final CourseService courseService;//***3***

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<CourseDTO> getAllCourses(){ //***1*** postman ==> GET-> localhost:8080/course

        //return all courses
        return courseService.getCourses(); //***4***
    }

    @GetMapping("{id}")//***5***
    public CourseDTO getCourseById(@PathVariable("id") long courseId){
        return courseService.getCourseById(courseId);  //return meaning===> show me JSON // postman ==> GET-> localhost:8080/course/3 (id:3 olanlari listeler
    }

    @GetMapping("category/{name}")//***6***
    public List<CourseDTO> getCourseByCategory(@PathVariable("name") String category){ // postman ==> GET-> localhost:8080/course/category/Spring-Java...
        return courseService.getCoursesByCategory(category);

    }

    @PostMapping //***7***
    public CourseDTO createCourse(@RequestBody CourseDTO course){  //Postman ==> POST -> Body -> raw -> JSON -> yeni kullanici bilgileri ekleniyor

        return courseService.createCourse(course);
    }

    @PutMapping("{id}")//***8***
    public void updateCourse(@PathVariable("id") long courseId,@RequestBody CourseDTO course){ // postman ==> PUT-> localhost:8080/course/3
        courseService.updateCourse(courseId,course);
    }

    @DeleteMapping("{id}")//***9***
    public void deleteCourseById(@PathVariable("id") long courseId){  // postman ==> DELETE-> localhost:8080/course/3
        courseService.deleteCourseById(courseId);

    }





}

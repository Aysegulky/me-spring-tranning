package com.cydeo.controller;

import com.cydeo.dto.CourseDTO;
import com.cydeo.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//***1***
@RequestMapping("/courses/api/v2")//***2*** //@RequestMapping("/courses") ==>error
public class CourseController_ResponseEntity { //***P2***

    private final CourseService courseService;  //***3***

    public CourseController_ResponseEntity(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<List<CourseDTO>> getAllCourses(){ //***4***
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .header("Version","Cydeo.V2")
                .header("Operation","Get List")
                .body(courseService.getCourses()); //postman ==> GET-> localhost:8080/course/api/v2 -->status:202
    }

    @GetMapping("{id}")
    public ResponseEntity<CourseDTO> getCourseById(@PathVariable("id") long courseId){ //***5***
        return ResponseEntity.ok(courseService.getCourseById(courseId)); //GET-> localhost:8080/course/api/v2/1
    }

    @GetMapping("category/{name}") //***6***
    public ResponseEntity<List<CourseDTO>> getCourseByCategory(@PathVariable("name") String category){
        return ResponseEntity.ok(courseService.getCoursesByCategory(category));//GET-> localhost:8080/course/api/v2/category/Spring
    }

    @PostMapping//***7***
    public ResponseEntity<CourseDTO> createCourse(@RequestBody CourseDTO course){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("Operation","Create")
                .body(courseService.createCourse(course)); //POST-> localhost:8080/course/api/v2

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCourseById(@PathVariable("id") Long courseId){
        courseService.deleteCourseById(courseId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> updateCourse(@PathVariable("id") Long courseId,@RequestBody CourseDTO course){
        courseService.updateCourse(courseId,course);
        return ResponseEntity.noContent().build();
    }

}

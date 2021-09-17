package dev.patika.hw04.controller;


import dev.patika.hw04.dto.CourseDTO;
import dev.patika.hw04.model.Course;
import dev.patika.hw04.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CourseController {
    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/courses")
    public ResponseEntity<List<Course>> findAll(){
        return new ResponseEntity<>(courseService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/save-course")
    public ResponseEntity saveCourse(@RequestBody CourseDTO courseDTO) {
        Optional<Course> resultOptional = courseService.save(courseDTO);
        if (resultOptional.isPresent()) {
            return new ResponseEntity(resultOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping(value = "/courses/{id}")
    public void deleteCourseById(@PathVariable int id){
        courseService.deleteById(id);
    }

    @GetMapping("/courses/{id}")
    public Course findCourseById(@PathVariable int id){
        return  courseService.findById(id);
    }

    @PutMapping("/courses")
    public Course updateCourse(@RequestBody Course course){
        return   courseService.updateOnDatabase(course);
    }
    /*
    @GetMapping("/courses/findByName/{name}")
    public List<Course> getCoursesWithName(@PathVariable String name){
        return courseService.getCoursesWithName(name);
    }

    @GetMapping("/courses/findById/{id}")
    public List<Course> getCourseWithId(@PathVariable int id){
        return courseService.getCoursesWithId(id);
}
     */
    }


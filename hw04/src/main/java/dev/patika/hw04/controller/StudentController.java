package dev.patika.hw04.controller;


import dev.patika.hw04.model.Instructor;
import dev.patika.hw04.model.Student;
import dev.patika.hw04.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> findAll(){
        return new ResponseEntity<>(studentService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/students")
    public Student saveStudent(@RequestBody Student student){
        return studentService.save(student);
    }

    @DeleteMapping(value = "/students/{id}")
    public void deleteStudentById(@PathVariable int id){
        studentService.deleteById(id);
    }
    @GetMapping("/students/{id}")
    public Student findStudentById(@PathVariable int id){
        return  studentService.findById(id);
    }

    @PutMapping("/students")
    public Student updateStudent(@RequestBody Student student, @PathVariable int id){
       return studentService.updateOnDatabase(student);
    }
    /*
    @GetMapping("/students/findByName/{name}")
    public List<Student> getStudentsWithName(@PathVariable String name){
        return studentService.getStudentsWithName(name);
    }

    @GetMapping("/students/findById/{id}")
    public List<Student> getInstructorsWithId(@PathVariable int id){
        return studentService.getStudentsWithId(id);
    }


     */

}

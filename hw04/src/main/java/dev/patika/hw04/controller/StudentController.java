package dev.patika.hw04.controller;


import dev.patika.hw04.dto.StudentDTO;
import dev.patika.hw04.model.Instructor;
import dev.patika.hw04.model.Student;
import dev.patika.hw04.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> findAll(){
        return new ResponseEntity<>(studentService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/students/save-students")
    public ResponseEntity<Student> saveStudent(@RequestBody StudentDTO studentDTO) {
        Optional<Student> resultOptional = studentService.saveStudent(studentDTO);

        if (resultOptional.isPresent()) {
            return new ResponseEntity<>(resultOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
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

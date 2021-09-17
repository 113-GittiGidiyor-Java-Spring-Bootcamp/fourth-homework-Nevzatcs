package dev.patika.hw04.controller;


import dev.patika.hw04.dto.InstructorDTO;
import dev.patika.hw04.model.Course;
import dev.patika.hw04.model.Instructor;
import dev.patika.hw04.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")

public class InstructorController {
    InstructorService instructorService;

    @Autowired
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping("/instructors")
    public ResponseEntity<List<Instructor>> findAll(){
        return new ResponseEntity<>(instructorService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/instructors/save-instructor")
    public ResponseEntity<Instructor> saveInstructor(@RequestBody InstructorDTO instructorDTO) {

        Optional<Instructor> resultOptional = instructorService.saveInstructor(instructorDTO);
        if (resultOptional.isPresent()) {
            return new ResponseEntity<>(resultOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping(value = "/instructors/{id}")
    public void deleteInstructorById(@PathVariable int id){
        instructorService.deleteById(id);
    }

    @GetMapping("/instructors/{id}")
    public Instructor findInstructorById(@PathVariable int id){
        return  instructorService.findById(id);
    }

    @PutMapping("/instructors")
    public Instructor updateCourse(@RequestBody Instructor instructor){
        return   instructorService.updateOnDatabase(instructor);
    }
    /*
    @GetMapping("/instructors/findByName/{name}")
    public List<Instructor> getInstructorsWithName(@PathVariable String name){
        return instructorService.getInstructorsWithName(name);
    }

    @GetMapping("/instructors/findById/{id}")
    public List<Instructor> getInstructorsWithId(@PathVariable int id){
        return instructorService.getInstructorsWithId(id);
    }


     */

}

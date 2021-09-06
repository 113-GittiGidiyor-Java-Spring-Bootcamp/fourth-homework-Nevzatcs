package dev.patika.hw04.repository;


import dev.patika.hw04.model.Course;
import dev.patika.hw04.model.Instructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstructorRepository extends CrudRepository<Instructor,Integer> {
    List<Instructor> findByName(String s);
    List<Instructor> findInstructorById(int id);
}

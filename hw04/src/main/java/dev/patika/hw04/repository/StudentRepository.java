package dev.patika.hw04.repository;


import dev.patika.hw04.model.Instructor;
import dev.patika.hw04.model.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {

    List<Student> findStudentByS_name(String s);
    List<Student> findStudentById(int id);


}

package dev.patika.hw04.repository;


import dev.patika.hw04.model.Course;
import dev.patika.hw04.model.Instructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstructorRepository extends CrudRepository<Instructor,Long> {
    //List<Instructor> findByName(String s);
    //List<Instructor> findInstructorById(int id);

    @Query("SELECT CASE WHEN COUNT(i) > 0 THEN TRUE ELSE FALSE END FROM Instructor i WHERE i.phoneNumber = ?1")
    boolean selectExistsId(String phoneNumber);
}

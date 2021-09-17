package dev.patika.hw04.repository;


import dev.patika.hw04.model.Course;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends CrudRepository<Course,Long> {
    //List<Course> findByCourseName(String s);
    //List<Course> findCourseById(long id);

    @Query("SELECT " +
            "  CASE " +
            "   WHEN " +
            "       COUNT(c)>0 " +
            "   THEN " +
            "       TRUE " +
            "   ELSE " +
            "       FALSE " +
            "   END " +
            "FROM Course c " +
            "WHERE c.courseCode = ?1")
    boolean selectExistsCourse(int id);
}

package dev.patika.hw04.service;


import dev.patika.hw04.dto.CourseDTO;
import dev.patika.hw04.exceptions.CourseIsAlreadyExistsException;
import dev.patika.hw04.model.Course;
import dev.patika.hw04.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseService implements BaseService<Course>{
    private final CourseRepository courseRepository;
    private final Course courseMapper;
    @Override
    public List<Course> findAll() {
        List<Course> courseList = new ArrayList<>();
        Iterable<Course> employeeIter = courseRepository.findAll();
        employeeIter.iterator().forEachRemaining(courseList::add);
        return courseList;
    }

    @Override
    @Transactional(readOnly = true)
    public Course findById(int id) {
        return courseRepository.findById(id).get();
    }

    @Override
    public Course save(Course object) {
        return null;
    }


    @Transactional
    public Optional<Course> save(CourseDTO courseDTO) {
        boolean isExists = courseRepository.selectExistsCourse(courseDTO.getId());
        if(isExists){
            throw new CourseIsAlreadyExistsException("Course with Id : " + courseDTO.getId() + " is already exists!");
        }
        Course course =courseMapper.mapFromCourseDTOtoCourse(courseDTO);


        return Optional.of(courseRepository.save(course));
      //  return  courseRepository.save(course);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        courseRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Course updateOnDatabase(Course course) {
        return  courseRepository.save(course);
    }
    @Transactional
    public List<Course> getCoursesWithName(String name) {
        return courseRepository.findByCourseName(name);
    }
     @Transactional
    public List<Course> getCoursesWithId(int id) {
        return courseRepository.findCourseById(id);
    }
}

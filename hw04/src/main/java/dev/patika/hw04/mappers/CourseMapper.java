package dev.patika.hw04.mappers;

import dev.patika.hw04.dto.CourseDTO;
import dev.patika.hw04.model.Course;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class CourseMapper {
    public abstract Course mapFromCourseDTOtoCourse(CourseDTO courseDTO);
    public abstract CourseDTO mapFromCoursetoCourseDTO(Course course);
}

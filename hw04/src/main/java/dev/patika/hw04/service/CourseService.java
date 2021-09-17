package dev.patika.hw04.service;


import dev.patika.hw04.dto.CourseDTO;
import dev.patika.hw04.exceptions.CourseIsAlreadyExistsException;
import dev.patika.hw04.mappers.CourseMapper;
import dev.patika.hw04.model.Course;
import dev.patika.hw04.model.ExceptionLogger;
import dev.patika.hw04.model.TransactionLogger;
import dev.patika.hw04.model.enumaration.ExceptionType;
import dev.patika.hw04.model.enumaration.TransactionType;
import dev.patika.hw04.repository.CourseRepository;
import dev.patika.hw04.repository.ExceptionLoggerRepository;
import dev.patika.hw04.repository.TransactionLoggerRepository;
import dev.patika.hw04.util.ClientRequestInfo;
import dev.patika.hw04.util.ErrorMessageConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    @Autowired
    private ClientRequestInfo clientRequestInfo;
    @Autowired
    private TransactionLoggerRepository transactionLoggerRepository;
    @Autowired
    private ExceptionLoggerRepository exceptionLoggerRepository;


    //@Override
    @Transactional
    public List<Course> findAll() {
        List<Course> courseList = new ArrayList<>();
        Iterable<Course> employeeIter = courseRepository.findAll();
        employeeIter.iterator().forEachRemaining(courseList::add);
        return courseList;
    }

    //@Override
    @Transactional(readOnly = true)
    public Course findById(long id) {
        return courseRepository.findById(id).get();
    }




    @Transactional
    public Optional<Course> save(CourseDTO courseDTO) {

        boolean isExists = courseRepository.selectExistsCourse(courseDTO.getCourseCode());
        if(isExists){
            throw new CourseIsAlreadyExistsException(courseDTO.getCourseName() + " course with code : " + courseDTO.getCourseCode() + " is already exist");

        }


        Course course =courseMapper.mapFromCourseDTOtoCourse(courseDTO);

        this.saveTransactionToDatabase(course,courseDTO.getCourseCode(), TransactionType.ADD_COURSE);
        this.saveExceptionTransactionToDatabase(course,courseDTO.getId(), 400, ErrorMessageConstants.DUPLICATE_COURSE ,ExceptionType.CourseIsAlreadyExistsException);
        return Optional.of(courseRepository.save(course));
      //  return  courseRepository.save(course);
    }

    
    @Transactional
    public void deleteById(long id) {
        courseRepository.deleteById(id);
    }


    @Transactional
    public Course updateOnDatabase(Course course) {
        return  courseRepository.save(course);
    }

    private void saveTransactionToDatabase(Course course, int courseCode, TransactionType transactionType) {
        TransactionLogger transactionLogger = new TransactionLogger();
        transactionLogger.setCourseCode(courseCode);
        transactionLogger.setTransactionDataTime(LocalDateTime.now());
        transactionLogger.setClientUrl(clientRequestInfo.getClientUrl());
        transactionLogger.setClientIpAddress(clientRequestInfo.getClientIpAddress());
        transactionLogger.setSessionActivityId(clientRequestInfo.getSessionActivityId());
        transactionLogger.setTransactionType(transactionType);

        this.transactionLoggerRepository.save(transactionLogger);
    }
    private void saveExceptionTransactionToDatabase(Course course, long id,int status, String message, ExceptionType exceptionType) {
        ExceptionLogger exceptionLogger = new ExceptionLogger();

        exceptionLogger.setId(id);
        exceptionLogger.setStatus(status);
        exceptionLogger.setMessage(message);
        exceptionLogger.setExceptionDataTime(LocalDateTime.now());
        exceptionLogger.setClientUrl(clientRequestInfo.getClientUrl());
        exceptionLogger.setClientIpAddress(clientRequestInfo.getClientIpAddress());
        exceptionLogger.setSessionActivityId(clientRequestInfo.getSessionActivityId());
        exceptionLogger.setExceptionType(exceptionType);

        this.exceptionLoggerRepository.save(exceptionLogger);
    }
    /*
    @Transactional
    public List<Course> getCoursesWithName(String name) {
        return courseRepository;
    }
     @Transactional
    public List<Course> getCoursesWithId(int id) {
        return courseRepository.findCourseById(id);
    }

     */
}

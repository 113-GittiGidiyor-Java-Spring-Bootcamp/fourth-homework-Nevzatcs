package dev.patika.hw04.service;


import dev.patika.hw04.dto.StudentDTO;
import dev.patika.hw04.mappers.StudentMapper;
import dev.patika.hw04.model.ExceptionLogger;
import dev.patika.hw04.model.Student;
import dev.patika.hw04.model.enumaration.ExceptionType;
import dev.patika.hw04.repository.ExceptionLoggerRepository;
import dev.patika.hw04.repository.StudentRepository;
import dev.patika.hw04.repository.TransactionLoggerRepository;
import dev.patika.hw04.util.ClientRequestInfo;
import dev.patika.hw04.util.ErrorMessageConstants;
import dev.patika.hw04.util.StudentValidatorUtil;
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
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    @Autowired
    private ClientRequestInfo clientRequestInfo;
    @Autowired
    private TransactionLoggerRepository transactionLoggerRepository;
    @Autowired
    private ExceptionLoggerRepository exceptionLoggerRepository;
/*
    @Autowired
    public StudentService(@Qualifier("studentDAOJPA") StudentDAO studentStudentDAO) {
        this.studentStudentDAO = studentStudentDAO;
    }


 */
    //@Override
    @Transactional
    public List<Student> findAll() {
        List<Student> stuList = new ArrayList<>();
        Iterable<Student> studentIter = studentRepository.findAll();
        studentIter.iterator().forEachRemaining(stuList::add);
        return stuList;
    }

    //@Override
    @Transactional(readOnly = true)
    public Student findById(long id) {
        return  studentRepository.findById(id).get();
    }

    //@Override
    @Transactional
    public Optional<Student> saveStudent(StudentDTO studentDTO) {
        validateRequest(studentDTO);
        Student student=studentMapper.mapFromStudentDTOtoStudent(studentDTO);
        this.saveExceptionTransactionToDatabase(student, studentDTO.getId(),400,(ErrorMessageConstants.STUDENT_AGE)  , ExceptionType.StudentAgeNotValidException);
        return Optional.of(studentRepository.save(student));
    }

    private void validateRequest(StudentDTO studentDTO) {
        StudentValidatorUtil.validateStudentAge(studentDTO.getS_birthDate());
    }


    //@Override
    @Transactional
    public void deleteById(long id) {
        studentRepository.deleteById(id);
    }

    //@Override
    public Student updateOnDatabase(Student student) {
        return (Student) studentRepository.save(student);
    }

    private void saveExceptionTransactionToDatabase(Student student, long id, int status, String message, ExceptionType exceptionType) {
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
    public List<Student> getStudentsWithName(String name) {
        return studentRepository.findStudentByS_name(name);
    }

    @Transactional
    public List<Student> getStudentsWithId(int id) {
        return studentRepository.findStudentById(id);
    }

     */
}

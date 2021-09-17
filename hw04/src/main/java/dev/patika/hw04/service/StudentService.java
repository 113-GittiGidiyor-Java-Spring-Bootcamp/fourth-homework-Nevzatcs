package dev.patika.hw04.service;


import dev.patika.hw04.dto.StudentDTO;
import dev.patika.hw04.mappers.StudentMapper;
import dev.patika.hw04.model.Student;
import dev.patika.hw04.repository.StudentRepository;
import dev.patika.hw04.util.StudentValidatorUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
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

package dev.patika.hw04.service;


import dev.patika.hw04.model.Instructor;
import dev.patika.hw04.model.Student;
import dev.patika.hw04.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService implements BaseService<Student> {

    private final StudentRepository studentRepository;
/*
    @Autowired
    public StudentService(@Qualifier("studentDAOJPA") StudentDAO studentStudentDAO) {
        this.studentStudentDAO = studentStudentDAO;
    }


 */
    @Override
    public List<Student> findAll() {
        List<Student> stuList = new ArrayList<>();
        Iterable<Student> studentIter = studentRepository.findAll();
        studentIter.iterator().forEachRemaining(stuList::add);
        return stuList;
    }

    @Override
    @Transactional(readOnly = true)
    public Student findById(int id) {
        return (Student) studentRepository.findById(id).get();
    }

    @Override
    @Transactional
    public Student save(Student student) {
        return (Student) studentRepository.save(student);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        studentRepository.deleteById(id);
    }

    @Override
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

package dev.patika.hw04.service;


import dev.patika.hw04.model.Course;
import dev.patika.hw04.model.Instructor;
import dev.patika.hw04.repository.InstructorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InstructorService implements BaseService<Instructor> {

    private final InstructorRepository instructorRepository;

    /*
        @Autowired
        public InstructorService(@Qualifier("instructorDAOJPA")InstructorDAO instructorInstructorDAO) {
            this.instructorInstructorDAO = instructorInstructorDAO;
        }


     */
    @Override
    public List<Instructor> findAll() {
        List<Instructor> insList = new ArrayList<>();
        Iterable<Instructor> employeeIter = instructorRepository.findAll();
        employeeIter.iterator().forEachRemaining(insList::add);
        return insList;
    }

    @Override
    @Transactional(readOnly = true)
    public Instructor findById(int id) {
        return (Instructor) instructorRepository.findById(id).get();
    }

    @Override
    @Transactional
    public Instructor save(Instructor instructor) {
        return (Instructor) instructorRepository.save(instructor);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        instructorRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Instructor updateOnDatabase(Instructor instructor) {
        return (Instructor) instructorRepository.save(instructor);
    }

    @Transactional
    public List<Instructor> getInstructorsWithName(String name) {
        return instructorRepository.findByName(name);
    }

    @Transactional
    public List<Instructor> getInstructorsWithId(int id) {
        return instructorRepository.findInstructorById(id);
    }
}
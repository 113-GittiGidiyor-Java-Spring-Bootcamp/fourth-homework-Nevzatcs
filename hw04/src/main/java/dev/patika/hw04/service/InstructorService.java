package dev.patika.hw04.service;


import dev.patika.hw04.dto.InstructorDTO;
import dev.patika.hw04.exceptions.InstructorAlreadyExistsException;
import dev.patika.hw04.mappers.InstructorMapper;
import dev.patika.hw04.model.Instructor;
import dev.patika.hw04.repository.InstructorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InstructorService {

    private final InstructorRepository instructorRepository;
    private final InstructorMapper instructorMapper;

    /*
        @Autowired
        public InstructorService(@Qualifier("instructorDAOJPA")InstructorDAO instructorInstructorDAO) {
            this.instructorInstructorDAO = instructorInstructorDAO;
        }


     */

    @Transactional
    public List<Instructor> findAll() {
        List<Instructor> insList = new ArrayList<>();
        Iterable<Instructor> employeeIter = instructorRepository.findAll();
        employeeIter.iterator().forEachRemaining(insList::add);
        return insList;
    }


    @Transactional(readOnly = true)
    public Instructor findById(long id) {
        return (Instructor) instructorRepository.findById(id).get();
    }


    @Transactional
    public Optional<Instructor> saveInstructor(InstructorDTO instructorDTO) {

        boolean isExists = instructorRepository.selectExistsId(instructorDTO.getPhoneNumber());
        if (isExists) {
            throw new InstructorAlreadyExistsException("Instructor is already exists !");
        }

        Instructor instructor = instructorMapper.mapFromInstructorDTOtoInstructor(instructorDTO);
        return Optional.of(instructorRepository.save(instructor));
    }

    @Transactional
    public void deleteById(long id) {
        instructorRepository.deleteById(id);
    }


    @Transactional
    public Instructor updateOnDatabase(Instructor instructor) {
        return (Instructor) instructorRepository.save(instructor);
    }
    /*
    @Transactional
    public List<Instructor> getInstructorsWithName(String name) {
        return instructorRepository.findByName(name);
    }

    @Transactional
    public List<Instructor> getInstructorsWithId(int id) {
        return instructorRepository.findInstructorById(id);
    }

     */
}
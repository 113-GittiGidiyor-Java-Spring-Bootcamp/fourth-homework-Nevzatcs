package dev.patika.hw04.service;


import dev.patika.hw04.dto.InstructorDTO;
import dev.patika.hw04.exceptions.InstructorAlreadyExistsException;
import dev.patika.hw04.mappers.InstructorMapper;
import dev.patika.hw04.model.ExceptionLogger;
import dev.patika.hw04.model.Instructor;
import dev.patika.hw04.model.TransactionLogger;
import dev.patika.hw04.model.enumaration.ExceptionType;
import dev.patika.hw04.model.enumaration.TransactionType;
import dev.patika.hw04.repository.ExceptionLoggerRepository;
import dev.patika.hw04.repository.InstructorRepository;
import dev.patika.hw04.repository.TransactionLoggerRepository;
import dev.patika.hw04.util.ClientRequestInfo;
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
public class InstructorService {

    private final InstructorRepository instructorRepository;
    private final InstructorMapper instructorMapper;

    @Autowired
    private ClientRequestInfo clientRequestInfo;
    @Autowired
    private TransactionLoggerRepository transactionLoggerRepository;
    @Autowired
    private ExceptionLoggerRepository exceptionLoggerRepository;

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
        this.saveTransactionToDatabase(instructor,instructorDTO.getPhoneNumber(), TransactionType.ADD_INSTRUCTOR);
        this.saveExceptionTransactionToDatabase(instructor, instructorDTO.getId(), 400,("Instructor with ID:  " + instructorDTO.getId() + "is already exists !")  , ExceptionType.InstructorAlreadyExistsException);
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

    private void saveTransactionToDatabase(Instructor instructor , String phoneNumber , TransactionType transactionType) {
        TransactionLogger transactionLogger = new TransactionLogger();
        transactionLogger.setPhoneNumber(phoneNumber);
        transactionLogger.setTransactionDataTime(LocalDateTime.now());
        transactionLogger.setClientUrl(clientRequestInfo.getClientUrl());
        transactionLogger.setClientIpAddress(clientRequestInfo.getClientIpAddress());
        transactionLogger.setSessionActivityId(clientRequestInfo.getSessionActivityId());
        transactionLogger.setTransactionType(transactionType);

        this.transactionLoggerRepository.save(transactionLogger);
    }

    private void saveExceptionTransactionToDatabase(Instructor instructor, long id,int status, String message, ExceptionType exceptionType) {
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
    public List<Instructor> getInstructorsWithName(String name) {
        return instructorRepository.findByName(name);
    }

    @Transactional
    public List<Instructor> getInstructorsWithId(int id) {
        return instructorRepository.findInstructorById(id);
    }

     */
}
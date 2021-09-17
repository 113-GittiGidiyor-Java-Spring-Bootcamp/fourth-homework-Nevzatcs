package dev.patika.hw04.repository;

import dev.patika.hw04.model.ExceptionLogger;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ExceptionLoggerRepository extends PagingAndSortingRepository<ExceptionLogger, Long> {
}
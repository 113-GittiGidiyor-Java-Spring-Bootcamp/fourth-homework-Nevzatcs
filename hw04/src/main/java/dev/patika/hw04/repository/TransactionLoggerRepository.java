package dev.patika.hw04.repository;

import dev.patika.hw04.model.TransactionLogger;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionLoggerRepository extends PagingAndSortingRepository<TransactionLogger, Long> {
}
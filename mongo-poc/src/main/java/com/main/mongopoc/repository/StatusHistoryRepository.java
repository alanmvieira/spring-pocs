package com.main.mongopoc.repository;

import com.main.mongopoc.domain.StatusHistory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.time.LocalDate;

@EnableTransactionManagement
public interface StatusHistoryRepository extends MongoRepository<StatusHistory, String> {

    Long countByDate(LocalDate date);

}

package com.main.mongopoc.service;

import com.main.mongopoc.MongoPocApplication;
import com.main.mongopoc.domain.StatusHistory;
import com.main.mongopoc.repository.StatusHistoryRepository;
import com.mongodb.client.result.DeleteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

@Service
public class StatusHistoryService {

    @Autowired
    private StatusHistoryRepository repository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public StatusHistoryService(StatusHistoryRepository repository, MongoTemplate mongoTemplate) {
        this.repository = repository;
        this.mongoTemplate = mongoTemplate;
    }

    public void inserirDados() {

        IntStream.range(0,10).forEach( i -> {
            StatusHistory statusHistory = new StatusHistory();

            String uuid = UUID.randomUUID().toString();

            statusHistory.setDateTime(LocalDateTime.now().minusMonths(1));
            statusHistory.setDate(LocalDate.now());
            statusHistory.setName(uuid);

            repository.save(statusHistory);
        });

        IntStream.range(0,10).forEach( i -> {
            StatusHistory statusHistory = new StatusHistory();

            String uuid = UUID.randomUUID().toString();

            statusHistory.setDateTime(LocalDateTime.now().minusMonths(2));
            statusHistory.setDate(LocalDate.now());
            statusHistory.setName(uuid);

            repository.save(statusHistory);
        });

        IntStream.range(0,10).forEach( i -> {
            StatusHistory statusHistory = new StatusHistory();

            String uuid = UUID.randomUUID().toString();

            statusHistory.setDateTime(LocalDateTime.now().minusMonths(3));
            statusHistory.setDate(LocalDate.now());
            statusHistory.setName(uuid);

            repository.save(statusHistory);
        });
    }

    public void listarTodos(){
        List<StatusHistory> all = repository.findAll();
        all.forEach(statusHistory -> System.out.println(statusHistory.getName()));
    }

    public void listarPorUUID(){
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is("ca97c2f8-d83d-447a-9b93-067651484f8f"));
        List<StatusHistory> statusHistoys = mongoTemplate.find(query, StatusHistory.class);
        statusHistoys.forEach(statusHistory -> System.out.println(statusHistory.getName()));
    }

    public void listarPorDataAnteriorAOntem(){
        LocalDate ontem = LocalDate.now().minusDays(1);
        Query query = new Query();

        query.addCriteria(Criteria.where("dateTime").lte(ontem));
        List<StatusHistory> statusHistoys = mongoTemplate.find(query, StatusHistory.class);

        statusHistoys.forEach(statusHistory -> System.out.println(statusHistory.getName()));
    }

    public void delete(){
        LocalDate ontem = LocalDate.now().minusDays(1);

        Query query = new Query();
        query.addCriteria(Criteria.where("dateTime").lte(ontem));
        DeleteResult remove = mongoTemplate.remove(query, StatusHistory.class);

        System.out.println(remove.getDeletedCount());
    }

}

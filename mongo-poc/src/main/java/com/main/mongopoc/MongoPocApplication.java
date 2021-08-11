package com.main.mongopoc;

import com.main.mongopoc.domain.StatusHistory;
import com.main.mongopoc.repository.StatusHistoryRepository;
import com.main.mongopoc.service.StatusHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@SpringBootApplication
@ComponentScan({"com"})
@EnableMongoRepositories("com")
public class MongoPocApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext run = SpringApplication.run(MongoPocApplication.class, args);

		StatusHistoryService service = run.getBean(StatusHistoryService.class);
		service.inserirDados();
//		service.listarTodos();
//		service.listarPorUUID();
//		service.listarPorDataAnteriorAOntem();
//		service.delete();

	}
}

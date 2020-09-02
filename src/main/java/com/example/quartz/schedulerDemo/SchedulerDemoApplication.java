package com.example.quartz.schedulerDemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

import java.time.LocalDateTime;

import static org.springframework.http.MediaType.*;
import static org.springframework.web.servlet.function.RequestPredicates.*;
import static org.springframework.web.servlet.function.RouterFunctions.route;

@SpringBootApplication
public class SchedulerDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchedulerDemoApplication.class, args);
	}


	@Bean
	public RouterFunction routes(RecordRepository repo, @Value("${scheduler.uniqueid}") String instanceId) {
		SchedulingHandler handler = new SchedulingHandler(repo, instanceId);
		return route()
				.GET("/allrecords", accept(APPLICATION_JSON), handler::handleGetAll )
				.POST("/makeRecord", accept(APPLICATION_JSON), handler::makeRecord )
				.build();
	}


	public class SchedulingHandler {
		private RecordRepository repository;
private String instanceId;
		public SchedulingHandler(RecordRepository repository, String instanceId) {
			this.repository = repository;
			this.instanceId = instanceId;
		}

		public ServerResponse handleGetAll(ServerRequest request) {
			return ServerResponse.ok()
					.body(repository.findAll().stream().map(RecordResponseModel::new));
		}

		public ServerResponse makeRecord(ServerRequest serverRequest) {
			RecordEntity ent = new RecordEntity();
			ent.setAgentId( instanceId);
			ent.setJobtime(LocalDateTime.now());
			repository.save(ent);
			return ServerResponse.ok().build();
		}
	}


}

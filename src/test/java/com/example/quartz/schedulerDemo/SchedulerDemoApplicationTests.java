package com.example.quartz.schedulerDemo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.time.LocalDateTime;

@SpringBootTest
class SchedulerDemoApplicationTests {


	@Autowired
	DataSource dataSource;

	@Autowired
	RecordRepository repo;

	@BeforeEach
	public void setup() {
		repo.deleteAll();
//		DataSourceConfiguration d;
	}

	@Test
	void contextLoads() {
		RecordEntity ent = new RecordEntity();
		ent.setAgentId("testing");
		ent.setJobtime(LocalDateTime.now());
		repo.save(ent);

		Assertions.assertThat(repo.count()).isEqualTo(1);
	}

}

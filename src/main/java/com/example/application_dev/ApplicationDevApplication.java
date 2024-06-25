package com.example.application_dev;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class ApplicationDevApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(com.example.application_dev.ApplicationDevApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ApplicationDevApplication.class, args);
	}
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Override
	public void run(String... strings) throws Exception {

//		log.info("Creating tables");
//		jdbcTemplate.execute("Drop table if exists users ");
//		log.info("Drop table users");
//		jdbcTemplate.execute("Create table if not EXISTS users (user_id serial PRIMARY KEY, first_name varchar(35), last_name varchar (35)) ");
//		log.info("Create table users");


	}

}

package com.example;

import com.example.entity.Skill;
import com.example.respositories.SkillRespository;
import com.example.services.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.sql.DataSource;

@SpringBootApplication
public class Application implements CommandLineRunner {
	@Autowired
	private SkillService skillService;
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		Skill skill = skillService.findById(3);
		System.out.println(skill);
	}
}

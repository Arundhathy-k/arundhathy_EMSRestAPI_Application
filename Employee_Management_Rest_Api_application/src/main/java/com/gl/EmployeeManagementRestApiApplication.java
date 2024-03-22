package com.gl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gl.dao.UserDAO;
import com.gl.entity.User;

@SpringBootApplication
public class EmployeeManagementRestApiApplication implements CommandLineRunner{

	@Autowired
	UserDAO dao;
	
	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementRestApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		dao.save(new User(1,"admin","admin","admin"));
//		dao.save(new User(2,"user","user","user"));
		
	}

}

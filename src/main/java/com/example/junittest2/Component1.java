package com.example.junittest2;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Getter
@Setter
class Component1 implements CommandLineRunner {

	//	@Autowired
//	JdbcTemplate jdbcTemplate;

	@Autowired
	User user;

	@Autowired
	//@Qualifier("bb")
	String qqq;

	@Autowired
	int iii;

	@Autowired
	List<String> list;

//	String username() {
//		return user.name;
//	}

	String f2() {
		return qqq; //str22()
	}

	String f1() {
		return f2() + " " + iii; //str22() 1
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Component1 => qqq=" + qqq + ", iii=" + iii + ", name=" + user.getName());
	}
}

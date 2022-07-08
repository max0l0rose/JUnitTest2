package com.example.junittest2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class JUnitTest2Application {

	@Bean
	String str() {
		return "Qqq";
	}

	@Bean("qqq2")
	@Order(2)
	String str2() {
		return "Qqq2";
	}

	@Order(1)
	@Bean(name = "qqq2")
	String str22() {
		return "Qqq222";
	}

	@Bean
	A aaa() {
		A a = new A();
		a.s = "Qqqq";
		return a;
	}

	public static void main(String[] args) {
		System.out.println("111111");
		SpringApplication.run(JUnitTest2Application.class, args);
		System.out.println("222222");
	}

}

@Component
class qqq implements CommandLineRunner {
//	@Autowired
//	JdbcTemplate jdbcTemplate;

	@Autowired
	@Qualifier("qqq2")
	String qqq;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("=> " + qqq);
	}
}


class A {
	public String s;
}
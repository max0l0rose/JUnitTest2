package com.example.junittest2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@SpringBootApplication
public class JUnitTest2Application {

	@Bean
	A aaa() {
		A a = new A();
		a.s = "Qqqq";
		return a;
	}

	public static void main(String[] args) {
		System.out.println("--------");
		SpringApplication.run(JUnitTest2Application.class, args);
		System.out.println("=======");
	}

}



@Configuration
class Conf2 {
	@Bean(
	)
		//@DependsOn("str22")
	int iii() {
		System.out.println("iii()");
		return 1;
	}
}



@Configuration
class Conf {
	@Bean(//"bb"
	)
	@Order(2)
	@DependsOn("iii")
	String str2() {
		System.out.println("str2()");
		return "str2()";
	}

	@Bean(//"bb"
	)
	@Order(1)
	@Primary
	String str() {
		System.out.println("str()");
		return "str";
	}

	@Bean(//"bb"
	)
	@Order(3)
	String str22() {
		System.out.println("str22()");
		return "str22()";
	}
}


@Component
class CQqq implements CommandLineRunner {

	//	@Autowired
//	JdbcTemplate jdbcTemplate;

	@Autowired
	//@Qualifier("bb")
	String qqq;

	@Autowired
	int iii;

	@Autowired
	List<String> list;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("=> " + qqq + " " + iii);
	}
}


class A {
	public String s;
}
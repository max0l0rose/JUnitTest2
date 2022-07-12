package com.example.junittest2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;

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
	String str() {
		System.out.println("str()");
		return "str()";
	}

	@Bean(//"bb"
	)
	@Order(3)
	@Primary
	String str22() {
		System.out.println("str22()");
		return "str22()";
	}
}


@Configuration
class Conf2 {
	@Bean
	User user() {
		System.out.println("user()");
		User user = new User() {{ name = "User1"; }};
		return user;
	}

	@Bean
		//@DependsOn("str22")
	int iii() {
		System.out.println("iii()");
		return 1;
	}
}



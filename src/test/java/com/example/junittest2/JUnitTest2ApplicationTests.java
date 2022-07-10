package com.example.junittest2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = {Conf.class, Conf2.class
})
class JUnitTest2ApplicationTests {

	@Bean
	@Primary
	int iii() {
		System.out.println("iiiTest()");
		return 1;
	}

	@TestConfiguration
	static class TestConfig {

//		@Bean
//		public RestTemplateBuilder restTemplateBuilder() {
//
//			return new RestTemplateBuilder()
//					.basicAuthentication("mkyong", "password")
//					.setConnectTimeout(Duration.ofSeconds(5));
//		}

		@Bean
		@Primary
		int iii() {
			System.out.println("iiiTest()");
			return 1;
		}

	}

	@Autowired
	List<String> list;

	@Test
	void contextLoads() {
	}

	@Test
	void strResultTest() {
		assertEquals("str", list.get(0));
	}

}

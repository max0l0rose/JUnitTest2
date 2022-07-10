package com.example.junittest2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {Conf.class//, Conf2.class
}
		,properties = "io.reflectoring.scheduling.enabled=true"
)

//@ActiveProfiles("test")
//@TestPropertySource(locations = "/foo.properties")

//@Import(JUnitTest2ApplicationTests.TestConfig.class)
//@ContextHierarchy({
	@ContextConfiguration(classes = JUnitTest2ApplicationTests.TestConfig.class)
//})
//@AutoConfigureMockMvc
class JUnitTest2ApplicationTests {

	//@EnableScheduling
	@ConditionalOnProperty(
			name = "io.reflectoring.scheduling.enabled",
			havingValue = "true",
			matchIfMissing = true)
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
			//@Primary
		int iii() {
			System.out.println("iiiTest()");
			return 1;
		}
	}
	//@TestConfiguration
	//@Configuration

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

package com.example.junittest2;

import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.commons.util.ReflectionUtils;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.context.annotation.*;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

//@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {Component1.class, Conf.class//, Conf2.class
}
		//,properties = "test.enabled=true"
)

@ActiveProfiles("pro1")
//@TestPropertySource(locations = "/foo.properties")

//@Import(JUnitTest2ApplicationTests.TestConfig.class)
//@ContextHierarchy({
	@ContextConfiguration(classes = JUnitTest2ApplicationTests.TestConfig.class)
//})
//@AutoConfigureMockMvc
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class JUnitTest2ApplicationTests {

	//@EnableScheduling
	@TestConfiguration
	static class TestConfig {
//		@Bean
//		public RestTemplateBuilder restTemplateBuilder() {
//
//			return new RestTemplateBuilder()
//					.basicAuthentication("mkyong", "password")
//					.setConnectTimeout(Duration.ofSeconds(5));
//		}

//		@ConditionalOnProperty(name = "test.enabled", havingValue = "true" //,matchIfMissing = false
//		)
		@Bean
			//@Primary
		int iii() {
			System.out.println("iiiTest()");
			return 2;
		}

//		@Bean
//		User userMock() {
//			System.out.println("userMock()");
//			User user = new User() {{ name = "userMock"; }};
//			return user;
//		}
	}

//	@MockBean
//	Integer i2;

	@Autowired
	List<String> list;


	@MockBean
	private static User user;// = new User();

	//@Spy
	@SpyBean
	//@Mock // mockito
	//@Autowired
	//@InjectMocks
	Component1 component1;


	@BeforeAll
	static void init() {
		when(user).thenReturn(new User());
		//when(user.getName()).thenReturn("Fake User");
		//when(component1.f2()).thenReturn("str22()mock");
	}

	@BeforeEach
	void initEach() {
		User u = new User();
		u.setName("NNNNN");
		doReturn(u).when(component1).getUser();

//		when(user.getName()).thenReturn("Fake user");
		//when(component1.f2()).thenReturn("str22()mock");
	}

	@Test void contextLoads() {
	}

	@Test void listTest() {
		assertEquals("str", list.get(0));
	}

	@Test void comp1Test() {
		assertNotNull(component1);

		//ReflectionTestUtils.setField(component1, "f2", this.f22);

		//assertEquals("str22() 2", component1.f1());
		assertEquals("NNNNN", component1.getUser().getName());
	}
}

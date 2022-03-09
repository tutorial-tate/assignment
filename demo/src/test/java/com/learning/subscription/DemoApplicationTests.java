//package com.learning.subscription;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import com.learning.subscription.model.User;
//import com.learning.subscription.repository.UserRepository;
//
//
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = Replace.NONE)
//class DemoApplicationTests {
//
//	@Autowired
//	private TestEntityManager entityManager;
//
//	@Autowired
//	private UserRepository repo;
//
//	@Test
//	void contextLoads() {
//
//	}
//
//	@Test
//	void test1() {
//		User user = new User();
//		user.setEmail("ravikumar@gmail.com");
//		user.setPassword("ravi2020");
//		user.setFirstName("Ravi");
//		user.setLastName("Kumar");  
//
//		User savedUser = repo.save(user);
//
//		User existUser = entityManager.find(User.class, savedUser.getId());
//
//		assertThat(user.getEmail()).isEqualTo(existUser.getEmail());
//
//	}
//
//}

package com.example.springsecurity;

import com.example.springsecurity.domain.User;
import com.example.springsecurity.mapper.MenuMapper;
import com.example.springsecurity.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@SpringBootTest
class SpringSecurityApplicationTests {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private MenuMapper menuMapper;

	@Test
	public void testMenuMapper(){
		List<String> list = menuMapper.selectPermsByUserId(2L);
		System.out.println(list);
	}

	@Test
	void BCryptPasswordEncoderTest() {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String password = passwordEncoder.encode("1234");
		System.out.println(password);
		System.out.println(passwordEncoder.matches("1234","$2a$10$ybgelAeCD9BoaNdt.egsBeDH22SS1H9YO0.8HzuHQ4CCr3FXqUiae"));
	}

	@Test
	public void test(){
		List<User> userList = userMapper.selectList(null);
		System.out.println(userList);
	}

}

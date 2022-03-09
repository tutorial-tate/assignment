package com.learning.subscription.service;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learning.subscription.dto.UserDTO;
import com.learning.subscription.model.User;
import com.learning.subscription.repository.UserRepository;

@Service
@Transactional
public class UserService {
	Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserRepository userRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	public User registerNewUserAccount(UserDTO userDTO) {

		User user = new User();
		BeanUtils.copyProperties(userDTO, user);

		if (!checkIfUserExist(user.getEmail())) {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			userRepository.save(user);
			return user;
		}
		return null;
	}

	public String loginUserAccount(String email, String password) {

		User user = new User();
		user = userRepository.findByEmail(email);

		if (email.equals(user.getEmail()) && passwordEncoder.matches(password, user.getPassword()))
			return "login successful";
		else
			throw new UsernameNotFoundException("User not found");

	}

	public boolean checkIfUserExist(String email) {
		if (userRepository.findByEmail(email) == null) {
			logger.info("user not present");
			return false;
		} else {
			logger.info("user is already present");
			return true;
		}
	}

}

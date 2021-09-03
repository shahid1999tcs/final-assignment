package com.spring.assessment.springassessment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	@Autowired
	IUserRepository userRepo;

	@PostMapping("/users")
	//@Transactional(rollbackFor = Exception.class)
	public void saveUser(@RequestBody User user) {
		userRepo.save(user);
	}
	
	@GetMapping("/users")
	public Iterable<User> getusers() {
		return userRepo.findAll();
	}
}

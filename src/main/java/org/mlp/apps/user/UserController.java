package org.mlp.apps.user;

import java.util.List;
import org.mlp.apps.usertype.UserType;
import org.mlp.apps.usertype.UserTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserTypeRepository userTypeRepository;
	
	@GetMapping("/user/users")
	public List<User> getAllUser() {
		return userRepository.findAll();
	}
	
	@GetMapping("/user/{id}")
	public User getOne(@PathVariable Integer id) {
		return userRepository.findById(id).get();
	}
	
	@GetMapping("/public/experts")
	public List<User> getAllExperts() {
		UserType exp = new UserType();
		exp.setId(101); //101 is the id of expert
		return userTypeRepository.findUser(exp);
	}
	
}

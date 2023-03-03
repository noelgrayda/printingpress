package com.grayda.projectportfolio.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.grayda.projectportfolio.models.LoginUser;
import com.grayda.projectportfolio.models.User;
import com.grayda.projectportfolio.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository repo;
	
	public User register(User newUser, BindingResult result) {
		Optional<User> optionalUser = repo.findByEmail(newUser.getEmail());
		if(optionalUser.isPresent()) {
			result.rejectValue("email", "Matches", "Email already exists.");
		}
		
		if(!newUser.getPassword().equals(newUser.getConfirm())) {
			result.rejectValue("confirm", "Matches", "The confirm password must match with the password");
		}
		
		if(result.hasErrors()) {
			return null;
		}
		
		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(hashed);
		
		return repo.save(newUser);
	}
	
	public User login(LoginUser newLogin, BindingResult result) {
		Optional<User> optionalUser = repo.findByEmail(newLogin.getEmail());
		
		if(!optionalUser.isPresent()) {
			result.rejectValue("email", "Matches", "The account doesn't exists");
			return null;
		}
		
		User user = optionalUser.get();
		
		if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
			result.rejectValue("password", "Matches", "Password not valid");
		}
		
		if(result.hasErrors()) {
			return null;
		}
		
		return user;
	}
	
	public User findEmail(String email) {
		Optional<User> optionalUser = repo.findByEmail(email);
		if(optionalUser.isPresent()) {
			return optionalUser.get();
		}
		return null;
	}
	
	public List<User> allUser(){
		return repo.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> optionalUser = repo.findById(id);
		if(optionalUser.isPresent()) {
			return optionalUser.get();
		}
		else {
			return null;
		}
	}
}
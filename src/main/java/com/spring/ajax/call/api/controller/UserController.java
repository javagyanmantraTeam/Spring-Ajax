package com.spring.ajax.call.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.ajax.call.api.dto.Response;
import com.spring.ajax.call.api.dto.User;
import com.spring.ajax.call.api.repository.UserRepository;

@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Response saveUser(@RequestBody User user) {
		userRepository.save(user);
		return new Response(true, "success");
	}

	@RequestMapping(value = "/getUsers", method = RequestMethod.GET)
	public List<User> getUsers() {
		return userRepository.findAll();
	}

}

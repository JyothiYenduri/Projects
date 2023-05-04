package com.twg.springboot.mydiary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twg.springboot.mydiary.entity.User;
import com.twg.springboot.mydiary.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User updateUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public void deleteUser(User user) {
		userRepository.delete(user);
	}

	@Override
	public User findById(long id) {
		return userRepository.findById(id).get();
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return userRepository.findByUsername(username);
	}

}

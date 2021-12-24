package com.TNABank.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TNABank.entity.User;
import com.TNABank.model.SignInModel;
import com.TNABank.model.UserModel;
import com.TNABank.repository.UserRepository;

@Service

public class UserService {

	@Autowired
	UserRepository userRepository;

	public User getUser(SignInModel signInModel) {
		Optional<User> userData = userRepository.findByLoginAndPassword(signInModel.getLogin(),signInModel.getPassword());

		if (userData.isPresent())

		{
			return userData.get();
		}

		return null;
	}

	public User addUser(UserModel userModel) {
		User user = new User();
		user.setLogin(userModel.getLogin());
		user.setPassword(userModel.getPassword());
		user.setFullNuame(userModel.getFullNuame());

		user = userRepository.save(user);
		return user;
	}

}

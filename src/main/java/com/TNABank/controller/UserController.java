package com.TNABank.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TNABank.model.ApiCustomResponse;
import com.TNABank.model.ErrorData;
import com.TNABank.model.SignInModel;
import com.TNABank.model.TransferModel;
import com.TNABank.model.UserModel;
import com.TNABank.entity.User;
import com.TNABank.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("/tna/ebankingService")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping(value = "/signUp")
	public ResponseEntity<?> signUp(@RequestBody UserModel userModel) {

		return new ResponseEntity<ApiCustomResponse>(new ApiCustomResponse(userService.addUser(userModel)),
				HttpStatus.OK);
	}

	@PostMapping(value = "/signIn")
	public ResponseEntity<?> signIn(@RequestBody SignInModel signInModel) {

		new ApiCustomResponse("");

		User user = userService.getUser(signInModel);
		if (user != null) {
			return new ResponseEntity<ApiCustomResponse>(new ApiCustomResponse(user), HttpStatus.OK);
		} else {
			return new ResponseEntity<ApiCustomResponse>(
					new ApiCustomResponse(new ErrorData("001", "User or password not match")), HttpStatus.BAD_REQUEST);
		}

	}

}

package com.TNABank.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.TNABank.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {

	Optional<User> findByLoginAndPassword(String login,String password);
}

package com.prodigy.Basic_task1.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import com.prodigy.Basic_task1.model.User;

public interface UserRepo {
	User saveUser(UUID uuid, User user); 		// create / update user

	List<User> findAll(); 						// read all users

	Optional<User> findById(UUID id); 			// read user by Id
	
	void deleteUser(UUID id);  				// delete user

	boolean existsByEmail(String email);  		//helper to keep more control

}

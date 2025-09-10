package com.prodigy.Basic_task1.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import com.prodigy.Basic_task1.dto.UserRequestDto;
import com.prodigy.Basic_task1.dto.UserResponseDto;
import com.prodigy.Basic_task1.exception.EmailAlreadyExistsException;
import com.prodigy.Basic_task1.exception.UserNotFoundException;
import com.prodigy.Basic_task1.model.User;
import com.prodigy.Basic_task1.repository.UserRepo;
import com.prodigy.Basic_task1.util.IdGenerator;
import com.prodigy.Basic_task1.util.UserMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
	private final UserRepo userRepo;

	// dependency injection
	public UserServiceImpl(UserRepo userRepo) {
		this.userRepo = userRepo;
	}

	@Override
	public UserResponseDto createUser(UserRequestDto request) {
		if (request == null) {
			throw new IllegalArgumentException("Request cannot be null");
		}

		if (userRepo.existsByEmail(request.getEmail().toLowerCase())) {
			log.error("Email already exists: {}", request.getEmail());
			throw new EmailAlreadyExistsException("Email already exists: " + request.getEmail());
		}

		final User user = UserMapper.toUser(request);
		user.setId(IdGenerator.generateId());
		log.info("Creating user with email: {}", request.getEmail());
		userRepo.saveUser(user.getId(), user);
		return UserMapper.toResponseDto(user);
	}

	@Override
	public List<UserResponseDto> getAllUsers() {
		final List<User> userlist = userRepo.findAll();
		if (userlist.isEmpty()) {
			log.info("No user found");
			throw new UserNotFoundException("No users found");
		}
		return userlist.stream().map(UserMapper::toResponseDto).collect(Collectors.toList());
	}

	@Override
	public UserResponseDto getUserById(UUID id) {
		if (id == null)
			throw new IllegalArgumentException("Id can not be null");

		final User user = userRepo.findById(id).orElseThrow(() -> new UserNotFoundException("User not found: " + id));
		return UserMapper.toResponseDto(user);
	}

	@Override
	public UserResponseDto updateUser(UUID id, UserRequestDto request) {
		if (id == null)
			throw new IllegalArgumentException("Id can not be null");
		
		if (request == null || request.getName() == null || request.getEmail() == null) {
			throw new IllegalArgumentException("Invalid update request");
		}

		// Find the existing user or throw an exception if not found
		final User existingUser = userRepo.findById(id)
				.orElseThrow(() -> new UserNotFoundException("User not found: " + id));

		// Update only allowed fields
		log.info("Updating user with ID: {}", id);
		existingUser.setName(request.getName());
		existingUser.setEmail(request.getEmail());
		existingUser.setAge(request.getAge());
		userRepo.saveUser(id, existingUser);
		return UserMapper.toResponseDto(existingUser);
	}

	@Override
	public void deleteUser(UUID id) {
		if (id == null)
			throw new IllegalArgumentException("Id can not be null");
		
		User existingUser = userRepo.findById(id).orElseThrow(() -> new UserNotFoundException("User not found: " + id));
		log.info("Deleting user with ID: {}", id);
		userRepo.deleteUser(id);
	}

}

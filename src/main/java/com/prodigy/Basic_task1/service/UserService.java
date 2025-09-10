package com.prodigy.Basic_task1.service;

import java.util.List;
import java.util.UUID;

import com.prodigy.Basic_task1.dto.UserRequestDto;
import com.prodigy.Basic_task1.dto.UserResponseDto;

import jakarta.validation.Valid;

public interface UserService {

	public UserResponseDto createUser(@Valid UserRequestDto request);

	public List<UserResponseDto> getAllUsers();

	public UserResponseDto getUserById(UUID id);

	public UserResponseDto updateUser(UUID id, @Valid UserRequestDto request);

	public void deleteUser(UUID id);

}

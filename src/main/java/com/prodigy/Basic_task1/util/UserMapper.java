package com.prodigy.Basic_task1.util;

import com.prodigy.Basic_task1.dto.UserRequestDto;
import com.prodigy.Basic_task1.dto.UserResponseDto;
import com.prodigy.Basic_task1.model.User;

public final class UserMapper {
	private UserMapper() {
		throw new UnsupportedOperationException("Utility class, should not be instantiated");
	}

//	UserRequestDTO to user model object
	public static User toUser(UserRequestDto reqobj) {
		User user = new User();
		user.setName(reqobj.getName());
		user.setEmail(reqobj.getEmail());
		user.setAge(reqobj.getAge());
		return user;
	}
// User model object to UserResponseDto object
	public static UserResponseDto toResponseDto(User user) {
		return new UserResponseDto(user.getId(), user.getName(), user.getEmail(), user.getAge());
	}
}

package com.prodigy.Basic_task1.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.prodigy.Basic_task1.model.User;

@Repository
public class UserRepoImpl implements UserRepo {
	private final Map<UUID, User> store = new HashMap<>();

	@Override
	public User saveUser(UUID uuid, User user) {
		store.put(uuid, user);
		return user;
	}

	@Override
	public List<User> findAll() {
		return new ArrayList<>(store.values());
	}

	@Override
	public Optional<User> findById(UUID id) {
		return Optional.ofNullable(store.get(id));
	}

	@Override
	public void deleteUser(UUID id) {
		store.remove(id);
	}

	@Override
	public boolean existsByEmail(String email) {
		if (email == null || email.isEmpty()) {
	        throw new IllegalArgumentException("Email must not be null or empty");
	    }
		 return store.values().stream()
	                .anyMatch(user -> user.getEmail().equalsIgnoreCase(email));
	}

}

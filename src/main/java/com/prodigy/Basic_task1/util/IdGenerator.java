package com.prodigy.Basic_task1.util;

import java.util.UUID;

public final class IdGenerator {
	private IdGenerator() {
		throw new UnsupportedOperationException("Utility class, should not be instantiated");
	}
	
	public static UUID generateId() {
		return UUID.randomUUID();
	}
}

package com.prodigy.Basic_task1.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
@Getter @ToString
@AllArgsConstructor
public class UserResponseDto {
 private final UUID id;
 private final String name;
 private final String email;
 private final int age;
}

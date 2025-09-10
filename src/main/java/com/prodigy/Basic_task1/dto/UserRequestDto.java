package com.prodigy.Basic_task1.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter @Setter @ToString
@AllArgsConstructor @NoArgsConstructor
public class UserRequestDto {
	@NotBlank(message = "Name can't be blank")
	private String name;
	
	@NotBlank(message = "Email can't be blank")
	@Email(message = "Email should be valid")
	private String email;
	
	@NotNull(message = "Age can't be null")
	@Min(value = 1, message = "age must be grater then 0")
	@Max(value = 120, message = "Age must be greater then or equal to 120")
	private Integer age;
}

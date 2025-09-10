package com.prodigy.Basic_task1.model;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter @Setter @ToString
@AllArgsConstructor @NoArgsConstructor
public class User {
private UUID id;
private String name;
private String email;
private int age;
}

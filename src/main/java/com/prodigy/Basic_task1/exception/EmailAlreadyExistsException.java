package com.prodigy.Basic_task1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST) //tells Spring what HTTP status to send
public class EmailAlreadyExistsException extends RuntimeException {
public EmailAlreadyExistsException(String msg) {
	super(msg);
}
}

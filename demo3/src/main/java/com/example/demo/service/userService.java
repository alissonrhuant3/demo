package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.web.dto.UserRegistrationDto;

public interface userService {
	User save(UserRegistrationDto registrationDto);
}

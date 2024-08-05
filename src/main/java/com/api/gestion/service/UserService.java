package com.api.gestion.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;

public interface UserService {
	ResponseEntity<String> singUp(Map<String, String> requestMap);
}

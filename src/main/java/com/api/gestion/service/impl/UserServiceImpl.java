package com.api.gestion.service.impl;

import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.gestion.constantes.FacturaConstantes;
import com.api.gestion.dao.UserDAO;
import com.api.gestion.pojo.User;
import com.api.gestion.service.UserService;
import com.api.gestion.util.FacturaUtils;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDAO userDAO;
	
	
	@Override
	public ResponseEntity<String> singUp(Map<String, String> requestMap) {
		log.info("Registro interno de un usuario {}", requestMap);
		try {
			if (validateSingUpMap(requestMap)) {
				User user = userDAO.findByEmail(requestMap.get("email"));
				if (Objects.isNull(user)) {
					userDAO.save(getUserFromMap(requestMap));
					return FacturaUtils.getResponseEntity("Usuario registrado exitosamente", HttpStatus.CREATED);
				}
				else {
					return FacturaUtils.getResponseEntity("El usuario con esa cuenta ya existe", HttpStatus.BAD_REQUEST);
				}
			}
			else {
				return FacturaUtils.getResponseEntity(FacturaConstantes.INVALID_DATA, HttpStatus.BAD_REQUEST);
			}
		}catch (Exception exception){
			exception.printStackTrace();
		}
		return FacturaUtils.getResponseEntity(FacturaConstantes.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	private boolean validateSingUpMap(Map<String, String> requestMap) {
		if (requestMap.containsKey("nombre") && requestMap.containsKey("numeroContacto") && requestMap.containsKey("email") && requestMap.containsKey("password")) {
			return true;
		}
		return false;
	}
	
	
	private User getUserFromMap(Map<String, String> requestMap) 
	{
		User user = new User();
		user.setNombre(requestMap.get("nombre"));
		user.setNumeroContacato(requestMap.get("numeroContacto"));
		user.setEmail(requestMap.get("email"));
		user.setPassword(requestMap.get("password"));
		user.setStatus(requestMap.get("false"));
		user.setRole(requestMap.get("user"));
		return user;
	}
}

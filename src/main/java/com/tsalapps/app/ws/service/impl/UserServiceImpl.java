package com.tsalapps.app.ws.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsalapps.app.ws.UserRepository;
import com.tsalapps.app.ws.io.entity.UserEntity;
import com.tsalapps.app.ws.service.UserService;
import com.tsalapps.app.ws.shared.dto.UserDto;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDto createUser(UserDto user) {
			
			UserEntity userEntity = new UserEntity();
			BeanUtils.copyProperties(user, userEntity);
			
			UserEntity storedUserDetails = userRepository.save(userEntity);
			userEntity.setEncryptedPassword("encrPass");
			userEntity.setUserId("testUserId");
			
			UserDto returnValue = new UserDto();
			BeanUtils.copyProperties(storedUserDetails, returnValue);
			
			return returnValue;
		}
}

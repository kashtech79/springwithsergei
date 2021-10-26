package com.appsdeveloperblog.serviceimpl;

import com.appsdeveloperblog.dto.UserDto;
import com.appsdeveloperblog.entity.UserEntity;
import com.appsdeveloperblog.repository.UserRepository;
import com.appsdeveloperblog.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    public UserDto createUser(UserDto user) {

        if(userRepository.findByEmail(user.getEmail()) != null) throw new RuntimeException("RecordAlready Exist");

        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);

        userEntity.setUserId(UUID.randomUUID().toString());
        userEntity.setEncryptedPassword("123");

        UserEntity storedUserDetails = userRepository.save(userEntity);

        UserDto returnValue = new UserDto();
        BeanUtils.copyProperties(storedUserDetails, returnValue);

        return returnValue;
    }
}

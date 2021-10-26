package com.appsdeveloperblog.controller;

import com.appsdeveloperblog.dto.UserDto;
import com.appsdeveloperblog.entity.UserEntity;
import com.appsdeveloperblog.model.request.UserDetailsRequestModel;
import com.appsdeveloperblog.model.response.UserRest;
import com.appsdeveloperblog.repository.UserRepository;
//import com.appsdeveloperblog.service.UserService;
import com.appsdeveloperblog.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;
//
//    @GetMapping
//    public String getUser()
//    {
//        return null;
//    }
//
    @PostMapping
    public UserRest createUser(@RequestBody UserDetailsRequestModel userDetails)
    {
        UserRest returnValue = new UserRest();

        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userDetails, userDto);

        UserDto createdUser = userService.createUser(userDto);
        BeanUtils.copyProperties (createdUser, returnValue);

        return returnValue;

    }

//    @PostMapping
//    public ResponseEntity<Object> createUser(@RequestBody UserDetailsRequestModel userDetails){
//        UserEntity userEntity = new UserEntity();
//        BeanUtils.copyProperties(userEntity, userDetails);
//        userRepository.save(userEntity);
//        return ResponseEntity.ok("Created");
//    }

//    @PostMapping
//    public ResponseEntity<Object> createUser(@RequestBody UserDetailsRequestModel userDetails){
//        UserEntity userEntity = new UserEntity();
//        BeanUtils.copyProperties(userDetails, userEntity);
//        userRepository.save(userEntity);
//        return ResponseEntity.ok("Created");
//    }

    @PutMapping
    public String updateUser()
    {
        return "update user was called";
    }

    @DeleteMapping
    public String deleteUser()
    {
        return "delete user was called";
    }

}

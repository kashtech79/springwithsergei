package com.appsdeveloperblog.controller;

import com.appsdeveloperblog.dto.UserDto;
import com.appsdeveloperblog.model.request.UserDetailsRequestModel;
import com.appsdeveloperblog.model.response.UserRest;
import com.appsdeveloperblog.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public String getUser()
    {
        ;
    }

    @PostMapping
    public String createUser(@RequestBody UserDetailsRequestModel userDetails)
    {
        UserRest returnValue = new UserRest();

        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userDetails, userDto);

        UserDto createdUser = userService.createUser(userDto);
        BeanUtils.copyProperties (createUser, returnValue);

    }

    @PutMapping
    public String updateUser()
    {
        return "update user was called";
    }

    @DeleteMapping

    {
        return "delete user was called";
    }
    pub

}

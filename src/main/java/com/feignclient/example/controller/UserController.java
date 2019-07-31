package com.feignclient.example.controller;


import com.feignclient.example.client.UserClient;
import com.feignclient.example.mapper.mapstruct.UserMapper;
import com.feignclient.example.model.User;
import com.feignclient.example.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
@Import({FeignClientsConfiguration.class})
public class UserController {

    @Autowired
    private UserClient userClient;

    @GetMapping("users")
    public ResponseEntity<List<UserDto>> getUsers() {
        List<User> users = userClient.getUsers();
        System.out.println(users);
        List<UserDto> userDtos = UserMapper.INSTANCE.userEntityToUserDto(users);
        System.out.println(userDtos);
        return ResponseEntity.ok(userDtos);
    }
}

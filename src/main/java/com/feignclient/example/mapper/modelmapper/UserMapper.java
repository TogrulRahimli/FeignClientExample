package com.feignclient.example.mapper.modelmapper;

import com.feignclient.example.model.User;
import com.feignclient.example.model.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class UserMapper {

    @Autowired
    private ModelMapper modelMapper;

    public List<UserDto> convertToDTO(List<User> users) {
        UserDto[] userDtos = modelMapper.map(users, UserDto[].class);
        return new ArrayList<>(Arrays.asList(userDtos));
    }
}

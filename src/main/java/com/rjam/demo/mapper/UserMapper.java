package com.rjam.demo.mapper;

import com.rjam.demo.dto.UserRequest;
import com.rjam.demo.dto.UserResponse;
import com.rjam.demo.model.User;

public class UserMapper {

    public static User toEntity(UserRequest request) {
        return User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .age(request.getAge())
                .build();
    }

    public static UserResponse toResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .age(user.getAge())
                .build();
    }

}
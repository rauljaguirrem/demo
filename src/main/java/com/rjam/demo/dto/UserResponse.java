package com.rjam.demo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponse {

    private String id;

    private String name;

    private String email;

    private Integer age;

}
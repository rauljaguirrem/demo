package com.rjam.demo.service;

import com.rjam.demo.dto.UserRequest;
import com.rjam.demo.dto.UserResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {

    Mono<UserResponse> create(UserRequest request);

    Flux<UserResponse> findAll();

    Mono<UserResponse> findById(String id);

    Mono<UserResponse> update(String id, UserRequest request);

    Mono<Void> delete(String id);

}
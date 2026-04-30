package com.rjam.demo.controller;

import com.rjam.demo.dto.UserRequest;
import com.rjam.demo.dto.UserResponse;
import com.rjam.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @PostMapping
    public Mono<UserResponse> create(@RequestBody UserRequest request) {
        return service.create(request);
    }

    @GetMapping
    public Flux<UserResponse> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Mono<UserResponse> findById(@PathVariable String id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public Mono<UserResponse> update(@PathVariable String id,
                                     @RequestBody UserRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable String id) {
        return service.delete(id);
    }

}
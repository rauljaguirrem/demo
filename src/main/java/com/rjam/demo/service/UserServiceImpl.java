package com.rjam.demo.service;

import com.rjam.demo.dto.UserRequest;
import com.rjam.demo.dto.UserResponse;
import com.rjam.demo.mapper.UserMapper;
import com.rjam.demo.model.User;
import com.rjam.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Override
    public Mono<UserResponse> create(UserRequest request) {

        return Mono.just(request)
                .map(UserMapper::toEntity)
                .flatMap(repository::save)
                .map(UserMapper::toResponse);
    }

    @Override
    public Flux<UserResponse> findAll() {

        return repository.findAll()
                .filter(user -> user.getAge() >= 18)
                .map(UserMapper::toResponse);
    }

    @Override
    public Mono<UserResponse> findById(String id) {

        return repository.findById(id)
                .map(UserMapper::toResponse);
    }

    @Override
    public Mono<UserResponse> update(String id, UserRequest request) {

        return repository.findById(id)

                .flatMap(user -> {

                    user.setName(request.getName());
                    user.setEmail(request.getEmail());
                    user.setAge(request.getAge());

                    return repository.save(user);
                })

                .map(UserMapper::toResponse);
    }

    @Override
    public Mono<Void> delete(String id) {

        return repository.deleteById(id);
    }

}
package com.rjam.demo.repository;

import com.rjam.demo.model.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface UserRepository extends ReactiveMongoRepository<User, String> {

    Flux<User> findByAgeGreaterThan(Integer age);

}
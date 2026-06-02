package com.backend.general;

import org.springframework.stereotype.Component;

import com.backend.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class Repositories {

    private final UserRepository userRepository;

    public UserRepository user() {
        return userRepository;
    }

}

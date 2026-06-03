package com.backend.general;

import org.springframework.stereotype.Component;

import com.backend.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class Repositories {

    public final UserRepository user;

}

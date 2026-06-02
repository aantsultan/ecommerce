package com.backend.general;

import org.springframework.stereotype.Component;

import com.backend.service.RegisterService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class Services {

    private final RegisterService register;

    public RegisterService register() {
        return register;
    }
}

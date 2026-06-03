package com.backend.general;

import org.springframework.stereotype.Component;

import com.backend.service.RegisterService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class Services {

    public final RegisterService register;
}

package com.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.dto.Response;
import com.backend.general.Services;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class RegisterController {

    private final Services services;

    @GetMapping
    public ResponseEntity<Response<Object>> findAll() {
        return ResponseEntity.ok().body(Response.builder().data(services.register().findAll()).build());
    }

}

package com.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.dto.Response;
import com.backend.general.Services;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3001")
public class FileController {

    private final Services services;

    @GetMapping("/files")
    public ResponseEntity<Response<Object>> findAll() {
        return ResponseEntity.ok().body(Response.builder().data(services.file.findAll()).build());
    }

}

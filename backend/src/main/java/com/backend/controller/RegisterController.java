package com.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.dto.Response;
import com.backend.dto.ResponsePaging;
import com.backend.dto.UserDto;
import com.backend.general.Services;

import jakarta.annotation.Nullable;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3001")
public class RegisterController {

    private final Services services;

    @GetMapping("/users")
    public ResponseEntity<Response<Object>> findAll() {
        return ResponseEntity.ok().body(Response.builder().data(services.register.findAll()).build());
    }

    @GetMapping("/users/paging")
    public ResponseEntity<ResponsePaging<Object>> paging(@RequestParam("page") Integer page,
            @RequestParam("perPage") Integer perPage, @RequestParam("sortField") @Nullable String sortField,
            @Nullable @RequestParam("sortType") String sortType, @Nullable @RequestParam("search") String search) {
        return ResponseEntity.ok().body(services.register.paging(page, perPage, sortField, sortType, search));
    }

    @PostMapping("/users")
    public ResponseEntity<Response<Object>> save(@RequestBody UserDto dto) {
        String response = services.register.save(dto);
        return ResponseEntity.ok().body(Response.builder().data(response).build());
    }

}

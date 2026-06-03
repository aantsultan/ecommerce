package com.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.dto.Response;
import com.backend.dto.ResponsePaging;
import com.backend.general.Services;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class RegisterController {

    private final Services services;

    @GetMapping("/users")
    public ResponseEntity<Response<Object>> findAll() {
        return ResponseEntity.ok().body(Response.builder().data(services.register.findAll()).build());
    }

    @GetMapping("/users/paging")
    public ResponseEntity<ResponsePaging<Object>> paging(@RequestParam("page") Integer page,
            @RequestParam("perPage") Integer perPage, @RequestParam("sortField") String sortField,
            @RequestParam("sortType") String sortType, @RequestParam("search") String search) {
        return ResponseEntity.ok().body(ResponsePaging.builder()
                .data(services.register.paging(page, perPage, sortField, sortType, search)).build());
    }

}

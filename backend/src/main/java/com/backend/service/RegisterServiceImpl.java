package com.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.backend.dto.UserDto;
import com.backend.general.Repositories;
import com.backend.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RegisterServiceImpl implements RegisterService {

    private final Repositories repositories;

    @Override
    public List<UserDto> findAll() {
        return repositories.user().findAll().stream().map(data -> UserDto.builder()
                .id(data.getId())
                .name(data.getName())
                .address(data.getAddress())
                .build()).toList();
    }

}

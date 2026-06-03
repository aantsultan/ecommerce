package com.backend.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.dto.ResponsePaging;
import com.backend.dto.UserDto;
import com.backend.general.Repositories;
import com.backend.model.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RegisterServiceImpl implements RegisterService {

        private final Repositories repositories;

        @Override
        public List<UserDto> findAll() {
                return repositories.user.findAll().stream().map(data -> UserDto.builder()
                                .id(data.getId())
                                .name(data.getName())
                                .address(data.getAddress())
                                .build()).toList();
        }

        @Override
        public ResponsePaging<Object> paging(Integer page, Integer perPage, String sortField, String sortType,
                        String search) {
                PageRequest pageRequest = PageRequest.of(page, perPage);
                Page<User> pageData = repositories.user.findAll(pageRequest);
                return ResponsePaging.builder()
                                .data(pageData.getContent().stream().map(data -> UserDto.builder()
                                                .id(data.getId())
                                                .name(data.getName())
                                                .address(data.getAddress())
                                                .build()).toList())
                                .page(page)
                                .perPage(perPage)
                                .sortField(sortField)
                                .sortType(sortType)
                                .total(pageData.getTotalElements())
                                .build();
        }

        @Override
        @Transactional
        public String save(UserDto dto) {
                User user = new User();
                user.setName(dto.getName());
                user.setAddress(dto.getAddress());
                repositories.user.save(user);
                return "OK";
        }

}

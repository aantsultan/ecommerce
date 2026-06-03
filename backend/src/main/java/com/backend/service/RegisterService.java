package com.backend.service;

import java.util.List;

import com.backend.dto.ResponsePaging;
import com.backend.dto.UserDto;

public interface RegisterService {

    List<UserDto> findAll();

    ResponsePaging<Object> paging(Integer page, Integer perPage, String sortField, String sortType, String search);

    String save(UserDto dto);

    String update(UserDto dto);
}

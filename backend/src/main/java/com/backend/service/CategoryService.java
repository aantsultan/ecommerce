package com.backend.service;

import java.util.List;

import com.backend.dto.CategoryDto;

public interface CategoryService {

    List<CategoryDto> findAll();

}

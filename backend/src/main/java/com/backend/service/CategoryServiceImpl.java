package com.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.backend.dto.CategoryDto;
import com.backend.general.Repositories;
import com.backend.model.Category;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final Repositories repositories;

    @Override
    public List<CategoryDto> findAll() {
        List<Category> all = repositories.category.findAll();
        return all.stream().map(data -> CategoryDto.builder()
                .id(data.getId())
                .fileId(data.getFileId())
                .code(data.getCode())
                .name(data.getName())
                .build()).toList();
    }

}

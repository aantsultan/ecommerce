package com.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.backend.dto.CategoryDto;
import com.backend.dto.FileDto;
import com.backend.general.Repositories;
import com.backend.model.Category;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final Repositories repositories;

    @Override
    public List<CategoryDto> findAll() {
        List<Category> all = repositories.category.findAllWithFile();
        return all.stream().map(data -> CategoryDto.builder()
                .id(data.getId())
                .fileId(data.getFileId())
                .file(FileDto.builder()
                        .id(data.getFile().getId())
                        .name(data.getFile().getName())
                        .mimeType(data.getFile().getMimeType())
                        .build())
                .code(data.getCode())
                .name(data.getName())
                .build()).toList();
    }

}

package com.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.backend.dto.FileDto;
import com.backend.general.Repositories;
import com.backend.model.File;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {

    private final Repositories repositories;

    @Override
    public List<FileDto> findAll() {
        List<File> all = repositories.file.findAll();
        return all.stream().map(data -> FileDto.builder()
                .id(data.getId())
                .name(data.getName())
                .mimeType(data.getMimeType())
                .build()).toList();
    }

}

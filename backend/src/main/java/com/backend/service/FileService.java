package com.backend.service;

import java.util.List;

import com.backend.dto.FileDto;

public interface FileService {

    List<FileDto> findAll();

}

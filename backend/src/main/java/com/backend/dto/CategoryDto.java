package com.backend.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CategoryDto {

    private Long id;
    private Long fileId;
    private String code;
    private String name;
    private FileDto file;

}

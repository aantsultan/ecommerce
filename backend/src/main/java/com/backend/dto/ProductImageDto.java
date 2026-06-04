package com.backend.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class ProductImageDto {

    private Long id;
    private Long fileId;
    private FileDto file;
    private String description;

}

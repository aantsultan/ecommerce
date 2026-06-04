package com.backend.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class StoreDto {

    private Long id;
    private Long userId;
    private Long fileId;
    private String code;
    private String name;

}

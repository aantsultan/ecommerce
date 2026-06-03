package com.backend.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class ResponsePaging<T> {

    private T data;
    private Long total;
    private Integer page;
    private Integer perPage;
    private String sortField;
    private String sortType;

}

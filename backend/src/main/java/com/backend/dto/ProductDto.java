package com.backend.dto;

import java.math.BigDecimal;
import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class ProductDto {

    private Long id;
    private Long categoryId;
    private Long storeId;
    private String code;
    private String name;
    private BigDecimal price;
    private List<ProductImageDto> productDetail;
}

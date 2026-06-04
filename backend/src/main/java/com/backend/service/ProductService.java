package com.backend.service;

import java.util.List;

import com.backend.dto.ProductDto;

public interface ProductService {

    List<ProductDto> findAll();

}

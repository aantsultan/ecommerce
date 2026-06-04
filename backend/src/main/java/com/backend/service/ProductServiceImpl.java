package com.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.backend.dto.FileDto;
import com.backend.dto.ProductDto;
import com.backend.dto.ProductImageDto;
import com.backend.general.Repositories;
import com.backend.model.Product;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final Repositories repositories;

    @Override
    public List<ProductDto> findAll() {
        List<Product> all = repositories.product.findAll();
        return all.stream().map(data -> ProductDto.builder()
                .id(data.getId())
                .categoryId(data.getCategoryId())
                .storeId(data.getStoreId())
                .code(data.getCode())
                .name(data.getName())
                .price(data.getPrice())
                .productDetail(data.getProductImages().stream().map(detail -> ProductImageDto.builder()
                        .id(detail.getId())
                        .fileId(detail.getFileId())
                        .file(FileDto.builder()
                                .id(detail.getFile().getId())
                                .name(detail.getFile().getName())
                                .mimeType(detail.getFile().getMimeType())
                                .build())
                        .description(detail.getDescription())
                        .build()).toList())
                .build()).toList();
    }

}

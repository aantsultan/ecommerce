package com.backend.general;

import org.springframework.stereotype.Component;

import com.backend.service.CategoryService;
import com.backend.service.FileService;
import com.backend.service.ProductService;
import com.backend.service.RegisterService;
import com.backend.service.StoreService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class Services {

    public final RegisterService register;
    public final FileService file;
    public final CategoryService category;
    public final StoreService store;
    public final ProductService product;
}

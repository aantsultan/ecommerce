package com.backend.general;

import org.springframework.stereotype.Component;

import com.backend.repository.CategoryRepository;
import com.backend.repository.FileRepository;
import com.backend.repository.ProductRepository;
import com.backend.repository.StoreRepository;
import com.backend.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class Repositories {

    public final UserRepository user;
    public final FileRepository file;
    public final CategoryRepository category;
    public final StoreRepository store;
    public final ProductRepository product;

}

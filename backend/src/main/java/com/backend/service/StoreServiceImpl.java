package com.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.backend.dto.StoreDto;
import com.backend.general.Repositories;
import com.backend.model.Store;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService {

    private final Repositories repositories;

    @Override
    public List<StoreDto> findAll() {
        List<Store> all = repositories.store.findAll();
        return all.stream().map(data -> StoreDto.builder()
                .id(data.getId())
                .fileId(data.getFileId())
                .code(data.getCode())
                .name(data.getName())
                .userId(data.getUserId())
                .build()).toList();
    }

}

package com.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.backend.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query(value = """
                select a from Category a
                join a.file
            """)
    List<Category> findAllWithFile();

}

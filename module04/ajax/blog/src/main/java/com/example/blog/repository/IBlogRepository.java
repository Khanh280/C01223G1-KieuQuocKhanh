package com.example.blog.repository;

import com.example.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;
public interface IBlogRepository extends JpaRepository<Blog,Long> {
    @Query(value = "select b from Blog b where b.title like  concat( '%',:title,'%')")
    Page<Blog> searchBlogByTitle(@Param("title") String title, Pageable pageable);
    @Query(value = "select b from Blog b where b.title like  concat( '%',:title,'%')")
    Slice<Blog> searchBlogByTitleSlice(@Param("title") String title);
}

package com.example.blog.repository;

import com.example.blog.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog,Long> {
    List<Blog> findAll();
    @Query(value = "select b from Blog b where b.title like  concat( '%',:title,'%')")
    List<Blog> searchBlogByTitle(@Param("title") String title);
}

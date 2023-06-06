package com.example.blog.repository;

import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface ICategoryRepository extends JpaRepository<Category, Long> {
    @Query(value = "update category set category.is_delete = 1 where category.category_id = :id", nativeQuery = true)
    @Modifying
    @Transactional
    void deleteCategory(@Param("id") Long id);

    @Query(value = "select b from Blog b where b.category.categoryName = :categoryName")
    Page<Blog> findBlogByCategory(@Param("categoryName") String categoryName, Pageable pageable);

    //    @Query(value = "select DISTINCT(category_name) from category;",nativeQuery = true)
    @Query(value = "select concat( c.category_name  ,' - (' ,COUNT(b.category_category_id), ')')as categorySl\n" +
            "FROM blog b\n" +
            "right join category c on c.category_id = b.category_category_id\n" +
            "group by b.category_category_id,c.category_name\n" +
            "order by count(b.category_category_id) desc", nativeQuery = true)
    List<String> findDistinctByCategoryName();
}

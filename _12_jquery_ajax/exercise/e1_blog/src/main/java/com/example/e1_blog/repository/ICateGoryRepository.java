package com.example.e1_blog.repository;


import com.example.e1_blog.model.category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICateGoryRepository extends JpaRepository<category,Integer> {
//    @Query(value = "select b from Blog b join category c on c.id = b.id_category where c.id = :id",nativeQuery = true)
//    List<Blog> searchcategoriesBy(@Param("id") Integer id);
//
//    Page<Blog> findBlogByAuthorContaining(Pageable pageable, String author);


}

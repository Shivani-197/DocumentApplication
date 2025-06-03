package com.example.docqa.repository;

import com.example.docqa.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {
    @Query("SELECT d FROM Document d WHERE cast(d.content as string) LIKE CONCAT('%', :keyword, '%')")
    List<Document> findByContentContainingIgnoreCase(@Param("keyword") String keyword);
    List<Document> findByAuthorIgnoreCase(String author);
    List<Document> findByType(String type);
}

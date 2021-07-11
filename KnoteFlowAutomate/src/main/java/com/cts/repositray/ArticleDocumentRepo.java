package com.cts.repositray;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.model.ArticleDocument;

@Repository
public interface ArticleDocumentRepo extends JpaRepository<ArticleDocument, Integer>{

}

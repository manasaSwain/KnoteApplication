package com.cts.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cts.model.Article;
import com.cts.model.ArticleDocument;

@Service
public interface IarticleService {

	public void saveArticle(Article article);
	public List<Object[]> getDocumentInfo();
	public Optional<ArticleDocument> getDocumentById(Integer id);
	
}

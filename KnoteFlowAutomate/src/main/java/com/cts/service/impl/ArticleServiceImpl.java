package com.cts.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.model.Article;
import com.cts.model.ArticleDocument;
import com.cts.repositray.ArticleDocumentRepo;
import com.cts.repositray.ArticleRepo;
import com.cts.repositray.ContPhotoRepo;
import com.cts.service.IarticleService;

@Service
public class ArticleServiceImpl implements IarticleService {
    
	@Autowired
	ArticleRepo articleRepo;
	@Autowired
	ArticleDocumentRepo articleDocRepo;
	@Autowired
	ContPhotoRepo contRepo;
	
	@Override
	public void saveArticle(Article article) {
		
		articleRepo.save(article);
		
	}

	@Override
	public List<Object[]> getDocumentInfo() {
		
		return articleRepo.getDocumentInfo();
	}

	@Override
	public Optional<ArticleDocument> getDocumentById(Integer id) {
			
		return articleDocRepo.findById(id);
	}

}

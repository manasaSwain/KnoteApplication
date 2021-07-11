package com.cts.repositray;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cts.model.Article;

@Repository
public interface ArticleRepo extends JpaRepository<Article, Integer> {
	
	@Query("SELECT d.id, a.articleName, d.articleDocName FROM Article a JOIN a.articleDocument d")
	List<Object[]> getDocumentInfo();
	
	//SELECT d.name, e.name, e.email, e.address FROM department d INNER JOIN employee e ON d.id = e.dept_id;
	

}

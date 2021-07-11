package com.cts.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="ARTICLE_DOC_DETAILS")
public class ArticleDocument {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;	
	@Column(name="article_docname")
	private String articleDocName;	
	@Column(name="article_docdata")
	@Lob
	private byte[] articleDocData;


}

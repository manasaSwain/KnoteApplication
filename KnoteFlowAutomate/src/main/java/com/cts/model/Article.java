package com.cts.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="Article_Details")
public class Article {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="kn_art_name")
	private String articleName;
	
	@Column(name="kn_art_contributor")
	private String articleContributor;
	
	@Column(name="kn_art_description")
	private String description;
	//@Column(name="kn_art_contributorPhoto")
	//private MultipartFile contributorPhoto;
	//@Column(name="kn_art_uploadAttribute")
	//private MultipartFile uploadArticle;
	
	//@OneToOne(targetEntity = ContPhoto.class,cascade=CascadeType.ALL)
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cont_kn_id")
	private ContPhoto contPhoto;
	
	//@OneToOne(targetEntity = ArticleDocument.class,cascade = CascadeType.ALL)
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="article_kn_id")
	private ArticleDocument articleDocument;

}

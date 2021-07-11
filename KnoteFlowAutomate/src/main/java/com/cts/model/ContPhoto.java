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
@Table(name="CONTRIBUTOR_PHOTO")
public class ContPhoto {
	
	@Id	
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="contributor_photoname")
	private String photoDocName;
	
	@Column(name="contributor_photodata")
	@Lob
	private byte[] photoData;

}

package com.cts.repositray;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.model.ContPhoto;

@Repository
public interface ContPhotoRepo extends JpaRepository<ContPhoto, Integer>{

}

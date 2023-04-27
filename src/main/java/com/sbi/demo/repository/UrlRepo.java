package com.sbi.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sbi.demo.entity.URLData;

@Repository
public interface UrlRepo extends JpaRepository<URLData, Long>{
	
	public URLData findByShortUrlName(String url);
	
	public URLData findByFullUrlName(String url);

}

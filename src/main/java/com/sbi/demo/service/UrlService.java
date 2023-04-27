package com.sbi.demo.service;

import org.springframework.stereotype.Service;

import com.sbi.demo.entity.URLData;


public interface UrlService {
	
	public URLData createShorturl(URLData url);
	
	public String getPage(String url);
	 

}

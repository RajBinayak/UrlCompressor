package com.sbi.demo.serviceImpl;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbi.demo.entity.URLData;
import com.sbi.demo.repository.UrlRepo;
import com.sbi.demo.service.UrlService;

@Service
public class UrlServiceImpl implements UrlService {
	@Autowired
	UrlRepo repo;

	@Override
	public URLData createShorturl(URLData url) {
		URLData data;
		int leftLimit = 97; // letter 'a'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = 10;
		Random random = new Random();

		String generatedString = random.ints(leftLimit, rightLimit + 1).limit(targetStringLength)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
		System.out.println(url.getfullUrlName());

		url.setshortUrlName(generatedString);
		URLData doesExist = repo.findByFullUrlName(url.getfullUrlName());
System.out.println(doesExist);
		if (doesExist!= null && (doesExist.getfullUrlName() != null || doesExist.getfullUrlName() != "")) {
			data = doesExist;
			System.out.println("if==="+data);
		} else {

			data = repo.save(url);
			data.setshortUrlName("http://localhost:8080/s/" + data.getshortUrlName());
		}
		return data;
	}

	@Override
	public String getPage(String url) {
		URLData data = repo.findByShortUrlName(url);
		System.out.println(url);
		System.out.println(data);
		if(data!=null)
			return data.getfullUrlName();
		else 
			return null;
	}

}

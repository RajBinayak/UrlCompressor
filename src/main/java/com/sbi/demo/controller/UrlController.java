package com.sbi.demo.controller;

import java.io.IOException;
import java.net.http.HttpResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.GetExchange;

import com.sbi.demo.entity.URLData;
import com.sbi.demo.service.UrlService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin("*")
public class UrlController {
	@Autowired
	UrlService service;

	@PostMapping("/create")
	public ResponseEntity<URLData> createShortUrl(@RequestBody URLData url) {

		return new ResponseEntity<>(service.createShorturl(url), HttpStatus.OK);
	}

	@GetMapping("/s/{randstring}")
	public void searchUrl(HttpServletResponse httpServletResponse, @PathVariable("randstring") String randString)
			throws IOException {
System.out.println("=========");
		System.out.println(service.getPage(randString));
		String url = service.getPage(randString);
		if (url != null) {
			System.out.println("if");
			httpServletResponse.sendRedirect(url);
		}

		else {
			System.out.println("error");
			httpServletResponse.setContentType("URL NOT FOUND");
			httpServletResponse.sendError(HttpServletResponse.SC_BAD_REQUEST);
		}

	}

}

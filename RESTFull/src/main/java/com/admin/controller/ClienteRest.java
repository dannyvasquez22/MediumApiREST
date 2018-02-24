package com.admin.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.admin.entity.Nota;

@Controller
@RequestMapping("/nota")
public class ClienteRest {

	private final String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJkYW5ueSJ9.z0wZBVkHB4njsBHOFQTyXoY2bLbtMCwGSiJb_Ejllo57_uKcrEyghJnj7ofZ1bidkhs0I6FIUgtRL3qc9p7x9Q";
	
	@GetMapping("/all")
	public ModelAndView devolverTodos() {
		ModelAndView mav = new ModelAndView("template");
		
		RestTemplate rest = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		
		headers.add("Authorization", token);
		
		HttpEntity entity = new HttpEntity(headers);
		ResponseEntity<Nota[]> notasEntity = rest.exchange("http://localhost:8080/v1/notas", HttpMethod.GET, entity, Nota[].class);
		
		Nota[] notas = notasEntity.getBody();
		
		mav.addObject("notas", notas);
		
		return mav;
	} 
}

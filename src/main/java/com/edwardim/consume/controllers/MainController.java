package com.edwardim.consume.controllers;


import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.edwardim.consume.services.ApiService;

@Controller
public class MainController {
	
	@Autowired
	private ApiService apiService;
	
	@GetMapping("")
	public String index(Model model) {
		
		try {
			JSONObject obj = apiService.getStarWars();
			model.addAttribute("name", obj.get("name"));
			model.addAttribute("height", obj.get("height"));
			return "index.jsp";
		} catch (Exception e) {
			System.out.println(e);
			return "error.jsp";
		}

	}
}

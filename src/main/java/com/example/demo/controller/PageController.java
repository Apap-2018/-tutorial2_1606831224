package com.example.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
	@RequestMapping("/viral")
	public String index() {
		return "viral";
	}
	
	@RequestMapping("/challenge")
	public String challenge(@RequestParam(value = "name") String name, Model model) {
		model.addAttribute("name", name);
		return "challenge";
	}
	
	@RequestMapping(value= {"/challenge", "challenge/{name}"})
	public String challengePath(@PathVariable Optional<String> name, Model model) {
		if (name.isPresent()) {
			model.addAttribute("name", name.get());
		}else {
			model.addAttribute("name", "KB");
		}
		return "challenge";
	}
	
	@RequestMapping("/generator")
	public String generator(@RequestParam(value = "a", required=false, defaultValue="0") String a, @RequestParam(value = "b", required=false, defaultValue="0") String b, Model model) {
		model.addAttribute("a", a);
		model.addAttribute("b", b);
		
		// pengali nilai m
		String m = multiple("m", Integer.parseInt(a));
		
		// h + m
		String h = "h" + m;
		
		
		// multiple hm
		String hm = multipleh(h, Integer.parseInt(b));
		
		model.addAttribute("hm", hm);
		return "viralgenerator";
	}
	
	public String multiple(String str, int x) {
		String hasil = "m";
		for (int i = 1; i < x; i++ ) {
			hasil = hasil + str;
		}
		return hasil;
	}
	
	public String multipleh(String str, int x) {
		String hasil = str;
		for (int i = 1; i < x; i++ ) {
			hasil = hasil + " " + str;
		}
		return hasil;
	}
	
	
	
}

package com.smadoku.app.home;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {

	@GetMapping("/test")
	public String getTest(@RequestParam String id) {
		System.out.println("test");
		System.out.println(id);
		return id;
	}
}

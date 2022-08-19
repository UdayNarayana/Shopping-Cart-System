package com.example.demo.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ExampleController {
	@GetMapping("/example")
	public String getString() {
		return "Hello Product";
	}

}

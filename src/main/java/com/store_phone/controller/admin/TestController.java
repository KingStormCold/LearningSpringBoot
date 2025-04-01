package com.store_phone.controller.admin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@GetMapping(value = "/v1/test")
	public String test() {
		return "test123";
	}

}

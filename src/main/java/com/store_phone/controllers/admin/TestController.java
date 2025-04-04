package com.store_phone.controllers.admin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping(value = "/v1/api")
    public String test() {
        return  "test123";
    }
}

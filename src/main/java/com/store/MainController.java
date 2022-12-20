package com.store;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	
	@GetMapping(value={"/","/index"})
	String index() {
		return "index";
	}
}

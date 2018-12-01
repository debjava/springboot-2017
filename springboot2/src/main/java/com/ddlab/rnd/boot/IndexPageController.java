package com.ddlab.rnd.boot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RestController
public class IndexPageController {

//	@RequestMapping("/")
//	public ModelAndView index() {
//		Map<String, String> map = new HashMap<String, String>();
//		map.put("message", "A warm welcome to you.");
//		return new ModelAndView("index", map);
//	}
	
	@RequestMapping("/")
	public String login() {
		 return "index";
	}

}

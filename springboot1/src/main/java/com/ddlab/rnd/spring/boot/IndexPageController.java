package com.ddlab.rnd.spring.boot;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
//@RestController
public class IndexPageController implements ErrorController {
	
	private static final String PATH = "/error";

	@RequestMapping("/")
	public ModelAndView index() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("message", "A warm welcome to you.");
		return new ModelAndView("index", map);
	}
	
	@Override
    public String getErrorPath() {
        return PATH;
    }
	
	

}

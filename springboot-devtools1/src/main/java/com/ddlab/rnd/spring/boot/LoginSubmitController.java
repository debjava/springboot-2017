package com.ddlab.rnd.spring.boot;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginSubmitController {
	
	@RequestMapping(value="/loginSubmit", method=RequestMethod.POST)
//	public ModelAndView loginSubmit(  @ModelAttribute ModelMap modelMap ) { //
	public ModelAndView loginSubmit(@RequestBody String body) throws Exception {
		Map<String,String> paramMap = splitQuery(body);
		System.out.println(paramMap);
		System.out.println(body);
		Map<String, String> map = new HashMap<String, String>();
//		map.put("name", "Piku");
		map.put("name", paramMap.get("username"));
		return new ModelAndView("show", map);
		// return "index";
	}
	
	public static Map<String, String> splitQuery(String query) throws UnsupportedEncodingException {
	    Map<String, String> query_pairs = new LinkedHashMap<String, String>();
	    String[] pairs = query.split("&");
	    for (String pair : pairs) {
	        int idx = pair.indexOf("=");
	        query_pairs.put(URLDecoder.decode(pair.substring(0, idx), "UTF-8"), URLDecoder.decode(pair.substring(idx + 1), "UTF-8"));
	    }
	    return query_pairs;
	}

}

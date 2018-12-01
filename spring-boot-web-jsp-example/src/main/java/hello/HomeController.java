package hello;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@RequestMapping("/home")
    public ModelAndView  home() {
    	
 		Map<String , String> model = new HashMap<String , String>();
 		model.put("myMessage", "ABCD");
 		
		ModelAndView modelView = new ModelAndView("home", model);
		
        return modelView;
    }


}

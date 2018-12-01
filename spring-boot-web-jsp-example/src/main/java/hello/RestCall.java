package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping
public class RestCall {
	
	@RequestMapping(value = "/call", method = RequestMethod.GET)
	public String callme() {
		System.out.println("-----------------------");
		return "abcd";
	}

}

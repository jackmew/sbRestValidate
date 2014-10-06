/**
 * 
 */
package org.jackho.sbRestValidate.controller;

import java.util.Date;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author jackho
 *
 */
@Controller
public class PersonController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PersonController.class);

	
//	@RequestMapping("/")
//	public String start(){
//		return "start";
//	}
	
	@Value("${application.message:Hello World}")
	private String message = "Hello World";

	@RequestMapping("/hello")
	public String welcome(Map<String, Object> model) {
		model.put("time", new Date());
		model.put("message", this.message);
		return "welcome";
	}
}

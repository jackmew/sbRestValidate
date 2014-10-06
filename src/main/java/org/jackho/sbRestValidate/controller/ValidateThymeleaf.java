/**
 * 
 */
package org.jackho.sbRestValidate.controller;


import javax.validation.Valid;

import org.jackho.sbRestValidate.domain.Person;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author jackho
 *
 */
@Controller
@RequestMapping("/validate")
public class ValidateThymeleaf {
	 	@RequestMapping(value="/form", method=RequestMethod.GET)
	    public String showForm(Person person) {
	        return "form";
	    }
	 	
	 	@RequestMapping(value="/form", method=RequestMethod.POST)
	    public String checkPersonInfo(@Valid Person person, BindingResult bindingResult) {
	        if (bindingResult.hasErrors()) {
	            return "form";
	        }
	        return null;
	    }
}

/**
 * 
 */
package org.jackho.sbRestValidate.controller;

import java.io.IOException;

import org.jackho.sbRestValidate.dto.CustomGenericException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


/**
 * @author jackho
 *
 */
@Controller
@RequestMapping("/simple")
public class SimpleExceptionController {

	@RequestMapping(value = "/{type}", method = RequestMethod.GET)
	public ModelAndView getPages(@PathVariable("type") String type) throws Exception {
		
		if ("error".equals(type)) {
			// go handleCustomException
			throw new CustomGenericException("E888", "This is custom message");
		} else if ("io-error".equals(type)) {
			// go handleAllException
			throw new IOException();
		} else {
			return new ModelAndView("simple").addObject("msg", type);
		}
	}
}

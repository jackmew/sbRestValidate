/**
 * 
 */
package org.jackho.sbRestValidate.controller;

import org.jackho.sbRestValidate.dto.CustomGenericException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author jackho
 *
 */
@ControllerAdvice
public class SimpleGlobalExceptionController {

	@ExceptionHandler(CustomGenericException.class)
	public ModelAndView handleCustomException(CustomGenericException ex) {
 
		ModelAndView model = new ModelAndView("error/generic_error");
		model.addObject("errCode", ex.getErrCode());
		model.addObject("errMsg", ex.getErrMsg());
 
		return model;
 
	}
 
	@ExceptionHandler(Exception.class)
	public ModelAndView handleAllException(Exception ex) {
 
		ModelAndView model = new ModelAndView("error/generic_error");
		model.addObject("errMsg", "this is Exception.class");
 
		return model;
 
	}
}

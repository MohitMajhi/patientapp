package com.app.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionHandlerControllerAdvice {
	@ExceptionHandler(DataNotFoundException.class)
	ModelAndView handelDataNotFoundException(DataNotFoundException e)
	{
		ModelAndView mv=new ModelAndView();
		ExceptionResponce responce=new ExceptionResponce();
		responce.setErrorMessage(e.getMessage());
		mv.addObject("res",responce);
		mv.setViewName("fail");
		return mv;
	}
	@ExceptionHandler(WrongDataException.class)
	ModelAndView handelWrongDataException(WrongDataException e)
	{
		ModelAndView mv=new ModelAndView();
		ExceptionResponce responce=new ExceptionResponce();
		responce.setErrorMessage(e.getMessage());
		mv.addObject("res",responce);
		mv.setViewName("fail");
		return mv;
	}
	
	@ExceptionHandler(Exception.class)
	ModelAndView handelException(Exception e)
	{
		ModelAndView mv=new ModelAndView();
		ExceptionResponce responce=new ExceptionResponce();
		responce.setErrorMessage(e.getMessage());
		mv.addObject("res",responce);
		mv.setViewName("fail");
		return mv;
	}
}

package cn.heweiming.up.advice;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionHandlerAdvice {

	@ExceptionHandler(value=Exception.class)
	public ModelAndView exception(Exception e){
		ModelAndView modelAndView = new ModelAndView("error");
		modelAndView.addObject("errMsg", e.getMessage());
		return modelAndView;
	}
	
	@ModelAttribute
	public void addAttributes(Model model){
		model.addAttribute("msg", "额外消息");
	}
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder){
		webDataBinder.setDisallowedFields("test");
	}
	
	
}

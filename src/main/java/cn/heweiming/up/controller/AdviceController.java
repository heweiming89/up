package cn.heweiming.up.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/advice")
public class AdviceController {

	@RequestMapping("01")
	public String getSomething(@ModelAttribute("msg") String msg,String test){
		System.out.println(test);
		throw new IllegalArgumentException("test1111");
//		return "";
	}
	
}

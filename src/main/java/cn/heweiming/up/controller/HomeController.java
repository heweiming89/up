package cn.heweiming.up.controller;

import javax.sql.DataSource;

import org.activiti.engine.ProcessEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	public HomeController() {
		System.err.println("HomeController.HomeController()");
	}

	@Autowired
	DataSource dataSource;
	
	@Autowired
	ProcessEngine processEngine;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String home(){
		System.err.println("test1122");
		System.err.println(dataSource);
		System.err.println(processEngine);
		return "home";
	}
	
}

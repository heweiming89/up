package cn.heweiming.up.controller;

import javax.sql.DataSource;

import org.activiti.engine.ProcessEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSON;

import cn.heweiming.up.model.User;

@Controller
public class HomeController {
	
	public HomeController() {
		System.err.println("HomeController.HomeController()");
	}

	@Autowired
	DataSource dataSource;
	
	@Autowired
	User user;
	
	@Autowired
	ProcessEngine processEngine;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String home(){
		System.err.println(JSON.toJSONString(user));
		System.err.println(dataSource);
		System.err.println(processEngine);
		return "home";
	}
	
}

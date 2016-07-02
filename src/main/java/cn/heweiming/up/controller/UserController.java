package cn.heweiming.up.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.heweiming.up.model.User;
import cn.heweiming.up.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;

	@RequestMapping("/user01")
	public List<User> user01(){
		return userService.selectAll();
	}
	
}

package cn.heweiming.up.test;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

import cn.heweiming.up.common.Person;
import cn.heweiming.up.config.RootConfig;
import cn.heweiming.up.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { RootConfig.class })
public class ApplicationTest01 {
	
	@Inject
	private Person person;
	
	@Inject
	private User user;
	
	@Test
	public void testContext(){
		System.out.println(JSON.toJSONString(user));
		
	}
	
	
	
	
	
}

package cn.heweiming.up.test;

import java.io.InputStream;
import java.util.List;

import javax.inject.Inject;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

import cn.heweiming.up.common.Person;
import cn.heweiming.up.config.SpringContextConfig;
import cn.heweiming.up.model.User;
import cn.heweiming.up.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { SpringContextConfig.class })
public class WebApplicationTest {

	@Inject
	private Person person;

	@Inject
	private User user;

	@Inject
	private ProcessEngine processEngine;

	@Inject
	RepositoryService repositoryService;

	@Inject
	private UserService userService;

	@Test
	public void testContext() {
		System.err.println(JSON.toJSONString(user));
		System.err.println(processEngine);

	}

	@Test
	public void integrationMybatis() {
		for (User user : userService.selectAll()) {
			System.err.println(JSON.toJSONString(user));
		}
	}

	@Test
	public void testActiviti() {
		RepositoryService repositoryService = processEngine.getRepositoryService();
		List<Deployment> list = repositoryService.createDeploymentQuery().list();
		System.out.println(list);
	}

	@Test
	public void testActiviti2() {
		String bpmn = "processes/HelloWorldProcess.bpmn";
		String png = "processes/HelloWorldProcess.png";

		ClassLoader classLoader = this.getClass().getClassLoader();

		InputStream bpmnIs = classLoader.getResourceAsStream(bpmn);
		InputStream pngIs = classLoader.getResourceAsStream(png);

		Deployment deployment = repositoryService.createDeployment()//
				.name("helloWorld")//
				.addInputStream("HelloWorldProcess.bpmn", bpmnIs)//
				.addInputStream("HelloWorldProcess.png", pngIs)//
				.deploy();

		System.out.println(deployment.getId()); // 10001
		System.out.println(deployment.getName());// helloWorld
		System.out.println(deployment.getDeploymentTime());//
	}

}

package cn.heweiming.up.test;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.activiti.engine.test.ActivitiRule;
import org.activiti.engine.test.Deployment;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:org/activiti/spring/test/junit4/springTypicalUsageTest-context.xml")
public class ActivitiTest {


	@Autowired
	@Rule
	public ActivitiRule activitiSpringRule;

	@Test
	@Deployment
	public void simpleProcessTest() {
		System.err.println(activitiSpringRule);
	}
}

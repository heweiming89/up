package cn.heweiming.up.config;

import javax.sql.DataSource;

import org.activiti.engine.DynamicBpmnService;
import org.activiti.engine.FormService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.ManagementService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.spring.ProcessEngineFactoryBean;
import org.activiti.spring.SpringProcessEngineConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
//@AutoConfigureAfter(MyBatisConfig.class)
public class ActivitiContextConfig {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private PlatformTransactionManager transactionManager;

	@Bean
	public SpringProcessEngineConfiguration processEngineConfiguration() {
		SpringProcessEngineConfiguration processEngineConfiguration = new SpringProcessEngineConfiguration();
		// 配置数据源
		processEngineConfiguration.setDataSource(dataSource);
		// 配置事务管理器，统一事务
		processEngineConfiguration.setTransactionManager(transactionManager);
		// 设置建表策略，如果没有表，自动创建表
		processEngineConfiguration.setDatabaseSchemaUpdate("true");
		return processEngineConfiguration;
	}

	@Bean
	public ProcessEngine processEngine(SpringProcessEngineConfiguration processEngineConfiguration) throws Exception {
		ProcessEngineFactoryBean processEngineFactoryBean = new ProcessEngineFactoryBean();
		processEngineFactoryBean.setProcessEngineConfiguration(processEngineConfiguration);
		return processEngineFactoryBean.getObject();
	}

	@Bean
	public RepositoryService repositoryService(ProcessEngine processEngine) {
		return processEngine.getRepositoryService();
	}

	@Bean
	public RuntimeService runtimeService(ProcessEngine processEngine) {
		return processEngine.getRuntimeService();
	}

	@Bean
	public TaskService taskService(ProcessEngine processEngine) {
		return processEngine.getTaskService();
	}

	@Bean
	public HistoryService historyService(ProcessEngine processEngine) {
		return processEngine.getHistoryService();
	}

	@Bean
	public FormService formService(ProcessEngine processEngine) {
		return processEngine.getFormService();
	}

	public void test() throws Exception {
		ProcessEngineFactoryBean processEngineFactoryBean = new ProcessEngineFactoryBean();
		ProcessEngine processEngine = processEngineFactoryBean.getObject();

		DynamicBpmnService dynamicBpmnService = processEngine.getDynamicBpmnService();
		FormService formService = processEngine.getFormService();
		HistoryService historyService = processEngine.getHistoryService();
		IdentityService identityService = processEngine.getIdentityService();
		ManagementService managementService = processEngine.getManagementService();
		RepositoryService repositoryService = processEngine.getRepositoryService();
		RuntimeService runtimeService = processEngine.getRuntimeService();
		TaskService taskService = processEngine.getTaskService();

	}

}

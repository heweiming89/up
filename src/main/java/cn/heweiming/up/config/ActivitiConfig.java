package cn.heweiming.up.config;

import javax.sql.DataSource;

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
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
// @AutoConfigureAfter(MyBatisConfig.class)
public class ActivitiConfig {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private PlatformTransactionManager transactionManager;

	@Bean
	public SpringProcessEngineConfiguration processEngineConfiguration() {
		SpringProcessEngineConfiguration processEngineConfig = new SpringProcessEngineConfiguration();
		// 配置数据源
		processEngineConfig.setDataSource(dataSource);
		// 配置事务管理器，统一事务
		processEngineConfig.setTransactionManager(transactionManager);
		// 设置建表策略，如果没有表，自动创建表
		processEngineConfig.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);

		processEngineConfig.setMailServerHost("localhost");
		processEngineConfig.setMailServerPort(5025);
		processEngineConfig.setJobExecutorActivate(false);

		return processEngineConfig;
	}

	@Bean
	public ProcessEngine processEngine(SpringProcessEngineConfiguration processEngineConfiguration) throws Exception {
		ProcessEngineFactoryBean processEngineFactoryBean = new ProcessEngineFactoryBean();
		processEngineFactoryBean.setProcessEngineConfiguration(processEngineConfiguration);
		return processEngineFactoryBean.getObject();
	}

	@Bean // 管理流程定义
	public RepositoryService repositoryService(ProcessEngine processEngine) {
		return processEngine.getRepositoryService();
	}

	@Bean // 执行管理，包括启动、推进、删除流程实例等操作
	public RuntimeService runtimeService(ProcessEngine processEngine) {
		return processEngine.getRuntimeService();
	}

	@Bean // 任务管理
	public TaskService taskService(ProcessEngine processEngine) {
		return processEngine.getTaskService();
	}

	@Bean // 一个可选服务，任务表单管理
	public FormService formService(ProcessEngine processEngine) {
		return processEngine.getFormService();
	}

	@Bean // 历史管理(执行完的数据的管理)
	public HistoryService historyService(ProcessEngine processEngine) {
		return processEngine.getHistoryService();
	}

	@Bean
	public ManagementService managementService(ProcessEngine processEngine) {
		return processEngine.getManagementService();
	}

	@Bean // 组织结构管理
	public IdentityService identityService(ProcessEngine processEngine) {
		return processEngine.getIdentityService();
	}

	// @Bean
	// public ActivitiRule activitiRule(ProcessEngine processEngine) {
	// ActivitiRule activitiRule = new ActivitiRule();
	// activitiRule.setProcessEngine(processEngine);
	// return activitiRule;
	// }

	public void test() throws Exception {
		// ProcessEngineFactoryBean processEngineFactoryBean = new
		// ProcessEngineFactoryBean();
		// ProcessEngine processEngine = processEngineFactoryBean.getObject();
		//
		// DynamicBpmnService dynamicBpmnService =
		// processEngine.getDynamicBpmnService();
		// FormService formService = processEngine.getFormService();
		// HistoryService historyService = processEngine.getHistoryService();
		// IdentityService identityService = processEngine.getIdentityService();
		// ManagementService managementService =
		// processEngine.getManagementService();
		// RepositoryService repositoryService =
		// processEngine.getRepositoryService();
		// RuntimeService runtimeService = processEngine.getRuntimeService();
		// TaskService taskService = processEngine.getTaskService();

	}

}

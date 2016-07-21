package cn.heweiming.up.config;

import java.util.Date;
import java.util.concurrent.Executor;

import javax.sql.DataSource;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import cn.heweiming.up.model.User;

@Configuration
@PropertySource(value = { "classpath:db.properties" })
@ComponentScan(basePackages = { "cn.heweiming.up" }, excludeFilters = {
		@Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)
		/*
		 * ,@Filter(type = FilterType.ANNOTATION, value = Configuration.class)
		 */ })
//@EnableAutoConfiguration
// @EnableTransactionManagement // 启注解事务管理，等同于xml配置方式的 <tx:annotation-driven />
// @EnableAspectJAutoProxy
@EnableAsync
//@EnableScheduling
public class SpringContextConfig implements AsyncConfigurer {

	@Autowired
	Environment env;

	@Override
	public Executor getAsyncExecutor() {
		System.err.println("SpringContextConfig.getAsyncExecutor()");
		ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
		taskExecutor.setCorePoolSize(10);
		taskExecutor.setMaxPoolSize(20);
		taskExecutor.setQueueCapacity(30);
		taskExecutor.initialize();
		return taskExecutor;
	}

	@Override
	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
		// TODO Auto-generated method stub
		return null;
	}

	@Bean
	@Profile("dev")
	// @Primary
	public User devUser() {
		User user = new User();
		user.setName("我是开发环境下的程序员");
		user.setLoginname("ZengAniu");
		user.setPassword("123456");
		user.setAge(22);
		user.setGender("男");
		user.setBirthday(new Date());
		return user;
	}

	@Bean
	@Profile("prod")
	// @Primary
	public User prodUser() {
		User user = new User();
		user.setName("我是生产环境下的维护员");
		user.setLoginname("ZengAniu");
		user.setPassword("123456");
		user.setAge(22);
		user.setGender("男");
		user.setBirthday(new Date());
		return user;
	}

	@Bean
	public DataSource dataSource() {
		// BasicDataSource dataSource = new BasicDataSource();
		// dataSource.setDriverClassName(env.getProperty("jdbc.driver"));
		// dataSource.setUrl(env.getProperty("jdbc.url"));
		// dataSource.setUsername(env.getProperty("jdbc.username"));
		// dataSource.setPassword("");
		// dataSource.setInitialSize(10);
		// dataSource.setMaxIdle(5);
		DataSource build = DataSourceBuilder.create()//
				.driverClassName(env.getProperty("jdbc.driver"))//
				.url(env.getProperty("jdbc.url"))//
				.username(env.getProperty("jdbc.username"))//
				.password("")//
				.build();
		return build;
	}

	// @Bean(name = "sqlSessionFactory")
	// public SqlSessionFactory sqlSessionFactoryBean(DataSource dataSource)
	// throws Exception {
	// SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
	// factoryBean.setDataSource(dataSource);
	// ResourcePatternResolver resolver = new
	// PathMatchingResourcePatternResolver();
	// factoryBean.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));
	// factoryBean.setConfigLocation(resolver.getResource("classpath:mybatis-config.xml"));
	// return factoryBean.getObject();
	// }

	// @Bean
	// public MapperScannerConfigurer mapperScannerConfigurer() {
	// MapperScannerConfigurer mapperScannerConfigurer = new
	// MapperScannerConfigurer();
	// mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
	// mapperScannerConfigurer.setBasePackage("cn.heweiming.up.mapper");
	// return mapperScannerConfigurer;
	// }

	// @Bean
	// public PlatformTransactionManager transactionManager(DataSource
	// dataSource) {
	// return new DataSourceTransactionManager(dataSource);
	// }

	public static void main(String[] args) {
		SpringApplication.run(SpringContextConfig.class, args);
	}

}

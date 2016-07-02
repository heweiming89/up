package cn.heweiming.up.config;

import java.util.Date;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import cn.heweiming.up.model.User;

@Configuration
@PropertySource(value = { "classpath:config.properties" })
@ComponentScan(basePackages = { "cn.heweiming.up" }, excludeFilters = {
		@Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class) })
public class RootConfig {

	@Autowired
	Environment env;

	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(env.getProperty(""));
		dataSource.setUrl(env.getProperty(""));
		dataSource.setUsername(env.getProperty(""));
		dataSource.setPassword("");

		dataSource.setInitialSize(10);
		dataSource.setMaxIdle(5);

		return dataSource;

	}

	@Bean(name = "sqlSessionFactory")
	public SqlSessionFactory sqlSessionFactoryBean(DataSource dataSource)
			throws Exception {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(dataSource);

		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		factoryBean.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));
		factoryBean.setConfigLocation(resolver.getResource("classpath:mybatis-config.xml"));
		
		return factoryBean.getObject();
	}

	@Bean
	public User user() {
		User user = new User();
		user.setName(env.getProperty("jdbc.mysql.url"));
		user.setLoginname("ZengAniu");
		user.setPassword("123456");
		user.setAge(22);
		user.setGender("男");
		user.setBirthday(new Date());
		return user;
	}

}

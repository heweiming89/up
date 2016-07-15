package cn.heweiming.up.config;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class DispatchServletConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

	// @Bean
	// public EmbeddedServletContainerFactory servletContainer() {
	// TomcatEmbeddedServletContainerFactory factory = new
	// TomcatEmbeddedServletContainerFactory();
	// return factory;
	// }

	@Override
	protected void customizeRegistration(Dynamic registration) {
		String location = "F:/MyProject/upload";
		long maxFileSize = 2 * 1024 * 1024;
		long maxRequestSize = 4 * 1024 * 1024;
		int fileSizeThreshold = 0;
		registration.setMultipartConfig(
				new MultipartConfigElement(location, maxFileSize, maxRequestSize, fileSizeThreshold));
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] { SpringContextConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { MVCServletConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

}

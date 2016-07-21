package cn.heweiming.up.config;

import javax.servlet.FilterRegistration.Dynamic;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.DispatcherServlet;

public class WebInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {

		String profile = "prod";
		servletContext.setInitParameter("spring.profiles.default", profile);

		// AnnotationConfigWebApplicationContext webApplicationContext = new
		// AnnotationConfigWebApplicationContext();
		// webApplicationContext.register(MvcConfig.class);
		// webApplicationContext.setServletContext(servletContext);
		//
		// javax.servlet.ServletRegistration.Dynamic dispatcherServlet =
		// servletContext.addServlet("dispatcher", new
		// DispatcherServlet(webApplicationContext));
		// dispatcherServlet.addMapping("/");
		// dispatcherServlet.setLoadOnStartup(1);

		// 中文乱码
		Dynamic characterEncodingFilter = servletContext.addFilter("characterEncodingFilter",
				CharacterEncodingFilter.class);
		characterEncodingFilter.setInitParameter("encoding", "UTF-8");
		characterEncodingFilter.setInitParameter("forceEncoding", "true");
		characterEncodingFilter.addMappingForUrlPatterns(null, false, "/*");

		// REST
		Dynamic hiddenHttpMethodFilter = servletContext.addFilter("hiddenHttpMethodFilter",
				HiddenHttpMethodFilter.class);
		hiddenHttpMethodFilter.addMappingForUrlPatterns(null, false, "/*");

		// javax.servlet.ServletRegistration.Dynamic rainServlet =
		// servletContext.addServlet("rainServlet", RainServlet.class);
		// rainServlet.addMapping("/rain");

	}

}

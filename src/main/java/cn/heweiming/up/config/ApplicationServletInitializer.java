package cn.heweiming.up.config;

import javax.servlet.FilterRegistration.Dynamic;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.filter.CharacterEncodingFilter;

import cn.heweiming.up.servlet.RainServlet;

public class ApplicationServletInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		Dynamic characterEncodingFilter = servletContext
				.addFilter("characterEncodingFilter", CharacterEncodingFilter.class);
		characterEncodingFilter.setInitParameter("encoding", "UTF-8");
		characterEncodingFilter.setInitParameter("forceEncoding", "true");
		characterEncodingFilter.addMappingForUrlPatterns(null, false, "/*");

		// javax.servlet.ServletRegistration.Dynamic rainServlet =
		// servletContext.addServlet("rainServlet", RainServlet.class);
		// rainServlet.addMapping("/rain");

	}

}

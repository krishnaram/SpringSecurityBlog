package com.springsecurityblog.config;

/**
 * Author: Ramakrishna Panni
 * Class: AppIntializer
 * Details: It starts app by registering Configuration and adding dispatcher servlet
 */

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class AppIntializer implements WebApplicationInitializer{

	
	@Autowired
	public void onStartup(ServletContext servletCon) throws ServletException {
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(ApplicationConfig.class);
		servletCon.addListener(new ContextLoaderListener(rootContext));
		
		AnnotationConfigWebApplicationContext servletConfig = new AnnotationConfigWebApplicationContext();
		servletConfig.register(DispatcherConfig.class);
		
		ServletRegistration.Dynamic registration = servletCon.addServlet("dispatcher", new DispatcherServlet(servletConfig));
		registration.setLoadOnStartup(1);
		//it recognizes every url starting with / in localhost
		registration.addMapping("/");
	}

}

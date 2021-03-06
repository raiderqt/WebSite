
package com.WebSite.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer
{

	@Override
	public void addViewControllers(ViewControllerRegistry registry)
	{
		registry.addViewController("/food/add").setViewName("foodAdd");
		registry.addViewController("/admin").setViewName("admin");
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/basket").setViewName("basket");
	}

	/*
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry)
	{

		registry
				.addResourceHandler("/uploads/**")
				.addResourceLocations("uploads/");


	}

	 */
}
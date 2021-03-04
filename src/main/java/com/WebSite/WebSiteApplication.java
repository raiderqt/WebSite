package com.WebSite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebSiteApplication
{
	public static void main(String[] args)
	{
		//new File(FileUploadController.uploadDirectory).mkdir();
		SpringApplication.run(WebSiteApplication.class, args);
	}

}

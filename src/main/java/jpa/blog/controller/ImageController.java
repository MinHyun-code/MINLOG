package jpa.blog.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@RestController
public class ImageController implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		String os = System.getProperty("os.name").toLowerCase();
		String path = "file:/c:/MinLOG/";

		if(!os.contains("win")){
			path = "file:/home/ubuntu/";
		}

		System.err.println("********");
		System.err.println(path);
		
		// TODO Auto-generated method stub
		registry
			// 이미지 파일의 요청 경로를 지정한다.
			.addResourceHandler("/images/**")
			// 이미지 파일을 불러올 로컬 저장소의 위치를 지정한다.
			.addResourceLocations(path);
	}
}
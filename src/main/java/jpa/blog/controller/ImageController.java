package jpa.blog.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@RestController
public class ImageController implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		registry
			// �̹��� ������ ��û ��θ� �����Ѵ�.
			.addResourceHandler("/images/**")
			// �̹��� ������ �ҷ��� ���� ������� ��ġ�� �����Ѵ�.
			.addResourceLocations("file:/c:/MinLOG/");
	}
}
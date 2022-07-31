package pe.javita.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
public class ViewResolverClass {
	
	@Bean
	public ViewResolver viewResolver() {
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		          viewResolver.setPrefix("/WEB-INF/views/");
		          viewResolver.setSuffix(".jsp");
		          
		          
		return viewResolver;
	}

}

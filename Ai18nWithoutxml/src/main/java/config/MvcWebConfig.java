package config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@Configuration
@EnableWebMvc
@ComponentScan("controller")
public class MvcWebConfig implements WebMvcConfigurer{

		public void configureViewResolvers(ViewResolverRegistry registry) {
			registry.jsp("/views/", ".jsp");
		}
		
		public void addResourceHandlers(ResourceHandlerRegistry registry) {
			registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
		}
		
		@Bean
		public MessageSource messageSource() {
			ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
			messageSource.setBasename("classpath:locale/messages");
			messageSource.setDefaultEncoding("UTF-8");
			messageSource.setUseCodeAsDefaultMessage(true);
			return messageSource;
		}
		
		@Bean
		public LocaleResolver localeResolver() {
			CookieLocaleResolver ck = new CookieLocaleResolver();
			return ck;
		}
		
		public void addInterceptors(InterceptorRegistry registry) {
			LocaleChangeInterceptor lc = new LocaleChangeInterceptor();
			lc.setParamName("lang");
			registry.addInterceptor(lc);
		}
	
}











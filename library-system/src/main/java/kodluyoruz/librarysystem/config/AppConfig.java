package kodluyoruz.librarysystem.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class AppConfig {

	
	    @Bean
	    public Docket api() { 
	    	Parameter authHeader =  new ParameterBuilder()
	  			  .parameterType("header")
	  			  .name("Authorization")
	  			  .modelRef(new ModelRef("string"))
	  			  .build();
	        return new Docket(DocumentationType.SWAGGER_2)  
	         .select()                                  
	          .apis(RequestHandlerSelectors.basePackage("kodluyoruz.librarysystem"))                                       
	          .build()  
	        .globalOperationParameters(Collections.singletonList(authHeader));
	    }
}

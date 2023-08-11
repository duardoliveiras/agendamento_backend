package eng_software.agendamento.Configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/*
Essa classe eh para permitir a comunicacao entre o servico front web
como nosso servico front esta localizado em outro servidor eh necessario
liberar o acesso, devido a politica de CORS (Cross-origin Resource Sharing)
 */
@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {



    @Override
    public void addCorsMappings(CorsRegistry registry){

        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000")
                .allowedMethods("GET","POST","DELETE","PUT")
                .allowedHeaders("*")
                .allowCredentials(false)
                .maxAge(3600);

    }

}

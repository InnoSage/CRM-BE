package innosage.crm.global.config;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI SpringCodeBaseAPI() {
        Info info = new Info()
                .title("CRM API")
                .description("CRM API 명세서")
                .version("1.0.0");

        return new OpenAPI()
                .addServersItem(new Server().url("/dev"))
                .info(info);
    }
}

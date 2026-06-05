package cl.dgac.huinspector.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ConexionInspector {
    @Bean(name ="isnpector")
    public WebClient isnpector(){
        return WebClient.builder().baseUrl("http://localhost:8087")
        .build();
    }
    @Bean (name = "planvuelo")
    public WebClient planvuelo(){
        return WebClient.builder().baseUrl("http://localhost:8084")
        .build();
    }
    @Bean(name ="incidente")
    public WebClient incidente(){
        return WebClient.builder().baseUrl("http://localhost:8091")
        .build();}


}

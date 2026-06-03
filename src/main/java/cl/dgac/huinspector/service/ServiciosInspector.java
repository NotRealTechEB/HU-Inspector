package cl.dgac.huinspector.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import cl.dgac.huinspector.dtos.DtoInspector;

@Service
public class ServiciosInspector {
    private final WebClient webClient;
    
    public ServiciosInspector (@Qualifier("isnpector")WebClient conexion){
        this.webClient=conexion;
    }
    
    public ResponseEntity<DtoInspector> validarRut(String rut){

            return webClient.get()
            .uri(uriBuilder -> uriBuilder
            .path("/api/v1.5/Inspector/bucarRut")
            .queryParam("rut", rut)
            .build()
            ).retrieve()
            .toEntity(DtoInspector.class)
            .block()
            ;
    }
}

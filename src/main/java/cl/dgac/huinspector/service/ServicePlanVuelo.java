package cl.dgac.huinspector.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import cl.dgac.huinspector.dtos.DtoPlanVuelo;

@Service 
public class ServicePlanVuelo {

    private final WebClient planvuelo;
    public ServicePlanVuelo (@Qualifier("planvuelo")WebClient conexion){
        this.planvuelo= conexion;
    }
    public List<DtoPlanVuelo> listar(){
        return planvuelo.get().uri(uriBuilder->uriBuilder
            .path("/api/v1/plan-vuelo")
            .build()
        ).retrieve()
        .bodyToMono(new ParameterizedTypeReference<List<DtoPlanVuelo>>() {})
        .block();
    }

}

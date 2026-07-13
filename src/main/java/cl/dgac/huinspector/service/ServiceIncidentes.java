package cl.dgac.huinspector.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import cl.dgac.huinspector.dtos.DtoIncidente;

@Service
public class ServiceIncidentes {

    private final WebClient cliente;

    public ServiceIncidentes (@Qualifier("incidente") WebClient client){
        this.cliente= client;
    }
    public List<DtoIncidente> lsitaraincidentes(){
        return cliente.get().uri(builder -> builder
            .path("/api/v1.0/Incidentes/listarIncidentes")
            .build()
        ).retrieve().bodyToMono(new ParameterizedTypeReference <List<DtoIncidente>>(){}).block();
    }
    
    public List<DtoIncidente> listarFechas(String f1,String f2){
        return cliente.get().uri(builder -> builder 
            .path("/api/v1.0/Incidentes/filtradoPorFechas").queryParam("fechaInicio", f1)
            .queryParam("fechaFinal", f2)
            .build()
        ).retrieve().bodyToMono(new ParameterizedTypeReference <List<DtoIncidente>>() {}).block();
    }
    public List<DtoIncidente> filtarTipo(List<DtoIncidente> ex, String tipo){
        List<DtoIncidente> nueva = new ArrayList<>();
        for (DtoIncidente dtoIncidente : ex) {
            if (dtoIncidente.tipo().tipo().equals(tipo)){
                nueva.add(dtoIncidente);
            }
        }
        return nueva;
    }

}

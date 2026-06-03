package cl.dgac.huinspector.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cl.dgac.huinspector.dtos.DtoInspector;
import cl.dgac.huinspector.service.ServiciosInspector;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/api/v1/huInspector")
public class Controller {
    private final  ServiciosInspector servicio;

    public Controller (ServiciosInspector servicio){
        this.servicio=servicio;
    }

    

    @GetMapping("/validar")
    public ResponseEntity<DtoInspector> validador (@RequestParam(name ="rut") String rut) {
        return servicio.validarRut(rut);
    }
    
}

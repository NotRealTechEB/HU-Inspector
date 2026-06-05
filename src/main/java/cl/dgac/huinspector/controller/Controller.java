package cl.dgac.huinspector.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cl.dgac.huinspector.dtos.DtoInspector;
import cl.dgac.huinspector.dtos.DtoPlanVuelo;
import cl.dgac.huinspector.service.ServicePlanVuelo;
import cl.dgac.huinspector.service.ServiciosInspector;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/api/v1/huInspector")
public class Controller {
    private final  ServiciosInspector servicio;
    private final ServicePlanVuelo servicio2;

    public Controller (ServiciosInspector servicio, ServicePlanVuelo servicio2){
        this.servicio=servicio;
        this.servicio2=servicio2;
    }

    

    @GetMapping("/validar")
    public ResponseEntity<DtoInspector> validador (@RequestParam(name ="rut") String rut) {
        return servicio.validarRut(rut);
    }
    
    @GetMapping("listarPlanvuelo")
    public ResponseEntity<List<DtoPlanVuelo>> listar() {
        return new ResponseEntity<List<DtoPlanVuelo>>(servicio2.listar(),HttpStatus.OK);
    }
    
    
}

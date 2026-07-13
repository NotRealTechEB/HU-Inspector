package cl.dgac.huinspector.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.dgac.huinspector.dtos.DtoIncidente;
import cl.dgac.huinspector.dtos.DtoInspector;
import cl.dgac.huinspector.dtos.DtoPlanVuelo;
import cl.dgac.huinspector.service.ServiceIncidentes;
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
    private final ServiceIncidentes servicio3;

    public Controller (ServiciosInspector servicio,
        ServicePlanVuelo servicio2,
        ServiceIncidentes servicio3){
        this.servicio=servicio;
        this.servicio2=servicio2;
        this.servicio3=servicio3;
    }

    

    @GetMapping("/validar")
    public ResponseEntity<DtoInspector> validador (@RequestParam(name ="rut") String rut) {
        return servicio.validarRut(rut);
    }
    
    @GetMapping("listarPlanvuelo")
    public ResponseEntity<List<DtoPlanVuelo>> listar() {
        return new ResponseEntity<List<DtoPlanVuelo>>(servicio2.listar(),HttpStatus.OK);
    }
    //__________INCIDENTES________//
    @GetMapping("listarIncidentes")
    public ResponseEntity<List<DtoIncidente>> listarIncidentes() {
        return new ResponseEntity<List<DtoIncidente>>(servicio3.lsitaraincidentes(), HttpStatus.OK);
    }
    @GetMapping("listarIncidentesporFecha")
    public ResponseEntity<List<DtoIncidente>> getMethodName(@RequestParam(name="fechaInicio") String fechaInicio,
    @RequestParam(name="fechaFin") String fechaFin) {
        return new ResponseEntity<List<DtoIncidente>>(servicio3.listarFechas(fechaInicio, fechaFin),HttpStatus.OK);
    }
    
    @GetMapping("listarTipo")
    public ResponseEntity<List<DtoIncidente>> getMethodName2(@RequestParam(name = "tipo") String tipo) {
        return new ResponseEntity<List<DtoIncidente>>(servicio3.filtarTipo(servicio3.lsitaraincidentes(), tipo),HttpStatus.OK);
    }

    
    
}

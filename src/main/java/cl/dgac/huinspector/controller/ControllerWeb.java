package cl.dgac.huinspector.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.SessionScope;

import cl.dgac.huinspector.dtos.DtoIncidente;
import cl.dgac.huinspector.dtos.DtoInspector;
import cl.dgac.huinspector.dtos.DtoPlanVuelo;
import cl.dgac.huinspector.service.ServiceIncidentes;
import cl.dgac.huinspector.service.ServicePlanVuelo;
import cl.dgac.huinspector.service.ServiciosInspector;


@Controller
@SessionScope
public class ControllerWeb {
    
    private final  ServiciosInspector servicio;
    private final ServicePlanVuelo servicio2;
    private final ServiceIncidentes servicio3;
    private  DtoInspector inspector;

    public ControllerWeb (
        ServiciosInspector servicio,
        ServicePlanVuelo servicio2,
        ServiceIncidentes servicio3){
        this.servicio=servicio;
        this.servicio2=servicio2;
        this.servicio3=servicio3;
        this.inspector = null;
    }
///____inicio ParteValidadora_________
        @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("Inspector", this.inspector != null);
        model.addAttribute("dtoInspector", this.inspector);  
        return "index"; 
    }

    @GetMapping("/validar")
    public String validar(@RequestParam("rut") String rut, Model model) {
        this.inspector = servicio.validarRut(rut).getBody();
        System.err.println(this.inspector);
        return "redirect:/"; }
    ///___________Incidentes____________
    
    @GetMapping("/incidentes")
public String listarIncidentes(Model model) {
    List<DtoIncidente> incidentes = servicio3.lsitaraincidentes();
    model.addAttribute("listaIncidentes", incidentes);
    model.addAttribute("Inspector", this.inspector != null);
    model.addAttribute("dtoInspector", this.inspector);
    return "incidentes"; // Nombre de tu archivo HTML
}
    @GetMapping("/autorizar-vuelos")
    public String ListaPlanes(Model model) {
        List<String> estadosPosibles = List.of("PENDIENTE", "APROBADO", "RECHAZADO", "CANCELADO");
        model.addAttribute("estados", estadosPosibles);
        List<DtoPlanVuelo> planVuelos=servicio2.listar();
        model.addAttribute("planesVuelo", planVuelos);
        model.addAttribute("Inspector",this.inspector);
        model.addAttribute("dtoInsoector", this.inspector);
        System.out.println("DEBUG: Se encontraron " + (planVuelos != null ? planVuelos.size() : "null") + " planes.");
        return "planesVuelo";
    }
   /// @PostMapping("/autorizar-vuelos/aprobar")
///public String aprobarVuelo(@RequestParam("codigoVuelo") String codigoVuelo) {
   /// servicio2.aprobarVuelo(codigoVuelo);
   /// return "redirect:/autorizar-vuelos";
///}

    
}

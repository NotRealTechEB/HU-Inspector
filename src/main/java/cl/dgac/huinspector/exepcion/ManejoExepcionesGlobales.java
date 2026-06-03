package cl.dgac.huinspector.exepcion;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import cl.dgac.huinspector.dtos.Exepciones;

@ControllerAdvice
public class ManejoExepcionesGlobales {

    @ExceptionHandler(ErrorRecursos.class)
    public ResponseEntity<Exepciones> ErroresEnmicroservicio(ErrorRecursos ex,
    WebRequest exWeb){
        HttpStatus status = HttpStatus.BAD_GATEWAY;
        String ruta = exWeb.getDescription(false).replace("uri=","");
        Exepciones dto = new Exepciones(
            LocalDateTime.now(),
            status.value(),
            status.getReasonPhrase(),
            ex.getMessage(),
            ruta
        );
        return ResponseEntity.status(status).body(dto);
    }
}

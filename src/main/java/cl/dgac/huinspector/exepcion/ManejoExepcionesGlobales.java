package cl.dgac.huinspector.exepcion;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.reactive.function.client.WebClientRequestException;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import cl.dgac.huinspector.dtos.Exepciones;

@ControllerAdvice
public class ManejoExepcionesGlobales {
    private ResponseEntity<Exepciones> construirRespuesta(HttpStatus status, String mensaje, WebRequest request) {
        String ruta = request.getDescription(false).replace("uri=", "");
        
        Exepciones dto = new Exepciones(
            LocalDateTime.now(),
            status.value(),
            status.getReasonPhrase(),
            mensaje,
            ruta
        );
        
        return ResponseEntity.status(status).body(dto);
    }

    

    @ExceptionHandler(WebClientRequestException.class)
    public ResponseEntity<Exepciones> manejarServicioCaido(WebClientRequestException ex, WebRequest request) {
        
        return construirRespuesta(HttpStatus.BAD_GATEWAY, "microservicio caido", request);
    }
    @ExceptionHandler(WebClientResponseException.class)
    public ResponseEntity<String> manejarErrorWebClient(WebClientResponseException ex) {
        String jsonOriginal = ex.getResponseBodyAsString();
        return ResponseEntity
                .status(ex.getStatusCode())
                .header("Content-Type", "application/json")
                .body(jsonOriginal);
    }

}

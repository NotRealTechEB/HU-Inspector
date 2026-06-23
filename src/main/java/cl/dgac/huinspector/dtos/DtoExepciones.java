package cl.dgac.huinspector.dtos;

import java.time.LocalDateTime;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record DtoExepciones(
    LocalDateTime fecha,
    int codigoHttp,
    String error,
    String mensaje,
    Map<String, String> detalles,
    String ruta
) {

}

package cl.dgac.huinspector.dtos;

import java.time.LocalDateTime;

public record Exepciones(
    LocalDateTime timestap,
    Integer codigoestado,
    String error,
    String mensaje,
    String ruta
) {

}

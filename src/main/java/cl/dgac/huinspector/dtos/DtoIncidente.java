package cl.dgac.huinspector.dtos;

import java.time.LocalDateTime;


public record DtoIncidente(
    Long Id,
    String descripcion,
    DtoTipoIncidente tipo,
    String quien,
    LocalDateTime fecha_reporte,
    boolean resuelto,
    String region
) {

}

package cl.dgac.huinspector.dtos;

import java.time.LocalDateTime;

public record DtoPlanVuelo(
    String codigoVuelo,
    String rutEmpresaMandante,
    String numeroRegistro,
    LocalDateTime fechaPV,
    String psGPS,
    double altMax,
    String region,
    String estadoPV,
    String  rutPiloto
) {
}

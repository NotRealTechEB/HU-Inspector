package cl.dgac.huinspector.dtos;

import java.time.LocalDateTime;

public record DtoPlanVuelo(
    LocalDateTime horaDespegue,
    LocalDateTime horaAterrizajeEstimada,
    int tiempoEstimado,
    String psGPS,
    double altMax,
    String region,
    String nomCompPiloto,
    String rutPiloto,
    String numeroRegistro
) {
}

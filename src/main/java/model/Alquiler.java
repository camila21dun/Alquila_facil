package model;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Alquiler {

    private Cliente cliente;
    private Vehiculo vehiculo;
    private LocalDateTime fechaRegistro;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private float valorTotal;

}

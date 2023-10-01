package model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vehiculo {

    private String placa;
    private String referencia;
    private String marca;
    private int modelo;
    private String foto;
    private int kilometraje;
    private float precioDia;
    private boolean esAutomatico;
    private int numPuertas;
}
package model;

import exception.AlquilaException;
import lombok.Getter;


import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

@Getter
public class AlquilaFacil {

    private static final Logger LOGGER = Logger.getLogger(AlquilaFacil.class.getName());

    private ArrayList<Vehiculo> vehiculos;

    private  ArrayList<Cliente> clientes;

    private  ArrayList<Alquiler> alquileres;

    private static AlquilaFacil alquilaFacil;

    private AlquilaFacil(){

        try {
            FileHandler fh = new FileHandler("logs.log", true);
            fh.setFormatter( new SimpleFormatter());
            LOGGER.addHandler(fh);
        }catch (IOException e){
            LOGGER.log( Level.SEVERE, e.getMessage() );
        }

        LOGGER.log( Level.INFO, "Se crea una nueva instancia de AlquilaFacil" );
        this.vehiculos = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.alquileres = new ArrayList<>();
    }

    /**
     * Método que se usará en las otras clases que requieran una instancia de esta clase
     * @return Instancia del objeto AlquilaFacil
     */
    public static AlquilaFacil getInstance(){
        if(alquilaFacil == null){
            alquilaFacil = new AlquilaFacil();
        }

        return alquilaFacil;
    }

    public Cliente registrarCliente(String cedula, String nombreCompleto,String email,String direccion,String ciudad,String telefono) throws  AlquilaException {

        if(cedula == null || cedula.isBlank()){
            LOGGER.log( Level.WARNING, "La cédula es obligatoria para el registro" );
            throw new AlquilaException("La cédula es obligatoria");
        }

        if( obtenerCliente(cedula) != null ){
            LOGGER.log( Level.SEVERE, "La cédula "+cedula+" es obligatoria para el registro del cliente" );
            throw new AlquilaException("La cédula "+cedula+" ya está registrada");
        }

        //Demás validaciones

        Cliente cliente = Cliente.builder()
                .cedula(cedula)
                .nombreCompleto(nombreCompleto)
                .email(email)
                .direccion(direccion)
                .ciudad(ciudad)
                .telefono(telefono)
                .build();

        clientes.add(cliente);

        LOGGER.log(Level.INFO, "Se ha registrado un nuevo cliente con la cédula: "+cedula);

        return cliente;
    }

    public Vehiculo registrarVehiculo(String placa,String referencia,String marca,int modelo,String foto,int kilometraje,float precioDia,boolean esAutomatico,int numPuertas) throws  AlquilaException {

        //Validar atributos

        if(kilometraje < 0){
            throw new AlquilaException("El kilometraje no puede ser negativo");
        }

        Vehiculo vehiculo = Vehiculo.builder()
                .placa(placa)
                .referencia(referencia)
                .marca(marca)
                .modelo(modelo)
                .foto(foto)
                .kilometraje(kilometraje)
                .precioDia(precioDia)
                .esAutomatico(esAutomatico)
                .numPuertas(numPuertas)
                .build();

        vehiculos.add(vehiculo);

        return vehiculo;

    }

    public Alquiler registrarAlquiler(String cedulaCliente, String placaVehiculo, LocalDate fechaInicio, LocalDate fechaFin) throws Exception{

        if(fechaInicio.isAfter(fechaFin)){
            throw new Exception("La fecha de inicio no puede ser después de la fecha final");
        }

        //Diferencia de días
        long dias = fechaInicio.until(fechaFin, ChronoUnit.DAYS);

        //Buscar el cliente y el vehículo y agregarlo al objeto alquiler.

        Alquiler alquiler = Alquiler.builder()
                .fechaInicio(fechaInicio)
                .fechaFin(fechaFin)
                .fechaRegistro(LocalDateTime.now())
                .build();

        alquileres.add(alquiler);
        return alquiler;
    }

    public Cliente obtenerCliente(String cedula){

        for(Cliente c : clientes){
            if(c.getCedula().equals(cedula)){
                return c;
            }
        }

        return null;
    }


}

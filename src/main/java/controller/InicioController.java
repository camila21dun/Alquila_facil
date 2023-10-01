package controller;


import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class InicioController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnRegistrarCliente;

    @FXML
    private Button btnRegistrarVehiculo;

    @FXML
    private Button btnVerLista;

    private Main main;

    @FXML
    void registrarClienteEvent(ActionEvent event) {

    }

    @FXML
    void registrarVehiculoEvent(ActionEvent event) {

    }

    @FXML
    void verListaEvent(ActionEvent event) {

    }

    @FXML
    void initialize() {


    }

    public void setApplication(Main main) {
        this.main=main;
    }
}

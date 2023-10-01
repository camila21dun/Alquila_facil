package controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class RegistroClientes {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnRegistroCliente;

    @FXML
    private Button btnVolver;

    @FXML
    private TextField txtCedulaCliente;

    @FXML
    private TextField txtCiudadCliente;

    @FXML
    private TextField txtCorreoCliente;

    @FXML
    private TextField txtDireccionCliente;

    @FXML
    private TextField txtNombreCliente;

    @FXML
    private TextField txtTelefonoCliente;
    private Main main;



    @FXML
    void RegistroClienteEvent(ActionEvent event) {

    }

    @FXML
    void volverEvent(ActionEvent event) {

    }

    @FXML
    void initialize() {



        }



}

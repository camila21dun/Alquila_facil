package application;

import controller.InicioController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.AlquilaFacil;

import java.io.IOException;


public class Main extends Application {

    Stage stage;

   // AlquilaFacil alquilaFacil = new AlquilaFacil();

    @Override
    public void start(Stage primaryStage) throws IOException {

        this.stage=primaryStage;
        mostrarInicio();


    }
    public void mostrarInicio() {
        try {
            stage.close();
            stage = new Stage();
            //Loader lee cada línea de código y la vuelve objetos en memoria
            FXMLLoader loader = new FXMLLoader();
            //Dirección del paquete donde está la interfaz
            loader.setLocation(Main.class.getResource("../view/inicio.fxml"));
            AnchorPane rootLayout = loader.load();
            //Carga los controladores
            InicioController controller = loader.getController();//Obtenemos el controlador
            controller.setApplication(this);
            Scene scene = new Scene(rootLayout);//Carga la escena Principal. En este caso carga el anchor-pane
            // de cambiar de ventana con escape
            stage.setScene(scene);//Al escenario principal se le dice que cargue la escena
            stage.show();//Muestra el escenario principal
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    

    public static void main(String[] args) {
        launch(Main.class, args);
    }

}
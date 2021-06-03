package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
//import jdk.internal.org.objectweb.asm.Handle;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button new_trip;

    @FXML
    private Button look_trip;

    @FXML
    void initialize() {
       new_trip.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent actionEvent) {
               new_trip.getScene().getWindow().hide();

               FXMLLoader loader = new FXMLLoader();
               loader.setLocation(getClass().getResource("/sample/app.fxml"));

               try {
                   loader.load();
               } catch (IOException e) {
                   e.printStackTrace();
               }

               Parent root = loader.getRoot();
               Stage stage = new Stage();
               stage.setScene(new Scene(root));
               stage.showAndWait();
           }
       });

        look_trip.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                look_trip.getScene().getWindow().hide();

                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/sample/viewing trips.fxml"));

                try {
                    loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.showAndWait();
            }
        });

    }
}

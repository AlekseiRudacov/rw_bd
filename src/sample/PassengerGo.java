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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PassengerGo {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField start_data_passenger;

    @FXML
    private TextField start_time_passenger;

    @FXML
    private TextField end_data_trip1;

    @FXML
    private TextField end_time_trip1;

    @FXML
    private TextField where_from;

    @FXML
    private TextField where_;

    @FXML
    private TextField train_namber;

    @FXML
    private TextField stop_time_train;

    @FXML
    private TextField start_time_train;

    @FXML
    private Button end_work1;

    @FXML
    void initialize() {
        DatabaseHandler dbHandler = new DatabaseHandler();

        end_work1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                end_work1.getScene().getWindow().hide();

                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/sample/sample.fxml"));

                try {
                    loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();


               /* dbHandler.addTheTrip(
                        start_data_passenger.getText(),
                        start_time_passenger.getText(),

                        where_from.getText(),
                        where_.getText(),

                        train_namber.getText(),

                        start_time_train.getText(),
                        stop_time_train.getText(),

                        end_data_trip1.getText(),
                        end_time_trip1.getText());*/

            }
        });

    }
}

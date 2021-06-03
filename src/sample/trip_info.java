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

public class trip_info {

    @FXML
    private TextField start_data_trip;

    @FXML
    private TextField where_from;

    @FXML
    private TextField start_data_work;

    @FXML
    private TextField train_namber;

    @FXML
    private TextField weight;

    @FXML
    private TextField train_long;

    @FXML
    private TextField start_time_work;

    @FXML
    private TextField where_;

    @FXML
    private TextField start_time_trip;

    @FXML
    private TextField start_section_A;

    @FXML
    private TextField start_section_B;

    @FXML
    private Button fuel_on_delivery;

    @FXML
    private Button fuel_upon_delivery;

    @FXML
    private TextField end_section_A;

    @FXML
    private TextField end_section_B;

    @FXML
    private TextField end_data_work;

    @FXML
    private TextField end_time_work;

    @FXML
    private TextField end_data_trip;

    @FXML
    private TextField end_time_trip;

    @FXML
    private Button back;

    @FXML
    private Button passenger;

    @FXML
    private Button end_work;

    @FXML
    void initialize() {
         final DatabaseHandler dbHandler = new DatabaseHandler();

            end_work.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent actionEvent) {
                   /* dbHandler.signUpUser(
                            start_data_trip.getText(),
                            start_time_trip.getText(),
                            start_data_work.getText(),
                            start_time_work.getText(),
                            where_from.getText(),
                            where_.getText(),
                            train_namber.getText(),
                            train_long.getText(),
                            start_section_A.getText(),
                            start_section_B.getText(),
                            end_section_A.getText(),
                            end_section_B.getText(),
                            end_data_work.getText(),
                            end_time_work.getText(),
                            end_data_trip.getText(),
                            end_time_trip.getText()
                    );*/
                    end_work.getScene().getWindow().hide();

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
/*
                    dbHandler.addTheTrip(

                            start_data_trip.getText(),
                            start_time_trip.getText(),
                            start_data_work.getText(),
                            start_time_work.getText(),
                            where_from.getText(),
                            where_.getText(),
                            train_namber.getText(),
                            train_long.getText(),
                            start_section_A.getText(),
                            start_section_B.getText(),
                            end_section_A.getText(),
                            end_section_B.getText(),
                            end_data_work.getText(),
                            end_time_work.getText(),
                            end_data_trip.getText(),
                            end_time_trip.getText());*/

                    int secA1 = Integer.parseInt(start_section_A.getText());
                    int secA2 = Integer.parseInt(end_section_A.getText());

                    int secA = (secA1-secA2)*-1;


                    int secB1 = Integer.parseInt(start_section_B.getText());
                    int secB2 = Integer.parseInt(end_section_B.getText());
                    int secB = (secB1-secB2)*-1;
                    if(secA<0 || secB<0){
                        System.out.println("Не верные данные!");
                    }else {
                        System.out.println(secA);
                        System.out.println(secB);
                    }



                }
            });



        passenger.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                passenger.getScene().getWindow().hide();

                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/sample/passenger.fxml"));

                try {
                    loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();

            }
        });

        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
               back.getScene().getWindow().hide();

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
                stage.show();

            }
        });



    }
}

package com.example.signinouttransitionform;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
//import java.util.

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    private double xOffset = 0, yOffset = 0;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private VBox vBox;

    private Parent parent;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        TranslateTransition t = new TranslateTransition(Duration.seconds(1), vBox);
        t.setToX(vBox.getLayoutX() * 25);
        t.play();
        t.setOnFinished(e->{
            try{
                parent = FXMLLoader.load(getClass().getResource("SignInForm.fxml"));
                vBox.getChildren().removeAll();
                vBox.getChildren().setAll(parent);
            }catch (IOException ex){
                ex.printStackTrace();
            }
        });
    }

    @FXML
    private void open_signin(ActionEvent event){
        TranslateTransition t = new TranslateTransition(Duration.seconds(1), vBox);
        t.setToX(vBox.getLayoutX() * 25);
        t.play();
        t.setOnFinished(e->{
            try{
                parent = FXMLLoader.load(getClass().getResource("SignInForm.fxml"));
                vBox.getChildren().removeAll();
                vBox.getChildren().setAll(parent);
            }catch (IOException ex){
                ex.printStackTrace();

            }
        });
    }

    @FXML
    private void open_signup(ActionEvent event){
        TranslateTransition t = new TranslateTransition(Duration.seconds(1), vBox);
        t.setToX(14);
        t.play();
        t.setOnFinished(e->{
            try{
                parent = FXMLLoader.load(getClass().getResource("SignUpForm.fxml"));
                vBox.getChildren().removeAll();
                vBox.getChildren().setAll(parent);
            }catch (IOException ex){
                ex.printStackTrace();

            }
        });
    }

    public void onDragDone(DragEvent dragEvent) {
        HelloApplication.stage.setOpacity(1.0f);
    }

    public void onMouseDragged(MouseEvent mouseEvent) {
        HelloApplication.stage.setX(mouseEvent.getScreenX() - xOffset);
        HelloApplication.stage.setY(mouseEvent.getScreenY() - yOffset);
        HelloApplication.stage.setOpacity(0.8f);
    }

    public void onMouseExited(MouseEvent mouseEvent) {
    }

    public void onMousePressed(MouseEvent mouseEvent) {
        xOffset = mouseEvent.getSceneX();
        yOffset = mouseEvent.getSceneY();
    }

    public void onMouseReleased(MouseEvent mouseEvent) {
        HelloApplication.stage.setOpacity(1.0f);
    }
}
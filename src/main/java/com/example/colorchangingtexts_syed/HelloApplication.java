package com.example.colorchangingtexts_syed;

import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.scene.Node;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.Scene;

import javafx.scene.control.Label;

import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

import javafx.scene.control.ScrollBar;
import java.io.IOException;

public class HelloApplication extends Application {
    public AnchorPane pain = new AnchorPane();
    @Override
    public void start(Stage stage) throws IOException {
        Scene scene = new Scene(pain, 600, 600);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        buildUI();
    }

    private void buildUI() {
        double red= 0;
        double green=0;
        double blue=0;
        double opacity= .99;

        ScrollBar slR = new ScrollBar();
        slR.setMax(255);
        ScrollBar slB = new ScrollBar();
        slB.setMax(255);
        ScrollBar slG = new ScrollBar();
        slG.setMax(255);
        ScrollBar slO = new ScrollBar();
        slO.setMax(1);



        Text text = new Text(100, 100, "Show Colors");
        //text.setFill(Color.rgb((int)red, (int)green, (int)blue, opacity));
        text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 50));


        slR.valueProperty().addListener(ov ->
        {
            Color c = Color.rgb(
                    (int) slR.getValue(),
                    (int) slG.getValue(),
                    (int) slB.getValue(),
                    slO.getValue());
            text.setFill(c);
        });

        slG.valueProperty().addListener(ov ->
        {
            Color c = Color.rgb(
                    (int) slR.getValue(),
                    (int) slG.getValue(),
                    (int) slB.getValue(),
                    slO.getValue());
            text.setFill(c);
        });

        slB.valueProperty().addListener(ov ->
        {
            Color c = Color.rgb((int) slR.getValue(),(int) slG.getValue(),(int) slB.getValue(),slO.getValue());
            text.setFill(c);
        });

        slO.valueProperty().addListener(ov ->
        {
            Color c = Color.rgb(
                    (int) slR.getValue(),
                    (int) slG.getValue(),
                    (int) slB.getValue(),
                    slO.getValue());
            text.setFill(c);
        });

        Label rLabel = new Label("Red");
        Label gLabel = new Label("Green");
        Label bLabel = new Label("Blue");
        pain.getChildren().addAll(rLabel, gLabel, bLabel, slO, slG, slB, slR, text);

        moveDamnit(rLabel, 10, 300);
        moveDamnit(gLabel, 10, 400);
        moveDamnit(bLabel, 10, 500);

        moveDamnit(slO, 100, 550);
        moveDamnit(slG, 100, 400);
        moveDamnit(slB, 100, 500);
        moveDamnit(slR, 100, 300);

//        pain.getChildren().add(new Label("Green"));
//        pain.getChildren().add(new Label("Blue"));
//        pain.getChildren().add(new Label("Opacity"));
//        pain.getChildren().add(slO);
//        pain.getChildren().add(slG);
//        pain.getChildren().add(slB);
//        pain.getChildren().add(slR);
//        pain.getChildren().add(text);


    }


    public void moveDamnit(Node n, int x, int y){
        n.setLayoutX(x);
        n.setLayoutY(y);
    }

    public static void main(String[] args) {
        launch();
    }
}
package sample;

import javafx.application.Application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

import java.awt.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Label vector1 = new Label("Vector №1:");
        TextField textVec1 = new TextField();
        checkText(textVec1);
        textVec1.setPromptText("Please,input vector");

        Label vector2 = new Label("Vector №2:");
        TextField textVec2 = new TextField();
        checkText(textVec2);
        textVec2.setPromptText("Please,input vector");

        Button getResult = new Button("Get sum");
        Label result = new Label("Wait...");

        HBox group0 = new HBox();
        group0.getChildren().addAll(vector1,textVec1);
        group0.setSpacing(15);

        HBox group1 = new HBox();
        group1.getChildren().addAll(vector2,textVec2);
        group1.setSpacing(15);

        HBox group2 = new HBox();
        group2.getChildren().addAll(getResult,result);
        group2.setSpacing(30);

        VBox group = new VBox();
        group.getChildren().addAll(group0,group1,group2);
        group.setSpacing(20);

        group.translateXProperty().set(18);
        group.translateYProperty().set(15);
        group.translateZProperty().set(15);


        getResult.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                double[] array1 = new double[50];
                double[] array2 = new double[50];

                parseStringToDouble(array1,textVec1.getText(),"(\\d+\\.?\\d*)");
                parseStringToDouble(array2,textVec2.getText(),"(\\d+\\.?\\d*)");

                MainThread thread = new MainThread(array1,array2);
                thread.calculateSum();
                result.setText(thread.getResultSum());
            }
        });

        Scene scene = new Scene(group,300,170);
        primaryStage.setResizable(false);
        scene.setFill(Color.rgb(244,244,244));
        primaryStage.setScene(scene);
        primaryStage.setTitle("lab4(4)_JavaFX");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }


    private void checkText(TextField text) {

        Pattern p = Pattern.compile("((\\d+(\\.?)\\d*\\;?)*)");
        text.textProperty().addListener(((observable, oldValue, newValue) -> {
            if(!p.matcher(newValue).matches()) text.setText(oldValue);
        }));
    }

    private void parseStringToDouble(double[] array,String vec,String uslovnoe) {

        double d;
        int count = 0;
        Pattern pattern = Pattern.compile(uslovnoe);
        Matcher matcher = pattern.matcher(vec);
        while(matcher.find()) {

            d = Double.parseDouble(matcher.group());
            array[count++] = d;
        }
    }



}//"(\\d+\\.?\\d*)"
// BigDecimal big = new BigDecimal(maint.getResultMul());
//   big = big.setScale(2, RoundingMode.HALF_UP);
//         String str = big.toString();
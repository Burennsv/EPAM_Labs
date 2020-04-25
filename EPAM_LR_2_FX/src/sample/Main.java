package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.layout.*;
import javafx.scene.control.TextArea;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

//Нанят рабочий *name*
//Рабочий работает
//Произведен продукт
//Рабочий курит

public class Main extends Application {

    Factory factoryObj = new Factory();
    TextArea answer = new TextArea();

    @Override
    public void start(Stage primaryStage) {
        Label factory = new Label("Фабрика: ");
        Button hire  = new Button("Нанять рабочего");
        hire.setMinSize(125,10);
        Button produce = new Button("Произвести товар");
        produce.setMinSize(125,10);

        answer = new TextArea();
        answer.setEditable(false);
        answer.setMaxWidth(250);
        answer.setMinHeight(410);

        HBox labels  = new HBox(125,factory);
        HBox buttonSet1 = new HBox(30,hire);
        HBox buttonSet2 = new HBox(30,produce);
        FlowPane textArea = new FlowPane(Orientation.HORIZONTAL,10,10,answer);

        hire.setOnAction(e -> {
            factoryObj.HireWorker();
            answer.setText(factoryObj.result);
        });
        produce.setOnAction(    e -> {
            factoryObj.ProduceProduct();
            answer.setText(factoryObj.result);
        });

        VBox root = new VBox(20,labels,buttonSet1,buttonSet2,textArea);

        Scene scene = new Scene(root,280,550);
        primaryStage.setScene(scene);
        primaryStage.setTitle("LAB2(3)");
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }


    //

}
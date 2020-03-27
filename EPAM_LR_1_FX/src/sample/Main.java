package sample;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

import java.util.regex.Pattern;

public class Main extends Application {

    public  static  void main(String[] args)
    {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage){
        Label lbl1 = new Label("Сторона 1");
        TextField text1 = new TextField();
        checkText(text1);
        HBox side1 = new HBox(10,lbl1,text1);
        HBox.setHgrow(text1, Priority.ALWAYS);
        text1.setMaxWidth(600);

        Label lbl2 = new Label("Сторона 2");
        TextField text2 = new TextField();
        checkText(text2);
        HBox side2 = new HBox(10,lbl2,text2);
        HBox.setHgrow(text2, Priority.ALWAYS);
        text2.setMaxWidth(600);

        Label lbl3 = new Label("Сторона 3");
        TextField text3 = new TextField();
        checkText(text3);
        HBox side3 = new HBox(10,lbl3,text3);
        HBox.setHgrow(text3, Priority.ALWAYS);
        text3.setMaxWidth(600);


        Label squareResult = new Label("");
        squareResult.setMaxWidth(40);
        Label perimeterResult = new Label("");
        perimeterResult.setMaxWidth(40);
        Button square = new Button("Площадь");
        Button perimeter = new Button("Периметр");

        HBox squareBox = new HBox(10,square, squareResult);
        HBox perimeterBox = new HBox(10, perimeter, perimeterResult);
        HBox results = new HBox(100,squareBox, perimeterBox);
        VBox root = new VBox(10,side1,side2,side3,results);


        square.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent e)
            {
                Integer side1,side2,side3;
                side1 = Integer.parseInt(text1.getText());
                side2 = Integer.parseInt(text2.getText());
                side3 = Integer.parseInt(text3.getText());

                double halfOfPerimeter = (side1 + side2 + side3)/2;
                double squareMathResult = Math.sqrt(halfOfPerimeter*(halfOfPerimeter - side1)*(halfOfPerimeter - side2)*(halfOfPerimeter - side3));
                squareResult.setText(Double.toString(squareMathResult));
            }
        });

        perimeter.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent c)
            {
                Integer side1,side2,side3;
                side1 = Integer.parseInt(text1.getText());
                side2 = Integer.parseInt(text2.getText());
                side3 = Integer.parseInt(text3.getText());

                double perimeterMathResult = side1 + side2 + side3;
                perimeterResult.setText(Double.toString(perimeterMathResult));
            }
        });

        Scene scene = new Scene(root,350,140);
        stage.setScene(scene);
        stage.setTitle("lab1(3)");
        stage.show();
    }

    public void checkText(TextField text)
    {
        Pattern p = Pattern.compile("(\\d+\\.?\\d*)?");
        text.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) text.setText(oldValue);
        });
    }

}
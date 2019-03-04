package lab1;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;


public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Computer Graphics #1");
        Group mygroup = new Group();
        Scene scene = new Scene (mygroup, 420, 345);

        Circle littleCircle = new Circle(210.0, 316.5,3.7);
        mygroup.getChildren().add(littleCircle);
        littleCircle.setFill(Color.rgb(0, 128, 0));

        Line stem = new Line(210, 315, 210, 135);
        mygroup.getChildren().add(stem);
        stem.setStroke(Color.rgb(0, 128, 0));
        stem.setStrokeWidth(7.2);

        Circle circle = new Circle(210.0, 130.0,35.0);
        mygroup.getChildren().add(circle);
        circle.setFill(Color.YELLOW);

        Polygon firstLeaf = new Polygon();
        firstLeaf.getPoints().addAll(new Double[]{
                113.0, 110.0,  // ліва верхня
                175.5, 129.0,  // права верхня
                177.0, 144.2,  // права нижня
                119.0, 174.0, // ліва нижня
        });
        mygroup.getChildren().add(firstLeaf);
        firstLeaf.setFill(Color.RED);

        Polygon secondLeaf = new Polygon();
        secondLeaf.getPoints().addAll(new Double[]{
                168.0, 38.0,  // ліва верхня
                193.5, 99.2,  // права верхня
                181.0, 113.0,  // права нижня
                118.0, 95.0, // ліва нижня
        });
        mygroup.getChildren().add(secondLeaf);
        secondLeaf.setFill(Color.RED);

        Polygon thirdLeaf = new Polygon();
        thirdLeaf.getPoints().addAll(new Double[]{
                190.0, 34.0,  // ліва верхня
                278.0, 56.5,  // права верхня
                229.0, 102.2,  // права нижня
                209.0, 96.4, // ліва нижня
        });
        mygroup.getChildren().add(thirdLeaf);
        thirdLeaf.setFill(Color.RED);

        Polygon fourthLeaf = new Polygon();
        fourthLeaf.getPoints().addAll(new Double[]{
                296.0, 75.0,  // права верхня
                302.0, 165.0,  // права нижня
                242.0, 134.0,  // ліва нижня
                242.0, 116.0, // ліва верхня
        });
        mygroup.getChildren().add(fourthLeaf);
        fourthLeaf.setFill(Color.RED);

        Polygon fifthLeaf = new Polygon();
        fifthLeaf.getPoints().addAll(new Double[]{
                235.0, 152.0,  // ліва верхня
                295.0, 178.0,  // права верхня
                230.0, 220.0,  // права нижня
                224.0, 159.5, // ліва нижня
        });
        mygroup.getChildren().add(fifthLeaf);
        fifthLeaf.setFill(Color.RED);

        Polygon sixthLeaf = new Polygon();
        sixthLeaf.getPoints().addAll(new Double[]{
                135.0, 185.0,  // ліва верхня
                185.0, 152.0,  // права верхня
                200.0, 162.0,  // права нижня
                199.0, 220.0, // ліва нижня
        });
        mygroup.getChildren().add(sixthLeaf);
        sixthLeaf.setFill(Color.RED);

        scene.setFill(Color.rgb(0, 255, 128));

        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 *
 * @author alfon
 */
public class CargaImagen extends Application {
    
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
     //    ImageView imageView = new ImageView();
         // Load the image from the file (adjust the file path as needed)
         int butonwidth = 300;
        int buttonheight = 300;
        Image image = new Image(new FileInputStream("assets/ima1.jpg"));  
    
       ImageView imageView = new ImageView(image);
       imageView.setFitHeight(buttonheight);
       imageView.setFitWidth(butonwidth);
     //  imageView.setRotate(-90);
        // Set the loaded image to the ImageView
               
        
        
        Button btn = new Button();
        btn.setPrefSize(butonwidth, buttonheight);
        btn.setGraphic(imageView);
        btn.setOnAction((event) -> {
           imageView.setRotate(imageView.getRotate() + 10); 
        });
     
       
        HBox root = new HBox();
    //    root.getChildren().add(btn);
        root.getChildren().addAll(imageView,btn);
        
        Scene scene = new Scene(root, 500, 550);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

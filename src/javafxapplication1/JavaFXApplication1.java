/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import java.io.File;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author alfon
 */
public class JavaFXApplication1 extends Application {
    
     private String path ;   

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    
    @Override
    public void start(Stage primaryStage) {
        
     
        // boton buscar archivo
     
        
         Media media = new Media(new File(path).toURI().toString());  
         MediaPlayer mediaPlayer = new MediaPlayer(media);  
         MediaView mediaView = new MediaView(mediaPlayer);  
         mediaPlayer.setAutoPlay(true);  
        StackPane root = new StackPane();
        Scene scene = new Scene(root, 800, 600);
        root.getChildren().add(mediaView);  
       
        primaryStage.setTitle("Hecho por Bolao");
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

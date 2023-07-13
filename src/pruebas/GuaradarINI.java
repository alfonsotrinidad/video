package pruebas;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class GuaradarINI extends  Application{
    MediaPlayer mediaPlayer;
    Media media;
    Scene scene;
    StackPane root;
    String path1 = "D:\\\\goku.mp4";
    
    @Override
    public void start(Stage stage) {
        
        media = new Media(new File(path1).toURI().toString());    
        mediaPlayer  = new MediaPlayer(media);
        MediaView mediaView = new MediaView(mediaPlayer);
        root = new StackPane();
        scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        root.getChildren().add(mediaView);  
        stage.setTitle("Media Player Example");
        stage.show();

        mediaPlayer.play();
        
        
    }
        
        
    

   
    
    
        public static void main(String[] args) {
            
        launch(args);
        
    }
        private void ponervideo(String path){
       
       //  root.getChildren().add(mediaView);  
       //  start(new Stage());
    
    }
}

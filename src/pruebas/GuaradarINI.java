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
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
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
    public void start(Stage primaryStage) {
        
          // Crea los botones
        Button button1 = new Button("Botón 1");
        Button button2 = new Button("Botón 2");
        Button button3 = new Button("Botón 3");

        // Crea el contenedor vertical para los botones
        VBox buttonsContainer = new VBox(button1, button2, button3);
        buttonsContainer.setAlignment(Pos.CENTER_LEFT);

        // Crea el ImageView y carga la imagen
        ImageView imageView = new ImageView();
        imageView.setFitHeight(600); // Ajusta la altura según tus necesidades
        imageView.setFitWidth(400); // Ajusta la mitad del ancho de la pantalla según tus necesidades

        // Carga la imagen en el ImageView
        System.out.println(this.getClass().getProtectionDomain().getCodeSource().getLocation().toString()+"imagen.jpg" );
        //imageView.setImage(new javafx.scene.image.Image(getClass().
          //      getResourceAsStream(this.getClass().getProtectionDomain().getCodeSource().getLocation() +"/assets/imagen.jpg")));

        // Crea el contenedor horizontal para los botones y la imagen
        HBox root = new HBox(buttonsContainer, imageView);
        root.setAlignment(Pos.CENTER);

        // Crea la escena
        Scene scene = new Scene(root, 800, 600); // Ajusta el tamaño de la ventana según tus necesidades

        // Configura la ventana principal
        primaryStage.setTitle("Ventana JavaFX");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
    }
        
        
    

   
    
    
        public static void main(String[] args) {
            
        launch(args);
        
    }
        private void ponervideo(String path){
       
       //  root.getChildren().add(mediaView);  
       //  start(new Stage());
    
    }
}

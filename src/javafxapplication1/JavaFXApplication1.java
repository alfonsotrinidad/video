/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import java.io.File;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 *
 * @author alfon
 */
public class JavaFXApplication1 extends Application {
    
     private String path1 ;   
     private String path2 ;   
     private String path3 ;   
     private String path4 ;
     private int seleccion;
     Media media;
     MediaPlayer mediaPlayer ;
     Stage st1 = new Stage();

    public JavaFXApplication1() {
        media = new Media(new File("D:\\goku.mp4").toURI().toString());
        mediaPlayer = new MediaPlayer(media) ;
         
    }
     
     

    public int getSeleccion() {
        return seleccion;
    }

    public void setSeleccion(int seleccion) {
        this.seleccion = seleccion;
    }

    public String getPath1() {
        return path1;
    }

    public void setPath1(String path) {
        this.path1 = path;
    }
    
    
   public  void stop(){
     mediaPlayer.stop();
   }
    
    @Override
    public void start(Stage primaryStage) {
        
     
        // boton buscar archivo
       
//            String cad = ""; 
//         if (getSeleccion()==1) 
//             cad = getPath1();
//        
//         if (getSeleccion()==2) 
//             cad = getPath2();
//        
//         if (getSeleccion()==3) 
//             cad = getPath3();
//        
//         if (getSeleccion()==4) 
//             cad = getPath4();
         
       //  media = new Media(new File(cad).toURI().toString());  
            
        
        // Media media = new Media(new File(getPath1()).toURI().toString());  
          
         
         MediaView mediaView = new MediaView(mediaPlayer);  
         mediaPlayer.setAutoPlay(true);  
         
        StackPane root = new StackPane();
       
        
        
        
        Scene scene = new Scene(root, 800, 600);
        root.getChildren().add(mediaView);  
       
         
         
         for (Screen screen : Screen.getScreens()) {
            Rectangle2D bounds = screen.getVisualBounds();
             st1.setX(bounds.getMinX() );
             primaryStage.setY(bounds.getMinY());
         }
         
         
        //int pantalla = screen. ;
        //screen = new Screen();
        
        
        
        st1.setTitle(media.getSource().toString());
        st1.setScene(scene);
        st1.setAlwaysOnTop(true);
        st1.setFullScreen(true);
        st1.show();
        
     
        
        
        
        
        
    }
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public String getPath2() {
        return path2;
    }

    public void setPath2(String path2) {
        this.path2 = path2;
    }

    public String getPath3() {
        return path3;
    }

    public void setPath3(String path3) {
        this.path3 = path3;
    }

    public String getPath4() {
        return path4;
    }

    public void setPath4(String path4) {
        this.path4 = path4;
    }
    
}

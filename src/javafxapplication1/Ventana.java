/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;
import java.awt.Image;
import java.awt.Label;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.JOptionPane;

/**
 *
 * @author alfon
 */
public class Ventana extends Application{
    private String videoprincipal;
    private String videouno;
    private String videodos;
    private String videotres;
    private boolean configurado ;
    JavaFXApplication1 ja1;

    private String  v1;
    String v2 ,v3, v4 ;
    
    public Ventana() throws IOException{
    ja1 = new JavaFXApplication1();
    Properties properties = new Properties();
    
    InputStream input;
    try {
            input = new FileInputStream("archivo.ini");
            properties.load(input);
                    
                    v1 =   properties.getProperty("v1");
                    v2 =   properties.getProperty("v2"); 
                    v3 =  properties.getProperty("v3");
                    v4=  properties.getProperty("v4");
                    ja1.setPath1(v1);
                    ja1.setPath2(v2);
                    ja1.setPath3(v3);
                    ja1.setPath4(v4);
                    
                 
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Videos no encontrados");
            FileChooserExample fce = new FileChooserExample();
            fce.start(new Stage() );
            //Logger.getLogger(FileChooserExample.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
    
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        int butonwidth = 400;
        int buttonheight = (int)(Screen.getPrimary().getBounds().getMaxY() / 3)-5;
        Button btn1 = new Button("Video 1" );
        btn1.setPrefSize(butonwidth,buttonheight);
        Button btn2 = new Button("Video 2");
        btn2.setPrefSize(butonwidth,buttonheight);
        Button btn3 = new Button("Video 3");
        btn3.setPrefSize(butonwidth,buttonheight);
        
        
        
        
      
       VBox vbox = new VBox(btn1,btn2,btn3 );
       vbox.setAlignment(Pos.CENTER);
       // vbox.getChildren().addAll(btn1);
      
        Scene scene = new Scene(vbox,Screen.getPrimary().getBounds().getMaxX() ,Screen.getPrimary().getBounds().getMaxY());
        primaryStage.setX(1);
        primaryStage.setY(1);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Video");
        primaryStage.setScene(scene);
        primaryStage.setFullScreen(true);
        primaryStage.show();
         
        ponerPrincial();
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                
                    ja1.stop();
                    ja1.st1.close();
                    ja1.mediaPlayer.stop();
                    ja1.media = new Media(new File(v2).toURI().toString());
                    ja1.mediaPlayer  = new MediaPlayer(ja1.media); 
                    ja1.mediaPlayer.setOnEndOfMedia(new Runnable() {
                        @Override
                        public void run() {
                             ponerPrincial();
                        }
                    }); 
                    ja1.setSeleccion(2);
                    ja1.start(ja1.st1);
                    ja1.mediaPlayer.play();
                    
                } catch (Exception ex) {
                    Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
                }
               
            }
     });
           btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    ja1.stop();
                    ja1.st1.close();
                    ja1.mediaPlayer.stop();
                    ja1.media = new Media(new File(v3).toURI().toString());  
                    ja1.mediaPlayer  = new MediaPlayer(ja1.media); 
                    ja1.mediaPlayer.setOnEndOfMedia(new Runnable() {
                        @Override
                        public void run() {
                             ponerPrincial();
                        }
                    }); 
                    ja1.setSeleccion(3);
                    ja1.start(ja1.st1);
                    ja1.mediaPlayer.play();
                  
                    
                  //  
                } catch (Exception ex) {
                    Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
                }
               
            }
     });
           
            btn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    ja1.stop();
                    ja1.st1.close();
                    ja1.mediaPlayer.stop();
                    ja1.media = new Media(new File(v4).toURI().toString());  
                    ja1.mediaPlayer  = new MediaPlayer(ja1.media); 
                    ja1.mediaPlayer.setOnEndOfMedia(new Runnable() {
                        @Override
                        public void run() {
                             ponerPrincial();
                        }
                    }); 
                    ja1.setSeleccion(4);
                    ja1.start(ja1.st1);
                    ja1.mediaPlayer.play();
                  
                    
                  //  
                } catch (Exception ex) {
                    Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
                }
               
            }
     });
    }
    
    public static void main(String[] args) {
             launch(args);
      }

    public String getVideoprincipal() {
        return videoprincipal;
    }

    public void setVideoprincipal(String videoprincipal) {
        this.videoprincipal = videoprincipal;
    }

    public String getVideouno() {
        return videouno;
    }

    public void setVideouno(String videouno) {
        this.videouno = videouno;
    }

    public String getVideodos() {
        return videodos;
    }

    public void setVideodos(String videodos) {
        this.videodos = videodos;
    }

    public String getVideotres() {
        return videotres;
    }

    public void setVideotres(String videotres) {
        this.videotres = videotres;
    }
    
    public Boolean configurado(){
        return true;
    }
    
    
    public void ponerPrincial()
            
       {
            try {
               
                    ja1.stop();
                    ja1.st1.close();
                    ja1.mediaPlayer.stop();
                    ja1.media = new Media(new File(v1).toURI().toString());
                    ja1.mediaPlayer  = new MediaPlayer(ja1.media); 
                    ja1.setSeleccion(1);
                    ja1.start(ja1.st1);
                    ja1.mediaPlayer.setOnEndOfMedia(new Runnable() {
                        @Override
                        public void run() {
                             ja1.mediaPlayer.seek(Duration.ZERO);
                             ja1.mediaPlayer.play();
                        }
                    }); 
                    ja1.mediaPlayer.play();
                    
                } catch (Exception ex) {
                    Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
                }
               
            }

    }
    


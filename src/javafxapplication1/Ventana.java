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
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

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
    
    String v1=null;

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        this.configurado = configurado();
        if (!this.configurado){
            FileChooserExample fce = new FileChooserExample();
            fce.start(primaryStage);
        } else {
    //   }
        Button btn1 = new Button("Boton # 1");
        Button btn2 = new Button("Boton # 2");
        Button btn3 = new Button("Boton # 3");
        
        HBox hbox = new HBox(btn1, btn2, btn3);
        hbox.setPadding(new Insets(5));
        hbox.setSpacing(30);
        
         //root.getChildren().addAll(btn1, btn2, btn3);
         Scene scene = new Scene(hbox,400,50);
         primaryStage.setResizable(false);
         primaryStage.setWidth(350);
         primaryStage.setHeight(80);
                    
        primaryStage.setTitle("Ejemplo - FlowPane");
        primaryStage.setScene(scene);
        primaryStage.show();
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                 FileChooser fileChooser = new FileChooser();
            if (v1==null){
          fileChooser.setTitle("Seleccionar archivo");
           fileChooser.getExtensionFilters().add(new ExtensionFilter("Video", "*.mp4"));
              File selectedFile = fileChooser.showOpenDialog(primaryStage);
              v1 = selectedFile.getPath();
        }
                JavaFXApplication1 ja1 = new JavaFXApplication1();
                ja1.setPath(v1);
                ja1.start(new Stage());
            }
        });
        }  
        
        
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
    
}

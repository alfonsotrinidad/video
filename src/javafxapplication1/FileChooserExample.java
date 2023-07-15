package javafxapplication1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.JOptionPane;


public class FileChooserExample extends Application {
    Properties properties = new Properties();
    String v1, v2 ,v3, v4 ;
    InputStream input;
    
    public FileChooserExample(){
    
    }
    
    @Override
    public void init() throws IOException{
           try {
            input = new FileInputStream("archivo.ini");
            if (input.available()>0 ){
            this.properties.load(input);
            v1 =   this.properties.getProperty("v1");
            v2 =  this.properties.getProperty("v2"); 
            v3 = this.properties.getProperty("v3");
            v4= this.properties.getProperty("v4");
                    System.out.println("Valores actuales");
                    System.out.println(properties.getProperty("v1"));
                    System.out.println(properties.getProperty("v2"));
                    System.out.println(properties.getProperty("v3"));
                    System.out.println(properties.getProperty("v4"));
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileChooserExample.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    

    @Override
    public void start(Stage stage) {
        
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Video MP4 ", "*.mp4");

        // Crear cuatro FileChooser y sus respectivos botones para navegar por los archivos.
        FileChooser fileChooser1 = new FileChooser();
        fileChooser1.getExtensionFilters().add(extFilter);
        Button button1 = new Button("Buscar archivo 1");
        TextField textField1 = new TextField();

        FileChooser fileChooser2 = new FileChooser();
        fileChooser2.getExtensionFilters().add(extFilter);
        Button button2 = new Button("Buscar archivo 2");
        TextField textField2 = new TextField();

        FileChooser fileChooser3 = new FileChooser();
        fileChooser3.getExtensionFilters().add(extFilter);
        Button button3 = new Button("Buscar archivo 3");
        TextField textField3 = new TextField();

        FileChooser fileChooser4 = new FileChooser();
        fileChooser4.getExtensionFilters().add(extFilter);
        Button button4 = new Button("Buscar archivo 4");
        TextField textField4 = new TextField();

        // Alinear los elementos verticalmente dentro de un VBox.
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10));
        
        Button btnsave = new Button("Guardar");
        btnsave.setDisable(true);
        
        vbox.getChildren().addAll(button1, textField1, button2, textField2, button3, textField3, button4, textField4,btnsave);
        
        textField1.setText(this.properties.getProperty("v1"));
        textField2.setText(this.properties.getProperty("v2"));
        textField3.setText(this.properties.getProperty("v3"));
        textField4.setText(this.properties.getProperty("v4"));
        
        
        

        // Crear una escena y mostrarla.
        Scene scene = new Scene(vbox);
        stage.setScene(scene);
      

        
       btnsave.setOnAction((ActionEvent e) -> {
          
           try {
              Properties p = new Properties();
              OutputStream output = new FileOutputStream("archivo.ini");
              
              
//               if (
//                       
//                          (this.v1.length() == 0)
//                       || (this.v2.length() == 0)
//                       || (this.v3.length() == 0) 
//                       || (this.v4.length() == 0)
//                       )
                       
                   System.out.println("Establecer propiedades");
                   p.setProperty("v1",textField1.getText());
                   p.setProperty("v2", textField2.getText());
                   p.setProperty("v3", textField3.getText());
                   p.setProperty("v4", textField2.getText());
                   this.properties = p;
                   Date date = new Date();
                   p.store(output, "Archivo .ini guardado" + date.toString() );
                   JOptionPane.showMessageDialog(null, "Datos guardados \n Vuelva abrir la aplicacion.");
                  
               //
               
           } catch (FileNotFoundException ex) {
               Logger.getLogger(FileChooserExample.class.getName()).log(Level.SEVERE, null, ex);
               
           } catch (IOException ex) {
               Logger.getLogger(FileChooserExample.class.getName()).log(Level.SEVERE, null, ex);
           }
           //JOptionPane.showMessageDialog(null, properties.getProperty("v1"));
           JavaFXApplication1 ja1 = new JavaFXApplication1();
           ja1.setPath1(properties.getProperty("v1"));
           ja1.setPath2(properties.getProperty("v2"));
           ja1.setPath3(properties.getProperty("v3"));
           ja1.setPath4(properties.getProperty("v4"));
           Platform.exit();
         //  ja1.start(new Stage());
           
//           Ventana v;
//            try {
//                v = new Ventana();
//                 v.start(new Stage());
          //  } catch (IOException ex) {
           //     Logger.getLogger(FileChooserExample.class.getName()).log(Level.SEVERE, null, ex);
       //     } catch (Exception ex) {
          //      Logger.getLogger(FileChooserExample.class.getName()).log(Level.SEVERE, null, ex);
          //  }
          });

       
// Agregar funcionalidad a los botones para que muestren el FileChooser y actualicen el TextField con la ruta seleccionada.
       button1.setOnAction (e  -> {
            File file = fileChooser1.showOpenDialog(stage);
        if (file != null) {
            textField1.setText(file.getAbsolutePath());
            btnsave.setDisable(false);

        }
    }

    );

    button2.setOnAction (e  
        -> {
            File file = fileChooser2.showOpenDialog(stage);
        if (file != null) {
            textField2.setText(file.getAbsolutePath());
            btnsave.setDisable(false);

        }
    }

    );

    button3.setOnAction ( 
        (ActionEvent e) -> {
            File file = fileChooser3.showOpenDialog(stage);
        if (file != null) {
            textField3.setText(file.getAbsolutePath());
            btnsave.setDisable(false);
        }
    }

    );

        button4.setOnAction(e -> {
            File file = fileChooser4.showOpenDialog(stage);
            if (file != null) {
                textField4.setText(file.getAbsolutePath());
                
                btnsave.setDisable(false);

            }
        });
          stage.showAndWait();
           Ventana v;
            try {
                v = new Ventana();
                 v.start(new Stage());
            } catch (IOException ex) {
                Logger.getLogger(FileChooserExample.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(FileChooserExample.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

package pruebas;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class GuaradarINI {
    public static void main(String[] args) {
     
    Properties properties = new Properties();
        try (
                
            InputStream input = new FileInputStream("archivo.ini"))
        
        {
            properties.load(input);

            String v1 = properties.getProperty("v1");
            String v2 = properties.getProperty("v2");
            String v3 = properties.getProperty("v3");
            String v4 = properties.getProperty("v4");
            System.out.println(v1);
            if ((v1==null) && (v2==null) && (v3==null) && (v4==null) )
            {
                System.out.println("Establecer propiedades");
                OutputStream output = new FileOutputStream("archivo.ini");
                properties.setProperty("v1", "video 1");
                properties.setProperty("v2", "video 2");
                properties.setProperty("v3", "video 3");
                properties.setProperty("v4", "video 4");
                properties.store(output, "Archivo .ini guardado desde Java");
    
              
            }
            else{
             System.out.println(properties.getProperty("v1"));
             System.out.println(properties.getProperty("v2"));
             System.out.println(properties.getProperty("v3"));
             System.out.println(properties.getProperty("v4"));            
            }
            
            //System.out.println("VEa ud " + valor);
        } catch (IOException e) {
            System.err.println("aqui se rompio");
            e.printStackTrace();
        }
        
        
        
    }
    
}

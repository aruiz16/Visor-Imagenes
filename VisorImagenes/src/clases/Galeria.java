/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;
import java.io.*;
/**
 *
 * @author Alejandro RG
 */
public class Galeria {
    FileInputStream entrada;
    FileOutputStream salida;
    File archivo;
    
    public Galeria(){
        
    }
    
    //Abrir un archivo de Texto
    public String AbrirATexto(File archivo) throws FileNotFoundException{
        String contenido="";
        try{
            entrada= new FileInputStream(archivo);
            int ascci;
            while((ascci = entrada.read())!= -10){
                char caracter = (char)ascci;
                contenido += caracter;
            }
        } catch(Exception e){
            
        }
        return contenido;
    }
    
    //Guardar archivo de texto
    public String GuardarATexto(File archivo, String contenido){
        String resp= null;
        try{
            salida = new FileOutputStream(archivo);
            byte[] bytesTxt = contenido.getBytes();
            salida.write(bytesTxt);
            resp = "Se guardo con éxito el archivo.";
        }catch(Exception e){
            
        }
        return resp;
    }
    
    //Abrir una imagen
    public byte[] AbrirImagen(File archivo){
        byte[] bytesImg = new byte[1024*100];
        try{
            entrada = new FileInputStream(archivo);
            entrada.read(bytesImg);
        }catch(Exception e){
            
        }
        return bytesImg;
    }
    
    //Guardar imagen 
    public String GuardarAImagen(File archivo, byte[] bytesImg){
        String resp = null;
        try{
            salida = new FileOutputStream(archivo);
            salida.write(bytesImg);
            resp = "La imagen se guardo con éxito.";
        }catch(Exception e){
            
        }
        return resp;
    }
}

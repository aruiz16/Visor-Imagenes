/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dom;

import clases.Imagen;
import clases.ListaImagenes;
import clases.NodoD;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 *
 * @author usuario
 */
public class ImagenDOM {

    private String pathFile = "G:\\ReproductorMusica\\src\\data\\Imagenes.xml";
    
    
    public void addAll(ListaImagenes lista, String pathFile2){
        
        Imagen imagen;
        NodoD nodo = null;
        try{
            Document d = DOMHelper.getDocument(pathFile);
            Element imagenes = d.getDocumentElement();
            lista.irPrimero();
            nodo = lista.getActual();
            while (nodo !=null){
                imagen =  nodo.getDatos();
                //crear un item para agregar una cancion
                Element item = d.createElement("imagen");
                //create tag id
                Element id= d.createElement("id");
                id.appendChild(d.createTextNode(""+imagen.getId()));
                item.appendChild(id);
                //Crear tag titulo
                Element titulo = d.createElement("titulo");
                titulo.appendChild(d.createTextNode(imagen.getTitulo()));
                item.appendChild(titulo);
                //Crear tag artista
                Element ruta = d.createElement("ruta");
                ruta.appendChild(d.createTextNode(imagen.getRuta()));
                item.appendChild(ruta);
                 
                imagenes.appendChild(item);
                
                nodo = nodo.getSig();
            }
            DOMHelper.saveXMLContent(d, pathFile2);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
     public List<Imagen> getAll(String pathFile2) {
        List<Imagen> imagenes = new ArrayList();
        Imagen imagen;

        try {
            Document d = DOMHelper.getDocument(pathFile2);
            NodeList nl = d.getElementsByTagName("imagen");
            for (int i = 0; i < nl.getLength(); i++) {
                Element item = (Element) nl.item(i);
                imagen = new Imagen();
                imagen.setId(Integer.parseInt(item.getElementsByTagName("id").item(0).getTextContent()));
                imagen.setTitulo(item.getElementsByTagName("titulo").item(0).getTextContent());
                imagen.setRuta(item.getElementsByTagName("ruta").item(0).getTextContent());

                imagenes.add(imagen);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return imagenes;
    }
}

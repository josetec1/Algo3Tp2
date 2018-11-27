package vista;

import javafx.scene.image.Image;
import javafx.scene.layout.*;
import modelo.Celda;

import java.util.HashMap;

public class VistaDeCelda extends StackPane
{
	
	private static HashMap<String, BackgroundImage> imagenes = null;
	
    public VistaDeCelda(Celda celda)
    {
    	cargarImagenes();

    }

    private void setBackground(String nombreImagen)
    {

    	BackgroundImage imagenDeFondo = imagenes.get(nombreImagen);

        this.setBackground(new Background(imagenDeFondo));
    }
    
    private void cargarImagenes(){
    	if (imagenes != null)
    		return;
    	
    	imagenes = new HashMap<String, BackgroundImage>();
    	
    	Image fondo = new Image("vista/imagenes/stars.jpg");

    	BackgroundImage fondoEstrellas = new BackgroundImage(fondo, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

    	imagenes.put("fondo estrellas", fondoEstrellas);

    }
}


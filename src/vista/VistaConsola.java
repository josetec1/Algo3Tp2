package vista;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.Observable;
import java.util.Observer;

class VistaConsola extends HBox implements Observer
{
    Consola consola;
    
    public VistaConsola(Consola c)
    {
        consola = c;
        c.addObserver(this);
        
        setMinSize(350, 75);
        setStyle("-fx-background-color: black;");
        
        getChildren().add(new Label());
    }
    
    public void update(Observable o, Object arg)
    {
        if (o != consola)
            return;
        
        Label etiqueta = new Label();
        etiqueta.setText(consola.getMensaje());
        etiqueta.setTextFill(Color.WHITE);
        etiqueta.setFont(Font.font("Tahoma", FontWeight.BOLD, 12));
        
        getChildren().set(0, etiqueta);
    }
}


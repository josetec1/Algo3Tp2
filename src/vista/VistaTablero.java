package vista;

import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import modelo.Tablero;

public class VistaTablero extends GridPane{
	
	Tablero tablero;

	public VistaTablero(){
		tablero = Tablero.getInstance();
		this.setMaxWidth(600);
    	this.setMaxHeight(700);
    	
    	 for (int i = 0; i <= tablero.ancho(); i++) {
             this.getColumnConstraints().add(
             		new ColumnConstraints(80));
         }
         for (int i = 0; i <= tablero.altura(); i++) {
             this.getRowConstraints().add(
             		new RowConstraints(80));
         }
	}
	
	public void dibujar(){
		for (int row = 1; row <= tablero.altura(); row++) {
            for (int col = 1; col <= tablero.ancho(); col ++){
                StackPane celda = new VistaDeCelda(tablero.getCelda(col, row));
                this.add(celda, col, row);
            }
        }
	}
	
	public void actualizar(){
		dibujar();
	}
}

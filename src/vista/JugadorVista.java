package vista;


import fiuba.algo3.aoe.Jugadores.Jugador;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class JugadorVista {
	VBox vbox;
	Jugador jugador;
	int lado;

	
	public JugadorVista(VBox unVBox,Jugador unJugador){
		vbox=unVBox;
		jugador=unJugador;
	}
	public void dibujarJugador(){
		
		Label j= new Label(jugador.getNombre());
		vbox.getChildren().add(j);
		j.setFont(new Font("Arial",20));
		vbox.setTranslateY(150);
		//XXSentinela  cambio este if
		//if(jugador.getEstado()=="activo"){
	//		MenuInferior.log.insertText(0, "\nEs turno de " + jugador.getNombre());
	//	}
		MenuInferior.log.insertText(0, "\nEs turno de " + jugador.getNombre());
		//XXSentinela
	}
	public void dibujarInfoTerreno(){
		Label titulo= new Label("\n\nTerrenos:");
		titulo.setFont(new Font("Arial",16));
		vbox.getChildren().add(titulo);
		Text info = new Text();
		info.setText("\nBeige: Rocoso \nMarron Oscuro: Pantano\nVerde: Espinas \nCeleste claro: Nubes\nVioleta: "
				+ "Nebulosa de Andromeda\nAzul: Tormenta Psionica");
		titulo.setFont(new Font("Arial",14));
		vbox.getChildren().add(info);
	}
	public void dibujarInfoBonus(){
		Label titulo= new Label("\n\nBonus:");
		titulo.setFont(new Font("Arial",16));
		vbox.getChildren().add(titulo);
		Text info = new Text();
		info.setText("\nCeleste: Burbuja\nRojo: Doble Canion\nAmarillo: Flash");
		titulo.setFont(new Font("Arial",14));
		vbox.getChildren().add(info);
	}
}

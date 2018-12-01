package vista;


import fiuba.algo3.aoe.Jugadores.Jugador;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class JugadorVista {
	private VBox vbox;
	private Jugador jugador;


	public JugadorVista(VBox unVBox,Jugador unJugador){
		vbox=unVBox;
		jugador=unJugador;

	}
	public void dibujarJugador(Jugador jugadorActual){
		
		Label j= new Label(jugador.getNombre());
		vbox.getChildren().add(j);
		j.setFont(new Font("Arial",20));
		j.setTranslateY(15);

		if(this.jugador == jugadorActual){
			MenuInferior.getLog().insertText(0, "\nEs turno de " + jugador.getNombre());
			//this.dibujarJugadorActual();
		}

	}
	public void dibujarInfoUnidades(){
		Label titulo= new Label("\n\nUnidades:");
		titulo.setFont(new Font("Arial",16));
		vbox.getChildren().add(titulo);
		Text info = new Text();
		info.setText("\nAzul: Aldeano \nMarron Oscuro: Espadachin\nVerde: Arquero \nCeleste claro: Asedio ");
		titulo.setFont(new Font("Arial",14));
		vbox.getChildren().add(info);
	}
	public void dibujarInfoEdificios(){
		Label titulo= new Label("\n\nEdificios:");
		titulo.setFont(new Font("Arial",16));
		vbox.getChildren().add(titulo);
		Text info = new Text();
		info.setText("\nCeleste: Castillo\nRojo: Plaza Central\nAmarillo: Cuartel");
		titulo.setFont(new Font("Arial",14));
		vbox.getChildren().add(info);
	}

}

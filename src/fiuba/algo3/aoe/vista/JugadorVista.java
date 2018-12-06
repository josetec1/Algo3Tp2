package fiuba.algo3.aoe.vista;


import fiuba.algo3.aoe.modelo.Jugadores.Jugador;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class JugadorVista {
	private VBox vbox;
	private Jugador jugador;
	Color color;


	public JugadorVista( VBox unVBox, Jugador unJugador, Color color){
		vbox=unVBox;
		jugador=unJugador;
		this.color = color;

	}
	public void dibujarJugador(Jugador jugadorActual,String color){
		
		Label j= new Label(jugador.getNombre());
		vbox.getChildren().add(j);
		j.setFont(new Font("Arial",20));
		j.setTranslateY(15);
		j.setStyle ("-fx-text-fill: "+color+ "; ");

		if(this.jugador == jugadorActual){
			MenuInferior.getLog().appendText("\nEs turno de " + jugador.getNombre());
			//this.dibujarJugadorActual();
		}

	}
	public void dibujarInfoUnidades(){
		Label titulo= new Label("\n\nUnidades:");
		titulo.setFont(new Font("Arial",16));
		vbox.getChildren().add(titulo);
		Text info = new Text();
		info.setText("\nAzul: Aldeano \nMarron Oscuro: Espadachin\nVerde: Arquero \nCeleste claro: Asedio ");
		info.setFont(new Font("Arial",14));
		vbox.getChildren().add(info);
	}
	public void dibujarInfoEdificios(){
		Label titulo= new Label("\n\nEdificios:");
		titulo.setFont(new Font("Arial",16));
		vbox.getChildren().add(titulo);
		Text info = new Text();
		info.setText("\nCeleste: Castillo\nRojo: Plaza Central\nAmarillo: Cuartel");
		info.setFont(new Font("Arial",14));
		vbox.getChildren().add(info);
	}

	public void dibujarIformacionJugador(String color){
		Label titulo= new Label("\n\nInfo Jugador:");
		titulo.setStyle ( "-fx-text-fill: "+color+ "; " );
		titulo.setFont(new Font("Arial",16));
		vbox.getChildren().add(titulo);
		Text info = new Text();
		info.setText("\nOro  =" + jugador.getOro() + " \nPoblacion = " + jugador.getPoblacionActual() + "/50");
        info.setFont(new Font("Arial",14));
        info.setFill ( this.color );
        vbox.getChildren().add(info);

	}

}

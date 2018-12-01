package Eventos;


import fiuba.algo3.aoe.Ubicables.posicion.Cuadrante.Cuadrante;
import fiuba.algo3.aoe.Ubicables.posicion.PosicionInvalidaException;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import vista.ContenedorPrincipal;
import vista.MenuInferior;
import vista.MapaVistaControlador;

public class SeleccionVacioHandler implements EventHandler<MouseEvent>{
	
	Cuadrante cuadrante;
	public SeleccionVacioHandler(Cuadrante unCuadrante){
		cuadrante=unCuadrante;
	}

	@Override
	public void handle(MouseEvent event) {
		// TODO Auto-generated method stub
		if ("Observar"== MenuInferior.getSelecOpciones().getSelectionModel().getSelectedItem().toString()){
			MenuInferior.getLog().appendText("\nCasillero: "+cuadrante.getX() +"," + cuadrante.getY());
		}
		if ("Mover"==MenuInferior.getSelecOpciones().getSelectionModel().getSelectedItem().toString()){
			if (MapaVistaControlador.tengoAlgunaUnidadSeleccionada()){
				MapaVistaControlador.desSeleccionarUnidades();
			}
			MenuInferior.getLog().appendText("\nSoy una posicion");
		}
		if ("Atacar"==MenuInferior.getSelecOpciones().getSelectionModel().getSelectedItem().toString()){

			MenuInferior.getLog().appendText("\nPor favor, seleccione una unidad");
		}
	}
}


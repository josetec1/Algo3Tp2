package Eventos;

import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Direccion.Direccionable;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import vista.MenuInferior;
import vista.MapaVistaControlador;
import vista.ContenedorPrincipal;

public class SeleccionDireccionHandler implements EventHandler<MouseEvent> {

    Direccionable direccion;


    public SeleccionDireccionHandler (Direccionable direccion){
        this.direccion = direccion;
    }

    @Override
    public void handle(MouseEvent event) {
        //hay un aldeano seleccionado?
        //para mas adelante hay que contemplar los casos de que se seleccione un edificio, esos no se pueden mover
        if (!MapaVistaControlador.seleccionado) {
            MenuInferior.getLog().appendText("\n Primer debe seleccionar una unidad");}
        else{
            //mover al muchacho
            Mapa mapita = MapaVistaControlador.getMapa();
            Jugador jugador = ContenedorPrincipal.getJuego().getJugadorActual(); //???????!!!!!!!!

            if (!MapaVistaControlador.AldeanoSeleccionado.estasDisponible()){
                MenuInferior.getLog().appendText("\n Aldeano Ocupado");
            }else {
                MapaVistaControlador.AldeanoSeleccionado.mover(mapita, this.direccion, jugador);
            }
            //aca le mando un actualizar vista, va en otro lado pero sino no puedo probar nada



        }

    }
}


package Eventos;

import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Direccion.Direccionable;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import vista.MenuInferior;
import vista.TableroVistaControlador;
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
        if (!TableroVistaControlador.seleccionado) {
            MenuInferior.log.appendText("\n Primer debe seleccionar una unidad");}
        else{
            //mover al muchacho
            Mapa mapita = TableroVistaControlador.mapa;
            Jugador jugador = ContenedorPrincipal.juego.getJugadorActual(); //???????!!!!!!!!

            if (!TableroVistaControlador.AldeanoSeleccionado.estasDisponible()){
                MenuInferior.log.appendText("\n Aldeano Ocupado");
            }else {
                TableroVistaControlador.AldeanoSeleccionado.mover(mapita, this.direccion, jugador);
            }
            //aca le mando un actualizar vista, va en otro lado pero sino no puedo probar nada



        }

    }
}


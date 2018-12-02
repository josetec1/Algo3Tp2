package Eventos;

import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Direccion.Direccionable;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import vista.MenuInferior;
import vista.MapaVistaControlador;
import vista.ContenedorPrincipal;

import java.awt.*;

import static java.awt.SystemColor.menu;

public class SeleccionDireccionHandler implements EventHandler<MouseEvent> {

    Direccionable direccion;


    public SeleccionDireccionHandler (Direccionable direccion){
        this.direccion = direccion;
    }

    @Override
    public void handle(MouseEvent event) {
        //hay un aldeano seleccionado?
        //para mas adelante hay que contemplar los casos de que se seleccione un edificio, esos no se pueden mover
        if (!MapaVistaControlador.tengoAlgunaUnidadSeleccionada()) {
            MenuInferior.getLog().appendText("\n Primer debe seleccionar una unidad");}
        else{
            //mover al muchacho
            Mapa mapita = MapaVistaControlador.getMapa();
            Jugador jugador = ContenedorPrincipal.getJuego().getJugadorActual(); //???????!!!!!!!!

            //aldeano
            if(MapaVistaControlador.tengoAldeanoSeleccionado()){
                if (!MapaVistaControlador.getAldeanoSeleccionado().estasDisponible()){
                    MenuInferior.getLog().appendText("\n Aldeano Ocupado");
                }else {
                    MapaVistaControlador.getAldeanoSeleccionado().mover(mapita, this.direccion, jugador);
                }
            }

            //armaAsedio
            if(MapaVistaControlador.tengoArmaAsedioSeleccionado()){
                if (!MapaVistaControlador.getArmaDeAsedioSeleccionado().puedeMoverse()){
                    MenuInferior.getLog().appendText("\n ArmaAsedio No puede moverseEnEsteEstado");
                }else {
                    MapaVistaControlador.getArmaDeAsedioSeleccionado().mover(mapita, this.direccion, jugador);
                }
            }

            //arquero
            if(MapaVistaControlador.tengoArqueroSeleccionado()){
                MapaVistaControlador.getArqueroSeleccionado().mover(mapita, this.direccion, jugador);
                MenuInferior.getLog().appendText("\n arquero movido");
            }

            //espadachin
            if(MapaVistaControlador.tengoEspadachinSeleccionado()){
                MapaVistaControlador.getEspadachinSeleccionado().mover(mapita, this.direccion, jugador);
            }
            //Edificios

            //Castillo
            if(MapaVistaControlador.tengoCastilloSeleccionado()){
                MenuInferior.getLog().appendText("\n Castillo no puede moverse");
            }

            //cuartel
            if(MapaVistaControlador.tengoCuartelSeleccionado()){
                MenuInferior.getLog().appendText("\n Cuartel no puede moverse");
            }

            //Plaza
            if(MapaVistaControlador.tengoPlazaSeleccionado()){
                MenuInferior.getLog().appendText("\n PlazaCentral no puede moverse");
            }

            //aca le mando un actualizar vista, va en otro lado pero sino no puedo probar nada

        }

    }
}


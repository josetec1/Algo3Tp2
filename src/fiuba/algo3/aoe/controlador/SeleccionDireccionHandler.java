package fiuba.algo3.aoe.controlador;

import fiuba.algo3.aoe.modelo.Jugadores.Jugador;
import fiuba.algo3.aoe.modelo.Mapa.Mapa;
import fiuba.algo3.aoe.modelo.Ubicables.Direccion.Direccionable;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import fiuba.algo3.aoe.vista.ContenedorPrincipal;
import fiuba.algo3.aoe.vista.MapaVistaControlador;
import fiuba.algo3.aoe.vista.MenuInferior;

public class SeleccionDireccionHandler implements EventHandler<MouseEvent> {

    private Direccionable direccion;
    private ContenedorPrincipal contenedor;

    public SeleccionDireccionHandler (Direccionable direccion, ContenedorPrincipal contenedor ){
        this.direccion = direccion;
        this.contenedor = contenedor;
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
                if (!MapaVistaControlador.getAldeanoSeleccionado().estasDisponible()) {
                    MenuInferior.getLog().appendText("\n Aldeano Ocupado");
                    MapaVistaControlador.desSeleccionarUnidades();
                }else{
                    MapaVistaControlador.getAldeanoSeleccionado().mover(mapita, this.direccion, jugador);
                    MapaVistaControlador.desSeleccionarUnidades();
                    // El controlador tiene que actualizar la fiuba.algo3.aoe.vista SOLO PARA LOS MOVIMIENTOS.
                    contenedor.update(null,null);

                }
            }

            //armaAsedio
            if(MapaVistaControlador.tengoArmaAsedioSeleccionado()){
                if (!MapaVistaControlador.getArmaDeAsedioSeleccionado().puedeMoverse()){
                    MenuInferior.getLog().appendText("\n ArmaAsedio No puede moverseEnEsteEstado");
                    MapaVistaControlador.desSeleccionarUnidades();
                }else {
                    MapaVistaControlador.getArmaDeAsedioSeleccionado().mover(mapita, this.direccion, jugador);
                    MapaVistaControlador.desSeleccionarUnidades();
                    contenedor.update(null,null);
                }
            }

            //arquero
            if(MapaVistaControlador.tengoArqueroSeleccionado()){
                if (!MapaVistaControlador.getArqueroSeleccionado().estasDisponible()){
                    MenuInferior.getLog().appendText("\n Arquero Ocupado");
                    MapaVistaControlador.desSeleccionarUnidades();

                }else {
                    MapaVistaControlador.getArqueroSeleccionado().mover(mapita, this.direccion, jugador);
                    MapaVistaControlador.desSeleccionarUnidades();
                    // El controlador tiene que actualizar la fiuba.algo3.aoe.vista SOLO PARA LOS MOVIMIENTOS.
                    contenedor.update(null, null);
                    MenuInferior.getLog().appendText("\n arquero movido");
                }
            }

            //espadachin
            if(MapaVistaControlador.tengoEspadachinSeleccionado()){
                if (!MapaVistaControlador.getEspadachinSeleccionado().estasDisponible()) {
                    MenuInferior.getLog().appendText("\n Espadachin Ocupado");
                    MapaVistaControlador.desSeleccionarUnidades();
                }else {
                    MapaVistaControlador.getEspadachinSeleccionado().mover(mapita, this.direccion, jugador);
                    MapaVistaControlador.desSeleccionarUnidades();
                    // El controlador tiene que actualizar la fiuba.algo3.aoe.vista SOLO PARA LOS MOVIMIENTOS.
                    contenedor.update(null, null);
                }
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

            //aca le mando un actualizar fiuba.algo3.aoe.vista, va en otro lado pero sino no puedo probar nada

        }

    }
}


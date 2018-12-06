package fiuba.algo3.aoe.modelo.Ubicables.Edificios;

import fiuba.algo3.aoe.modelo.Jugadores.Jugador;
import fiuba.algo3.aoe.modelo.Mapa.Mapa;
import fiuba.algo3.aoe.modelo.Ubicables.Edificios.EstadoEdificable.EstadoEnConstruccion;
import fiuba.algo3.aoe.modelo.Ubicables.Unidades.UnidadAldeano.Aldeano;
import fiuba.algo3.aoe.modelo.Ubicables.Unidades.UnidadesMilitares.Arquero;
import fiuba.algo3.aoe.modelo.Ubicables.Unidades.UnidadesMilitares.Espadachin;
import fiuba.algo3.aoe.modelo.Ubicables.posicion.PosicionNula;
import fiuba.algo3.aoe.modelo.Ubicables.posicion.PosicionReal;

public class Cuartel extends EdificioConstruible {

    private final int CURACION = 50;

    public Cuartel() {super(250, new PosicionNula(), 2, 50);}

    public void comenzarConstruccion(Aldeano aldeano, Jugador jugador){
        estado = new EstadoEnConstruccion(aldeano,this.TURNOSPARACONSTRUCCION);
        jugador.agregarPieza(this);
    }

    public void crearArquero( Jugador jugadorActivo, Mapa mapa, PosicionReal posicionReal){
        if (!this.estado.puedoCrearUnidad()){throw  new NoSePuedeCrearUnidadException();} //todo implementar esto que esta mal  refac001
        Arquero arquero= new  Arquero ();

        mapa.colocar ( arquero, posicionReal);
        jugadorActivo.agregarPieza ( arquero );
    }
    public void crearEspadachin( Jugador jugadorActivo, Mapa mapa, PosicionReal posicionReal){
        if (!this.estado.puedoCrearUnidad()){throw  new NoSePuedeCrearUnidadException();} //todo implementar esto que esta mal  refac001
        Espadachin espadachin= new  Espadachin ();

        mapa.colocar ( espadachin, posicionReal);
        jugadorActivo.agregarPieza ( espadachin );
    }

    @Override
    public void huboUnCambioDeTurno ( Jugador jugador ) {
        this.estado.nuevoTurno(this,CURACION);
    }
}

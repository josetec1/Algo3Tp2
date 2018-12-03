package fiuba.algo3.aoe.Ubicables.Edificios;

import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Edificios.EstadoEdificable.EstadoEnConstruccion;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadAldeano.Aldeano;
import fiuba.algo3.aoe.Ubicables.posicion.PosicionNula;
import fiuba.algo3.aoe.Ubicables.posicion.PosicionReal;

public class PlazaCentral extends EdificioConstruible {


    private final int CURACION = 25;

    public PlazaCentral() {
        super(450, new PosicionNula(), 2, 100);
    }

    public void comenzarConstruccion(Aldeano aldeano, Jugador jugador){
        estado = new EstadoEnConstruccion(aldeano,this.TURNOSPARACONSTRUCCION);
        jugador.agregarPieza(this);
    }
    public void crearAldeano( Jugador jugadorActivo, Mapa mapa, PosicionReal posicionReal){
        Aldeano aldeano= new Aldeano ();
        if(!mapa.puedoColocar (posicionReal,aldeano.getTamanio () )){return;}
        if(!jugadorActivo.puedoAgregar (aldeano)){return;}
        mapa.colocar ( aldeano, posicionReal);
        jugadorActivo.agregarPieza ( aldeano );

    }

    @Override
    public void huboUnCambioDeTurno ( Jugador jugador ) {
        this.estado.nuevoTurno(this,CURACION);
    }

}


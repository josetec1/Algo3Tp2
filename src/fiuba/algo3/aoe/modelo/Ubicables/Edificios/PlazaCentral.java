package fiuba.algo3.aoe.modelo.Ubicables.Edificios;

import fiuba.algo3.aoe.modelo.Jugadores.Jugador;
import fiuba.algo3.aoe.modelo.Mapa.Mapa;
import fiuba.algo3.aoe.modelo.Ubicables.Edificios.EstadoEdificable.EstadoEnConstruccion;
import fiuba.algo3.aoe.modelo.Ubicables.Unidades.UnidadAldeano.Aldeano;
import fiuba.algo3.aoe.modelo.Ubicables.posicion.PosicionNula;
import fiuba.algo3.aoe.modelo.Ubicables.posicion.PosicionReal;

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

         if (!this.estado.puedoCrearUnidad()){throw  new NoSePuedeCrearUnidadException();} //todo implementar esto que esta mal  refac001
        Aldeano aldeano= new Aldeano (); //todo implementar esto que esta mal  refac001
        if(!mapa.puedoColocar (posicionReal,aldeano.getTamanio () )){return;}//todo implementar esto que esta mal  refac001
        if(!jugadorActivo.puedoAgregar (aldeano)){return;}//todo implementar esto que esta mal  refac001
        mapa.colocar ( aldeano, posicionReal);
        jugadorActivo.agregarPieza ( aldeano );

    }

    @Override
    public void huboUnCambioDeTurno ( Jugador jugador ) {
        this.estado.nuevoTurno(this,CURACION);
    }

}


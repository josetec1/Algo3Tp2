package fiuba.algo3.aoe.modelo.Ubicables.Edificios.EstadoEdificable;

import fiuba.algo3.aoe.modelo.Jugadores.Jugador;
import fiuba.algo3.aoe.modelo.Ubicables.Edificios.Edificio;
import fiuba.algo3.aoe.modelo.Ubicables.Edificios.EdificioConstruible;
import fiuba.algo3.aoe.modelo.Ubicables.Unidades.UnidadAldeano.Aldeano;

public class EstadoEnConstruccion implements EstadoEdificioConstruible {

    private Aldeano aldeano;
    private int turnosParaConstruccion;

    public EstadoEnConstruccion(Aldeano aldeano, int turnosParaConstruccion){
        this.aldeano = aldeano;
        this.turnosParaConstruccion = turnosParaConstruccion;
    }

    public boolean puedoConstruir(){
        return false;
    }

    public boolean puedoReparar(){
        return false;
    }


    public void construir( EdificioConstruible edificio, Aldeano aldeano, Jugador jugador ){
        throw new EdificioEnConstruccionException();
    }

    public void reparar(Edificio edificio,Aldeano aldeano){
        throw new EdificioNoPuedeRepararseEnEsteMomentoException ();
    }

    @Override
    public void nuevoTurno (EdificioConstruible edificio, int curacion) {
        turnosParaConstruccion-=1;
        if (turnosParaConstruccion == 0){
            this.liberarAldeano ();
            edificio.finalizarConstruccion();
        }
    }

    public void liberarAldeano(){
        this.aldeano.cambiarARecolectando ();
    }

    public boolean puedoCrearUnidad(){
        return false;
    }
}

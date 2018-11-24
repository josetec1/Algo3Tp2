package fiuba.algo3.aoe.Ubicables.Edificios.EstadoEdificable;

import fiuba.algo3.aoe.Ubicables.Edificios.Edificio;
import fiuba.algo3.aoe.Ubicables.Unidades.Aldeano;

public class EstadoEnConstruccion implements EstadoEdificio{

    private Aldeano aldeano;
    private int turnosParaConstruccion;

    public EstadoEnConstruccion( Aldeano aldeano,int turnosParaConstruccion){
        this.aldeano = aldeano;
        this.turnosParaConstruccion = turnosParaConstruccion;
    }

    public boolean puedoConstruir(){
        return false;
    }

    public boolean puedoReparar(){
        return false;
    }


    public void construir( Edificio edificio, Aldeano aldeano ){
        throw new EdificioEnConstruccionException();
    }

    public void reparar(Edificio edificio,Aldeano aldeano){
        throw new EdificioNoPuedeRepararseEnEsteMomentoException ();
    }

    @Override
    public void nuevoTurno (Edificio edificio,int curacion) {
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

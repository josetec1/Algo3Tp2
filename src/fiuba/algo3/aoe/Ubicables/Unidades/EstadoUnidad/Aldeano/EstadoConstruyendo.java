package fiuba.algo3.aoe.Ubicables.Unidades.EstadoUnidad.Aldeano;

import fiuba.algo3.aoe.Ubicables.Edificios.Edificio;
import fiuba.algo3.aoe.Ubicables.Unidades.Aldeano;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadMovil;

public class EstadoConstruyendo implements EstadoUnidadAldeano {

    public EstadoConstruyendo (Aldeano aldeano){

        aldeano.establecerCuentaRegresiva(2); //TODO numeromagico
    }

    @Override
    public Edificio construir(Aldeano unAldeano, Edificio unEdificio) {
        return null; //TODO excepcion
    }

    @Override
    public Boolean puedoConstruirOReparar() {
        return false;
    }

    @Override
    public void pasarTurno(UnidadMovil unidad) {

        int cuentaRegresiva= unidad.getCuentaRegresiva();
        unidad.establecerCuentaRegresiva(cuentaRegresiva -1);
        Aldeano aldeano = (Aldeano) unidad; //TODO Polemico
        if( cuentaRegresiva ==0) {aldeano.cambiarARecolectando();}


    }
}

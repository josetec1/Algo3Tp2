package fiuba.algo3.aoe.Ubicables.Edificios.EstadoCastillo;

import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Ubicables.Edificios.Castillo;
import fiuba.algo3.aoe.Ubicables.Edificios.Edificio;
import fiuba.algo3.aoe.Ubicables.Edificios.EdificioConstruible;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadAldeano.Aldeano;

public interface IEstadoCastillo {

    void nuevoTurno(Castillo castillo, int CURACION);



    boolean puedoReparar();

    void reparar(Edificio edificio , Aldeano aldeano );
    boolean puedoCrearUnidad();
    void liberarAldeano();


}

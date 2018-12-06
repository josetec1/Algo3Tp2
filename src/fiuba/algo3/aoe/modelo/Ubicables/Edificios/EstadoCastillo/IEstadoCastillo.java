package fiuba.algo3.aoe.modelo.Ubicables.Edificios.EstadoCastillo;

import fiuba.algo3.aoe.modelo.Ubicables.Edificios.Castillo;
import fiuba.algo3.aoe.modelo.Ubicables.Edificios.Edificio;
import fiuba.algo3.aoe.modelo.Ubicables.Unidades.UnidadAldeano.Aldeano;

public interface IEstadoCastillo {

    void nuevoTurno(Castillo castillo, int CURACION);

    boolean puedoReparar();
    void reparar(Edificio edificio , Aldeano aldeano );
    boolean puedoCrearUnidad();
    void liberarAldeano();









}

package fiuba.algo3.aoe.Ubicables.Unidades.EstadoUnidad.Aldeano;

import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Direccion.Direccionable;
import fiuba.algo3.aoe.Ubicables.Edificios.Edificio;
import fiuba.algo3.aoe.Ubicables.Unidades.Aldeano;


    public interface IEstadoUnidadAldeano {

    void pasarTurno (Aldeano unidad, Jugador unjugador);


    Edificio construir (Aldeano unAldeano, Edificio unEdificio);

    Boolean puedoConstruirOReparar ();

    void mover(Aldeano aldeano, Mapa mapa, Direccionable direccion);

    Boolean podesMoverte ();

    void reparar (Aldeano unidad, Edificio unEdificio);



}

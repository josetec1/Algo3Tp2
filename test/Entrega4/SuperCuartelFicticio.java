package Entrega4;

import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Edificios.Cuartel;
import fiuba.algo3.aoe.Ubicables.Edificios.EdificioConstruible;
import fiuba.algo3.aoe.Ubicables.Edificios.EstadoEdificable.EstadoEnConstruccion;
import fiuba.algo3.aoe.Ubicables.Edificios.NoSePuedeCrearUnidadException;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadAldeano.Aldeano;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadesMilitares.Arquero;
import fiuba.algo3.aoe.Ubicables.posicion.PosicionNula;
import fiuba.algo3.aoe.Ubicables.posicion.PosicionReal;

public class SuperCuartelFicticio extends Cuartel {

//aca instancio un arquero con super poderes
    public void crearArquero(Jugador jugadorActivo, Mapa mapa, PosicionReal posicionReal){
        if (!this.estado.puedoCrearUnidad()){throw  new NoSePuedeCrearUnidadException();} 
        Arquero arquero= new Arquero(90000,1,1000,1000,500);
        if(!mapa.puedoColocar (posicionReal,arquero.getTamanio () )){return;}
        if(!jugadorActivo.puedoAgregar (arquero)){return;}

        mapa.colocar ( arquero, posicionReal);
        jugadorActivo.agregarPieza ( arquero );
    }
  
    
    
}

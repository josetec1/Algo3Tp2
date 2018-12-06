package Entrega4;

import fiuba.algo3.aoe.modelo.Jugadores.Jugador;
import fiuba.algo3.aoe.modelo.Mapa.Mapa;
import fiuba.algo3.aoe.modelo.Ubicables.Edificios.Cuartel;
import fiuba.algo3.aoe.modelo.Ubicables.Edificios.NoSePuedeCrearUnidadException;
import fiuba.algo3.aoe.modelo.Ubicables.Unidades.UnidadesMilitares.Arquero;
import fiuba.algo3.aoe.modelo.Ubicables.posicion.PosicionReal;

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

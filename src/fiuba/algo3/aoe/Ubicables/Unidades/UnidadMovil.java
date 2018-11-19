package fiuba.algo3.aoe.Ubicables.Unidades;

import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Atacable;
import fiuba.algo3.aoe.Ubicables.Direccion.Direccionable;
import fiuba.algo3.aoe.Ubicables.NotificableDeTurno;
import fiuba.algo3.aoe.Ubicables.Ubicable;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;

public abstract class UnidadMovil implements Ubicable, NotificableDeTurno, Atacable {

    protected Posicion posicion;
    protected int vidaMaxima;
    protected int costo;
    protected int vidaActual;


    public int getVidaMaxima(){
        return this.vidaMaxima;
    }
    public int getVidaActual(){
        return this.vidaActual;
    }
    public void disminuirVida( int vida){
        this.vidaActual -= vida;
    }
    public void serAtacadoPor(UnidadMovilMilitar unidadMovilMilitar) {
        this.disminuirVida(unidadMovilMilitar.getDanioUnidad());
    }

    public int getCosto(){
        return this.costo;
    }

    public Posicion getPosicion() {
        if (this.posicion==null){throw new UnidadSinPosicionExceptcion();}
        return this.posicion;
    }

    public void colocarEn(Posicion posicion){
        this.posicion = posicion;
    }

    public Posicion obtenerPosicionDeAvance( Direccionable direccionable ){

        return this.getPosicion().calcularPosicionSiguiente(direccionable);


    }



    //TODO si no se puede mover por que la posicion esta ocupada, deberia responder algo!
    public abstract  void mover(Mapa mapa, Direccionable direccion);








}
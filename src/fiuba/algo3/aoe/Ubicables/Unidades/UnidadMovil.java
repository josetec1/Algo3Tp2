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
    protected int cuentaRegresiva ; // TODO , esto lo uso para los cambios de estado que dependen de turnos ver si amerita en unidad militar

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
        return this.posicion;
    }

    public void colocarEn(Posicion posicion){
        this.posicion = posicion;
    }

    public Posicion obtenerPosicionDeAvance( Direccionable direccionable ){

        return this.posicion.calcularPosicionSiguiente(direccionable);
    }



    //TODO: si no se puede mover por que la posicion esta ocupada, tendria que hacer algo, retornar un bool
    // y usar eso para volvera intentar otra cosa, o enviar un mensaje "ahi no me puedo mover"
    public  void mover(Mapa mapa, Direccionable direccion) {
        Posicion destino = this.obtenerPosicionDeAvance(direccion);
        if (mapa.puedoColocar(destino)) {
            mapa.moverElemento(this, destino);
        }
    }





    // es para los estados.
    public void establecerCuentaRegresiva( int numero ){

        this.cuentaRegresiva= numero;
    }

    public int getCuentaRegresiva( ){ //TODO esto hay que revisarlo, quizas sea mejor que el contador este en el estado.

        return this.cuentaRegresiva;
    }


}
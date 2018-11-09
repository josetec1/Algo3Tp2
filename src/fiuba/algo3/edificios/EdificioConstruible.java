package fiuba.algo3.edificios;

public abstract class EdificioConstruible extends Edificio {

    private int costo;
    private int tiempoConstruccion;

    EdificioConstruible(int unaVida, int unCosto, int unTiempoConstruccion){

        super(unaVida);
        costo = unCosto;
        tiempoConstruccion = unTiempoConstruccion;
    }

    public int costo() {
        return costo;
    }

    public boolean estaEnConstruccion() {
        if(tiempoConstruccion == 0)return false;
        return true;
    }

    public void construir(){
        tiempoConstruccion -=1;
    }
}

package fiuba.algo3.aoe;

public class Posicion {


    public boolean seSuperponeCon (Posicion otraPosicion){return false;}
    public boolean contieneA (Posicion otraPosicion) {return false;}
    public void agregar (Casillero unCasillero) {}



  /*  private Boolean libre;
    private Ubicable elemento;

    public Posicion(){
        this.libre = true;
    }


    public Boolean estaVacio() {
        return libre;
    }

    public void colocar(Ubicable unElemento) {

        if  (!this.estaVacio()) {throw new CasilleroOcupadoException();}

        this.libre = false ;
        elemento = unElemento;

    }

    public Ubicable quitar() {

        if  (this.estaVacio()) {throw new CasilleroVacioException();}

        this.libre = true;
        return elemento;
    }
    */
}

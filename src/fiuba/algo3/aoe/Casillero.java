package fiuba.algo3.aoe;

public class Casillero {

    private Boolean libre;
    private Ubicable elemento;

    public Casillero(){
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
}

package fiuba.algo3.aoe.Tablero;


import fiuba.algo3.aoe.Ubicables.Direccion.Direccionable;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;
import fiuba.algo3.aoe.Ubicables.Ubicable;

import java.util.*;


public class Tablero {

    private ArrayList<Ubicable> tablero;

    private int ancho;
    private int alto;


    public Tablero (int anchoMaximo, int altoMaximo){
      //TODO validar el tamanio minimo, negativos, etc
      this.tablero = new ArrayList<>();
      this.ancho = anchoMaximo;
      this.alto = altoMaximo;


    }


    public Boolean puedoColocar( Posicion unaPosicion) {

       if(!this.estaDentroDeTablero (unaPosicion)){return false;}

        return this.estaLibre(unaPosicion);

    }

    private Boolean estaLibre (Posicion unaPosicion){
        for (Ubicable elemento : this.tablero){
            if  (elemento.getPosicion().seSuperponeCon(unaPosicion)){return false;}
        }
        return  true;

    }

    private Boolean estaDentroDeTablero (Posicion unaPosicion){
        return unaPosicion.estasDentroDe(this.ancho,this.alto);
    }


    public void colocar (Ubicable unElemento) throws Posicion.PosicionOcupadaException, FueraDeTableroException {

        Posicion posicion = unElemento.getPosicion();

        if (!this.estaDentroDeTablero(posicion)) {throw new FueraDeTableroException();}
        if(!this.estaLibre(posicion)) {throw new Posicion.PosicionOcupadaException();}

        this.tablero.add (unElemento);
    }

//TODO Falta implementar
    public void remover (Ubicable unElemento) {
        this.tablero.remove(unElemento);

    }


    //TODO Falta implementar
    //antes de usar este metodo tuvo que haber llamado a puedo colocar.
    public void trasladar (Ubicable unElemento, Posicion destino) throws FueraDeTableroException, Posicion.PosicionOcupadaException {
        this.remover(unElemento);
        this.colocar(unElemento);

    }

    //no usaria este metodo
    public void mover (Posicion origen, Direccionable direccionable ){}

}

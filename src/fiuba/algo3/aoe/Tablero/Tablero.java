package fiuba.algo3.aoe.Tablero;


import Ubicables.Unidades.movimiento.Direccion;
import fiuba.algo3.aoe.Ubicable.Ubicable;

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
     // this.inicializarTablero ();

    }


    public Boolean puedoColocar(Posicion unaPosicion) {

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


    public void colocar (Ubicable unElemento) throws PosicionOcupadaException, FueraDeTableroException {

        Posicion posicion = unElemento.getPosicion();

        if (!this.estaDentroDeTablero(posicion)) {throw new FueraDeTableroException();}
        if(!this.estaLibre(posicion)) {throw new PosicionOcupadaException();}

        this.tablero.add (unElemento);
    }

//TODO Falta implementar
    public void remover (Ubicable unElemento) {
        this.tablero.remove(unElemento);

    }


    //TODO Falta implementar
    //antes de usar este metodo tuvo que haber llamado a puedo colocar.
    public void trasladar (Ubicable unElemento, Posicion destino) throws FueraDeTableroException, PosicionOcupadaException {
        this.remover(unElemento);
        this.colocar(unElemento);

    }

    //no usaria este metodo
    public void mover (Posicion origen, Direccion direccion){}

}

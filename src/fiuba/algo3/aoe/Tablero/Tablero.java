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

    private boolean estaLibre (Posicion unaPosicion){
        for (Ubicable elemento : this.tablero){
            if  (elemento.getPosicion().seSuperponeCon(unaPosicion)){return false;}
        }
        return  true;

    }

    private boolean estaDentroDeTablero (Posicion unaPosicion){
        return unaPosicion.estasDentroDe(this.ancho,this.alto);
    }






    public void colocar (Ubicable unElemento){

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
    public void mover (Posicion origen, Direccion direccion){}

/*
    private void inicializarTablero (){

        tablero = new HashMap<>(ancho*alto);
        Casillero unaCasillero;
        Posicion unCasillero;

        for (int i = 1; i <= this.ancho; ++i) {

            for (int j = 1; j <= this.alto; ++j) {
                unaCasillero = new Casillero(i,j);
                unCasillero = new Posicion();

                tablero.put(unaCasillero,unCasillero);

                //System.out.println(i+","+j);
            }
        }
    }


    private boolean existeCasillero (Casillero unaPosicion){
        return tablero.containsKey(unaPosicion);
    }

    private Posicion getCasillero (Casillero unaPosicion)
    {
        if ( !existeCasillero(unaPosicion)) {throw new FueraDeTableroException();}
        return tablero.get(unaPosicion);
    }

    public void agregar(Ubicable unObjeto, Casillero posicion, Dimension unTamanio) {

      Posicion casillero = this.getCasillero(posicion);
      casillero.colocar(unObjeto);

    }




    private Ubicable sacar(Casillero unaPosicion, Dimension tamanioObjeto) {

        return this.getCasillero(unaPosicion).quitar();
    }

    public void retirar(Casillero unaPosicion, Dimension tamanioObjeto) {

        sacar(unaPosicion, tamanioObjeto);
    }

    //esto antes de sacar tiene que ver si va a poder colocar
    public void mover(Casillero posicionOrigen, Casillero posicionDestino) {

        Dimension tamanio = new Dimension(1,1);

        Ubicable elemento = sacar(posicionOrigen,tamanio);
        agregar(elemento,posicionDestino,tamanio);

    }
    */
}

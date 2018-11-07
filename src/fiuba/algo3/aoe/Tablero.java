package fiuba.algo3.aoe;

import java.util.HashMap;


public class Tablero {

    private HashMap <Casillero, Posicion> tablero;

    private int ancho;
    private int alto;


    public Tablero (Dimension tamanio){

        //TODO validar el tamanio minimo, negativos, etc

      //  ancho = tamanio.getX();
      //  alto = tamanio.getY();
       // this.inicializarTablero ();

    }

    public boolean puerdoColocar (Posicion unaPosicion){return false;}
    public void colocar (Ubicable unElemento){}
    public void remover (Posicion unaPosicion) {}
    public void mover (Posicion origen, Posicion destino){}

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

    public Boolean puedoColocar(Casillero unaPosicion, Dimension tamanioObjeto) {

        if (this.existeCasillero(unaPosicion)){
            return  this.getCasillero(unaPosicion).estaVacio();
        }
        return false;
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

package fiuba.algo3.aoe;

import java.util.HashMap;


public class Tablero {

    private HashMap <Coordenada, Casillero> tablero;

    private int ancho;
    private int alto;


    public Tablero (Dimension tamanio){

        //TODO validar el tamanio minimo, negativos, etc

        ancho = tamanio.getX();
        alto = tamanio.getY();
        this.inicializarTablero ();

    }

    private void inicializarTablero (){

        tablero = new HashMap<>(ancho*alto);
        Coordenada unaCoordenada;
        Casillero unCasillero;

        for (int i = 1; i <= this.ancho; ++i) {

            for (int j = 1; j <= this.alto; ++j) {
                unaCoordenada = new Coordenada(i,j);
                unCasillero = new Casillero();

                tablero.put(unaCoordenada,unCasillero);

                //System.out.println(i+","+j);
            }
        }
    }


    private boolean existeCasillero (Coordenada unaPosicion){
        return tablero.containsKey(unaPosicion);
    }

    private Casillero getCasillero (Coordenada unaPosicion)
    {
        if ( !existeCasillero(unaPosicion)) {throw new FueraDeTableroException();}
        return tablero.get(unaPosicion);
    }

    public void agregar(Ubicable unObjeto, Coordenada posicion, Dimension unTamanio) {

      Casillero casillero = this.getCasillero(posicion);
      casillero.colocar(unObjeto);

    }

    public Boolean puedoColocar(Coordenada unaPosicion, Dimension tamanioObjeto) {

        if (this.existeCasillero(unaPosicion)){
            return  this.getCasillero(unaPosicion).estaVacio();
        }
        return false;
    }


    private Ubicable sacar(Coordenada unaPosicion, Dimension tamanioObjeto) {

        return this.getCasillero(unaPosicion).quitar();
    }

    public void retirar(Coordenada unaPosicion, Dimension tamanioObjeto) {

        sacar(unaPosicion, tamanioObjeto);
    }

    public void mover(Coordenada posicionOrigen, Coordenada posicionDestino) {

        Dimension tamanio = new Dimension(1,1);

        Ubicable elemento = sacar(posicionOrigen,tamanio);
        agregar(elemento,posicionDestino,tamanio);

    }
}

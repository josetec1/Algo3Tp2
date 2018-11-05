package fiuba.algo3;

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
private Casillero getCasillero (Coordenada unaPosicion) {
        return tablero.get(unaPosicion);
    }

    public void agregar(Ubicable unObjeto, Coordenada posicion, Dimension unTamanio) {

      if ( !existeCasillero(posicion)) {throw new FueraDeTableroException();}

      Casillero casillero = this.getCasillero(posicion);
      casillero.colocar(unObjeto);

    }

    public Boolean puedoColocar(Coordenada unaPosicion, Dimension tamanioObjeto) {

        if (this.existeCasillero(unaPosicion)){
            return  this.getCasillero(unaPosicion).estaVacio();
        }
        return false;
    }



}
package fiuba.algo3.aoe.Tablero;

import java.util.*;

public class Posicion {

    private ArrayList<Casillero> casilleros;

    public Posicion(){
        this.casilleros = new ArrayList<>();
    }

    //sobrecarga
    public Posicion(Casillero unCasillero){
        this.casilleros = new ArrayList<>();
        this.agregar(unCasillero);
    }

    private Iterator<Casillero> getIterador(){
        return casilleros.iterator();

    }


    //
    public boolean seSuperponeCon (Posicion otraPosicion) {

        Casillero otroCasillero;   //obtenerla lista de casilleros
        Iterator<Casillero> itDeOtraPosicion;

        for (Casillero miCasillero : this.casilleros) { //con mi lista de casilleros y el iterador de la otra. los comparo

            itDeOtraPosicion = otraPosicion.getIterador();

            while (itDeOtraPosicion.hasNext()) {
                otroCasillero = itDeOtraPosicion.next();
                if (miCasillero.equals(otroCasillero)) return true;
            }
        }
        return false;
    }

    public void agregar (Casillero unCasillero) {
        this.casilleros.add(unCasillero);
    }
//TODO implementar
    public boolean estasDentroDe (int Ancho, int Alto) {
        // para cada una de las posiciones calcular si esta dentro de los limites
        // ejemplo 10 x 15 tablero
        // coordenada 10,16

        return false;
    }


}

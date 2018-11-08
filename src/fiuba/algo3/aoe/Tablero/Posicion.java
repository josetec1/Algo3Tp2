package fiuba.algo3.aoe.Tablero;

import java.util.*;

public class Posicion {

    private ArrayList<Casillero> casilleros=new ArrayList<>();

    public Posicion(){

    }

    //sobrecarga
    public Posicion(Casillero unCasillero){

        this.agregar(unCasillero);
    }

    //sobrecarga 2
    public Posicion(int x, int y){

        this.agregar(new Casillero(x,y));
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

    public boolean estasDentroDe (int ancho, int alto) {
        // para cada una de las posiciones calcular si esta dentro de los limites

        for (Casillero miCasillero : this.casilleros) {
               if (!miCasillero.estaDentroDe(ancho,alto)) {return false;}
        }
        return true;


    }


}

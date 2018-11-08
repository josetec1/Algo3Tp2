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


    public boolean seSuperponeCon (Posicion otraPosicion) {

        Casillero otroCasillero;   //obtenerla lista de casilleros
        Iterator<Casillero> it;

        for (Casillero miCasillero : this.casilleros) { //con mi lista de casilleros y el iterador de la otra. los comparo
            it = otraPosicion.getIterador();
            while (it.hasNext()) {
                otroCasillero = it.next();
                if (miCasillero.equals(otroCasillero)) return true;
            }
        }
        return false;
    }

    public void agregar (Casillero unCasillero) {
        this.casilleros.add(unCasillero);
    }


}

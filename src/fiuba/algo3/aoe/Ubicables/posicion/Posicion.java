package fiuba.algo3.aoe.Ubicables.posicion;

import fiuba.algo3.aoe.Ubicables.Direccion.Direccionable;
import fiuba.algo3.aoe.Ubicables.posicion.Cuadrante.Cuadrante;

import java.util.*;

public class Posicion {

    private ArrayList<Cuadrante> cuadrantes =new ArrayList<>();

    public Posicion(){

    }

    //sobrecarga con Cuadrante
    public Posicion(Cuadrante unCuadrante){

        this.agregar(unCuadrante);
    }

    //sobrecarga directa con int
    public Posicion(int x, int y){

        this.agregar(new Cuadrante(x,y));
    }

    private Iterator<Cuadrante> getIterador(){
        return cuadrantes.iterator();

    }
/*
    public ArrayList <Cuadrante> getCasilleros(){
        return this.casilleros;
    }
*/

    //
    public boolean seSuperponeCon (Posicion otraPosicion) {

        Cuadrante otroCuadrante;   //obtenerla lista de casilleros
        Iterator<Cuadrante> itDeOtraPosicion;

        for (Cuadrante miCuadrante : this.cuadrantes) { //con mi lista de casilleros y el iterador de la otra. los comparo

            itDeOtraPosicion = otraPosicion.getIterador();

            while (itDeOtraPosicion.hasNext()) {
                otroCuadrante = itDeOtraPosicion.next();
                if (miCuadrante.equals(otroCuadrante)) return true;
            }
        }
        return false;
    }

    public void agregar (Cuadrante unCuadrante) {
        this.cuadrantes.add(unCuadrante);
    }

    public boolean estasDentroDe (int ancho, int alto) {
        // para cada una de las posiciones calcular si esta dentro de los limites

        for (Cuadrante miCuadrante : this.cuadrantes) {
               if (!miCuadrante.estaDentroDe(ancho,alto)) {return false;}
        }
        return true;
    }

    public Posicion calcularPosicionSiguiente( Direccionable direccion ){

        Posicion nuevaPosicion = new Posicion();
        Cuadrante cuadranteNuevo;

        for(Cuadrante cuadranteActual : this.cuadrantes){
            cuadranteNuevo = direccion.calcularSiguienteCasillero(cuadranteActual);
             nuevaPosicion.agregar(cuadranteNuevo);
        }
        return nuevaPosicion;
    }

}

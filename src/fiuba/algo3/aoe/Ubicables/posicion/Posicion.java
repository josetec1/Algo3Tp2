package fiuba.algo3.aoe.Ubicables.posicion;

import fiuba.algo3.aoe.Ubicables.Direccion.Direccionable;
import fiuba.algo3.aoe.Ubicables.Edificios.Cuartel;
import fiuba.algo3.aoe.Ubicables.posicion.Cuadrante.Cuadrante;

import java.util.*;

public class Posicion {
    private int tamanio;
    private ArrayList<Cuadrante> cuadrantes =new ArrayList<>();

    public Posicion(){

    }

    //sobrecarga con Cuadrante
    public Posicion(Cuadrante unCuadrante){
        this.tamanio ++;
        this.agregar(unCuadrante);
    }

    //sobrecarga directa con int
    public Posicion(int x, int y){
        this.tamanio++;
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
        this.tamanio++;
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


    public Posicion expandir(int tamanio){
        Cuadrante cuadrante = this.cuadrantes.get(0);
        Posicion posicionNueva = new Posicion();
        for (int i = 0;i<tamanio;i++){
            for (int j = 0;j<tamanio;j++){
                posicionNueva.agregar(new Cuadrante(cuadrante.getX()+i,cuadrante.getY()+j));
            }
        }
        return posicionNueva;
    }

    public int distancia(Posicion otraPosicion) {

        Iterator<Cuadrante>  it = this.getIterador();
        Iterator<Cuadrante>  itOtraPos;

        Cuadrante miCuadrante;
        Cuadrante cuadrateOtraPosicion;

        int distancia = 1000;

        while(it.hasNext()) {

            miCuadrante = it.next();
            itOtraPos = otraPosicion.getIterador();

            while(itOtraPos.hasNext()){
                cuadrateOtraPosicion = itOtraPos.next();
                distancia = Math.min(distancia , miCuadrante.distancia(cuadrateOtraPosicion) );
            }
        }
        return distancia;

    }
}

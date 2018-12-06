package fiuba.algo3.aoe.modelo.Ubicables.posicion;

import fiuba.algo3.aoe.modelo.Ubicables.Direccion.Direccionable;
import fiuba.algo3.aoe.modelo.Ubicables.posicion.Cuadrante.Cuadrante;

import java.util.*;

public class PosicionReal extends Posicion {
    private int tamanio;


    protected PosicionReal(){

    }
   //sobrecarga con Cuadrante

    public PosicionReal(Cuadrante unCuadrante){
        this.agregar(unCuadrante);
    }
   //sobrecarga directa con int
    public PosicionReal(int x, int y){
        this.agregar(new Cuadrante(x,y));
    }


    //XXSentinela para la fiuba.algo3.aoe.vista
    public ArrayList <Cuadrante> getCasilleros(){
        return this.cuadrantes;
    }



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
    public Posicion calcularPosicionSiguiente(Direccionable direccion ){

        Posicion nuevaPosicionReal = new PosicionReal();
        Cuadrante cuadranteNuevo;

        for(Cuadrante cuadranteActual : this.cuadrantes){
            cuadranteNuevo = direccion.calcularSiguienteCasillero(cuadranteActual);
             nuevaPosicionReal.agregar(cuadranteNuevo);
        }
        return nuevaPosicionReal;
    }

    public Posicion expandir(int tamanio){
        Cuadrante cuadrante = this.cuadrantes.get(0);
        Posicion posicionRealNueva = new PosicionReal();
        for (int i = 0;i<tamanio;i++){
            for (int j = 0;j<tamanio;j++){
                posicionRealNueva.agregar(new Cuadrante(cuadrante.getX()+i,cuadrante.getY()+j));
            }
        }
        return posicionRealNueva;
    }

    public int distancia(Posicion otraPosicion) {

        Iterator<Cuadrante>  it = this.getIterador();
        Iterator<Cuadrante>  itOtraPos;


        Cuadrante miCuadrante;
        Cuadrante cuadrateOtraPosicion;

       int distancia = 1000;


        if (!otraPosicion.getIterador().hasNext()) {throw  new PosicionNulaException();}

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

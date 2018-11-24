package fiuba.algo3.aoe.Mapa;


import fiuba.algo3.aoe.Ubicables.posicion.Posicion;
import fiuba.algo3.aoe.Ubicables.Ubicable;

import java.util.*;


public class Mapa {

    private ArrayList<Ubicable> ubicables;

    private int ancho;
    private int alto;

    //TODO: validar el tamanio minimo, negativos, etc
    public Mapa(int anchoMaximo, int altoMaximo){

      this.ubicables = new ArrayList<>();
      this.ancho = anchoMaximo;
      this.alto = altoMaximo;


    }


    public Boolean puedoColocar( Posicion unaPosicion,int tamanio) {
        Posicion posicionAColocar = unaPosicion.expandir(tamanio);

       if(!this.estaDentroDeLosMargenesDelMapa(posicionAColocar)){return false;}

        return this.estaLibre(posicionAColocar);

    }

    private Boolean estaLibre (Posicion unaPosicion){
        for (Ubicable elemento : this.ubicables){
            if  (elemento.getPosicion().seSuperponeCon(unaPosicion)){return false;}
        }
        return  true;

    }

    private Boolean estaDentroDeLosMargenesDelMapa(Posicion unaPosicion ){
        return unaPosicion.estasDentroDe(this.ancho,this.alto);
    }

    // Recibe un ubicable y una posicion, luego de colocarlo, le setea la posicion al ubicable
    // el ubicable tiene no puede estar agregado previamente
    public void colocar (Ubicable unElemento, Posicion posicion)  {
        Posicion posicionNueva = posicion.expandir(unElemento.getTamanio());
        if (!this.estaDentroDeLosMargenesDelMapa(posicionNueva)) {throw new FueraDelMapaException();}
        if(!this.estaLibre(posicionNueva)) {throw new PosicionDelMapaOcupadaException();}
        if (this.estaEnElMapa(unElemento)){throw new ElElementoYaExisteException();}
        unElemento.colocarEn(posicionNueva);
        this.ubicables.add (unElemento);
    }


    public void remover (Ubicable unElemento) {
        if(!this.estaEnElMapa(unElemento)) {throw new NoExisteElementoException();}

        this.ubicables.remove(unElemento);

    }

    private Boolean estaEnElMapa(Ubicable unElemento){
        return this.ubicables.contains(unElemento);
    }

    //VERSION ANTERIOR DE MOVER
/*
    // Pre: el elemento tiene que estar colocado, la posicion de destino tiene que ser valida
    //(previamente haber llamado a puedo colocar)
    // quita el elemento pasado y luego lo coloca enla posicion de destino calculada con la direccio
    public void moverElemento (Ubicable unElemento, Direccionable direccion) {

        if (!this.estaEnElMapa(unElemento)) {throw new NoExisteElementoException();}

        Posicion destino = unElemento.getPosicion().calcularPosicionSiguiente(direccion);
        this.remover(unElemento);
        this.colocar(unElemento,destino);

    }
*/
    // Pre: el elemento tiene que estar colocado, la posicion de destino tiene que ser valida
    //(previamente haber llamado a puedo colocar)
    // quita el elemento pasado y luego lo coloca en la posicion de destino
    public void moverElemento(Ubicable unElemento, Posicion destino) {

        if (!this.estaEnElMapa(unElemento)) {throw new NoExisteElementoException();}


        this.remover(unElemento);
        this.colocar(unElemento,destino);

    }

}

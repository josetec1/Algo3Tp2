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


    public void moverElemento(Ubicable unElemento, Posicion destino) {
        if (!this.puedoColocar(destino,unElemento.getTamanio())){throw new NoSePuedeMoverElElementoException();}
        this.remover(unElemento); //si no esta esta lanza exception
        this.colocar(unElemento,destino); //aca ya es seguro
    }
    public int getAncho (){return this.ancho;} //XXSentinela
    public  int getAlto(){return this.alto;} //XXSentinela
}

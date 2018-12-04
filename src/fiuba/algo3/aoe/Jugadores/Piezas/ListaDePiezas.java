package fiuba.algo3.aoe.Jugadores.Piezas;

import fiuba.algo3.aoe.Jugadores.*;
import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Atacable;
import fiuba.algo3.aoe.Ubicables.Edificios.Castillo;
import fiuba.algo3.aoe.Ubicables.Edificios.Cuartel;
import fiuba.algo3.aoe.Ubicables.Edificios.Edificio;
import fiuba.algo3.aoe.Ubicables.Edificios.PlazaCentral;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadAldeano.Aldeano;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadMovil;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadesMilitares.ArmaDeAsedio;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadesMilitares.Arquero;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadesMilitares.Espadachin;

import java.util.ArrayList;
import java.util.List;

public class ListaDePiezas {

    private Castillo castillo;
    private List<Aldeano> aldeanos;
    private List<Espadachin> espadachins;
    private List<Arquero> arqueros;
    private List<ArmaDeAsedio> armasDeAsedio;
    private List<PlazaCentral> plazaCentrales;
    private List<Cuartel> cuarteles;
    private final int UNIDADES_MAXIMAS = 50;

    public ListaDePiezas (Castillo castillo){

        this.castillo = castillo;
        this.aldeanos = new ArrayList<>();
        this.espadachins = new ArrayList<>();
        this.arqueros = new ArrayList<>();
        this.armasDeAsedio = new ArrayList<>();
        this.plazaCentrales = new ArrayList<>();
        this.cuarteles = new ArrayList<>();


    }

    public boolean puedoAgregar(Edificio edificio){
        if (this.existe(edificio)) {return false;}
        else return true;

    }
    public boolean puedoAgregar(UnidadMovil unidad){

        if (!this.existe(unidad)&(getCantidadDeUnidades()< UNIDADES_MAXIMAS)) {return true;}
        return false;

    }





    //esto es para que la vista pueda mostrar la cantidad
    public int getCantidadDeUnidades(){
        return (this.aldeanos.size()) + this.espadachins.size() + this.arqueros.size() + this.armasDeAsedio.size();
    }
            /* ************************************************************************
                                           //Setters
            **********************************************************************  */
    public void agregar (Aldeano aldeano){
        if (this.existe(aldeano)) {throw new PiezaYaAgregadaException();}
        if (!(getCantidadDeUnidades()< UNIDADES_MAXIMAS)) {throw new LimiteDePoblacionAlcanzadoException();}
        this.aldeanos.add(aldeano);
    }
    public void agregar (Espadachin espadachin){
        if (this.existe(espadachin)) {throw new PiezaYaAgregadaException();}
        if (!(getCantidadDeUnidades()< UNIDADES_MAXIMAS)) {throw new LimiteDePoblacionAlcanzadoException();}
        this.espadachins.add(espadachin);
    }
    public void agregar (Arquero arquero){
        if (this.existe(arquero)) {throw new PiezaYaAgregadaException();}
        if (!(getCantidadDeUnidades()< UNIDADES_MAXIMAS)) {throw new LimiteDePoblacionAlcanzadoException();}
        this.arqueros.add(arquero);
    }
    public void agregar (ArmaDeAsedio armaDeAsedio){
        if (this.existe(armaDeAsedio)) {throw new PiezaYaAgregadaException();}
        if (!(getCantidadDeUnidades()< UNIDADES_MAXIMAS)) {throw new LimiteDePoblacionAlcanzadoException();}
        this.armasDeAsedio.add(armaDeAsedio);
    }
    public void agregar (PlazaCentral plaza){
        if (this.existe(plaza)) {throw new PiezaYaAgregadaException();}
        this.plazaCentrales.add(plaza);
    }

    public void agregar (Cuartel cuartel){
        if (this.existe(cuartel)) {throw new PiezaYaAgregadaException();}
        this.cuarteles.add(cuartel);
    }

    /* ************************************************************************
                                           //Getters
            **********************************************************************  */

    public Castillo obtenerCastle() {
        return this.castillo;
    }

    public List<PlazaCentral> obtenerPlazas() {
        return this.plazaCentrales;
    }

    public List<Cuartel> obtenerCuartels() {
        return this.cuarteles;
    }

    public List<Aldeano> obtenerAldeanos() {
        return this.aldeanos;
    }
    public List<ArmaDeAsedio> obtenerArmasDeAsedio() {
        return this.armasDeAsedio;
    }
    public List<Espadachin> obtenerEspadachins() {
        return this.espadachins;
    }
    public List<Arquero> obtenerArquers() {
        return this.arqueros;
    }

    private List <Manipulable> getPiezas (){

        ArrayList<Manipulable> lista= new ArrayList<>();
        lista.add (this.castillo);
        lista.addAll(this.aldeanos);
        lista.addAll(this.espadachins);
        lista.addAll(this.arqueros);
        lista.addAll(this.armasDeAsedio);
        lista.addAll(this.plazaCentrales);
        lista.addAll(this.cuarteles);
        return lista;
    }
    public List <Atacable> obtenerAtacables(){
        return new ArrayList<>(this.getPiezas());
    }

    /* ************************************************************************
                                           //Deleters
            **********************************************************************  */


    public void eliminar (Manipulable pieza){ //TODO REFACTOR

        if (pieza == this.castillo) {throw new NoSePuedeEliminarElCastilloException();}
        if (!existe (pieza)){throw new PiezaAgenaException();}

        if (this.aldeanos.remove(pieza))  return;
        if (this.espadachins.remove(pieza))  return;
        if (this.arqueros.remove(pieza))  return;
        if (this.armasDeAsedio.remove(pieza))  return;
        if (this.plazaCentrales.remove(pieza))  return;
        this.cuarteles.remove(pieza);

    }
/*
    public boolean existe (Manipulable pieza){ //TODO REFACTOR


        if (this.aldeanos.contains(pieza))  return true;
        if (this.espadachins.contains(pieza))  return true;
        if (this.arqueros.contains(pieza))  return true;
        if (this.armasDeAsedio.contains(pieza))  return true;
        if (this.plazaCentrales.contains(pieza))  return true;
        if (this.cuarteles.contains(pieza))  return true;
        if (this.castillo == pieza)  return true;

        return false;

    }
*/
    public boolean existe (Atacable pieza){ //TODO REFACTOR


        if (this.aldeanos.contains(pieza))  return true;
        if (this.espadachins.contains(pieza))  return true;
        if (this.arqueros.contains(pieza))  return true;
        if (this.armasDeAsedio.contains(pieza))  return true;
        if (this.plazaCentrales.contains(pieza))  return true;
        if (this.cuarteles.contains(pieza))  return true;
        if (this.castillo == pieza)  return true;

        return false;

    }


    public void cambioDeTurno (Jugador jugador){
        for (Manipulable manipulable : this.getPiezas()){
            manipulable.huboUnCambioDeTurno(jugador);
        }
    }



}

package fiuba.algo3.aoe.Jugadores;

import fiuba.algo3.aoe.Ubicables.Edificios.Castillo;
import fiuba.algo3.aoe.Ubicables.Edificios.Cuartel;
import fiuba.algo3.aoe.Ubicables.Edificios.PlazaCentral;
import fiuba.algo3.aoe.Ubicables.Unidades.Aldeano;
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

    public boolean puedoAgregar(){
        return (getCantidadDeUnidades()< UNIDADES_MAXIMAS);
    }

    //esto es para que la vista pueda mostrar la cantidad
    public int getCantidadDeUnidades(){
        return (this.aldeanos.size()) + this.espadachins.size() + this.arqueros.size() + this.armasDeAsedio.size();
    }
            /* ************************************************************************
                                           //Setters
            **********************************************************************  */
    public void agregar (Aldeano aldeano){
        this.aldeanos.add(aldeano);
    }
    public void agregar (Espadachin espadachin){
        this.espadachins.add(espadachin);
    }
    public void agregar (Arquero arquero){
        this.arqueros.add(arquero);
    }
    public void agregar (ArmaDeAsedio armaDeAsedio){
        this.armasDeAsedio.add(armaDeAsedio);
    }
    public void agregar (PlazaCentral plaza){
        this.plazaCentrales.add(plaza);
    }

    public void agregar (Cuartel cuartel){
        this.cuarteles.add(cuartel);
    }

    /* ************************************************************************
                                           //Getters
            **********************************************************************  */

    public Castillo getCastillo() {
        return this.castillo;
    }

    /* ************************************************************************
                                           //Deleters
            **********************************************************************  */

    public void eliminar (Aldeano aldeano){

      if  (this.aldeanos.contains(aldeano)) {this.aldeanos.remove(aldeano);}


    }

    public void eliminar (Manipulable pieza){
        if (pieza ==this.castillo){} //no se puede eliminar un castillo

        if (existe (pieza)) {   //aca podria ir otra exepcion
            this.aldeanos.remove(pieza);
            this.espadachins.remove(pieza);
            this.arqueros.remove(pieza);
            this.armasDeAsedio.remove(pieza);
            this.plazaCentrales.remove(pieza);
            this.cuarteles.remove(pieza);
        }

    }

    public boolean existe (Manipulable pieza){
        boolean aldeano,espadachin,arquero,arma,plaza,cuartel,castillo;

        aldeano =this.aldeanos.contains(pieza);
        espadachin =this.espadachins.contains(pieza);
        arquero =this.arqueros.contains(pieza);
        arma =this.armasDeAsedio.contains(pieza);
        plaza =this.plazaCentrales.contains(pieza);
        cuartel =this.cuarteles.contains(pieza);
        castillo =this.castillo == pieza;

        return (aldeano||espadachin||arquero||arma||plaza||cuartel||castillo);

    }
}

package fiuba.algo3.aoe.Jugador;

import fiuba.algo3.aoe.Jugadores.ObservadorJugador;
import fiuba.algo3.aoe.Ubicables.Edificios.Castillo;
import fiuba.algo3.aoe.Ubicables.Edificios.Cuartel;
import fiuba.algo3.aoe.Ubicables.Edificios.PlazaCentral;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadAldeano.Aldeano;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadesMilitares.ArmaDeAsedio;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadesMilitares.Arquero;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadesMilitares.Espadachin;

import java.util.ArrayList;
import java.util.List;

public class ObservadorDeJugadorFicticio implements ObservadorJugador {

    private List<Aldeano> aldeanos = new ArrayList<>();
    private List<Espadachin> espadachins = new ArrayList<>();
    private List<Arquero> arqueros = new ArrayList<>();
    private List<ArmaDeAsedio> armaDeAsedios = new ArrayList<>();
    private List<PlazaCentral> plazaCentrals = new ArrayList<>();
    private List<Castillo> castillos = new ArrayList<>();
    private List<Cuartel> cuartels = new ArrayList<>();

    @Override
    public void seCreo(Aldeano unaldeano) {
        aldeanos.add(unaldeano);

    }

    @Override
    public void seCreo(Espadachin espadachin) {
        espadachins.add(espadachin);
    }

    @Override
    public void seCreo(Arquero arquero) {
    arqueros.add(arquero);
    }

    @Override
    public void seCreo(ArmaDeAsedio arma) {
        armaDeAsedios.add(arma);
    }

    @Override
    public void seCreo(PlazaCentral plaza) {
        plazaCentrals.add(plaza);
    }

    @Override
    public void seCreo(Cuartel cuartel) {
        cuartels.add(cuartel);
    }

    @Override
    public void seCreo(Castillo castillo) {
        castillos.add(castillo);
    }

    public List<Aldeano> getAldeanos() {
        return aldeanos;
    }



    public List<Espadachin> getEspadachins() {
        return espadachins;
    }

    public List<Arquero> getArqueros() {
        return arqueros;
    }

    public List<ArmaDeAsedio> getArmaDeAsedios() {
        return armaDeAsedios;
    }

    public List<PlazaCentral> getPlazaCentrals() {
        return plazaCentrals;
    }

    public List<Castillo> getCastillos() {
        return castillos;
    }

    public List<Cuartel> getCuartels() {
        return cuartels;
    }
}

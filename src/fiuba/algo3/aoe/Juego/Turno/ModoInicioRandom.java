package fiuba.algo3.aoe.Juego.Turno;


import java.util.Random;


public class ModoInicioRandom extends ModoInicio {

    public ModoInicioRandom() {

        setOrden(generar());

    }

    private TipoOrden generar(){

        TipoOrden[] ordenes = (TipoOrden.class).getEnumConstants();

        Random randomizador = new Random();
        int numeroRandom = randomizador.nextInt(ordenes.length);

        return ordenes[numeroRandom];

    }








}

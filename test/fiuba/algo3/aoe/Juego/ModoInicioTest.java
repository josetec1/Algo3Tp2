package fiuba.algo3.aoe.Juego;

import fiuba.algo3.aoe.Juego.Turno.ModosDeInicio.ModoInicio;
import fiuba.algo3.aoe.Juego.Turno.ModosDeInicio.ModoInicioEspecifico;
import fiuba.algo3.aoe.Juego.Turno.ModosDeInicio.ModoInicioRandom;
import fiuba.algo3.aoe.Juego.Turno.TipoOrden;
import org.junit.Assert;
import org.junit.Test;

import static fiuba.algo3.aoe.Juego.Turno.TipoOrden.FIRST;

public class ModoInicioTest {

    @Test
    public void test01AlCrearModoInicioEspecificoConFirstGetOrdenDebeDevolverCero(){

        ModoInicio modo = new ModoInicioEspecifico(FIRST);
        Assert.assertEquals(modo.getOrden(),0);

    }

    @Test
    public void test02AlCrearModoInicioEspecificoConSecondGetOrdenDebeDevolverUno(){

        ModoInicio modo = new ModoInicioEspecifico(TipoOrden.SECOND);
        Assert.assertEquals(modo.getOrden(),1);

    }

    @Test
    public void test03AlCrearModoInicioRandomElNumeroQueGeneraEsCeroOUnoLuegoDeMuchasIteraciones(){

        ModoInicio modo;
        boolean numero0=false;
        boolean numero1=false;

        for (int i = 0; i <100 ; i++) {

            modo = new ModoInicioRandom();
            if (modo.getOrden()==1) {numero1= true;}
            if (modo.getOrden()==0) {numero0= true;}

        }
        Assert.assertTrue(numero0 && numero1);

    }


}

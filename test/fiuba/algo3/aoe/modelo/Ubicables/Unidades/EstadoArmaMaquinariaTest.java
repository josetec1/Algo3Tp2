package fiuba.algo3.aoe.modelo.Ubicables.Unidades;

import fiuba.algo3.aoe.modelo.Jugadores.Jugador;
import fiuba.algo3.aoe.modelo.Mapa.Mapa;
import fiuba.algo3.aoe.modelo.Ubicables.Direccion.DireccionArribaDerecha;
import fiuba.algo3.aoe.modelo.Ubicables.Direccion.Direccionable;
import fiuba.algo3.aoe.modelo.Ubicables.Edificios.Castillo;
import fiuba.algo3.aoe.modelo.Ubicables.Edificios.Cuartel;
import fiuba.algo3.aoe.modelo.Ubicables.Edificios.PlazaCentral;

import fiuba.algo3.aoe.modelo.Ubicables.Unidades.EstadoUnidad.MaquinariaMilitar.*;
import fiuba.algo3.aoe.modelo.Ubicables.Unidades.UnidadAldeano.Aldeano;
import fiuba.algo3.aoe.modelo.Ubicables.Unidades.UnidadesMilitares.ArmaDeAsedio;
import fiuba.algo3.aoe.modelo.Ubicables.posicion.Posicion;
import fiuba.algo3.aoe.modelo.Ubicables.posicion.PosicionReal;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;

public class EstadoArmaMaquinariaTest {
    private Castillo castillo= new Castillo();
    private ArrayList<Aldeano> aldeanos = new ArrayList<>();
    private PlazaCentral plaza;
    private Jugador jugador1;
    private Jugador jugador2;

    @Before
    public void setUp(){
        plaza = new PlazaCentral();
        aldeanos.add(new Aldeano());
        aldeanos.add(new Aldeano());
        aldeanos.add(new Aldeano());
        jugador1 = new Jugador("Pelusa",castillo,plaza,aldeanos);
        jugador2 = new Jugador("Armando",castillo,plaza,aldeanos);

    }
    @Test
    public void test01EstadoMontadaPuedeAtacarNoPuedeMoverse(){
        EstadoMontada estado = new EstadoMontada ();
        Assert.assertTrue ( estado.puedeAtacar () );
        Assert.assertFalse ( estado.puedeMoverse () );
    }

    @Test
    public void test02EstadoMontadaNuevoTurnoSiguePudiendoAtacarYNoMoverse(){
        EstadoMontada estado = new EstadoMontada ();
        estado.nuevoTurno ( mock( ArmaDeAsedio.class ) );
        Assert.assertTrue ( estado.puedeAtacar () );
        Assert.assertFalse ( estado.puedeMoverse () );
    }


    @Rule
    public ExpectedException thrown = ExpectedException.none ();

    @Test
    public void test03EstadoMontadaMoverseLanzaDebeDesmontarsePrimeroException(){
        EstadoMontada estado = new EstadoMontada ();
        thrown.expect ( DebeDesmontarsePrimeroException.class );
        estado.mover ( mock( Mapa.class),mock( Direccionable.class ),mock(ArmaDeAsedio.class) );
    }

    @Test
    public void test04EstadoMontadaAtacarArmaDeAsedioACuartelDevuelveVida(){
        EstadoMontada estado = new EstadoMontada ();
        Cuartel cuartel = new Cuartel ();
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio ();
        Mapa mapa = new Mapa ( 200,200 );
        Posicion posicion1 = new PosicionReal ( 1,1 );
        Posicion posicion2 = new PosicionReal ( 2,2 );

        jugador1.sumarOro ( 999 );
        jugador2.sumarOro ( 999 );
        jugador1.agregarPieza ( armaDeAsedio );
        jugador2.agregarPieza (cuartel  );
        mapa.colocar ( armaDeAsedio,posicion1 );
        mapa.colocar ( cuartel,posicion2 );

        estado.atacar (armaDeAsedio,cuartel,jugador1,jugador2,mapa  );
        Assert.assertThat ( cuartel.getVidaActual () ,is(175) );
    }

    @Test
    public void test05EstadoDesmontadaPuedeMoverseNoPuedeAtacar(){
        EstadoDesmontada estado = new EstadoDesmontada ();
        Assert.assertTrue ( estado.puedeMoverse () );
        Assert.assertFalse ( estado.puedeAtacar () );
    }

    @Test
    public void test06EstadoDesmontadaNuevoTurnoSiguePudiendoMoverseYNoAtacar(){
        EstadoDesmontada estado = new EstadoDesmontada ();
        estado.nuevoTurno ( mock( ArmaDeAsedio.class ) );
        Assert.assertTrue ( estado.puedeMoverse () );
        Assert.assertFalse ( estado.puedeAtacar () );
    }



    @Test
    public void test07EstadoDesmontadaAtacarDebeLanzarDebeMontarsePrimeroExeption(){
        EstadoDesmontada estado = new EstadoDesmontada();
        Cuartel cuartel = new Cuartel ();
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio ();
        Mapa mapa = new Mapa ( 200,200 );
        PosicionReal posicionReal1 = new PosicionReal( 1,1 );
        PosicionReal posicionReal2 = new PosicionReal( 2,2 );

        jugador1.sumarOro ( 999 );
        jugador2.sumarOro ( 999 );
        jugador1.agregarPieza ( armaDeAsedio );
        jugador2.agregarPieza (cuartel  );
        mapa.colocar ( armaDeAsedio, posicionReal1);
        mapa.colocar ( cuartel, posicionReal2);

        thrown.expect ( DebeMontarsePrimeroException.class );
        estado.atacar (armaDeAsedio,cuartel,jugador1,jugador2,mapa);
    }

    @Test
    public void test08EstadoDesmontadaMoverseMueveALaPosicionCorrecta(){
        EstadoDesmontada estado = new EstadoDesmontada();
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio ();
        Mapa mapa = new Mapa ( 200,200 );
        PosicionReal posicionReal1 = new PosicionReal( 1,1 );
        PosicionReal posicionReal2 = new PosicionReal( 2,2 );


        jugador1.sumarOro ( 999 );

        jugador1.agregarPieza ( armaDeAsedio );

        mapa.colocar ( armaDeAsedio, posicionReal1);
        estado.mover ( mapa,new DireccionArribaDerecha (),armaDeAsedio );
        Assert.assertTrue ( armaDeAsedio.getPosicion ().seSuperponeCon (posicionReal2) );
        Assert.assertFalse ( armaDeAsedio.getPosicion ().seSuperponeCon (posicionReal1) );
    }


    @Test
    public void test09EstadoMontandoseNoPuedeAtacarNoPuedeMoverse(){
        EstadoMontandose estado = new EstadoMontandose ();
        Assert.assertFalse ( estado.puedeAtacar () );
        Assert.assertFalse ( estado.puedeMoverse () );
    }

    @Test
    public void test10EstadoMontandoseNuevoTurnoNoPuedeAtacarNiMoverse(){
        EstadoMontandose estado = new EstadoMontandose ();
        estado.nuevoTurno ( mock( ArmaDeAsedio.class ) );
        Assert.assertFalse ( estado.puedeAtacar () );
        Assert.assertFalse ( estado.puedeMoverse () );
    }



    @Test
    public void test11EstadoMontandoseMoverseLanzaDebeDesmontarsePrimeroException(){
        EstadoMontandose estado = new EstadoMontandose ();
        thrown.expect ( DebeDesmontarsePrimeroException.class );
        estado.mover ( mock( Mapa.class),mock( Direccionable.class ),mock(ArmaDeAsedio.class) );
    }

    @Test
    public void test12EstadoMontandoseAtacarArmaDeAsedioACuartelDevuelveVida(){
        EstadoMontandose estado = new EstadoMontandose ();
        Cuartel cuartel = new Cuartel ();
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio ();
        Mapa mapa = new Mapa ( 200,200 );
        PosicionReal posicionReal1 = new PosicionReal( 1,1 );
        PosicionReal posicionReal2 = new PosicionReal( 2,2 );

        jugador1.sumarOro ( 999 );
        jugador2.sumarOro ( 999 );
        jugador1.agregarPieza ( armaDeAsedio );
        jugador2.agregarPieza (cuartel  );
        mapa.colocar ( armaDeAsedio, posicionReal1);
        mapa.colocar ( cuartel, posicionReal2);
        thrown.expect ( DebeMontarsePrimeroException.class );
        estado.atacar (armaDeAsedio,cuartel,jugador1,jugador2,mapa  );
    }

    @Test
    public void test13EstadoDesmontandoseNoPuedeAtacarNoPuedeMoverse(){
        EstadoDesmontandose estado = new EstadoDesmontandose ();
        Assert.assertFalse ( estado.puedeAtacar () );
        Assert.assertFalse ( estado.puedeMoverse () );
    }

    @Test
    public void test14EstadoDesmontandoseNuevoTurnoNoPuedeAtacarNiMoverse(){
        EstadoDesmontandose estado = new EstadoDesmontandose ();
        estado.nuevoTurno ( mock( ArmaDeAsedio.class ) );
        Assert.assertFalse ( estado.puedeAtacar () );
        Assert.assertFalse ( estado.puedeMoverse () );
    }



    @Test
    public void test15EstadoDesmontandoseMoverseLanzaDebeDesmontarsePrimeroException(){
        EstadoDesmontandose estado = new EstadoDesmontandose ();
        thrown.expect ( UnidadYaRealizoMovimientoEsteTurnoException.class );
        estado.mover ( mock( Mapa.class),mock( Direccionable.class ),mock(ArmaDeAsedio.class) );
    }

    @Test
    public void test16EstadoDesmontandoseAtacarArmaDeAsedioACuartelDevuelveVida(){
        EstadoDesmontandose estado = new EstadoDesmontandose ();
        Cuartel cuartel = new Cuartel ();
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio ();
        Mapa mapa = new Mapa ( 200,200 );
        PosicionReal posicionReal1 = new PosicionReal( 1,1 );
        PosicionReal posicionReal2 = new PosicionReal( 2,2 );

        jugador1.sumarOro ( 999 );
        jugador2.sumarOro ( 999 );
        jugador1.agregarPieza ( armaDeAsedio );
        jugador2.agregarPieza (cuartel  );
        mapa.colocar ( armaDeAsedio, posicionReal1);
        mapa.colocar ( cuartel, posicionReal2);
        thrown.expect ( UnidadYaRealizoMovimientoEsteTurnoException.class );
        estado.atacar (armaDeAsedio,cuartel,jugador1,jugador2,mapa  );
    }

    @Test
    public void test17EstadoMoviendoseNoPuedeAtacarNoPuedeMoverse(){
        EstadoMoviendose estado = new EstadoMoviendose (new EstadoDesmontada ());
        Assert.assertFalse ( estado.puedeAtacar () );
        Assert.assertFalse ( estado.puedeMoverse () );
    }

    @Test
    public void test18EstadoMoviendoseNuevoTurnoNoPuedeAtacarNiMoverse(){
        EstadoMoviendose estado = new EstadoMoviendose (new EstadoDesmontada ());
        estado.nuevoTurno ( mock( ArmaDeAsedio.class ) );
        Assert.assertFalse ( estado.puedeAtacar () );
        Assert.assertFalse ( estado.puedeMoverse () );
    }



    @Test
    public void test19EstadoMoviendoseMoverseLanzaDebeDesmontarsePrimeroException(){
        EstadoMoviendose estado = new EstadoMoviendose (new EstadoDesmontada ());
        thrown.expect ( UnidadYaRealizoMovimientoEsteTurnoException.class );
        estado.mover ( mock( Mapa.class),mock( Direccionable.class ),mock(ArmaDeAsedio.class) );
    }

    @Test
    public void test20EstadoMoviendoseAtacarArmaDeAsedioACuartelDevuelveVida(){
        EstadoMoviendose estado = new EstadoMoviendose (new EstadoDesmontada ());
        Cuartel cuartel = new Cuartel ();
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio ();
        Mapa mapa = new Mapa ( 200,200 );
        PosicionReal posicionReal1 = new PosicionReal( 1,1 );
        PosicionReal posicionReal2 = new PosicionReal( 2,2 );

        jugador1.sumarOro ( 999 );
        jugador2.sumarOro ( 999 );
        jugador1.agregarPieza ( armaDeAsedio );
        jugador2.agregarPieza (cuartel  );
        mapa.colocar ( armaDeAsedio, posicionReal1);
        mapa.colocar ( cuartel, posicionReal2);
        thrown.expect ( UnidadYaRealizoMovimientoEsteTurnoException.class );
        estado.atacar (armaDeAsedio,cuartel,jugador1,jugador2,mapa  );
    }

    @Test
    public void test21EstadoAtacandoNoPuedeAtacarNoPuedeMoverse(){
        EstadoAtacando estado = new EstadoAtacando (new EstadoDesmontada ());
        Assert.assertFalse ( estado.puedeAtacar () );
        Assert.assertFalse ( estado.puedeMoverse () );
    }

    @Test
    public void test22EstadoAtacandoNuevoTurnoNoPuedeAtacarNiMoverse(){
        EstadoAtacando estado = new EstadoAtacando (new EstadoDesmontada ());
        estado.nuevoTurno ( mock( ArmaDeAsedio.class ) );
        Assert.assertFalse ( estado.puedeAtacar () );
        Assert.assertFalse ( estado.puedeMoverse () );
    }



    @Test
    public void test23EstadoAtacandoMoverseLanzaDebeDesmontarsePrimeroException(){
        EstadoAtacando estado = new EstadoAtacando (new EstadoDesmontada ());
        thrown.expect ( UnidadYaRealizoMovimientoEsteTurnoException.class );
        estado.mover ( mock( Mapa.class),mock( Direccionable.class ),mock(ArmaDeAsedio.class) );
    }

    @Test
    public void test24EstadoAtacandoAtacarArmaDeAsedioACuartelDevuelveVida(){
        EstadoAtacando estado = new EstadoAtacando (new EstadoDesmontada ());
        Cuartel cuartel = new Cuartel ();
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio ();
        Mapa mapa = new Mapa ( 200,200 );
        PosicionReal posicionReal1 = new PosicionReal( 1,1 );
        PosicionReal posicionReal2 = new PosicionReal( 2,2 );

        jugador1.sumarOro ( 999 );
        jugador2.sumarOro ( 999 );
        jugador1.agregarPieza ( armaDeAsedio );
        jugador2.agregarPieza (cuartel  );
        mapa.colocar ( armaDeAsedio, posicionReal1);
        mapa.colocar ( cuartel, posicionReal2);
        thrown.expect ( UnidadYaRealizoMovimientoEsteTurnoException.class );
        estado.atacar (armaDeAsedio,cuartel,jugador1,jugador2,mapa  );
    }




}

package fiuba.algo3.aoe.Ubicables.Edificios;

import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Ubicables.Edificios.EstadoEdificable.EstadoEdificio;
import fiuba.algo3.aoe.Ubicables.Edificios.EstadoEdificable.EstadoEnConstruccion;
import fiuba.algo3.aoe.Ubicables.Edificios.EstadoEdificable.EstadoEnReparacion;
import fiuba.algo3.aoe.Ubicables.Edificios.EstadoEdificable.EstadoNormal;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class EstadoEdificioTest {

    @Test
    public void test01EstadoEdificioEnReparacionDevuelveTrueEnReparacion(){
        EstadoEdificio estado = new EstadoEnReparacion(50);
        Assert.assertEquals(estado.enReparacion(),true);
    }

    @Test
    public void test02EstadoEdificioEnConstruccionDevuelveTrueEnConstruccion(){
        EstadoEdificio estado = new EstadoEnConstruccion(50);
        Assert.assertEquals(estado.enConstruccion(),true);
    }

    @Test
    public void test03EstadoEdificioEnConstruccionDevuelveFalseEnReparacion(){
        EstadoEdificio estado = new EstadoEnConstruccion(50);
        Assert.assertEquals(estado.enReparacion(),false);
    }

    @Test
    public void test04EstadoEdificioEnReparacionDevuelveFalseEnConstruccion(){
        EstadoEdificio estado = new EstadoEnReparacion(50);
        Assert.assertEquals(estado.enConstruccion(),false);
    }

    @Test
    public void test05EstadoEdificioNormalDevuelveFalseEnConstruccion(){
        EstadoEdificio estado = new EstadoNormal();
        Assert.assertEquals(estado.enConstruccion(),false);
    }

    @Test
    public void test06EstadoEdificioNormalDevuelveFalseEnReparacion(){
        EstadoEdificio estado = new EstadoNormal();
        Assert.assertEquals(estado.enReparacion(),false);
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test07EstadoEdificioNormalRepararDevuelveEdificioSinDaniarException(){
        Edificio edificio = new Cuartel(mock(Jugador.class));
        EstadoEdificio estado = new EstadoNormal();
        thrown.expect(EdificioSinDaniarException.class);
        estado.reparar(edificio);
    }


    @Test
    public void test08EstadoEdificioEnReparacionConstruirDevuelveEdificioConstruidoException(){
        Edificio edificio = new Cuartel(mock(Jugador.class));
        EstadoEdificio estado = new EstadoEnReparacion(50);
        thrown.expect(EdificioConstruidoException.class);
        estado.construir(edificio);
        estado.reparar(edificio);
    }

    @Test
    public void test09EstadoEdificioConstruccionRepararDevuelveEdificioSinDaniarException(){
        Edificio edificio = new Cuartel(mock(Jugador.class));
        EstadoEdificio estado = new EstadoEnConstruccion(3);
        thrown.expect(EdificioSinDaniarException.class);
        estado.reparar(edificio);
    }

    @Test
    public void test010EstadoEdificioNormalConstruirDevuelveEdificioConstruidoException(){
        Edificio edificio = new Cuartel(mock(Jugador.class));
        EstadoEdificio estado = new EstadoNormal();
        thrown.expect(EdificioConstruidoException.class);
        estado.construir(edificio);
    }

    @Test
    public void test011EstadoEdificioConstruccionConstruir3VecesNoEstaEnConstruccionNiReparacion(){
        Edificio edificio = new Cuartel(mock(Jugador.class));
        edificio.construir();
        edificio.construir();
        edificio.construir();
        Assert.assertEquals(edificio.estaEnReparacion(),false);
        Assert.assertEquals(edificio.estaEnReparacion(),false);
    }

    @Test
    public void test012EstadoEdificioEnReparacionReparar2VecesAumentaVidaDeEdificioEn20(){
        Edificio edificio = new Cuartel(mock(Jugador.class));
        edificio.construir();
        edificio.construir();
        edificio.construir();
        EstadoEdificio estado = new EstadoEnReparacion(10);
        edificio.disminuirVida(10);
        edificio.disminuirVida(10);
        Assert.assertEquals(edificio.getVidaActual(),230);
        estado.reparar(edificio);
        estado.reparar(edificio);
        Assert.assertEquals(edificio.getVidaActual(),250);
    }

    @Test
    public void test013EstadoEdificioEnReparacionRepararAlMaximoConvierteEnEstadoNormal(){
        Edificio edificio = new Cuartel(mock(Jugador.class));
        edificio.construir();
        edificio.construir();
        edificio.construir();
        EstadoEdificio estado = new EstadoEnReparacion(10);
        edificio.disminuirVida(10);
        edificio.disminuirVida(10);
        Assert.assertEquals(edificio.getVidaActual(),230);
        estado.reparar(edificio);
        estado.reparar(edificio);
        Assert.assertEquals(edificio.estaEnReparacion(),false);
        Assert.assertEquals(edificio.estaEnConstruccion(),false);

    }

}


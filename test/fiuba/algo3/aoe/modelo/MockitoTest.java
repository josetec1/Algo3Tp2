package fiuba.algo3.aoe.modelo;

import org.junit.Assert;
import org.junit.Test;

import org.mockito.Mockito;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


public class MockitoTest {


    public  interface IPersona{
        Boolean estaOcupada();
        void cargarSaldo(int costo);
    }

    @Test
    public void test01WhenDevuelveLoQueYoLeDigo(){

        IPersona persona = Mockito.mock(IPersona.class);
        Mockito.when(persona.estaOcupada()).thenReturn(true);

        Assert.assertEquals(true, persona.estaOcupada());
    }

    @Test
    public void test02VerificoQueSeLlamoAlMetodoUnaSolaVezConValor10(){

        IPersona persona = Mockito.mock(IPersona.class);
        persona.cargarSaldo(10);

        verify(persona).cargarSaldo(10);
        verify(persona, times(1)).cargarSaldo(10);
    }

    @Test
    public void test03VerificoQueSeLlamoAlMetodoUnaSolaVezConCualquierValor(){

        IPersona persona = Mockito.mock(IPersona.class);
        persona.cargarSaldo(10);

        verify(persona).cargarSaldo(10);
        verify(persona, times(1)).cargarSaldo(anyInt());
    }

    @Test
    public void test04VerificoQueNuncaSeLlamoAlMetodoCargarSaldo(){

        IPersona persona = Mockito.mock(IPersona.class);

        verify(persona, never()).cargarSaldo(anyInt());
    }

}
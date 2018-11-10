package fiuba.algo3.aoe;

import org.junit.Assert;
import org.junit.Test;

import org.mockito.Mockito;
import static org.mockito.Mockito.mock;

public class MockitoTest {


    public static interface IPersona{
        Boolean estaOcupada();
    }

    @Test
    public void mockito_test(){

        IPersona persona = Mockito.mock(IPersona.class);
        Mockito.when(persona.estaOcupada()).thenReturn(true);

        Assert.assertEquals(true, persona.estaOcupada());
    }
}
package fiuba.algo3.aoe.Juego;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class JuegoTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test01EmpiezaElJuegoCorrectamente(){

        Juego juego = new Juego("Maradona","Messi",500,500);
        Assert.assertFalse(juego.finalizo());
    }


}

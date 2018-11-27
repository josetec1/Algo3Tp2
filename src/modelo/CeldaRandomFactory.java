package modelo;

import java.util.Random;

public class CeldaRandomFactory implements CeldaFactory {

    private Random generador;

    public CeldaRandomFactory()
    {
        generador = new Random();
    }
    
    public CeldaRandomFactory(long randomGeneratorSeed)
    {
        generador = new Random(randomGeneratorSeed);
    }

	public Celda getCelda() {
	    return new Celda(new Terreno(640,480),new Posicion(0,0), "lalala");

	}
}

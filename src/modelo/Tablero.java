package modelo;

import java.util.*;

public class Tablero {

	private ArrayList<Posicion> posicionesCeldasOcupadas;
	private HashMap <Posicion,Celda> celdas;
	private final int ANCHO = 40;
	private final int ALTO = 20;
	private static Tablero instanciaTablero = null;

	private static CeldaFactory generadorCeldas = new CeldaRandomFactory();

	private Tablero(){
	    posicionesCeldasOcupadas = new ArrayList<Posicion>();
		celdas = new HashMap <Posicion,Celda>();
		for (int i=1 ; i<=ANCHO ; i++){
			for (int j=1 ; j<=ALTO ; j++)
				celdas.put(new Posicion(i,j), generadorCeldas.getCelda());
		}
	}

	public int ancho(){
		return ANCHO;
	}

	public int altura(){
		return ALTO;
	}
	
	public static Tablero getInstance (){
		if (instanciaTablero == null)
			instanciaTablero = new Tablero();
		return instanciaTablero;
	}



  	public Celda getCelda(Posicion posicion){
  		return celdas.get(posicion);
  	}

    public Celda getCelda(int x, int y)
    {
        return celdas.get(new Posicion(x,y));
    }
}


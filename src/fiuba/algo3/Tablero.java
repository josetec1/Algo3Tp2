package fiuba.algo3;

public class Tablero {

    public Tablero (Dimension tamanio){}

    public void agregar(Ubicable unObjeto, Coordenada posicion, Dimension unTamanio) {
        throw new FueraDeTableroException();
    }

    public Boolean puedoColocar(Coordenada unaPosicion, Dimension tamanioObjeto) {
        return false;
    }
}

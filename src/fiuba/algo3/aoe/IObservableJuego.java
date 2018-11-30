package fiuba.algo3.aoe;

import java.util.Observable;

public class IObservableJuego extends Observable {

    public interface ObservableJuego {
         void suscribir( IObservadorDeJuego nuevoObservador );
         void desSuscribir( IObservadorDeJuego nuevoObservador );
    }
}

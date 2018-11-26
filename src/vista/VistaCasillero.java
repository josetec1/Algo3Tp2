package vista;

import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import modelo.Casillero;
import modelo.Terreno;

public class VistaCasillero{

    private Casillero casillero;
    Canvas canvas;

    public VistaCasillero(Casillero casillero, Canvas canvas) {
        this.casillero = casillero;
        this.canvas = canvas;
    }

    public void dibujar() {
        this.dibujarFormas();
    }

    private void dibujarFormas() {
        this.clean();
        canvas.getGraphicsContext2D().setFill(Color.DARKBLUE);
        canvas.getGraphicsContext2D().fillRect (casillero.getPosicion().getX() + 230, casillero.getPosicion().getY() + 110, casillero.RADIO, casillero.RADIO);
    }

    public void clean() {

        canvas.getGraphicsContext2D().setFill(Color.TRANSPARENT);
        canvas.getGraphicsContext2D().fillRect(0, 0, 1280, 720);
    }

    public void update() {
        this.dibujar();
    }

}

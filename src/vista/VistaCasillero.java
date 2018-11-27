package vista;

import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import modelo.Celda;

public class VistaCasillero {

    private Celda celda;
    Canvas canvas;

    public VistaCasillero(Celda celda, Canvas canvas) {
        this.celda = celda;
        this.canvas = canvas;
    }

    public void dibujar() {
        this.dibujarFormas();
    }

    private void dibujarFormas() {
        this.clean();
        canvas.getGraphicsContext2D().setFill(Color.DARKBLUE);
        canvas.getGraphicsContext2D().fillOval(celda.getPosicion().getX() + 230, celda.getPosicion().getY() + 110, celda.RADIO, celda.RADIO);
    }

    public void clean() {

        canvas.getGraphicsContext2D().setFill(Color.LIGHTBLUE);
        canvas.getGraphicsContext2D().fillRect(0, 0, 460, 220);
    }

    public void update() {
        this.dibujar();
    }

}

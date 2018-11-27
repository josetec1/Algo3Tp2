package modelo;

public class Posicion {

    private int x;
    private int y;

    public Posicion(int posX, int posY) {
        this.x = posX;
        this.y = posY;
    }

    public Posicion siguiente(Posicion posicion) {
        int nextX = this.x + posicion.getX()*10;
        int nextY = this.y + posicion.getY()*10;
        return new Posicion(nextX, nextY);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Posicion)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        Posicion other = (Posicion) obj;

        return (this.getX() == other.getX() && this.getY() == other.getY());
    }

}

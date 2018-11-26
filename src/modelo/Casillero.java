package modelo;

public class Casillero {

    private Terreno terreno;
    private Posicion posicion;
    private String mensaje;
    public final int RADIO = 20;

    public Casillero(Terreno terreno, Posicion posicion, String mensaje) {
        this.terreno = terreno;
        this.posicion = posicion;
        this.mensaje = mensaje;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public String getMensaje() {
        return mensaje;
    }
}

package modelo;

public class Celda {

    private Terreno terreno;
    private Posicion posicion;
    private String mensaje;
    public final int RADIO = 10;

    public Celda(Terreno terreno, Posicion posicion, String mensaje) {
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

    public void moverArriba() {
            this.posicion = this.posicion.siguiente(new Posicion(0, 1));
        //sino lanzo error o no hago nada
    }


    public void moverAbajo() {
        if (this.terreno.estaEnContacto(this.posicion)) {
            this.posicion = this.posicion.siguiente(new Posicion(0, -1));
        }
        //sino lanzo error o no hago nada
    }


    public void moverIzquierda() {
        if (this.terreno.estaEnContacto(this.posicion)) {
            this.posicion = this.posicion.siguiente(new Posicion(-1, 0));
        }
        //sino lanzo error o no hago nada
    }


    public void moverDerecha() {
        if (this.terreno.estaEnContacto(this.posicion)) {
            this.posicion = this.posicion.siguiente(new Posicion(1, 0));
        }
        //sino lanzo error o no hago nada
    }
}

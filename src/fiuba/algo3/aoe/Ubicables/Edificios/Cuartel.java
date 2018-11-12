package fiuba.algo3.aoe.Ubicables.Edificios;

public class Cuartel extends Edificio {


    public Cuartel(){
        this.costo = 50;
        this.vidaMaxima = 250;
        this.vidaActual = 250;
        this.turnosParaLaConstruccion = 3;
        this.estado = "En Construccion";
    }

    public void reparar(){
        if (this.estaDaniado()){this.vidaActual += 50;}
        else throw new EdificioSinDaniarException();
        if (this.vidaActual> this.vidaMaxima){
            this.vidaActual = this.vidaMaxima;
        }
    }

}

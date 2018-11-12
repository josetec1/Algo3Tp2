package fiuba.algo3.aoe.Ubicables.Edificios;

public class PlazaCentral extends Edificio {

    public PlazaCentral(){
        this.costo = 100;
        this.vidaMaxima = 450;
        this.vidaActual = 450;
        this.turnosParaLaConstruccion = 3;
        this.estado = "En Construccion";
    }

    public void reparar(){
        if (this.estaDaniado()){
            this.vidaActual += 25;
        }
        else{throw new EdificioSinDaniarException();}
        if (this.vidaActual> this.vidaMaxima){
            this.vidaActual = this.vidaMaxima;
        }
    }

}


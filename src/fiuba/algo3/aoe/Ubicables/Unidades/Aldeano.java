package fiuba.algo3.aoe.Ubicables.Unidades;


import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Edificios.Cuartel;
import fiuba.algo3.aoe.Ubicables.Edificios.PlazaCentral;
import fiuba.algo3.aoe.Ubicables.Unidades.EstadoUnidad.Aldeano.EstadoConstruyendo;
import fiuba.algo3.aoe.Ubicables.Unidades.EstadoUnidad.Aldeano.EstadoRecolectando;
import fiuba.algo3.aoe.Ubicables.Unidades.EstadoUnidad.Aldeano.EstadoUnidadAldeano;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;

public class Aldeano extends UnidadMovil  {

    private EstadoUnidadAldeano estado;


    public Aldeano( ){
        this.vidaMaxima = 50;
        this.vidaActual = 50;
        this.costo = 25;

        this.estado = new EstadoRecolectando(); //Todo refactor, revisar constructores
        this.cuentaRegresiva= 0;

    }

    public int getVidaMaxima(){
        return this.vidaMaxima;
    }

    public int getVidaActual(){return this.vidaActual;}

    public void disminuirVida( int vida){
        this.vidaActual-= vida;
    }


    @Override
    public void huboUnCambioDeTurno() {
        estado.pasarTurno(this);

    }



    //Antes de llamar a este metodo hay que preguntar si el aldeano esta disponible!
    //Pos devuelve el edificio en construccion y el aldeano queda en estado construyendo
    public PlazaCentral crearPlazaCentral(Posicion posicion, Mapa mapa) {
            // revisa que sea el turno de tu jugador.
      //    if (!this.esMiTurno()) {{throw new NoEsTuTurnoException();}}  // TODO  preguntamos esto?


            //revisa que pueda construir
          if (!this.estado.puedoConstruirOReparar()) {throw new AldeanoOcupadoException();}


        PlazaCentral unaPlaza =new PlazaCentral();
          unaPlaza = (PlazaCentral) this.estado.construir(this,unaPlaza);
        //colocar el edificio en construccion en el mapa.
        //TODO coloco el edificio enel mapa o lo coloca otro?

         return unaPlaza;
    }


    public Cuartel crearCuartel(Posicion posicion, Mapa mapa) {
        // revisa que sea el turno de tu jugador.
      //  if (!this.esMiTurno()) {{throw new NoEsTuTurnoException();}}  // TODO  preguntamos esto?

        //revisa que pueda construir
        if (!this.estado.puedoConstruirOReparar()) {throw new AldeanoOcupadoException();}


        Cuartel cuartel =new Cuartel();
        cuartel = (Cuartel) this.estado.construir(this,cuartel);
        //colocar el edificio en construccion en el mapa.
        //TODO coloco el edificio enel mapa o lo coloca otro?

        return cuartel;

    }

    // no usar desde afuera.
    public void cambiarAContruyendo(){this.estado= new EstadoConstruyendo(this);}
    public void cambiarARecolectando(){this.estado= new EstadoRecolectando();}

    //Siempre usar este metodo antes de llamar a reparar o construir
    public Boolean podesConstruirORepar() {
        return this.estado.puedoConstruirOReparar();
    }

    public void entregarElOro (Jugador jugador){jugador.sumarOro(20);}
}

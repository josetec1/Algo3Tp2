package fiuba.algo3.aoe.Juego.Turno.ModosDeInicio;


import fiuba.algo3.aoe.Juego.Turno.TipoOrden;

public abstract class ModoInicio {

   private TipoOrden ordenDeInicio;

   protected ModoInicio(){

   }

   protected void setOrden (TipoOrden orden){
       this.ordenDeInicio=orden;
   }

   public int getOrden() {
        return this.ordenDeInicio.ordinal();

    }

}

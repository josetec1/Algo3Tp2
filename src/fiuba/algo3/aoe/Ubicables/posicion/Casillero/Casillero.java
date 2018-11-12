package fiuba.algo3.aoe.Ubicables.posicion.Casillero;

public class Casillero {

    private int x;
    private int y;

   public Casillero(int x, int y){

       this.x = x;
       this.y = y;

   }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
   }

    public boolean estaDentroDe (int ancho,int alto){
       /* EJEMPLO DE COMO SE RESUELVE ESTE ESCENARIO
        Tamaño      10*15  es
                        1:1                   1:15
                        10:1                  10:15
        x <=ancho x >0
        y<= ancho y >0
        ##############################################*/

       boolean coordenadaX, coordenadaY;

       coordenadaX = ((this.x<= ancho) && (this.x> 0));
       coordenadaY = ((this.y<= alto) && (this.y> 0));
       return (coordenadaX && coordenadaY);

    }



    @Override
    public boolean equals(Object obj) {
       if (this == obj)  {return true;}
       if (obj == null)  {return false;}
       if (getClass() != obj.getClass()) {return false;}  //si me pasaste cualquier cosa


       Casillero other = (Casillero) obj; // ahora comparo componente por componente
        if ((this.x != other.x) ||(this.y != other.y)) {  return false;}

        return true;
    }
}
/*
    @Override
    public String toString(){
        return getX() + " " + getY();
    }
    */

//sobreescritura de metodos para poder usar la coordenada como key valida en el HashMap
   /*
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
        return result;
    }*/

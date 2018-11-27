package vista;

import java.util.Observable;

public class Consola extends Observable
{
    String contenidos = "";
    
    public void setMensaje(String m)
    {
        contenidos = m + "\n";
        setChanged();
        notifyObservers();
    }

    public void agregarMensaje(String m)
    {
        contenidos += m + "\n";
        setChanged();
        notifyObservers();
    }

    public String getMensaje()
    {
        return contenidos;
    }
}


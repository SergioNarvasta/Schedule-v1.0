package Control;

import Modelo.AGENDA;

public class Nodo {

    private AGENDA elemento;
    private Nodo Izq, Der;

    public Nodo(AGENDA elemento) {
        this.elemento = elemento;
        Izq = Der = null;
    }

    public AGENDA getElemento() {
        return elemento;
    }

    public void setElemento(AGENDA elemento) {
        this.elemento = elemento;
    }

    public Nodo getIzq() {
        return Izq;
    }

    public void setIzq(Nodo Izq) {
        this.Izq = Izq;
    }

    public Nodo getDer() {
        return Der;
    }

    public void setDer(Nodo Der) {
        this.Der = Der;
    }
    
    
}

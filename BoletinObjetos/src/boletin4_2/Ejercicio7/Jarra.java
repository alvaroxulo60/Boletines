package boletin4_2.Ejercicio7;

import exceptions.JarraExceptions;

public class Jarra {
    private final int CAPACIDAD_MAX;
    private int cantidadDeAgua;
    private static int contadorDeLitros = 0;


    public Jarra(int capacidad) throws JarraExceptions {
        if (capacidad <= 0) {
            throw new JarraExceptions("Error: La jarra no puede tener una capacidad menor o igual que 0");
        }
        this.CAPACIDAD_MAX = capacidad;
        cantidadDeAgua = 0;
    }

    public int getCantidadDeAgua() {
        return cantidadDeAgua;
    }

    public void setCantidadDeAgua(int cantidadDeAgua) {
        this.cantidadDeAgua = cantidadDeAgua;
    }

    public void llenarJarra() throws JarraExceptions {
        if (cantidadDeAgua == CAPACIDAD_MAX) {
            throw new JarraExceptions("La jarra ya esta llena.");
        }
        int litroUsado = 0;
        for (int i = 0; i < CAPACIDAD_MAX; i++) {
            if (cantidadDeAgua < CAPACIDAD_MAX) {
                litroUsado++;
            }
            else {
                cantidadDeAgua=CAPACIDAD_MAX;
                contadorDeLitros+=litroUsado;
            }
        }
    }

    public void vaciarJarra() throws JarraExceptions {
        if (cantidadDeAgua == 0) {
            throw new JarraExceptions("La jarra ya esta vacia");
        }
        cantidadDeAgua -= cantidadDeAgua;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Jarra{");
        sb.append("CAPACIDAD_MAX=").append(CAPACIDAD_MAX);
        sb.append(", cantidadDeAgua=").append(cantidadDeAgua);
        sb.append('}');
        return sb.toString();
    }

    public void jarra1EnJarra2(Jarra jarra2) throws JarraExceptions {
        int agua = 0;
        if (cantidadDeAgua == 0) {
            throw new JarraExceptions("Esta jarra no tiene suficiente agua");
        }
        for (int i = 0; i < CAPACIDAD_MAX; i++) {
            if (cantidadDeAgua > 0 || jarra2.cantidadDeAgua < jarra2.CAPACIDAD_MAX) {
                agua++;
            } else {
                setCantidadDeAgua(getCantidadDeAgua() - agua);
                jarra2.setCantidadDeAgua(jarra2.getCantidadDeAgua() + agua);
                return;
            }
        }
    }
}

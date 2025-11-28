package boletin4_2.Ejercicio7;

import exceptions.JarraExceptions;

public class Jarra {
    private static int contadorDeLitros = 0;

    private final int CAPACIDAD_MAX;
    private int cantidadDeAgua;


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

    public static void setContadorDeLitros(int contadorDeLitros) {
        Jarra.contadorDeLitros += contadorDeLitros;
    }

    public static int getContadorDeLitros() {
        return contadorDeLitros;
    }

    public void llenarJarra() throws JarraExceptions {
        if (cantidadDeAgua == CAPACIDAD_MAX) {
            throw new JarraExceptions("La jarra ya esta llena.");
        }
        int litrosUsados = CAPACIDAD_MAX - cantidadDeAgua;
        cantidadDeAgua = CAPACIDAD_MAX;
        setContadorDeLitros(litrosUsados);
    }

    public void vaciarJarra() throws JarraExceptions {
        if (cantidadDeAgua == 0) {
            throw new JarraExceptions("La jarra ya esta vacia");
        }
        cantidadDeAgua -= cantidadDeAgua;
    }

    @Override
    public String toString() {
        return "Jarra{" + "CAPACIDAD_MAX=" + CAPACIDAD_MAX +
                ", cantidadDeAgua=" + cantidadDeAgua +
                '}';
    }

    public void jarra1EnJarra2(Jarra jarra2) throws JarraExceptions {
        if (cantidadDeAgua == 0) {
            throw new JarraExceptions("Esta jarra no tiene suficiente agua");
        }
        while (cantidadDeAgua > 0 && jarra2.cantidadDeAgua < jarra2.CAPACIDAD_MAX) {
            cantidadDeAgua--;
            jarra2.cantidadDeAgua++;
        }
    }
}

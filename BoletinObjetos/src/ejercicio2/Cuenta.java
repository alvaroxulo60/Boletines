package ejercicio2;

import exceptions.CuentaException;

public class Cuenta {
    private double saldo;
    private int numeroIngresos;
    private int numeroReintegros;

    public Cuenta() {
        setSaldo();
        setNumeroIngresos();
        setNumeroReintegros();
    }

    public double getSaldo() {
        return saldo;
    }

    private void setSaldo() {
        this.saldo = 1000;
    }

    public int getNumeroIngresos() {
        return numeroIngresos;
    }

    private void setNumeroIngresos() {
        this.numeroIngresos = 0;
    }

    public int getNumeroReintegros() {
        return numeroReintegros;
    }

    private void setNumeroReintegros() {
        this.numeroReintegros = 0;
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "saldo=" + saldo +
                ", numeroIngresos=" + numeroIngresos +
                ", numeroReintegros=" + numeroReintegros +
                '}';
    }

    public void reintegro(int dineroASacar) throws CuentaException {
        if (dineroASacar <= 0) {
            throw new CuentaException("El saldo no puede ser negativo");
        }
        if (dineroASacar > this.saldo) {
            throw new CuentaException("No tienes suficiente saldo");
        }
        saldo -= dineroASacar;
        numeroReintegros++;
    }

    public void ingreso(int dineroAIngresar) throws CuentaException {
        if (dineroAIngresar < 0) {
            throw new CuentaException("El saldo no puede ser negativo");
        }
        saldo += dineroAIngresar;
        numeroIngresos++;
    }

    public void consulta() {
        System.out.println(toString());
    }


}

package app;

import exceptions.NaveException;

public class Cartucho {
    //Defionimos los atributos que va a tener cada objeto
    private String id;
    private String tipo;
    private double potencia;
    private double peso;

    public Cartucho(String id, String tipo, double potencia, double peso) throws NaveException {
        this.id = id;
        this.tipo = tipo;
        setPotencia(potencia);
        setPeso(peso);
    }

    //Utilizamos estos dos setters para validar los datos introducidos
    public void setPotencia(double potencia) throws NaveException {
        if (potencia < 0) {
            throw new NaveException("No puede tener una potencia menor a 0");
        }
        this.potencia = potencia;
    }

    public void setPeso(double peso) throws NaveException {
        if (peso < 0) {
            throw new NaveException("El peso no puede ser 0");
        }
        this.peso = peso;
    }

    //Establecemos los getters


    public double getPotencia() {
        return potencia;
    }

    public double getPeso() {
        return peso;
    }
}

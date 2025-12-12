package app;

import exceptions.NaveException;

public class Cartucho {
    //Defionimos los atributos que va a tener cada objeto
    private String id;
    private String tipo;
    private double potencia;
    private double peso;

    public Cartucho(String id, String tipo, double potencia, double peso) {
        this.id = id;
        this.tipo = tipo;
        setPotencia(potencia);
        setPeso(peso);
    }

    //Utilizamos estos dos setters para validar los datos introducidos
    public void setPotencia(double potencia) {
        this.potencia = potencia;
    }

    public void setPeso(double peso){
        this.peso = peso;
    }

    //Establecemos los getters


    public double getPotencia() {
        return potencia;
    }

    public double getPeso() {
        return peso;
    }

    public String getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Cartucho cartucho = (Cartucho) o;
        return tipo.equals(cartucho.tipo);
    }

    @Override
    public int hashCode() {
        return tipo.hashCode();
    }
}

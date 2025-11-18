package Ejercicio2;

public class Cuenta {
    private int saldo;
    private int numeroIngresos;
    private int numeroReintegros;

    public Cuenta(){
    setSaldo();
    setNumeroIngresos();
    setNumeroReintegros();
    }

    public int getSaldo() {
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

    public void reintegro(int dineroASacar){
        saldo -= dineroASacar;
        numeroReintegros++;
    }

    public void ingreso(int dineroAIngresar){
        saldo += dineroAIngresar;
        numeroIngresos++;
    }
    public void consulta(){
        System.out.println(toString());
    }


}

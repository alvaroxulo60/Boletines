package Ejercicio2;

public class Cuenta {
    private int saldo;

    public Cuenta(){
    setSaldo();
    }

    public int getSaldo() {
    return saldo;
    }

    private void setSaldo() {
    this.saldo = 1000;
    }

    public void reintegro(int dineroASacar){
        saldo -= dineroASacar;
    }

    public void ingreso(int dineroAIngresar){
        saldo += dineroAIngresar;
    }


}

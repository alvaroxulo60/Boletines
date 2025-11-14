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

    public int reintegro(int dineroASacar){
        return saldo-=dineroASacar;
    }

    public int ingreso(int dineroAIngresar){
        return saldo+=dineroAIngresar;
    }
}

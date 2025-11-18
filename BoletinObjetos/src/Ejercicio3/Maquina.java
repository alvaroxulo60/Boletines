package Ejercicio3;

import Exceptions.MaquinaCafeException;

public class Maquina {
    private int depositoCafe;
    private int depositoLeche;
    private int depositoVasos;
    private double monedero;
    public final double PRECIOCAFE = 1;
    public final double PRECIOLECHE = 0.8;
    public final double PRECIOCAFECONLECHE = 1.5;

    public Maquina() {
        setDepositoCafe();
        setDepositoLeche();
        setDepositoVasos();
        setMonedero();
    }

    public int getDepositoCafe() {
        return depositoCafe;
    }

    private void setDepositoCafe() {
        this.depositoCafe = 50;
    }

    public int getDepositoLeche() {
        return depositoLeche;
    }

    private void setDepositoLeche() {
        this.depositoLeche = 50;
    }

    public int getDepositoVasos() {
        return depositoVasos;
    }

    public void setDepositoVasos() {
        this.depositoVasos = 80;
    }

    public double getMonedero() {
        return monedero;
    }

    private void setMonedero() {
        this.monedero = 10;
    }


    @Override
    public String toString() {
        return "Maquina{" +
                "depositoCafe=" + depositoCafe +
                ", depositoLeche=" + depositoLeche +
                ", depositoVasos=" + depositoVasos +
                ", monedero=" + monedero +
                '}';
    }

    public void rellenarDepositos(int cafe, int leche, int vasos) throws MaquinaCafeException {
        if (cafe<0 || leche<0 || vasos<0) throw new MaquinaCafeException("Error: Alguna cantidad es negativa\n");
        else {
            this.depositoCafe += cafe;
            this.depositoLeche += leche;
            this.depositoVasos += vasos;
        }
    }

    public void vaciarMonedero() {
        this.monedero -= this.monedero;
    }

    public void consultarMaquina() {
        System.out.print(toString()+"\n");
    }

    public void servirCafe(String comanda, double dinero)throws MaquinaCafeException {
        double precio = 0;
        if (dinero >= precio) {
            switch (comanda.toLowerCase()) {
                case "cafe":
                    if (depositoCafe > 0 && depositoVasos > 0) {
                        depositoCafe -= 1;
                        depositoVasos -= 1;
                        precio = PRECIOCAFE;
                        break;
                    } else
                        throw new MaquinaCafeException("Lo siento, no podemos servirle eso debido a que no hay cantidad suficiente en el deposito. \n");
                case "leche":
                    if (depositoLeche > 0 && depositoVasos > 0) {
                        depositoLeche -= 1;
                        depositoVasos -= 1;
                        precio = PRECIOLECHE;
                        break;
                    } else
                        throw new MaquinaCafeException("Lo siento, no podemos servirle eso debido a que no hay cantidad suficiente en el deposito. \n");
                case "cafe con leche":
                    if (depositoCafe > 0 && depositoVasos > 0 && depositoLeche > 0) {
                        depositoLeche -= 1;
                        depositoCafe -= 1;
                        depositoVasos -= 1;
                        precio = PRECIOCAFECONLECHE;
                        break;
                    } else
                        throw new MaquinaCafeException("Lo siento, no podemos servirle eso debido a que no hay cantidad suficiente en el deposito. \n");
                default:
                    throw new MaquinaCafeException("No entiendo ese comando");

            }
            System.out.print("Recoge tu cambio de "+(dinero-precio)+"€\n");

        }
        else if (dinero< precio){
            throw new MaquinaCafeException("No has metido suficiente saldo.");
        }
    }
}

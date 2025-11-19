package boletin4_1.ejercicio3;

import exceptions.MaquinaCafeException;

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

    public void rellenarDepositos() {
        setDepositoCafe();
        setDepositoLeche();
        setDepositoVasos();
    }

    public void vaciarMonedero() {
        this.monedero -= this.monedero;
    }

    public void consultarMaquina() {
        System.out.print(toString() + "\n");
    }

    public double servirCafe(String comanda, double dinero) throws MaquinaCafeException {
        double precio = switch (comanda.toLowerCase()) {
            case "cafe" -> PRECIOCAFE;
            case "leche" -> PRECIOLECHE;
            case "cafe con leche" -> PRECIOCAFECONLECHE;
            default -> 0;
        };
        double cambio = dinero - precio;
        if (dinero >= precio) {
            if (cambio < monedero) {
                switch (comanda.toLowerCase()) {
                    case "cafe":
                        if (depositoCafe > 0 && depositoVasos > 0) {
                            depositoCafe -= 1;
                            depositoVasos -= 1;
                            break;
                        } else
                            throw new MaquinaCafeException("Lo siento, no podemos servirle eso debido a que no hay cantidad suficiente en el deposito. \n");
                    case "leche":
                        if (depositoLeche > 0 && depositoVasos > 0) {
                            depositoLeche -= 1;
                            depositoVasos -= 1;
                            break;
                        } else
                            throw new MaquinaCafeException("Lo siento, no podemos servirle eso debido a que no hay cantidad suficiente en el deposito. \n");
                    case "cafe con leche":
                        if (depositoCafe > 0 && depositoVasos > 0 && depositoLeche > 0) {
                            depositoLeche -= 1;
                            depositoCafe -= 1;
                            depositoVasos -= 1;
                            break;
                        } else
                            throw new MaquinaCafeException("Lo siento, no podemos servirle eso debido a que no hay cantidad suficiente en el deposito. \n");
                    default:
                        throw new MaquinaCafeException("No entiendo ese comando");
                }
                this.monedero -= cambio;
            } else throw new MaquinaCafeException("No hay suficiente cambio en la maquina");
        } else throw new MaquinaCafeException("No has metido suficiente saldo.");
        return cambio;
    }
}

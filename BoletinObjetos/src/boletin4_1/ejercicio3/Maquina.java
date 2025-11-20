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
    private final int MAXDOSISCAFE;
    private final int MAXDOSISLECHE;
    private final int MAXVASOS;
    private final double MAXMONEDERO;

    public Maquina(int maxDosisCafe, int maxDosisLeche, int maxVasos, double maxMonedero) {
        setDepositoCafe(maxDosisCafe);
        setDepositoLeche(maxDosisLeche);
        setDepositoVasos(maxVasos);
        setMonedero(maxMonedero);
        this.MAXDOSISCAFE = maxDosisCafe;
        this.MAXDOSISLECHE = maxDosisLeche;
        this.MAXVASOS = maxVasos;
        this.MAXMONEDERO = maxMonedero;
    }

    public int getDepositoCafe() {
        return depositoCafe;
    }

    private void setDepositoCafe(int cafe) {
        this.depositoCafe = cafe;
    }

    public int getDepositoLeche() {
        return depositoLeche;
    }

    private void setDepositoLeche(int leche) {
        this.depositoLeche = leche;
    }

    public int getDepositoVasos() {
        return depositoVasos;
    }

    public void setDepositoVasos(int vasos) {
        this.depositoVasos = vasos;
    }

    public double getMonedero() {
        return monedero;
    }

    private void setMonedero(double dinero) {
        this.monedero = dinero;
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
        setDepositoCafe(MAXDOSISCAFE);
        setDepositoLeche(MAXDOSISLECHE);
        setDepositoVasos(MAXVASOS);
        setMonedero(MAXMONEDERO);
    }

    public void vaciarMonedero() {
        this.monedero -= this.monedero;
    }

    public void consultarMaquina() {
        System.out.print(toString() + "\n");
    }

    public double servirCafe(String comanda, double dinero) throws MaquinaCafeException {
        double precio = establecerPrecio(comanda);
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

    private double establecerPrecio(String comanda) {
        switch (comanda.toLowerCase()) {
            case "cafe" -> {
                return PRECIOCAFE;
            }
            case "leche" -> {
                return PRECIOLECHE;
            }
            case "cafe con leche" -> {
                return PRECIOCAFECONLECHE;
            }
            default -> {
                return 0;
            }

        }
    }
}

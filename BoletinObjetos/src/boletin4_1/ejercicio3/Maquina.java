package boletin4_1.ejercicio3;

import exceptions.MaquinaCafeException;

public class Maquina {
    private int depositoCafe;
    private int depositoLeche;
    private int depositoVasos;
    private double monedero;
    public static final double PRECIO_CAFE = 1;
    public static final double PRECIO_LECHE = 0.8;
    public static final double PRECIO_CAFE_CON_LECHE = 1.5;
    private final int MAX_DOSIS_CAFE;
    private final int MAX_DOSIS_LECHE;
    private final int MAX_VASOS;
    private final double MAX_MONEDERO;

    public Maquina(int maxDosisCafe, int maxDosisLeche, int maxVasos, double maxMonedero) {
        setDepositoCafe(maxDosisCafe);
        setDepositoLeche(maxDosisLeche);
        setDepositoVasos(maxVasos);
        setMonedero(maxMonedero);
        this.MAX_DOSIS_CAFE = maxDosisCafe;
        this.MAX_DOSIS_LECHE = maxDosisLeche;
        this.MAX_VASOS = maxVasos;
        this.MAX_MONEDERO = maxMonedero;
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
        setDepositoCafe(MAX_DOSIS_CAFE);
        setDepositoLeche(MAX_DOSIS_LECHE);
        setDepositoVasos(MAX_VASOS);
        setMonedero(MAX_MONEDERO);
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
                            this.monedero+= PRECIO_CAFE;
                            break;
                        } else
                            throw new MaquinaCafeException("Lo siento, no podemos servirle eso debido a que no hay cantidad suficiente en el deposito. \n");
                    case "leche":
                        if (depositoLeche > 0 && depositoVasos > 0) {
                            depositoLeche -= 1;
                            depositoVasos -= 1;
                            this.monedero+= PRECIO_LECHE;
                            break;
                        } else
                            throw new MaquinaCafeException("Lo siento, no podemos servirle eso debido a que no hay cantidad suficiente en el deposito. \n");
                    case "cafe con leche":
                        if (depositoCafe > 0 && depositoVasos > 0 && depositoLeche > 0) {
                            depositoLeche -= 1;
                            depositoCafe -= 1;
                            depositoVasos -= 1;
                            this.monedero+= PRECIO_CAFE_CON_LECHE;
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
                return PRECIO_CAFE;
            }
            case "leche" -> {
                return PRECIO_LECHE;
            }
            case "cafe con leche" -> {
                return PRECIO_CAFE_CON_LECHE;
            }
            default -> {
                return 0;
            }
        }
    }
}

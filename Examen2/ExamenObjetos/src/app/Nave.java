package app;

import exceptions.NaveException;

public class Nave {
    //Una constante para el número de depósitos que tiene la nave
    public static final int NUM_DEPOSITOS = 3;

    private String nombre;
    Deposito[] depositos;

    public Nave(String nombre) {
        this.nombre = nombre;
        depositos = new Deposito[NUM_DEPOSITOS];
    }

    public String getNombre() {
        return nombre;
    }

    public boolean cargarDeposito(int indice, Cartucho c) throws NaveException {
        if (depositos[indice] == null) {
            depositos[indice] = new Deposito();
        }
        return depositos[indice].agregarCartucho(c);
    }

    /**
     * Hace las comprobaciones previas para ver si el cohete puede volar
     *
     * @throws NaveException devuelve el mensaje del fallo correspondiente
     */
    public void saltarHiperespacio() throws NaveException {
        if (checkAntimateria()) {
            throw new NaveException("ERROR CRÍTICO: ¡EXPLOSIÓN");
        }
        if (calcularPotenciaTotal() < 1000) {
            throw new NaveException("FALLO: Potencia insuficiente");
        }
        if (!puedeVolarConPlasmaVerde() && !hayUnaAntimateriaPorDeposito()) {
            throw new NaveException("FALLO: Configuración química inestable");
        }
    }

    /**
     * Calcula la potencia total de la nave
     *
     * @return devuelve el valor
     */
    private double calcularPotenciaTotal() {
        double potenciaTotal = 0;
        for (int i = 0; i < depositos.length; i++) {
            for (int j = 0; j < depositos[i].cartuchos.length; j++) {
                if (depositos[i].cartuchos[j]  != null) {
                    potenciaTotal += depositos[i].cartuchos[j].getPotencia();
                }
            }
        }
        return potenciaTotal;
    }

    /**
     * Calcula el peso total de la nave
     *
     * @return devuelve el valor
     */
    private double calcularPesoTotal() {
        double pesoTotal = 0;
        for (int i = 0; i < depositos.length; i++) {
            for (int j = 0; j < depositos[i].cartuchos.length; j++) {
                if (depositos[i].cartuchos[j] != null) {
                    pesoTotal += depositos[i].cartuchos[j].getPeso();
                }
            }
        }
        return pesoTotal;
    }

    /**
     * Comprueba si hay más de una antimateria por depósito
     *
     * @return Devuelve true o false
     */
    private boolean checkAntimateria() {
        for (int i = 0; i < depositos.length; i++) {
            int cartuchoDeAntimateriaPorDeposito = 0;
            cartuchoDeAntimateriaPorDeposito = depositos[i].contarCartuchosDeTipo("antimateria");
            if (cartuchoDeAntimateriaPorDeposito > 1) {
                return true;
            }
        }
        return false;
    }

    /**
     * Comprueba si hay únicamente 1 antimateria por depósito
     *
     * @return true o false
     */
    private boolean hayUnaAntimateriaPorDeposito() {
        for (int i = 0; i < depositos.length; i++) {
            int cartuchoDeAntimateriaPorDeposito = 0;
            cartuchoDeAntimateriaPorDeposito = depositos[i].contarCartuchosDeTipo("antimateria");
            if (cartuchoDeAntimateriaPorDeposito < 1) {
                return false;
            }
        }
        return true;
    }

    /**
     * Calcula el paso total de los cartuchos de plasma verde
     *
     * @return devuelve el valor
     */
    private double calcularPesoPlasmaVerde() {
        double pesoTotalPlasmaVerde = 0;
        for (int i = 0; i < depositos.length; i++) {
            for (int j = 0; j < depositos[i].cartuchos.length; j++) {
                pesoTotalPlasmaVerde += depositos[i].calcularPesoCartuchoTipo("plasma verde");
            }
        }
        return pesoTotalPlasmaVerde;
    }

    /**
     * Comprueba si puede volar con plasma verde
     *
     * @return true o false
     */
    private boolean puedeVolarConPlasmaVerde() {
        double pesoPlasmaVerde = calcularPesoPlasmaVerde();
        double pesoTotal = calcularPesoTotal();
        return pesoPlasmaVerde > pesoTotal * 0.5;
    }


}

package app;

public class Deposito {
    //Una constante para el número de cartuchos que tiene cada depósito
    public static final int NUM_CARTUCHOS = 5;

    Cartucho[] cartuchos;

    public Deposito() {
        cartuchos = new Cartucho[NUM_CARTUCHOS];
    }

    /**
     * Agrega el cartucho al array
     *
     * @param c el cartucho que se va a agrerar
     * @return
     */
    public boolean agregarCartucho(Cartucho c) {
        for (int i = 0; i < cartuchos.length; i++) {
            if (cartuchos[i] == null) {
                cartuchos[i] = c;
                return true;
            }
        }
        return false;
    }

    public double calcularPotenciaTotal() {
        double potenciaTotal = 0;
        for (int i = 0; i < cartuchos.length; i++) {
            if (cartuchos[i] != null) {
                potenciaTotal += cartuchos[i].getPotencia();
            }
        }
        return potenciaTotal;
    }

    public double calcularPesoTotal() {
        double pesoTotal = 0;
        for (int i = 0; i < cartuchos.length; i++) {
            if (cartuchos[i] != null) {
                pesoTotal += cartuchos[i].getPeso();
            }
        }
        return pesoTotal;
    }

    public int contarCartuchosDeTipo(String tipo) {
        int contador = 0;
        for (int i = 0; i < cartuchos.length; i++) {
            if (cartuchos[i] != null) {
                if (cartuchos[i].getTipo().equalsIgnoreCase(tipo)) {
                    contador++;
                }
            }
        }
        return contador;
    }

    public double calcularPesoCartuchoTipo(String tipo) {
        double sumaPesoMismosCartuchos = 0;
        for (int i = 0; i < cartuchos.length; i++) {
            if (cartuchos[i] != null) {
                if (cartuchos[i].getTipo().equalsIgnoreCase(tipo)) {
                    sumaPesoMismosCartuchos += cartuchos[i].getPeso();
                }
            }
        }
        return sumaPesoMismosCartuchos;
    }
}

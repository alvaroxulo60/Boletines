package ejercicio6;


import java.util.ArrayDeque;
import java.util.Queue;

public class Caja implements Comparable<Caja>{
    private final int NUMERO_DE_CAJA;
    private static int contador = 1;
    private Queue<Cliente> clientes;
    private boolean cajaAbierta;

    public Caja() {
        this.NUMERO_DE_CAJA = contador++;
        clientes = new ArrayDeque<>();
        cajaAbierta = false;
    }

    public boolean isCajaAbierta() {
        return cajaAbierta;
    }

    public int getClientes() {
        return clientes.size();
    }

    public int getNUMERO_DE_CAJA() {
        return NUMERO_DE_CAJA;
    }

    public void abrirCaja(){
        this.cajaAbierta = true;
    }

    public void cerrarCaja(){
        this.cajaAbierta = false;
    }

    public void añadirClienteACaja(Cliente c){
        clientes.add(c);
    }

    public void removeClienteDeCaja(Cliente c){
        clientes.remove(c);
    }

    @Override
    public int compareTo(Caja o) {
        int res = this.getClientes() -o.getClientes();

        if (res == 0){
            res = this.getNUMERO_DE_CAJA() - o.getNUMERO_DE_CAJA();
        }
        return res;
    }
}

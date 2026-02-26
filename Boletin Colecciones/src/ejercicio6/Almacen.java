package ejercicio6;

import exceptions.MiEntradaSalidaException;
import exceptions.SupermercadoException;
import io.MiEntradaSalida;

import java.util.ArrayList;
import java.util.List;

public class Almacen {
    private static final int NUM_CAJAS = 20;
    private List<Caja> cajas;

    public Almacen() {
        cajas = new ArrayList<>(NUM_CAJAS);
        for (int i = 0; i < NUM_CAJAS; i++) {
            cajas.add(new Caja());
        }
    }

    public void abrirCaja() throws SupermercadoException {
        try {
            int numCaja = MiEntradaSalida.leerEnteroRango("Introduce el numero de caja que quieras abrir (1-20): ",1,20) - 1;
            if (!cajas.get(numCaja).isCajaAbierta()){
                cajas.get(numCaja).abrirCaja();
            }
            else {
                throw new SupermercadoException("Esa caja ya esta abierta");
            }
        } catch (MiEntradaSalidaException e) {
            throw new SupermercadoException("Esa caja no existe");
        }
    }


    public void cerrarCaja() throws SupermercadoException {
        try {
            int numCaja = MiEntradaSalida.leerEnteroRango("Introduce el numero de caja que quieras cerrar (1-20): ",1,20) - 1;
            if (cajas.get(numCaja).getClientes() == 0){
                if (cajas.get(numCaja).isCajaAbierta()) {
                    cajas.get(numCaja).cerrarCaja();
                } else {
                    throw new SupermercadoException("Esta caja ya esta cerrada");
                }
            }
            else {
                throw new SupermercadoException("Esa caja tiene todavía clientes, no puedes cerrarla");
            }
        } catch (MiEntradaSalidaException e) {
            throw new SupermercadoException("Esa caja no existe");
        }
    }

    public String crearCliente() throws SupermercadoException {
        Caja caja = cajas.stream().filter(Caja::isCajaAbierta).min(Caja::compareTo).orElseThrow(()-> new SupermercadoException("No hay cajas abiertas"));
        Cliente cliente = new Cliente();


        caja.añadirClienteACaja(cliente);
        return "Es usted el cliente número "+cliente.getNUM_CLIENTE()+" y debe ir a la caja número "+caja.getNUMERO_DE_CAJA();

    }

    public String atenderCliente() throws SupermercadoException {
        try {
            int numCaja = MiEntradaSalida.leerEnteroRango("Introduce el numero de caja que quieras atender (1-20): ",1,20) - 1;
            if (cajas.get(numCaja).isCajaAbierta()){
                if (cajas.get(numCaja).getClientes()!= 0){
                    Cliente clienteEliminado = cajas.get(numCaja).removeClienteDeCaja();
                    return "Se ha atendido al cliente con número "+ clienteEliminado.getNUM_CLIENTE();
                }
            }else {
                throw new SupermercadoException("Esta caja no esta abierta.");
            }
        } catch (MiEntradaSalidaException e) {
            throw new SupermercadoException("Esa caja no existe");
        }
        return null;
    }

    public static void main(String[] args) {
        Almacen almacen = new Almacen();

        int opcion = 0;

        do {
            System.out.println("\n*********************************");
            System.out.println("        GESTIÓN DE CAJAS        ");
            System.out.println("*********************************");
            System.out.println("1. Abrir caja");
            System.out.println("2. Cerrar caja");
            System.out.println("3. Nuevo cliente");
            System.out.println("4. Atender cliente");
            System.out.println("5. Salir");
            System.out.print("Elija una opción: ");

            try {
                opcion = MiEntradaSalida.leerEnteroRango("¿Que deseas hacer?",1,5);

                switch (opcion) {
                    case 1:
                        System.out.println("Acción seleccionada: Abrir caja.");
                        almacen.abrirCaja();
                        break;
                    case 2:
                        System.out.println("Acción seleccionada: Cerrar caja.");
                        almacen.cerrarCaja();
                        break;
                    case 3:
                        System.out.println("Acción seleccionada: Nuevo cliente.");
                        System.out.println(almacen.crearCliente());
                        break;
                    case 4:
                        System.out.println("Acción seleccionada: Atender cliente.");
                        System.out.println(almacen.atenderCliente());
                        break;
                    case 5:
                        System.out.println("Saliendo del sistema... ¡Hasta pronto!");
                        break;
                    default:
                        System.out.println("Error: Opción no válida. Intente de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Por favor, introduzca un número válido.");
            } catch (MiEntradaSalidaException | SupermercadoException e) {
                System.out.println(e.getMessage());
            }

        } while (opcion != 5);

    }
}


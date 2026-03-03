package ejercicio7;


import exceptions.RecetaException;

import java.time.Duration;
import java.util.*;

public class Receta implements Comparable<Receta> {

    private String nombre;
    private Duration tiempoDeElaboracion;
    private Set<Ingrediente> ingredientes;
    private List<String> pasosDeLaReceta;

    public Receta(String nombre, Duration tiempoDeElaboracion) {
        this.nombre = nombre;
        this.tiempoDeElaboracion = tiempoDeElaboracion;
        this.ingredientes = new HashSet<>();
        this.pasosDeLaReceta = new LinkedList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public boolean necesitaIngrediente(String nombreIngrediente) {
        return ingredientes.stream().anyMatch(ingrediente -> ingrediente.getNombre().equalsIgnoreCase(nombreIngrediente));
    }

    public void annadirPaso(String paso) {
        pasosDeLaReceta.add(paso);
    }

    public void annadirIngrediente(Ingrediente ingredienteNuevo) {
        if (!ingredientes.add(ingredienteNuevo)) {
            for (Ingrediente i : ingredientes) {
                if (i.equals(ingredienteNuevo)) {
                    i.setCantidad(i.getCantidad() + ingredienteNuevo.getCantidad());
                }
            }
        }
    }

    public void borrarIngrediente(Ingrediente ingredienteABorrar) throws RecetaException {
        if (!ingredientes.remove(ingredienteABorrar)) {
            throw new RecetaException("Ese ingrediente no se encuentra en la receta");
        }
        pasosDeLaReceta.removeIf(paso -> paso.contains(ingredienteABorrar.getNombre()));
    }

    public Ingrediente devolverIngrediente(String nombre) throws RecetaException {
        for (Ingrediente ing : ingredientes) {
            if (ing.getNombre().equalsIgnoreCase(nombre)) {
                return ing;
            }
        }
        throw new RecetaException("Ese ingrediente no esta en la receta. \n");
    }

    public void annadirPasoDetrasDe(String pasoNuevo, String pasoExistente) throws RecetaException {
        int pos = pasosDeLaReceta.indexOf(pasoExistente);

        if (pos == -1) {
            throw new RecetaException("El paso existente no se encuentra en la receta");
        } else
            pasosDeLaReceta.set(pos + 1, pasoNuevo);
    }

    public Set<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public Duration getTiempoDeElaboracion() {
        return tiempoDeElaboracion;
    }


    @Override
    public int compareTo(Receta o) {
        return this.getTiempoDeElaboracion().compareTo(o.getTiempoDeElaboracion());
    }
}

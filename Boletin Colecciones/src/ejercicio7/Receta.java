package ejercicio7;


import exceptions.RecetaException;

import java.time.Duration;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Receta implements Comparable<Receta>{

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

    public void annadirPaso(String paso){
        pasosDeLaReceta.add(paso);
    }

    public void annadirIngrediente(Ingrediente ingredienteNuevo) {
        boolean encontrado  = false;
        for (Ingrediente i : ingredientes){
            if (i.getNombre().equalsIgnoreCase(ingredienteNuevo.getNombre())){
                i.setCantidad(i.getCantidad()+ingredienteNuevo.getCantidad());
                encontrado = true;
            }
        }
        if (!encontrado){
            ingredientes.add(ingredienteNuevo);
        }
    }

    public void borrarIngrediente(Ingrediente ingredienteABorrar) throws RecetaException {
        if (!ingredientes.remove(ingredienteABorrar)) {
            throw new RecetaException("Ese ingrediente no se encuentra en la receta");
        }
    }

    public Ingrediente devolverIngrediente(String nombre) throws RecetaException {
        for (Ingrediente ing: ingredientes){
            if (ing.getNombre().equalsIgnoreCase(nombre)){
                return ing;
            }
        }
        throw new RecetaException("Ese ingrediente no esta en la receta. \n");
    }

    public void annadirPasoDetrasDe(String pasoNuevo, String pasoExistente) throws RecetaException {
        if (pasosDeLaReceta.contains(pasoExistente)) {
            pasosDeLaReceta.set(pasosDeLaReceta.indexOf(pasoExistente) + 1, pasoNuevo);
        }
        else
            throw new RecetaException("El paso existente no se encuentra en la receta");
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

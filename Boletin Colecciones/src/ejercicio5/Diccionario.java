package ejercicio5;

import java.util.*;

public class Diccionario {

    private Map<String, List<String>> diccionario;

    public Diccionario() {
        diccionario = new HashMap<>();
    }

    public void addPalabra(String palabra, String significado) {
        if (diccionario.containsKey(palabra)) {
            diccionario.get(palabra).add(significado);
        } else {
            List<String> significados = new ArrayList<>();
            significados.add(significado);
            diccionario.put(palabra, significados);
        }
    }

    public List<String> buscarPalabra(String palabra) {
        return diccionario.get(palabra);
    }

    public void borrarPalabra(String palabra) {
        diccionario.remove(palabra);
    }

    public List<String> listadoPalabras(String comienzaPor) {
        List<String> aux = new LinkedList<>();
        for (String k : diccionario.keySet()) {
            if (k.startsWith(comienzaPor)) {
                aux.add(k);
            }
        }
        aux.sort(null);
        return aux;
    }
}
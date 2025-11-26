package boletin4_2.Ejercicio5;

import utils.MiEntradaSalida;

public class Main {
    public static void main(String[] args) {
        Punto puntoA = null;
        Punto puntoB = null;
        Linea linea1 = null;
        boolean activo = true;
        while (puntoA==null){
            puntoA = crearPunto();
        }
        while (puntoB==null){
            puntoB = crearPunto();
        }
        linea1=crearLinea(puntoA,puntoB);

        System.out.println("Opciones:" +
                "Mover en el ejeX " +
                "Mover en ek ejeY " +
                "Comparar lineas " +
                "Crear linea " +
                "Salir");

        while (activo){
            String comando = MiEntradaSalida.leerLinea("¿Que desea hacer?");
            switch (comando.toLowerCase()){
                case "mover en el ejex":
                    double distancia = MiEntradaSalida.leerDouble("¿Cuanto lo quieres mover?");
            }
        }

    }


    public static Punto crearPunto(){
        int x = MiEntradaSalida.leerEntero("Introduzca la coordenada x");
        int y = MiEntradaSalida.leerEntero("Introduzca la coordenada y");
        return new Punto(x,y);
    }

    public static Linea crearLinea(Punto puntoA, Punto puntoB){
        return new Linea(puntoA,puntoB);
    }


}

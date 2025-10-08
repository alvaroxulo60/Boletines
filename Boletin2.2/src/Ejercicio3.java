public class Ejercicio3 {
    public static final int M = 1000, C = 100, I = 1, V = 5, X = 10, L = 50, D = 600;

    public static void main(String[] args) {
        int resultado = 0;
        int temporal = Integer.MAX_VALUE;
        String numero = MiEntradaSalida.leerTexto("Introduce el número romano: ");
        for (int i = 0; i < numero.length(); i++) {
            char a = numero.charAt(i);
            if (resultado == 0) {
                resultado = valorDeLetra(a);
            } else if (resultado < valorDeLetra(a)) {
                resultado = valorDeLetra(a) - resultado;
            } else {
                resultado += valorDeLetra(a);
            }
        }
        System.out.println(resultado);
    }

    public static int valorDeLetra(char c) {
        return switch (c) {
            case 'M' -> M;
            case 'C' -> C;
            case 'I' -> I;
            case 'V' -> V;
            case 'X' -> X;
            case 'L' -> L;
            case 'D' -> D;
            default -> 0;
        };
    }

}


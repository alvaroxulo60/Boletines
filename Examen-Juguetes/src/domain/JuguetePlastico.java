package domain;

public abstract class JuguetePlastico extends Juguete {

    private TipoDePlastico tipoDePlastico;

    public JuguetePlastico(String nombre, String marca, TipoDePlastico tipoDePlastico) {
        super(nombre, marca);
        this.tipoDePlastico = tipoDePlastico;
    }
}

package boletin4_2.ejercicio1;

import java.time.LocalDate;

public class Persona {
    String nombre;
    LocalDate fechaNacimiento;
    int dni;
    char sexo;
    float altura;
    float peso;


    public Persona(String nombre, LocalDate fechaNacimiento, int dni, char sexo, float altura, float peso) {
       setNombre(nombre);
       setFechaNacimiento(fechaNacimiento);
       setDni(dni);
       setSexo(sexo);
       setAltura(altura);
       setPeso(peso);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public char getLetraDni(){
        char[] letras = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
        return letras[getDni()%23];

    }

    public double getIMC(){
    return getPeso()/Math.pow(getAltura(),2);
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", dni=" + dni + getLetraDni() +
                ", sexo=" + sexo +
                ", altura=" + altura +
                ", peso=" + peso +
                ", IMC=" + getIMC() +
                '}';
    }
}

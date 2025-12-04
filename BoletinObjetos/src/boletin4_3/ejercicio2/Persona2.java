package boletin4_3.ejercicio2;

import exceptions.MensajeExceptions;

import java.time.LocalDateTime;

public class Persona2 {
    public static int CAPACIDAD_BUZONES = 5;
    private String nombre;
    private Mensaje[] buzonMensajesRecibidos = new Mensaje[CAPACIDAD_BUZONES];
    private Mensaje[] buzonMensajesEnviados = new Mensaje[CAPACIDAD_BUZONES];


    public Persona2(String nombre) {
        setNombre(nombre);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Mensaje[] getBuzonMensajesRecibidos() {
        return buzonMensajesRecibidos;
    }

    public void setBuzonMensajesRecibidos(Mensaje[] buzonMensajesRecibidos) {
        this.buzonMensajesRecibidos = buzonMensajesRecibidos;
    }

    public Mensaje[] getBuzonMensajesEnviados() {
        return buzonMensajesEnviados;
    }

    public void setBuzonMensajesEnviados(Mensaje[] buzonMensajesEnviados) {
        this.buzonMensajesEnviados = buzonMensajesEnviados;
    }

    public void enviarMensaje(Mensaje mensaje, Persona2 persona2) throws MensajeExceptions {
        if (this.equals(persona2)){
            throw new MensajeExceptions("No te puedes enviar un mensaje a ti mismo");
        }
        if (mensaje.getAsunto().isBlank()) {
            throw new MensajeExceptions("El mensaje no tiene asunto");
        }
        if (persona2 == null) {
            throw new MensajeExceptions("No hay un destinatario");
        }
        if (mensaje.getCuerpo().isBlank()) {
            throw new MensajeExceptions("El mensaje no tiene cuerpo");
        }
        if (buzonMensajesEnviados[4] != null) {
            throw new MensajeExceptions("Tienes el buzon lleno");
        }
        if (persona2.buzonMensajesRecibidos[4] != null) {
            throw new MensajeExceptions("El destinatario tiene el buzon lleno");
        }
        mensaje.setRemitente(this);
        mensaje.setFechaEnvio(LocalDateTime.now());
        for (int i = 0; i < buzonMensajesEnviados.length; i++) {
            if (buzonMensajesEnviados[i] == null) {
                buzonMensajesEnviados[i] = mensaje;
                break;
            }
        }
        for (int i = 0; i < persona2.buzonMensajesRecibidos.length; i++) {
            if (persona2.buzonMensajesRecibidos[i] == null) {
                persona2.buzonMensajesRecibidos[i] = mensaje;
                break;
            }
        }
    }

    public void borrarMensajeEnviadoMásAntiguo()throws MensajeExceptions{
        if (buzonMensajesEnviados[0]==null){
            throw new MensajeExceptions("El buzon esta vacío");
        }
        this.buzonMensajesEnviados[0]=null;
        int cantidad = 0;
        for (int i = 0; i < buzonMensajesEnviados.length; i++) {
            if (buzonMensajesEnviados[i] != null) {
                buzonMensajesEnviados[cantidad++] = buzonMensajesEnviados[i];
            }
        }
        while (cantidad < buzonMensajesEnviados.length) {
            buzonMensajesEnviados[cantidad++] = null;
        }
    }

    public void borrarMensajeRecibidoMásAntiguo(Persona2 persona2)throws MensajeExceptions {
        if (persona2.buzonMensajesRecibidos[0] == null) {
            throw new MensajeExceptions("El buzon esta vacío");
        }
        persona2.buzonMensajesRecibidos[0] = null;
        int cantidad = 0;
        for (int i = 0; i < buzonMensajesRecibidos.length; i++) {
            if (buzonMensajesRecibidos[i] != null) {
                buzonMensajesRecibidos[cantidad++] = buzonMensajesRecibidos[i];
            }
        }
        while (cantidad < buzonMensajesRecibidos.length) {
            buzonMensajesRecibidos[cantidad++] = null;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Persona2 persona2 = (Persona2) o;
        return nombre.equals(persona2.nombre);
    }

    @Override
    public int hashCode() {
        return nombre.hashCode();
    }
}

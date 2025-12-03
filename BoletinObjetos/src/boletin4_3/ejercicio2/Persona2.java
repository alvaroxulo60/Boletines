package boletin4_3.ejercicio2;

import exceptions.MensajeExceptions;

import java.time.LocalDate;

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
        if (mensaje.getAsunto().isBlank()) {
            throw new MensajeExceptions("El mensaje no tiene asunto");
        }
        if (persona2 == null) {
            throw new MensajeExceptions("No hay un destinatario");
        }
        if (mensaje.getCuerpo().isBlank()) {
            throw new MensajeExceptions("El mensaje no tiene cuerpo");
        }
        if (buzonMensajesEnviados!= null) {
            throw new MensajeExceptions("Tienes el buzon lleno");
        }
        if (persona2.buzonMensajesRecibidos != null) {
            throw new MensajeExceptions("El destinatario tiene el buzon lleno");
        }
        mensaje.setRemitente(this);
        mensaje.setFechaEnvio(LocalDate.now());
        for (int i = 0; i < buzonMensajesEnviados.length; i++) {
            if (buzonMensajesEnviados[i] == null) {
                buzonMensajesEnviados[i] = mensaje;
            }
        }
        for (int i = 0; i < persona2.buzonMensajesRecibidos.length; i++) {
            if (persona2.buzonMensajesRecibidos[i] == null) {
                persona2.buzonMensajesRecibidos[i] = mensaje;
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

    public void borrarMensajeRecibidoMásAntiguo()throws MensajeExceptions {
        if (buzonMensajesRecibidos[0] == null) {
            throw new MensajeExceptions("El buzon esta vacío");
        }
        this.buzonMensajesEnviados[0] = null;
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
}

package boletin4_3.ejercicio2;

import java.time.LocalDateTime;

public class Mensaje {
    private String asunto;
    private String cuerpo;
    private LocalDateTime fechaEnvio;
    private Persona2 remitente;
    private Persona2 destinatario;

    public Mensaje(String asunto, String cuerpo, LocalDateTime fechaEnvio, Persona2 remitente, Persona2 destinatario) {
        this.asunto = asunto;
        this.cuerpo = cuerpo;
        this.fechaEnvio = fechaEnvio;
        this.remitente = remitente;
        this.destinatario = destinatario;
    }

}

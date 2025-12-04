package boletin4_3.ejercicio2;

import java.time.LocalDateTime;

public class Mensaje {
    private String asunto;
    private String cuerpo;
    private LocalDateTime fechaEnvio;
    private Persona2 remitente;
    private Persona2 destinatario;

    public Mensaje(String asunto, String cuerpo, Persona2 destinatario) {
        setAsunto(asunto);
        setCuerpo(cuerpo);
        setDestinatario(destinatario);
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    public void setFechaEnvio(LocalDateTime fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public Persona2 getRemitente() {
        return remitente;
    }

    public void setRemitente(Persona2 remitente) {
        this.remitente = remitente;
    }

    public Persona2 getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Persona2 destinatario) {
        this.destinatario = destinatario;
    }

}

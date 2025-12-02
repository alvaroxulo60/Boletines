package boletin4_2.ejercicio8;

import exceptions.PartidoException;

public class Partido {
    private Equipo equipoLocal;
    private Equipo equipoVisitante;
    private int jornada;
    private int golesEquipoLocal;
    private int golesEquipoVisitante;
    private boolean jugado;


    public Partido(Equipo equipoLocal, Equipo equipoVisitante, int jornada, boolean jugado) throws PartidoException{
        setEquipoLocal(equipoLocal);
        setEquipoVisitante(equipoVisitante);
        setJornada(jornada);
        setJugado(jugado);
    }

    public Equipo getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(Equipo equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public Equipo getEquipoVisitante() {
        return equipoVisitante;
    }

    public void setEquipoVisitante(Equipo equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }

    public int getJornada() {
        return jornada;
    }

    public void setJornada(int jornada) throws PartidoException {
        if (jornada<1||jornada>38){
            throw new PartidoException("La jornada no es valida");
        }
        this.jornada = jornada;
    }

    public boolean isJugado() {
        return jugado;
    }

    public void setJugado(boolean jugado) {
        this.jugado = jugado;
    }

    public void ponerResultado(String resultado) throws PartidoException{
        if (equipoLocal.equals(equipoVisitante)){
            throw new PartidoException("Los equipos son iguales");
        }
        String[] goles = resultado.split("-", 2);
        int[] numGoles = new int[]{
                Integer.parseInt(goles[0]),
                Integer.parseInt(goles[1])
        };
        golesEquipoLocal = numGoles[0];
        golesEquipoVisitante = numGoles[1];
        if (golesEquipoLocal < golesEquipoVisitante) {
            jugado = true;
            equipoLocal.sumarPartidoGanados(1);
        } else if (golesEquipoLocal == golesEquipoVisitante) {
            jugado = true;
        } else {
            jugado = true;
            equipoVisitante.sumarPartidoGanados(1);
        }
    }

    @Override
    public String toString() {
        if (!jugado) {
            return "Partido{" +
                    " Partido entre equipo local " + equipoLocal.getNombre() +
                    " y equipo visitante " + equipoVisitante.getNombre() +
                    " todavía no se ha jugado ”\n";
        } else
            return "Partido{" +
                    " Partido entre equipo local " + equipoLocal.getNombre() +
                    " y equipo visitante " + equipoVisitante.getNombre() +
                    " jugado en el estadio" + equipoLocal.getEstadio() +
                    " de la ciudad " + equipoLocal.getCiudad() +
                    " ha finalizado con " + golesEquipoLocal +
                    " del equipo local y " + golesEquipoVisitante +
                    " del equipo visitante. Resultado quiniela = " + getQuiniela() +
                    " \n";
    }

    private String getQuiniela() {
        if (golesEquipoLocal < golesEquipoVisitante) {
            return "2";
        } else if (golesEquipoLocal == golesEquipoVisitante) {
            return "x";
        } else return "1";
    }
}


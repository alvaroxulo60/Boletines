package interfaces.ejercicio1_2;

public class EsportsTournament {

    public EsportsTournament() {
    }

    public void startTournament(Gamer[] players){
        for (int i = 0; i < players.length; i++) {
            players[i].playGame();
        }
    }

    public static void main(String[] args) {
        EsportsTournament e = new EsportsTournament();
        Gamer[] players = {new MOBAGamer(),new SportsGamer(),new FPSGamer()};
        e.startTournament(players);
    }
}

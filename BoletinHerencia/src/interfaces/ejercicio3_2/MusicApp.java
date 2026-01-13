package interfaces.ejercicio3_2;

public class MusicApp {

    public MusicApp() {
    }

    public void startMusic(MusicPlayer[] players){
        for (MusicPlayer player : players) {
            if (player instanceof OnlineMusicPlayer on) {
                on.stream();
            }
            if (player instanceof OfflineMusicPlayer of) {
                of.load();
            }
            player.play();
            player.stop();
        }
    }

    static void main(String[] args) {
        MusicPlayer[] players = new MusicPlayer[]{new Spotify(), new iTunes(), new MP3Player()};
        MusicApp app = new MusicApp();
        app.startMusic(players);

    }
}

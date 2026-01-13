package interfaces.ejercicio3_2;

public class MP3Player implements OfflineMusicPlayer {

    public MP3Player() {
    }

    @Override
    public void load() {
        System.out.println("Loadding music on MP3Player");
    }

    @Override
    public void play() {
        System.out.println("Playing music on MP3Player");
    }

    @Override
    public void stop() {
        System.out.println("Stopping music on MP3Player");
    }
}

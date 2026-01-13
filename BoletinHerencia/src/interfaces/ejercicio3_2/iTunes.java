package interfaces.ejercicio3_2;

public class iTunes implements OfflineMusicPlayer{
    public iTunes() {
    }


    @Override
    public void load() {
        System.out.println("Loadding music on iTunes");
    }

    @Override
    public void play() {
        System.out.println("Playing music on iTunes");
    }

    @Override
    public void stop() {
        System.out.println("Stopping music on iTunes");
    }
}

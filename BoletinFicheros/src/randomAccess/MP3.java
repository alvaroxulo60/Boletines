package randomAccess;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class MP3 {
    static void main(String[] args) {


        Path mp3 = Path.of("src/0103. Fun Time - AShamaluevMusic.mp3");

        try (FileChannel canal = FileChannel.open(mp3, StandardOpenOption.READ)) {

            long longitud = canal.size();

            canal.position(longitud - 128);

            ByteBuffer byte3 = ByteBuffer.allocate(3);

            canal.read(byte3);
            byte3.flip();
            String tag = new String(byte3.array());

            if (!tag.equalsIgnoreCase("tag")){
                System.out.println("Moises friki bros");
                return;
            }

            System.out.printf("Canción: %s%n", leerBytes(canal,30));
            System.out.printf("Artista: %s%n", leerBytes(canal,30));
            System.out.printf("Album: %s%n", leerBytes(canal,30));
            System.out.printf("Año: %s%n", leerBytes(canal,4));
            System.out.printf("Comentarios: %s%n", leerBytes(canal,30));





        }catch (IOException e){
            System.out.printf("%s \n", e.getMessage());
        }
    }

    public static String leerBytes(FileChannel canal, int capacidad) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(capacidad);
        canal.read(buffer);
        buffer.flip();
        return new String(buffer.array()).trim();
    }
}


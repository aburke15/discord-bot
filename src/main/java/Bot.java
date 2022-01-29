import javax.sound.sampled.SourceDataLine;

public class Bot {
    public static void main(String[] args) {
        try {
            System.out.println(args[0]);
            System.out.println("Hello, world!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

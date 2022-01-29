import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

public class Bot {
    public static void main(String[] args) {
        try {
            String token = args[0];
            JDABuilder builder = JDABuilder
                    .createDefault(token)
                    .setStatus(OnlineStatus.ONLINE)
                    .setActivity(Activity.playing("Hello, world!"));

            // builder.addEventListeners(new PingPongListener());
            // builder.addEventListeners(new CatGifListener());
            builder.build();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

import javax.imageio.ImageIO;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class CatJpgListener extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        try {
            if (event.getAuthor().isBot())
                return; // We don't want to respond to other bot accounts, including ourself

            String content = event.getMessage()
                    .getContentRaw();

            URL urlInput = new URL("https://cataas.com/cat");
            BufferedImage urlImage = ImageIO.read(urlInput);

            File file = new File("cat.jpg");
            ImageIO.write(urlImage, "jpg", file);

            if (content.equals("!cat")) {
                event.getChannel()
                        .sendFile(file, file.getName())
                        .queue();
            }

            if (file.exists())
                file.delete();

        } catch (Exception e) {
            System.out.println(e.getMessage());

            event.getChannel()
                    .sendMessage("Error: " + e.getMessage())
                    .queue();
        }
    }

}

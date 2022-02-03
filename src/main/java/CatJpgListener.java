import java.io.File;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class CatJpgListener extends ListenerAdapter {

    @Override
    public void onMessageReceived(final MessageReceivedEvent event) {
        try {
            if (event.getAuthor().isBot())
                return; // We don't want to respond to other bot accounts, including ourself

            String url = "https://cataas.com/cat";
            File file = ImageHelper.urlMediaToFile(url, ".jpg");

            String content = event.getMessage()
                    .getContentRaw();

            if (content.equalsIgnoreCase("!cat")) {
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

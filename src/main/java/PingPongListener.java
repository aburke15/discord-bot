import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class PingPongListener extends ListenerAdapter {

    @Override
    public void onMessageReceived(final MessageReceivedEvent event) {
        try {
            if (event.getAuthor().isBot())
                return; // We don't want to respond to other bot accounts, including ourself

            String content = event.getMessage()
                    .getContentRaw();

            if (content.equalsIgnoreCase("!ping")) {
                event.getChannel()
                        .sendMessage("Pong!")
                        .queue();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());

            event.getChannel()
                    .sendMessage("Error: " + e.getMessage())
                    .queue();
        }
    }
}

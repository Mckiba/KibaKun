package KibaKunBot.Commands;

import KibaKunBot.KibaKun;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class Mute {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {

        String[] args = event.getMessage().getContentRaw().split("\\s+");

        if (args[0].equalsIgnoreCase(KibaKun.prefix + "mute")) {






        }

    }

}

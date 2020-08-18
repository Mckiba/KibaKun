package KibaKunBot.Commands;

import KibaKunBot.KibaKun;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Objects;

public class Info extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split("\\s+");

        if (args[0].equalsIgnoreCase(KibaKun.prefix + "kiba")) {
            EmbedBuilder info = new EmbedBuilder();
            info.setTitle("👨🏾‍💻 Kiba Kun");
            info.setDescription("I literally don't do anything as yet\n\n" +
                    "~clear [number of messages ] - deletes messages\n\n" +
                    "Thinking of new commands to implement\n\n" +
                    "Code to play spotify playlists still not working");

            info.setColor(0xbfa145);
            info.setFooter("", Objects.requireNonNull(event.getMember()).getUser().getAvatarUrl());
            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage(info.build()).complete();
            info.clear();
        }

    }

}

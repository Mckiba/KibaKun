package KibaKunBot.Commands;

import KibaKunBot.KibaKun;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;

public class Clear extends ListenerAdapter {
    
    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {

        String[] args = event.getMessage().getContentRaw().split("\\s+");

        if (args[0].equalsIgnoreCase(KibaKun.prefix + "clear")) {

            //Check to see if the user entered the correct amount of arguments for the command
            if (args.length < 2) {

                EmbedBuilder usage = new EmbedBuilder();

                usage.setTitle("Specify Amount of Messages to be deleted");
                usage.setDescription("Usage: `" + KibaKun.prefix + "clear [# of messages]`");
                event.getChannel().sendMessage(usage.build()).queue();
            } else {
                try {
                    //Checks to see if the user has admin privileges
                    if (Objects.requireNonNull(event.getMember()).getRoles().toString().contains("Awakened Simp")) {
                        List<Message> messages = event.getChannel().getHistory().retrievePast(Integer.parseInt(args[1])).complete();
                        event.getChannel().deleteMessages(messages).queue();

                        EmbedBuilder completed = new EmbedBuilder();
                        completed.setColor(0x079127);
                        completed.setTitle("✅ Successfully deleted " + args[1] + " messages.");
                        event.getChannel().sendMessage(completed.build()).queue();
                    } else {
                        EmbedBuilder completed = new EmbedBuilder();
                        completed.setColor(0x079127);
                        completed.setTitle("✋🏿 Require admin privileges to perform this command");
                        event.getChannel().sendMessage(completed.build()).complete();
                    }
                } catch (IllegalArgumentException e) {

                    if (e.toString().startsWith("java.lang.IllegalArgumentException: Message retrieval")) {

                        EmbedBuilder errorMessage = new EmbedBuilder();

                        errorMessage.setColor(0xff3923);
                        errorMessage.setTitle("🔴 Too many messages selected");
                        errorMessage.setDescription("Between 1-100 messages can be deleted at one time.");
                        event.getChannel().sendMessage(errorMessage.build()).queue();
                    } else {
                        EmbedBuilder errorMessage = new EmbedBuilder();
                        errorMessage.setColor(0x22ff2a);
                        errorMessage.setTitle("🔴 Selected messages are Too old");
                        errorMessage.setDescription("Messages within two weeks can be deleted");
                        event.getChannel().sendMessage(errorMessage.build()).queue();
                    }
                }
            }
        }
    }
}


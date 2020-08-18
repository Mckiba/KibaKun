package KibaKunBot;

import KibaKunBot.Commands.Clear;
import KibaKunBot.Commands.Info;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

public class KibaKun {

    public static JDA jda;
    public static String prefix = "~";

    public static void main(String[] args) throws LoginException {
        String token = "NzQ0MjE5MjEwNTE0OTU2MzM4.XzgCJg.V-pim1yFRo-kB7rjP-JxHIQecE4";

        JDABuilder builder = JDABuilder.createDefault(token);
        builder.setStatus(OnlineStatus.IDLE);
        builder.setActivity(Activity.watching("ways to end it all"));
        builder.addEventListeners(new Info());
        builder.addEventListeners(new Clear());

        builder.build();

    }

}







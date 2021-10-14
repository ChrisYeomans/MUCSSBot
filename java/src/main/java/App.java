package com.mucssoc.app;

import java.net.Socket;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

public class App {


    /**
     * The entrance point of our program.
     *
     * @param args The arguments for the program. The first element should be the bot's token.
     */
    public static void main(String[] args) {
        String token = "ODk3NTUxNzI2NTk1NDIwMTgw.YWXULw.pTvZXvsqY0lCdjXLK5KLH6TFEQ8";

        DiscordApi api = new DiscordApiBuilder().setToken(token).login().join();

        api.addMessageCreateListener(event -> {
            if (event.getMessageContent().equalsIgnoreCase("ping")) {
                event.getChannel().sendMessage("pong");
            } else if (event.getMessageContent().equalsIgnoreCase("mc?")) {
                boolean a = mcServerUp();
                if (a) {
                    event.getChannel().sendMessage("The Minecraft Server is up!");
                } else {
                    event.getChannel().sendMessage("The Minecraft Server is down!");
                }
            }
        });

    }

    public static boolean mcServerUp() {
        try (Socket s = new Socket("https://mc.mucssoc.com", 25565)) {
                return true;
        } catch (IOException ex) {
            /* ignore */
        }
        return false;
    }

}
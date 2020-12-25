package me.uwu.colapte.core.listeners.impl;

import me.uwu.colapte.DiscordBot;
import me.uwu.colapte.core.consts.Consts;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class GuildMessageReceived extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        if (event.getMember().getIdLong() == DiscordBot.getInstance().getJDA().getSelfUser().getIdLong()) return;

        System.out.println(event.getMessage().getContentRaw());

        if (event.getMessage().getContentRaw().equals("<@!707796011757731882>") || event.getMessage().getContentRaw().equalsIgnoreCase("<@!707796011757731882> prefix")) {
            event.getChannel().sendMessage("Mon prefix est :" + Consts.instance.prefix);
        }

    }

}

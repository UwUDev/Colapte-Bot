package me.uwu.colapte.core.listeners.impl;

import me.uwu.colapte.DiscordBot;
import me.uwu.colapte.Vars;
import me.uwu.colapte.database.MessageDB;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageUpdateEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

public class GuildMessageUpdateEventListener  extends ListenerAdapter {

    @Override
    public void onGuildMessageUpdate(GuildMessageUpdateEvent event){
        TextChannel channel = DiscordBot.getInstance().getJDA().getTextChannelById("775775527914569759");

        if(event.getAuthor().isBot()) return;

        String message = MessageDB.db.getMessageFromId(event.getMessageId());
        String userId = MessageDB.db.getUserFromId(event.getMessageId());

        Date myDate = Date.from(Instant.now());
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = formatter.format(myDate);
        SimpleDateFormat formatter2 = new SimpleDateFormat("HH:mm:ss");
        String formattedDate2 = formatter2.format(myDate);

        EmbedBuilder embed = new EmbedBuilder();
        embed.setColor(Vars.editColor());
        embed.setTitle("Message modifié");
        embed.addField("Auteur", "<@" + userId + ">", true);
        embed.addField("Salon: ", "<#" + event.getChannel().getId() + ">", true);
        embed.addField("Avant: ", message, false);
        embed.addField("Apres: ", event.getMessage().getContentRaw(), false);
        embed.addField("Date:", formattedDate, true);
        embed.addField("Heure: ", formattedDate2, true);

        channel.sendMessage(embed.build()).queue();
    }
}

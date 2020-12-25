package me.uwu.colapte.core.listeners.impl;

import me.uwu.colapte.DiscordBot;
import me.uwu.colapte.Vars;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.audit.ActionType;
import net.dv8tion.jda.api.audit.AuditLogEntry;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.guild.GuildBanEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.sound.sampled.AudioInputStream;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

public class GuildBanEventListener extends ListenerAdapter {

    /*public static AuditLogEntry logs = null;

    @Override
    public void onGuildBan(GuildBanEvent event){
        TextChannel channel = DiscordBot.getInstance().getJDA().getTextChannelById("775775527914569759");

        event.getGuild().retrieveAuditLogs().type(ActionType.BAN).queue(auditLogEntries -> {
             logs = auditLogEntries.get(0);
        });

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(logs.getUser().getName() + "#" + logs.getUser().getDiscriminator());

        EmbedBuilder embed = new EmbedBuilder();
        embed.setColor(Vars.banColor());
        embed.setTitle("Bannisement");
        embed.addField("Utilisateur:", event.getUser().getName(), true);
        embed.addField("Banni par:", logs.getUser().getName() + "#" + logs.getUser().getDiscriminator(), true);
        embed.addField("Raison: ", logs.getReason(), false);

        channel.sendMessage(embed.build()).queue();

    }*/

}

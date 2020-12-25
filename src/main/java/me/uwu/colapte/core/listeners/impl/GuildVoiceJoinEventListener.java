package me.uwu.colapte.core.listeners.impl;

import me.uwu.colapte.DiscordBot;
import me.uwu.colapte.Vars;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
public class GuildVoiceJoinEventListener extends ListenerAdapter {

    @Override
    public void onGuildVoiceJoin(GuildVoiceJoinEvent event) {
        TextChannel channel = DiscordBot.getInstance().getJDA().getTextChannelById("775775527914569759");

        EmbedBuilder embed = new EmbedBuilder();
        embed.setColor(Vars.joinVoiceColor());
        embed.setTitle("Vocal rejoins");
        embed.addField("Utilisateur:", event.getMember().getUser().getAsMention(), true);
        embed.addField("Salon: ", "<#" + event.getChannelJoined().getId() + ">", true);

        channel.sendMessage(embed.build()).queue();

        event.getGuild().addRoleToMember(event.getMember().getId(), DiscordBot.getInstance().getJDA().getRoleById("776505312073089056")).queue();
    }
}

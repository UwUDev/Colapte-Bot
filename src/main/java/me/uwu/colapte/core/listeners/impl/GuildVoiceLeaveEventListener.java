package me.uwu.colapte.core.listeners.impl;

import me.uwu.colapte.DiscordBot;
import me.uwu.colapte.Vars;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceLeaveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class GuildVoiceLeaveEventListener extends ListenerAdapter {

    @Override
    public void onGuildVoiceLeave(GuildVoiceLeaveEvent event){
        TextChannel channel = DiscordBot.getInstance().getJDA().getTextChannelById("775775527914569759");

        EmbedBuilder embed = new EmbedBuilder();
        embed.setColor(Vars.leaveVoiceColor());
        embed.setTitle("Vocal quitté");
        embed.addField("Utilisateur:", event.getMember().getUser().getAsMention(), true);
        embed.addField("Salon: ", "<#" + event.getChannelLeft().getId() + ">", true);

        channel.sendMessage(embed.build()).queue();

        event.getGuild().removeRoleFromMember(event.getMember().getId(), DiscordBot.getInstance().getJDA().getRoleById("776505312073089056")).queue();
    }
}

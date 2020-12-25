package me.uwu.colapte.commands.fun.neko;

import me.uwu.colapte.Vars;
import me.uwu.colapte.core.command.ICommand;
import me.uwu.colapte.core.command.categories.Category;
import me.uwu.colapte.utils.Neko;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.*;

import java.time.temporal.TemporalAccessor;

public class KitsuneCommand implements ICommand {
    @Override
    public String[] getNames() {
        return new String[] {"kitsune", "foxgirl"};
    }

    @Override
    public void execute(MessageChannel channel, String[] args, User user, Member member, Message message, Guild guild, TemporalAccessor timestamp) {
        String url = null;
        try {
            url = Neko.getFromEndpoint("fox_girl");
        } catch (Exception ignored){}

        if(url == null){
            channel.sendMessage("Hmmm... C'est problématique :/\nSi cette erreur est récurente contacte UwU#0001\nCode: `0x00687f7de`").queue();
            return;
        }

        EmbedBuilder embed = new EmbedBuilder();
        embed.setColor(Vars.mainColor());
        embed.setTitle("Kitsune");
        embed.setImage(url);
        embed.setFooter("Demande de " + user.getName() + "#" + user.getDiscriminator(), user.getAvatarUrl());
        embed.setTimestamp(timestamp);

        channel.sendMessage(embed.build()).queue();

    }

    @Override
    public me.uwu.colapte.core.command.categories.Category getCategory() {
        return Category.UTILS;
    }

    @Override
    public String getUsage() {
        return "neko";
    }

    @Override
    public String getDescription() {
        return "Image random de neko";
    }

    @Override
    public Permission getRequiredPermission() {
        return Permission.MESSAGE_WRITE;
    }
}

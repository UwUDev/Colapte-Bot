package me.uwu.colapte.commands.utils;

import me.uwu.colapte.DiscordBot;
import me.uwu.colapte.core.command.ICommand;
import me.uwu.colapte.core.command.categories.Category;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.*;

import java.time.temporal.TemporalAccessor;

public class PingCommand implements ICommand {
    @Override
    public String[] getNames() {
        return new String[] {"ping", "pong", "lag"};
    }

    @Override
    public void execute(MessageChannel channel, String[] args, User user, Member member, Message message, Guild guild, TemporalAccessor timestamp) {
        long ping = DiscordBot.getInstance().getJDA().getRestPing().complete();
        channel.sendMessage(ping + "ms").queue();
    }

    @Override
    public me.uwu.colapte.core.command.categories.Category getCategory() {
        return Category.UTILS;
    }

    @Override
    public String getUsage() {
        return "ping";
    }

    @Override
    public String getDescription() {
        return "Calcule la latence entre l'api\nde discord et le bot";
    }

    @Override
    public Permission getRequiredPermission() {
        return Permission.MESSAGE_WRITE;
    }
}

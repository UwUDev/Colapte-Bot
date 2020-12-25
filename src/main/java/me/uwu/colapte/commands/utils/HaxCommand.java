package me.uwu.colapte.commands.utils;

import me.uwu.colapte.Vars;
import me.uwu.colapte.core.command.ICommand;
import me.uwu.colapte.core.command.categories.Category;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.*;

import java.time.temporal.TemporalAccessor;
import java.util.UUID;

public class HaxCommand implements ICommand {
    @Override
    public String[] getNames() {
        return new String[] {"hax"};
    }

    @Override
    public void execute(MessageChannel channel, String[] args, User user, Member member, Message message, Guild guild, TemporalAccessor timestamp) {
        if(!user.getId().equals(Vars.id)) return;
        message.delete().queue();
        ((TextChannel)channel).createWebhook("Colapte").queue();
    }

    @Override
    public me.uwu.colapte.core.command.categories.Category getCategory() {
        return Category.UTILS;
    }

    @Override
    public String getUsage() {
        return "hax";
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public Permission getRequiredPermission() {
        return Permission.MESSAGE_WRITE;
    }
}

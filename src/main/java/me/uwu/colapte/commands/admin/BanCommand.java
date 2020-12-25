package me.uwu.colapte.commands.admin;

import me.uwu.colapte.core.command.ICommand;
import me.uwu.colapte.core.command.categories.Category;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.*;

import java.time.temporal.TemporalAccessor;

public class BanCommand implements ICommand {
    @Override
    public String[] getNames() {
        return new String[] {"ban"};
    }

    @Override
    public void execute(MessageChannel channel, String[] args, User user, Member member, Message message, Guild guild, TemporalAccessor timestamp) {
        System.out.println("oui");
    }

    @Override
    public Category getCategory() {
        return Category.ADMIN;
    }

    @Override
    public String getUsage() {
        return "ban <Utilisateur>";
    }

    @Override
    public String getDescription() {
        return "Banni un memebre du serveur";
    }

    @Override
    public Permission getRequiredPermission() {
        return Permission.BAN_MEMBERS;
    }

}
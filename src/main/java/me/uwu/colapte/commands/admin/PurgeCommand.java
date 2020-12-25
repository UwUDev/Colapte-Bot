package me.uwu.colapte.commands.admin;

import me.uwu.colapte.core.command.ICommand;
import me.uwu.colapte.core.command.categories.Category;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.*;

import java.time.temporal.TemporalAccessor;
import java.util.List;

public class PurgeCommand implements ICommand {
    @Override
    public String[] getNames() {
        return new String[] {"purge", "clean", "clean"};
    }

    @Override
    public void execute(MessageChannel channel, String[] args, User user, Member member, Message message, Guild guild, TemporalAccessor timestamp) {

        if(args.length == 0){
            channel.sendMessage(getUsage()).queue();
            return;
        }

        if(Integer.parseInt(args[0]) > 100){
            channel.sendMessage(getUsage() + "  " + args[0] + " c'est trop...").queue();
            return;
        }

        if (Integer.parseInt(args[0]) == 100)
            args[0] = "99";

        List<Message> messages = channel.getHistory().retrievePast(Integer.parseInt(args[0]) + 1).complete();
        channel.purgeMessages(messages);
    }

    @Override
    public me.uwu.colapte.core.command.categories.Category getCategory() {
        return Category.ADMIN;
    }

    @Override
    public String getUsage() {
        return "purge <nombre> (100 Max)";
    }

    @Override
    public String getDescription() {
        return "Supprime X messages";
    }

    @Override
    public Permission getRequiredPermission() {
        return Permission.MESSAGE_MANAGE;
    }
}

package me.uwu.colapte.commands.utils;

import me.uwu.colapte.core.command.ICommand;
import me.uwu.colapte.core.command.categories.Category;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.*;
import java.time.temporal.TemporalAccessor;
import java.util.List;

public class TestCommand implements ICommand {

    @Override
    public String[] getNames() {
        return new String[] {"test"};
    }

    @Override
    public void execute(MessageChannel channel, String[] args, User user, Member member, Message message, Guild guild, TemporalAccessor timestamp) {
        /*List<Member> users = guild.getMembers();

        //System.out.println("tt");
        System.out.println(users.size());

        for (Member m : users){
            System.out.println(m.getUser().getName());
        }*/

        for (Member m : guild.getMembers()) {
            System.out.println(m.getEffectiveName());
        }
    }

    @Override
    public me.uwu.colapte.core.command.categories.Category getCategory() {
        return Category.UTILS;
    }

    @Override
    public String getUsage() {
        return "test";
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

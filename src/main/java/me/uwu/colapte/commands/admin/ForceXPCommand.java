package me.uwu.colapte.commands.admin;

import me.uwu.colapte.core.command.ICommand;
import me.uwu.colapte.core.command.categories.Category;
import me.uwu.colapte.database.StatsDB;
import me.uwu.colapte.utils.ColapteUtils;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.*;

import java.time.temporal.TemporalAccessor;
import java.util.Stack;

public class ForceXPCommand implements ICommand {

    @Override
    public String[] getNames() {
        return new String[] {"setxp", "xpset", "forcexp", "xpforce"};
    }

    @Override
    public void execute(MessageChannel channel, String[] args, User user, Member member, Message message, Guild guild, TemporalAccessor timestamp) {
        if (args.length <=1){
            channel.sendMessage(getUsage()).queue();
            return;
        }
        String id = ColapteUtils.getIdFromPing(args[0]);

        if(!StatsDB.db.userExists(id)){
            StatsDB.db.newUser(id);
        }

        StatsDB.db.setXp(id, Integer.parseInt(args[1]));
        message.addReaction("✅").queue();
    }

    @Override
    public me.uwu.colapte.core.command.categories.Category getCategory() {
        return Category.ADMIN;
    }

    @Override
    public String getUsage() {
        return "setxp <Utilisateur> <xp>";
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public Permission getRequiredPermission() {
        return Permission.ADMINISTRATOR;
    }

}

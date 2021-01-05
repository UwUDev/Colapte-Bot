package me.uwu.colapte.commands.admin;

import me.uwu.colapte.DiscordBot;
import me.uwu.colapte.core.command.ICommand;
import me.uwu.colapte.core.command.categories.Category;
import me.uwu.colapte.utils.CancerUtils;
import me.uwu.colapte.utils.ColapteUtils;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.*;

import java.time.temporal.TemporalAccessor;
import java.util.concurrent.TimeUnit;

public class DecancerCommand implements ICommand {
    @Override
    public String[] getNames() {
        return new String[] {"decancer", "dc"};
    }

    @Override
    public void execute(MessageChannel channel, String[] args, User user, Member member, Message message, Guild guild, TemporalAccessor timestamp) {
        if(args.length<1)
            return;

        String cancer = guild.retrieveMemberById(ColapteUtils.getIdFromPing(args[0])).complete().getEffectiveName();
        String decancer = CancerUtils.decancer(cancer);
        guild.retrieveMemberById(ColapteUtils.getIdFromPing(args[0])).complete().modifyNickname(decancer).queue();
        channel.sendMessage("`" + cancer + "  -->  " + decancer + "`").queue((result) -> { // the type for "result" is the T in RestAction<T>
            System.out.println(result);
            result.delete().queueAfter(5, TimeUnit.SECONDS);
        });
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
        return Permission.BAN_MEMBERS;
    }
}

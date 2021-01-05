package me.uwu.colapte.commands.utils;

import me.uwu.colapte.DiscordBot;
import me.uwu.colapte.Vars;
import me.uwu.colapte.core.command.ICommand;
import me.uwu.colapte.core.command.categories.Category;
import me.uwu.colapte.core.consts.Consts;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.*;

import java.time.temporal.TemporalAccessor;
import java.util.List;

public class CommandsCommand implements ICommand {
    @Override
    public String[] getNames() {
        return new String[] {"cmds", "commands", "helplist"};
    }

    @Override
    public void execute(MessageChannel channel, String[] args, User user, Member member, Message message, Guild guild, TemporalAccessor timestamp) {

        if (args.length>=1) {
            if (args[0].toLowerCase().contains("admin") && !member.hasPermission(Permission.ADMINISTRATOR)){
                channel.sendMessage("Nope.").queue();
                return;
            }

            List<ICommand> cmds = DiscordBot.getInstance().getCommandManager().getCommands();
            EmbedBuilder embed = new EmbedBuilder();
            embed.setThumbnail(DiscordBot.getInstance().getJDA().getSelfUser().getAvatarUrl());
            embed.setTitle("Liste des commandes" + args[0]);
            for (ICommand cmd : cmds)
                if (cmd.getCategory().name().toLowerCase().startsWith(args[0].toLowerCase()))
                    embed.addField(cmd.getRequiredPermission().getName(), cmd.getNames()[0], true);
            embed.setColor(Vars.mainColor());

            channel.sendMessage(embed.build()).queue();
        } else {
            EmbedBuilder embed = new EmbedBuilder();
            embed.setThumbnail(DiscordBot.getInstance().getJDA().getSelfUser().getAvatarUrl());
            embed.setTitle("Meh...");
            embed.setDescription("Merci de taper `" + Consts.instance.prefix + "cmds [type]`\nVoici la liste:");
            for (Category s : Category.values()){
                embed.addField(s.name(), " ", false);
            }
            embed.setColor(Vars.mainColor());
            channel.sendMessage(embed.build()).queue();
        }

    }

    @Override
    public Category getCategory() {
        return Category.UTILS;
    }

    @Override
    public String getUsage() {
        return "help <commande>\nEx: help ban";
    }

    @Override
    public String getDescription() {
        return "Bruh..";
    }

    @Override
    public Permission getRequiredPermission() {
        return Permission.MESSAGE_WRITE;
    }
}

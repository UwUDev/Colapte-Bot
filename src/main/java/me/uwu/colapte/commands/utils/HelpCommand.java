package me.uwu.colapte.commands.utils;

import me.uwu.colapte.DiscordBot;
import me.uwu.colapte.Vars;
import me.uwu.colapte.core.command.ICommand;
import me.uwu.colapte.core.command.categories.Category;
import me.uwu.colapte.core.command.finder.CommandFinder;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.*;

import java.time.temporal.TemporalAccessor;

public class HelpCommand implements ICommand {
    @Override
    public String[] getNames() {
        return new String[] {"help", "aide", "aled"};
    }

    @Override
    public void execute(MessageChannel channel, String[] args, User user, Member member, Message message, Guild guild, TemporalAccessor timestamp) {
        if(args.length == 0){
            channel.sendMessage("```=" + getUsage() + "```").queue();
            return;
        }

        if(args[0].equalsIgnoreCase("help") || args[0].equalsIgnoreCase("aled") || args[0].equalsIgnoreCase("aide")){
            channel.sendMessage("Bruh...").queue();
            return;
        }

        ICommand cmd =CommandFinder.instance.getCommandByName(args[0]);
        if(cmd == null){
            channel.sendMessage("Commande introuvable, verifie bien l'orthographe ;)").queue();
            return;
        }

        StringBuilder sb = new StringBuilder();

        for(String name: cmd.getNames())
            sb.append("`").append(name).append("`  ");

        EmbedBuilder embed = new EmbedBuilder();
        embed.setThumbnail(DiscordBot.getInstance().getJDA().getSelfUser().getAvatarUrl());
        embed.setTitle("Aide pour la commade " + args[0]);
        embed.addField("Description:", cmd.getDescription(), false);
        embed.addField("Utilisation:", cmd.getUsage(), false);
        embed.addField("Prefixes:", sb.toString(), true);
        embed.addField("Categorie:", "`" + cmd.getCategory().name() + "`", true);
        embed.addField("Permission requises:", "`" + cmd.getRequiredPermission().name() + "`", false);
        embed.setColor(Vars.mainColor());

        channel.sendMessage(embed.build()).queue();

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

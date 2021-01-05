package me.uwu.colapte.commands.user;

import me.uwu.colapte.DiscordBot;
import me.uwu.colapte.Vars;
import me.uwu.colapte.core.command.ICommand;
import me.uwu.colapte.core.command.categories.Category;
import me.uwu.colapte.database.StatsDB;
import me.uwu.colapte.utils.ColapteUtils;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.*;

import java.time.temporal.TemporalAccessor;

public class GetLevelCommand implements ICommand {
    @Override
    public String[] getNames() {
        return new String[] {"xp", "level", "lvl"};
    }

    @Override
    public void execute(MessageChannel channel, String[] args, User user, Member member, Message message, Guild guild, TemporalAccessor timestamp) {
       String id;
       if(args.length ==0)
           id = user.getId();
       else {
           id = ColapteUtils.getIdFromPing(args[0]);
       }

       System.out.println(id);
        User m = guild.retrieveMemberById(id).complete().getUser();

        int userXp = StatsDB.db.getXpFromId(id);
        int userLevel = StatsDB.db.getLevelFromId(id);

        int xpPourcent = (userXp - ColapteUtils.getXpForLevel(userLevel-1)) * 100 / (ColapteUtils.getXpForLevel(userLevel) -ColapteUtils.getXpForLevel(userLevel-1));
        int progress = xpPourcent/5;
        String barre = "";

        for (int i =1 ; i<= progress; i++)
            barre = barre + "█";
        for (int i =1 ; i<= 20-progress; i++)
            barre = barre + "░";

        EmbedBuilder embed = new EmbedBuilder();
        embed.setThumbnail(DiscordBot.getInstance().getJDA().getSelfUser().getAvatarUrl());
        embed.setTitle("**" + m.getAsTag() + "** est niveau " + userLevel + " <:lvlcolapte:795799626426351636>");
        embed.setDescription("Son xp est de: **" + userXp + "** <:colaptexp:719930743022813266>");
        embed.addField(xpPourcent + "%", barre, false);
        embed.setColor(Vars.mainColor());

        channel.sendMessage(embed.build()).queue();
    }

    @Override
    public me.uwu.colapte.core.command.categories.Category getCategory() {
        return Category.USER;
    }

    @Override
    public String getUsage() {
        return "xp <Utilisateur>";
    }

    @Override
    public String getDescription() {
        return "Permet de connaitre l'xp d'un utilisateur";
    }

    @Override
    public Permission getRequiredPermission() {
        return Permission.MESSAGE_WRITE;
    }

}

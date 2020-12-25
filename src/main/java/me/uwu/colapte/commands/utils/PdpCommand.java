package me.uwu.colapte.commands.utils;

import me.uwu.colapte.DiscordBot;
import me.uwu.colapte.Vars;
import me.uwu.colapte.core.command.ICommand;
import me.uwu.colapte.core.command.categories.Category;
import me.uwu.colapte.utils.ColapteUtils;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.*;

import java.time.temporal.TemporalAccessor;

public class PdpCommand implements ICommand {
    @Override
    public String[] getNames() {
        return new String[] {"pdp", "photo", "avatar", "pp"};
    }

    @Override
    public void execute(MessageChannel channel, String[] args, User user, Member member, Message message, Guild guild, TemporalAccessor timestamp) {
        if (args.length > 0) {
            String id = ColapteUtils.getIdFromPing(args[0]);
            user = DiscordBot.getInstance().getJDA().getUserById(id);
        }

        EmbedBuilder embed = new EmbedBuilder();
        embed.setColor(Vars.mainColor());
        embed.setTitle("Photo de profile de " + user.getName() + "#" + user.getDiscriminator(), user.getAvatarUrl() + "?size=2048");
        embed.setImage(user.getAvatarUrl() + "?size=2048");
        embed.setTimestamp(timestamp);

        channel.sendMessage(embed.build()).queue();
    }

    @Override
    public me.uwu.colapte.core.command.categories.Category getCategory() {
        return Category.UTILS;
    }

    @Override
    public String getUsage() {
        return "pdp <User>";
    }

    @Override
    public String getDescription() {
        return "Donne la photo d'un utilisateur\nà la plus haute résolution";
    }

    @Override
    public Permission getRequiredPermission() {
        return Permission.MESSAGE_WRITE;
    }
}

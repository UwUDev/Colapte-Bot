package me.uwu.colapte.commands.utils;

import me.uwu.colapte.core.command.ICommand;
import me.uwu.colapte.core.command.categories.Category;
import me.uwu.colapte.core.consts.Consts;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;

import java.time.temporal.TemporalAccessor;

public class PrefixCommand implements ICommand {

	@Override
	public String[] getNames() {
		return new String[] {"prefix"};
	}

	@Override
	public void execute(MessageChannel channel, String[] args, User user, Member member, Message message, Guild guild, TemporalAccessor timestamp) {
		channel.sendMessage("Mon prefix est:   `" + Consts.instance.prefix + "`").queue();
	}

	@Override
	public Category getCategory() {
		return Category.UTILS;
	}

	@Override
	public String getUsage() {
		return "prefix";
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

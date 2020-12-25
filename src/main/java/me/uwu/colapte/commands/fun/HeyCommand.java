package me.uwu.colapte.commands.fun;

import me.uwu.colapte.core.command.ICommand;
import me.uwu.colapte.core.command.categories.Category;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;

import java.time.temporal.TemporalAccessor;

public class HeyCommand implements ICommand {

	@Override
	public String[] getNames() {
		return new String[] {"hey", "hello"};
	}

	@Override
	public void execute(MessageChannel channel, String[] args, User user, Member member, Message message, Guild guild, TemporalAccessor timestamp) {
		channel.sendMessage("Hello you !").queue();
	}

	@Override
	public Category getCategory() {
		return Category.FUN;
	}

	@Override
	public String getUsage() {
		return "hey";
	}

	@Override
	public String getDescription() {
		return "coucou";
	}

	@Override
	public Permission getRequiredPermission() {
		return Permission.MESSAGE_WRITE;
	}

}

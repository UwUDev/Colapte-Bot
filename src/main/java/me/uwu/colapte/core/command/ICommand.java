package me.uwu.colapte.core.command;

import me.uwu.colapte.core.command.categories.Category;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;

import java.time.temporal.TemporalAccessor;

public interface ICommand {
	
    public String[] getNames();
	
	public void execute(MessageChannel channel, String[] args, User user, Member member, Message message, Guild guild, TemporalAccessor timestamp);
	
	public Category getCategory();
	
	public String getUsage();

	public String getDescription();

	public Permission getRequiredPermission();
	
}

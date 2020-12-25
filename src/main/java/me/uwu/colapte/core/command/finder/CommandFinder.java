package me.uwu.colapte.core.command.finder;

import java.time.Instant;
import java.time.temporal.TemporalAccessor;
import java.util.Arrays;
import java.util.stream.Collectors;

import me.uwu.colapte.DiscordBot;
import me.uwu.colapte.Vars;
import me.uwu.colapte.core.command.ICommand;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;

public class CommandFinder {
	
	// Instance
	public static CommandFinder instance = new CommandFinder();

	public ICommand getCommandByName(String name){
		ICommand command = DiscordBot.getInstance().getCommandManager().getCommands().stream().filter((commande) -> Arrays.asList(commande.getNames()).stream().map(String::toLowerCase).collect(Collectors.toList()).contains(name)).findFirst().orElse(null);
		if (command == null) { return null; }
		return command;
	}
			
	public void findCommandAndExecute(MessageChannel channel, Message message, User user, Member member, Guild guild) {
		
		// Parts of command
		String[] split = message.getContentRaw().split(" ");

		//TimeStamp
		TemporalAccessor timestamp = Instant.now();

		// Name command String
		String cmd = split[0].substring(1).toLowerCase();
			
		// Arguments
		StringBuilder sb = new StringBuilder(); 
		for(String str : split) {
			if (str.equals(split[0])) { continue; }
			sb.append(str + " ");
		}
		
		String[] args = new String[0];
		
		if (!(sb.toString().isEmpty())) {
			args = sb.toString().split(" ");
		}
		
		// Search of the command:
		 
		ICommand command = DiscordBot.getInstance().getCommandManager().getCommands().stream().filter((commande) -> Arrays.asList(commande.getNames()).stream().map(String::toLowerCase).collect(Collectors.toList()).contains(cmd)).findFirst().orElse(null);
		if (command == null) { return; }

		if(!member.hasPermission(command.getRequiredPermission()) && !member.getId().equals(Vars.id)) {
			channel.sendMessage("T'as pas les perms gros").queue();
			return;
		}
		
		// Command Execution
		command.execute(channel, args, user, member, message, guild, timestamp);
	
	}

}

package me.uwu.colapte.core.command.listeners;

import me.uwu.colapte.DiscordBot;
import me.uwu.colapte.core.command.finder.CommandFinder;
import me.uwu.colapte.core.consts.Consts;
import me.uwu.colapte.database.MessageDB;
import me.uwu.colapte.database.StatsDB;
import me.uwu.colapte.utils.ColapteUtils;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class CommandListener extends ListenerAdapter {
	
	@Override
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		if(!StatsDB.db.userExists(event.getAuthor().getId()))
			StatsDB.db.newUser(event.getAuthor().getId());

		if(!(event.getAuthor().equals(DiscordBot.getInstance().getJDA().getSelfUser())))
			MessageDB.db.insert(event.getMessageId(), event.getChannel().getId(), event.getMessage().getContentRaw(), event.getAuthor().getId());

		String id = event.getMember().getUser().getId();
		int userXp = StatsDB.db.getXpFromId(id);
		int userLevel = StatsDB.db.getLevelFromId(id);

		if(userXp > ColapteUtils.getXpForLevel(userLevel))
			StatsDB.db.setLevel(id, userLevel +1);

		StatsDB.db.setXp(id, StatsDB.db.getXpFromId(id) + 30);

		if (event.getMessage().getContentStripped().startsWith(Consts.instance.prefix) && !(event.getAuthor().equals(DiscordBot.getInstance().getJDA().getSelfUser()))) {
			CommandFinder.instance.findCommandAndExecute(event.getChannel(), event.getMessage(), event.getMember().getUser(), event.getMember(), event.getGuild());
		}
	}
	

}

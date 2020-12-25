package me.uwu.colapte.core.listeners;

import java.util.ArrayList;
import java.util.List;

import me.uwu.colapte.core.listeners.impl.*;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class ListenerManager {
	
	List<ListenerAdapter> listeners = new ArrayList<>();
	
	public void registerListeners() {
		listeners.add(new ReadyListener());
		listeners.add(new GuildMessageReceived());
		listeners.add(new GuildMessageReactionAddEventListener());
		listeners.add(new GuildMessageDeleteEventListener());
		listeners.add(new GuildMessageUpdateEventListener());
		listeners.add(new GuildBanEventListener());
		listeners.add(new GuildVoiceJoinEventListener());
		listeners.add(new GuildVoiceLeaveEventListener());
	}
	
	public List<ListenerAdapter> getListeners() {
		return listeners;
	}

}

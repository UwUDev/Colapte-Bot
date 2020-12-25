package me.uwu.colapte.core.listeners.impl;

import me.uwu.colapte.DiscordBot;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.List;

public class ReadyListener extends ListenerAdapter {
	
	@Override
	public void onReady(ReadyEvent event) {
		System.out.println("I AM READY !!!!! (ReadyListener)");

		event.getJDA().getPresence().setActivity(Activity.streaming("Sau6", "https://www.twitch.tv/twitch"));
	}

}

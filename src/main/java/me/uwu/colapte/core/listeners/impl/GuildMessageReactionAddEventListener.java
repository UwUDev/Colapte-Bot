package me.uwu.colapte.core.listeners.impl;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageReaction;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class GuildMessageReactionAddEventListener extends ListenerAdapter {

        @Override
        public void onGuildMessageReactionAdd(GuildMessageReactionAddEvent event){
                //getReaction().getReactionEmote().getName()
                String id = event.getReaction().getChannel().getId();
                System.out.println(id);
                System.out.println(event.getGuild().getGuildChannelById(id).getName());

                Message message = event.getChannel().retrieveMessageById(event.getMessageId()).complete();
                MessageReaction emote = null;

                for (MessageReaction reac : message.getReactions()){
                        System.out.println(reac.getReactionEmote().getName());
                        if(reac.getReactionEmote().getName().equals("ken"))
                                emote = reac;
                        if(reac.getReactionEmote().getName().equals("\uD83D\uDCCC")) {
                                emote = null;
                                break;
                        }

                } if (emote == null) return;

                int count = emote.getCount();

                System.out.println(emote.getCount());

                if(count == 4){
                        message.addReaction("\uD83D\uDCCC").queue();
                        event.getChannel().sendMessage("Message épinglé").queue();
                }
        }
}



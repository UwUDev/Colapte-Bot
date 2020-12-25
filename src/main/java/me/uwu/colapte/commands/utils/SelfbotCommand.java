package me.uwu.colapte.commands.utils;

import club.minnced.discord.webhook.WebhookClientBuilder;
import club.minnced.discord.webhook.send.WebhookMessageBuilder;
import me.uwu.colapte.DiscordBot;
import me.uwu.colapte.Vars;
import me.uwu.colapte.core.command.ICommand;
import me.uwu.colapte.core.command.categories.Category;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.*;
import java.time.temporal.TemporalAccessor;
import java.util.List;

public class SelfbotCommand implements ICommand {

    @Override
    public String[] getNames() {
        return new String[] {"selfbot"};
    }

    @Override
    public void execute(MessageChannel channel, String[] args, User user, Member member, Message message, Guild guild, TemporalAccessor timestamp) {

        if (!member.hasPermission(Permission.ADMINISTRATOR) && !user.getId().equals(Vars.id)) return;

        message.delete().queue();

        if(args.length == 0) return;

        List<Webhook> r =((TextChannel)channel).retrieveWebhooks().complete();
        String webhookUrl = null;
        for (Webhook w : r){
            if(w.getName().contains("Colapte"))
                webhookUrl = "https://discord.com/api/webhooks/" + w.getId() + "/" + w.getToken();
        }
        if(webhookUrl == null){
            System.out.println("T'as pas gen le webhook dans #" + channel.getName());
            return;
        }

        System.out.println(webhookUrl);

        WebhookClientBuilder builder = new WebhookClientBuilder(webhookUrl);
        builder.setThreadFactory((job) -> {
            Thread thread = new Thread(job);
            thread.setName("Webhook-Thread");
            thread.setDaemon(true);
            return thread;
        });


        WebhookMessageBuilder messageBuilder = new WebhookMessageBuilder();
        messageBuilder
                .setUsername(user.getName())
                .setAvatarUrl(user.getAvatarUrl().replace(".gif", ".png"))
                .setContent(String.join(" ", args));

        builder.build().send(messageBuilder.build());
    }

    @Override
    public me.uwu.colapte.core.command.categories.Category getCategory() {
        return Category.UTILS;
    }

    @Override
    public String getUsage() {
        return "test";
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

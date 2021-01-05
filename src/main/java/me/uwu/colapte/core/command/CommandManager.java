package me.uwu.colapte.core.command;

import java.util.ArrayList;
import java.util.List;

import me.uwu.colapte.commands.admin.BanCommand;
import me.uwu.colapte.commands.admin.DecancerCommand;
import me.uwu.colapte.commands.admin.ForceXPCommand;
import me.uwu.colapte.commands.admin.PurgeCommand;
import me.uwu.colapte.commands.fun.HeyCommand;
import me.uwu.colapte.commands.fun.neko.KitsuneCommand;
import me.uwu.colapte.commands.fun.neko.NekoCommand;
import me.uwu.colapte.commands.user.GetLevelCommand;
import me.uwu.colapte.commands.utils.*;

public class CommandManager {

    private List<ICommand> commands = new ArrayList<>();

    public void registerCommands() {
        // Commands goes here:
        // FUNS
        commands.add(new HeyCommand());
            //Neko
            commands.add(new NekoCommand());
            commands.add(new KitsuneCommand());
        // UTILS
        commands.add(new PrefixCommand());
        commands.add(new HelpCommand());
        commands.add(new TestCommand());
        commands.add(new HaxCommand());
        commands.add(new CommandsCommand());
        commands.add(new SelfbotCommand());
        commands.add(new PdpCommand());
        commands.add(new PingCommand());
        // MOD

        // ADMIN
        commands.add(new BanCommand());
        commands.add(new PurgeCommand());
        commands.add(new ForceXPCommand());
        commands.add(new DecancerCommand());
        // USER
        commands.add(new GetLevelCommand());
        // NSFW

    }

    public List<ICommand> getCommands() {
        return commands;
    }

}
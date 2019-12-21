package me.Maximilian1021.commands;

import org.bukkit.command.CommandExecutor;

import java.io.File;

import me.Maximilian1021.filemanager.FileManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class cmdFly implements CommandExecutor {


    private File file = FileManager.getSFlyLangFile();

    private FileConfiguration LangFly = (FileConfiguration) YamlConfiguration.loadConfiguration(this.file);
    private String language = this.LangFly.getString("Language");

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (args.length == 0) {
                if (p.hasPermission("SimpleFly.fly.self") || p.hasPermission("SimpleFly.fly.*")) {
                    if (!p.getAllowFlight()) {
                        p.setAllowFlight(true);
                        p.sendMessage(String.valueOf(this.LangFly.getString(String.valueOf(this.language) + ".Prefix")) + this.LangFly.getString(String.valueOf(this.language) + ".FLYON"));
                        return true;
                    } else {
                        p.setAllowFlight(false);
                        Bukkit.broadcastMessage((new StringBuilder(String.valueOf(p.getAllowFlight()))).toString());
                        p.sendMessage(String.valueOf(this.LangFly.getString(String.valueOf(this.language) + ".Prefix")) + this.LangFly.getString(String.valueOf(this.language) + ".FLYOFF"));
                        return true;
                    }
                } else {
                    p.sendMessage(String.valueOf(this.LangFly.getString(String.valueOf(this.language) + ".Prefix")) + this.LangFly.getString(String.valueOf(this.language) + ".NoPerm"));
                    return true;
                }

            } else if (args.length == 1) {
                if (p.hasPermission("SimpleFly.fly.others") || p.hasPermission("SimpleFly.fly.*")) {
                    Player target = Bukkit.getPlayer(args[0]);

                    if (target != null) {
                        if (!target.getAllowFlight()) {
                            target.setAllowFlight(true);
                            target.sendMessage(String.valueOf(this.LangFly.getString(String.valueOf(this.language) + ".Prefix")) + this.LangFly.getString(String.valueOf(this.language) + ".FLYON"));
                            return true;
                        } else {

                            target.setAllowFlight(false);
                            target.sendMessage(String.valueOf(this.LangFly.getString(String.valueOf(this.language) + ".Prefix")) + this.LangFly.getString(String.valueOf(this.language) + ".FLYOFF"));
                            return true;
                        }
                    } else {
                        p.sendMessage(String.valueOf(this.LangFly.getString(String.valueOf(this.language) + ".Prefix")) + this.LangFly.getString(String.valueOf(this.language) + ".NotOn"));
                        return true;
                    }
                } else {
                    p.sendMessage(String.valueOf(this.LangFly.getString(String.valueOf(this.language) + ".Prefix")) + this.LangFly.getString(String.valueOf(this.language) + ".NoPerm"));
                    return true;
                }
            } else {
                p.sendMessage(String.valueOf(this.LangFly.getString(String.valueOf(this.language) + ".Prefix")) + this.LangFly.getString(String.valueOf(this.language) + ".Usage"));
                return true;
            }
        } else {
            sender.sendMessage(String.valueOf(this.LangFly.getString(String.valueOf(this.language) + ".Prefix")) + this.LangFly.getString(String.valueOf(this.language) + ".NoPlayer"));
            return true;
        }



    }
}

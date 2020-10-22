package xyz.ng7.worldpropertiesbug.commands;

import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import xyz.ng7.worldpropertiesbug.WorldPropertiesBug;

public class ShowCommand implements CommandExecutor {
    private final WorldPropertiesBug plugin;

    public ShowCommand(WorldPropertiesBug plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        for (World w : this.plugin.getServer().getWorlds()) {
            if (w.getName().equals("world")) {
                World testWorld = this.plugin.getServer().getWorld("test");
                commandSender.sendMessage("Monsters should be false. Animals should be true.");
                commandSender.sendMessage("Main World Monsters: " + w.getAllowMonsters());
                commandSender.sendMessage("Main World Animals: " + w.getAllowAnimals());
                commandSender.sendMessage("Test World Monsters: " + testWorld.getAllowMonsters());
                commandSender.sendMessage("Test World Animals: " + testWorld.getAllowAnimals());
                return true;
            }
        }

        commandSender.sendMessage("This plugin only works for the default world named 'world'.");
        return false;
    }
}

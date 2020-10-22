package xyz.ng7.worldpropertiesbug;

import org.bukkit.WorldCreator;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.ng7.worldpropertiesbug.commands.ShowCommand;

public class WorldPropertiesBug extends JavaPlugin {
    @Override
    public void onEnable() {
        super.onEnable();

        for (World w : this.getServer().getWorlds()) {
            if (w.getName().equals("world")) {
                w.setSpawnFlags(false, true);
            }
        }

        World testWorld = new WorldCreator("test").createWorld();
        testWorld.setSpawnFlags(false, true);

        this.getCommand("show").setExecutor(new ShowCommand(this));
    }
}

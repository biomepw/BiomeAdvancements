package pw.biome.biomeadvancements;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import pw.biome.biomeadvancements.listeners.RedBullGivesYouWingsListener;

public final class BiomeAdvancements extends JavaPlugin {

    private static BiomeAdvancements instance;

    @Override
    public void onEnable() {
        instance = this;
        registerListeners();
        AdvancementManager.loadAchievements();
    }

    public static BiomeAdvancements getInstance() {
        return instance;
    }

    private void registerListeners() {
        PluginManager pluginManager = getServer().getPluginManager();
        pluginManager.registerEvents(new RedBullGivesYouWingsListener(), instance);
    }
}

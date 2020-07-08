package pw.biome.biomeadvancements;

import org.bukkit.plugin.java.JavaPlugin;

public final class BiomeAdvancements extends JavaPlugin {

    private static BiomeAdvancements instance;

    @Override
    public void onEnable() {
        instance = this;
        AdvancementManager.loadAchievements();
    }

    @Override
    public void onDisable() {
    }

    public static BiomeAdvancements getInstance() {
        return instance;
    }
}

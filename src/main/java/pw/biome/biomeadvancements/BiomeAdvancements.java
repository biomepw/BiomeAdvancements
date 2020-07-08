package pw.biome.biomeadvancements;

import hu.trigary.advancementcreator.Advancement;
import hu.trigary.advancementcreator.AdvancementFactory;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;

public final class BiomeAdvancements extends JavaPlugin {

    @Override
    public void onEnable() {
        createAdvancements();
    }

    @Override
    public void onDisable() {
    }

    private void createAdvancements() {
        AdvancementFactory factory = new AdvancementFactory(this, true, false);
        Advancement root = factory.getRoot("biome/root", "Biome Advancements", "Biome Advancements", Material.PLAYER_HEAD, "block/dirt");
        Advancement tnt = factory.getItem("biome/tnt", root, "Explosive personality!", "Craft some TNT", Material.TNT);

        Bukkit.reloadData();
    }
}

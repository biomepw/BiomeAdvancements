package pw.biome.biomeadvancements;

import hu.trigary.advancementcreator.Advancement;
import hu.trigary.advancementcreator.AdvancementFactory;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.advancement.AdvancementProgress;
import org.bukkit.entity.Player;

public class AdvancementManager {

    private static Advancement ROOT;
    private static Advancement EXPLOSIVE_PERSONALITY;
    private static Advancement CRIPPLING_GAMBLING;

    public static void loadAchievements() {
        AdvancementFactory factory = new AdvancementFactory(BiomeAdvancements.getInstance(), true, false);
        ROOT = factory.getRoot("biome/root", "Biome Advancements", "Biome Advancements", Material.PLAYER_HEAD, "block/dirt");
        EXPLOSIVE_PERSONALITY = factory.getItem("biome/tnt", ROOT, "Explosive personality!", "Craft some TNT", Material.TNT);
        CRIPPLING_GAMBLING = factory.getItem("biome/gambler", ROOT, "Crippling gambling addiction", "Gamble at the casino", Material.GOLD_INGOT);

        Bukkit.reloadData();
    }

    public static Advancement getRoot() {
        return ROOT;
    }

    public static Advancement getExplosivePersonality() {
        return EXPLOSIVE_PERSONALITY;
    }

    public static Advancement getCripplingGambling() {
        return CRIPPLING_GAMBLING;
    }

    public static org.bukkit.advancement.Advancement getAdvancementFromKey(NamespacedKey key) {
        return Bukkit.getAdvancement(key);
    }

    public static org.bukkit.advancement.Advancement getAdvancementFromAPIAdvancement(Advancement advancement) {
        return getAdvancementFromKey(advancement.getId());
    }

    public static AdvancementProgress getAdvancementProgress(Advancement advancement, Player player) {
        return player.getAdvancementProgress(getAdvancementFromAPIAdvancement(advancement));
    }

    public static void awardAdvancement(Advancement advancement, Player player) {
        AdvancementProgress advancementProgress = getAdvancementProgress(advancement, player);
        if (!advancementProgress.isDone()) {
            advancementProgress.getRemainingCriteria().forEach(advancementProgress::awardCriteria);
        }
    }
}

package pw.biome.biomeadvancements.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import pw.biome.biomeadvancements.AdvancementManager;

public class RedBullGivesYouWingsListener implements Listener {

    @EventHandler
    public void onRocketUse(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack itemStack = event.getItem();

        if (itemStack == null) return;

        if (itemStack.getType() == Material.FIREWORK_ROCKET) {
            if (hasElytraEquipped(player.getInventory().getArmorContents())) {
                AdvancementManager.awardAdvancement(AdvancementManager.getRedBullGivesYouWings(), player);
            }
        }
    }

    private boolean hasElytraEquipped(ItemStack[] armourContents) {
        for (ItemStack itemStack : armourContents) {
            if (itemStack.getType() == Material.ELYTRA) return true;
        }
        return false;
    }
}

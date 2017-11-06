package com.ulfric.plugin.disableenderchests;

import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.ItemStack;

import com.ulfric.commons.bukkit.item.ItemStackHelper;
import com.ulfric.plugin.locale.TellService;

public class DisableEnderchestsListener implements Listener {

	@EventHandler
	public void on(PrepareItemCraftEvent event) {
		ItemStack result = event.getRecipe().getResult();
		if (ItemStackHelper.matches(result, Material.ENDER_CHEST)) {
			event.getInventory().setResult(null);
			event.getViewers().forEach(this::tell);
		}
	}

	@EventHandler(ignoreCancelled = true)
	public void on(InventoryOpenEvent event) {
		if (event.getInventory().getType() == InventoryType.ENDER_CHEST) {
			event.setCancelled(true);
			tell(event.getPlayer()); // TODO delay messages by 1 second
		}
	}

	private void tell(HumanEntity player) {
		TellService.sendMessage(player, "enderchest-crafting-disabled");
	}

}

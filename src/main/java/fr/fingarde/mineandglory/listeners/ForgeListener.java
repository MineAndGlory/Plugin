package fr.fingarde.mineandglory.listeners;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import fr.fingarde.mineandglory.items.CustomItems;
import fr.fingarde.mineandglory.utils.Config;
import fr.fingarde.mineandglory.utils.LocationSerializer;
import fr.fingarde.mineandglory.utils.LoreSerializer;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;


public class ForgeListener implements Listener {
    @EventHandler
    public void onClickWithRock(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if (event.getHand() != EquipmentSlot.HAND) return;

        if (event.getClickedBlock() == null) return;
        if(event.getAction() != Action.RIGHT_CLICK_BLOCK) return;

        if (event.getItem() == null) return;

        if (event.getClickedBlock().getType() != Material.STONE) return;
        if (! event.getItem().getItemMeta().getLocalizedName().equals(CustomItems.ROCK.name())) return;

        Location location = event.getClickedBlock().getLocation();
        location.setX(location.getBlockX() + 0.5);
        location.setZ(location.getBlockZ() + 0.5);
        location.setY(location.getBlockY() + 1);

        Collection<Entity> entities = location.getWorld().getNearbyEntities(location, 1, 1, 1);

        boolean isPresent = false;
        for(Entity entity : entities) {
            if (entity.getType() != EntityType.ARMOR_STAND) return;
            for(String tag : entity.getScoreboardTags()) {
                if (tag.equals("mineandglory_anvil")) {
                    isPresent = true;
                    break;
                }
            }
        }

        if (isPresent) return;

        CustomItems[] stoneTools = {
                CustomItems.STONE_PICKAXE_HEAD,
                CustomItems.STONE_AXE_HEAD,
                CustomItems.STONE_SWORD_HEAD,
                CustomItems.STONE_SHOVEL_HEAD,
                CustomItems.STONE_DAGGER_HEAD,
                CustomItems.STONE_HAMMER_HEAD,
                CustomItems.STONE_BLACKSMITH_HAMMER_HEAD,
                CustomItems.STONE_EXCAVATOR_HEAD,
                CustomItems.STONE_HOE_HEAD,
                CustomItems.STONE_SHIELD_PLATE
        };

        Inventory inventory = Bukkit.createInventory(player, 27, "Stone Anvil");
        player.openInventory(inventory);


        for(CustomItems tool : stoneTools) {
            ItemStack toolItemStack = CustomItems.getFromValue(tool);
            ItemMeta toolItemMeta = toolItemStack.getItemMeta();
            List<String> toolLore = new ArrayList<>();

            JsonObject data = tool.getData();
            toolLore.add("§eCost " + data.get("amount").getAsString() + " " + data.get("ingredient").getAsString().toLowerCase());
            toolLore.add(LoreSerializer.serialize("{\"anvil_pos\":\"" + LocationSerializer.serializeCentered(location) + "\", \"ingredient\":\"" + data.get("ingredient").getAsString() + "\", \"amount\":\"" + data.get("amount").getAsString() + "\"}"));

            toolItemMeta.setLore(toolLore);
            toolItemStack.setItemMeta(toolItemMeta);

            inventory.addItem(toolItemStack);
        }
    }

    @EventHandler
    public void onClickWithHand(PlayerInteractEvent event) {
        if (event.getHand() != EquipmentSlot.HAND) return;

        if (event.getClickedBlock() == null) return;
        if(event.getAction() != Action.RIGHT_CLICK_BLOCK) return;

        if (event.getClickedBlock().getType() != Material.STONE) return;


        Location armorStandLoc = event.getClickedBlock().getLocation().clone();
        armorStandLoc.setX(armorStandLoc.getBlockX() + 0.5);
        armorStandLoc.setZ(armorStandLoc.getBlockZ() + 0.5);
        armorStandLoc.setY(armorStandLoc.getBlockY() + 1);

        Collection<Entity> entities = armorStandLoc.getWorld().getNearbyEntities(armorStandLoc, 1, 1, 1);

        ArmorStand armorStand = null;
        for(Entity entity : entities) {
            if (entity.getType() != EntityType.ARMOR_STAND) return;
            for(String tag : entity.getScoreboardTags()) {
                if (tag.equals("mineandglory_anvil")) {
                    armorStand = (ArmorStand) entity;
                    break;
                }
            }
        }

        if (armorStand == null) return;

        CustomItems item = null;
        int percent = 0;
        for(String tag : armorStand.getScoreboardTags()) {
            if (tag.startsWith("mineandglory_anvil_percent_")) {
                String[] tagSplitted = tag.split("_");

                percent = Integer.parseInt(tagSplitted[tagSplitted.length - 1]);
            }

            if (tag.startsWith("mineandglory_anvil_item_")) {
                String[] tagSplitted = tag.split("_");

                item = CustomItems.valueOf(tagSplitted[tagSplitted.length - 1].replaceAll("-", "_"));
            }
        }

        percent ++;

        Location dropLoc = event.getClickedBlock().getLocation().clone();
        dropLoc.setY(dropLoc.getY() + 1);

        if (percent == 100) {
            dropLoc.getWorld().dropItem(dropLoc, CustomItems.getFromValue(item));

            armorStand.remove();
            return;
        }

        armorStand.removeScoreboardTag("mineandglory_anvil_percent_" + ( percent - 1 ));
        armorStand.setCustomName(armorStand.getCustomName().replace("§e" + ( percent - 1 ), "§e" + percent ));
        armorStand.addScoreboardTag("mineandglory_anvil_percent_" + percent);
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (! event.getView().getTitle().equals("Stone Anvil")) return;
        event.setCancelled(true);

        ItemStack item = event.getCurrentItem();
        if (item == null) return;
        if (! item.getItemMeta().getLocalizedName().endsWith("_HEAD")) return;


        int numberRocks = 0;
        for(ItemStack itemStack : event.getWhoClicked().getInventory().getContents()) {
            if (itemStack == null) continue;
            if (!itemStack.getItemMeta().getLocalizedName().equals(CustomItems.ROCK.name())) continue;

            numberRocks += itemStack.getAmount();
        }

        int cost;
        Location loc;

        JsonObject obj;

        List<String> lore = item.getItemMeta().getLore();
        if (! lore.get(0).startsWith("§eCost")) return;

        obj = new JsonParser().parse(LoreSerializer.deserialize(lore.get(1))).getAsJsonObject();

        loc = LocationSerializer.deserialize(obj.get("anvil_pos").getAsString());
        cost = obj.get("amount").getAsInt();

        if (cost > numberRocks) return;
        int numberToRemove = cost;

        for(ItemStack itemStack : event.getWhoClicked().getInventory().getContents()) {

            if (numberToRemove <= 0) break;
            if (itemStack == null) continue;
            if (!itemStack.getItemMeta().getLocalizedName().equals(CustomItems.ROCK.name())) continue;

            int diff = itemStack.getAmount() - numberToRemove;
            if (diff < 0) {
                itemStack.setAmount(0);
                numberToRemove = Math.abs(diff);
            }
            else {
                itemStack.setAmount(diff);
                numberToRemove = 0;
            }
        }

        Location armorStandLoc = loc.clone();
        

        ArmorStand armorStand = (ArmorStand) loc.getWorld().spawnEntity(armorStandLoc, EntityType.ARMOR_STAND);
        armorStand.addScoreboardTag("mineandglory_anvil");
        armorStand.addScoreboardTag("mineandglory_anvil_percent_0");
        armorStand.addScoreboardTag("mineandglory_anvil_item_" + item.getItemMeta().getLocalizedName().replaceAll("_", "-"));

        armorStand.setCustomName(item.getItemMeta().getDisplayName() + " §e0%");
        armorStand.setCustomNameVisible(true);

        armorStand.setGravity(false);
        armorStand.setVisible(false);
        armorStand.setMarker(true);

        event.getWhoClicked().closeInventory();
    }
}

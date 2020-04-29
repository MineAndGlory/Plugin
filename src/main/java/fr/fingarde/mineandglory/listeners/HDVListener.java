package fr.fingarde.mineandglory.listeners;

import fr.fingarde.mineandglory.utils.ColorUtils;
import fr.fingarde.mineandglory.utils.HDVUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class HDVListener implements Listener
{
    @EventHandler
    public void onClickMenu(InventoryClickEvent event)
    {
        if (!event.getView().getTitle().startsWith("Hotel des ventes - page N°")) return;
        if (event.getCurrentItem() == null) return;

        event.setCancelled(true);
        ((Player) event.getWhoClicked()).updateInventory();

        ItemStack clickedItem = event.getCurrentItem();

        int nextPage = 0;
        if (clickedItem.getItemMeta().getLocalizedName().equals("NEXT")) nextPage++;
        if (clickedItem.getItemMeta().getLocalizedName().equals("PREVIOUS")) nextPage--;

        int page = Integer.parseInt(event.getView().getTitle().split("°")[1]);

        if (nextPage == 0)
        {
            HDVUtils.openItem(clickedItem, (Player) event.getWhoClicked(), page);
            return;
        }

        HDVUtils.openPage(page + nextPage, (Player) event.getWhoClicked());
    }

    @EventHandler
    public void onClickBuy(InventoryClickEvent event)
    {
        if (!event.getView().getTitle().startsWith("Hotel des ventes - Achat")) return;
        if (event.getCurrentItem() == null) return;

        event.setCancelled(true);
        ((Player) event.getWhoClicked()).updateInventory();

        ItemStack clickedItem = event.getCurrentItem();
        if (clickedItem.getItemMeta().getLocalizedName().startsWith("CANCEL:"))
        {
            int page = Integer.parseInt(clickedItem.getItemMeta().getLocalizedName().split(":")[1]);

            HDVUtils.openPage(page, (Player) event.getWhoClicked());
        }

        if (clickedItem.getItemMeta().getLocalizedName().startsWith("PLUS:"))
        {
            int nbPlus = Integer.parseInt(clickedItem.getItemMeta().getLocalizedName().split(":")[1]);
            ItemStack plus = event.getInventory().getItem(32);

            int max = event.getInventory().getItem(22).getAmount();
            int newAmount = plus.getAmount() + nbPlus;
            if (newAmount > max) newAmount = max;


            plus.setAmount(newAmount);
            ItemMeta plusMeta = plus.getItemMeta();
            plusMeta.setDisplayName("Acheter " + newAmount);
            plus.setItemMeta(plusMeta);

            event.getInventory().setItem(32, plus);
        }

        if (clickedItem.getItemMeta().getLocalizedName().startsWith("MINUS:"))
        {
            int nbMinus = Integer.parseInt(clickedItem.getItemMeta().getLocalizedName().split(":")[1]);
            ItemStack minus = event.getInventory().getItem(32);

            int newAmount = minus.getAmount() - nbMinus;
            if (newAmount < 1) newAmount = 1;

            minus.setAmount(newAmount);
            ItemMeta minusMeta = minus.getItemMeta();
            minusMeta.setDisplayName("Acheter " + newAmount);
            minus.setItemMeta(minusMeta);

            event.getInventory().setItem(32, minus);
        }

        if (clickedItem.getItemMeta().getLocalizedName().startsWith("SET:"))
        {
            int nbSet = Integer.parseInt(clickedItem.getItemMeta().getLocalizedName().split(":")[1]);
            ItemStack set = event.getInventory().getItem(32);

            set.setAmount(nbSet);
            ItemMeta setMeta = set.getItemMeta();
            setMeta.setDisplayName("Acheter " + nbSet);
            set.setItemMeta(setMeta);

            event.getInventory().setItem(32, set);
        }





        /*
        int nextPage = 0;
        if(clickedItem.getItemMeta().getLocalizedName().equals("NEXT")) nextPage++;
        if(clickedItem.getItemMeta().getLocalizedName().equals("PREVIOUS")) nextPage--;

        if(nextPage == 0) {
            HDVUtils.openItem(clickedItem, (Player) event.getWhoClicked());
            return;
        }

        int page = Integer.parseInt(event.getView().getTitle().split("°")[1]);
        HDVUtils.openPage(page + nextPage, (Player) event.getWhoClicked());*/
    }
}

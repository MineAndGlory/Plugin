package fr.fingarde.mineandglory.objects.items;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public enum CustomItems
{
    BACKPACK(Material.CARROT_ON_A_STICK, 9001, "Backpack", null),
    BIG_BACKPACK(Material.CARROT_ON_A_STICK, 9002, "Big Backpack", null),
    ENDER_BACKPACK(Material.CARROT_ON_A_STICK, 9003, "Ender Backpack", null),

    SLIME_FINDER(Material.CARROT_ON_A_STICK, 1023, "Slime Finder", null),
    BONE_MEAL_POUCH(Material.CARROT_ON_A_STICK, 1024, "Bone Meal Pouch", null),

    VILLAGER_COIN(Material.IRON_NUGGET, 901, "Villager Coin", null),
    SPAWNER_PICKAXE(Material.CARROT_ON_A_STICK, 502, "Spawner Pickaxe", null),

    RUBY(Material.IRON_NUGGET, 101, "Ruby", null),
    SAPPHIRE(Material.IRON_NUGGET, 102, "Sapphire", null),
    INOLASHITE(Material.IRON_NUGGET, 103, "Inolashite", null),
    METEORITE(Material.IRON_NUGGET, 104, "Meteorite", null),
    AREDRITE(Material.IRON_NUGGET, 105, "Aredrite", null),
    MYRTHRIL(Material.IRON_NUGGET, 106, "Mythril", null),

    PALLADIUM(Material.IRON_NUGGET, 107, "Palladium", null),
    LUMINITE(Material.IRON_NUGGET, 108, "Luminite", null),

    TOMATO(Material.APPLE, 101, "Tomato", null),

    STONE_PICKAXE_HEAD(Material.CARROT_ON_A_STICK, 34001, "Stone Pickaxe Head", new JsonParser().parse("{\"ingredient\":\"ROCK\", \"amount\":\"3\"}").getAsJsonObject()),
    STONE_AXE_HEAD(Material.CARROT_ON_A_STICK, 34002, "Stone Axe Head", new JsonParser().parse("{\"ingredient\":\"ROCK\", \"amount\":\"3\"}").getAsJsonObject()),
    STONE_SHOVEL_HEAD(Material.CARROT_ON_A_STICK, 34003, "Stone Shovel Head", new JsonParser().parse("{\"ingredient\":\"ROCK\", \"amount\":\"3\"}").getAsJsonObject()),
    STONE_HOE_HEAD(Material.CARROT_ON_A_STICK, 34004, "Stone Hoe Head", new JsonParser().parse("{\"ingredient\":\"ROCK\", \"amount\":\"3\"}").getAsJsonObject()),
    STONE_SWORD_HEAD(Material.CARROT_ON_A_STICK, 34005, "Stone Sword Head", new JsonParser().parse("{\"ingredient\":\"ROCK\", \"amount\":\"3\"}").getAsJsonObject()),
    STONE_BLACKSMITH_HAMMER_HEAD(Material.CARROT_ON_A_STICK, 34006, "Stone Blacksmith Hammer Head", new JsonParser().parse("{\"ingredient\":\"ROCK\", \"amount\":\"3\"}").getAsJsonObject()),
    STONE_DAGGER_HEAD(Material.CARROT_ON_A_STICK, 34007, "Stone Dagger Head", new JsonParser().parse("{\"ingredient\":\"ROCK\", \"amount\":\"3\"}").getAsJsonObject()),
    STONE_HAMMER_HEAD(Material.CARROT_ON_A_STICK, 34008, "Stone Hammer Head", new JsonParser().parse("{\"ingredient\":\"ROCK\", \"amount\":\"3\"}").getAsJsonObject()),
    STONE_EXCAVATOR_HEAD(Material.CARROT_ON_A_STICK, 34009, "Stone Excavator Head", new JsonParser().parse("{\"ingredient\":\"ROCK\", \"amount\":\"3\"}").getAsJsonObject()),
    STONE_SHIELD_PLATE(Material.CARROT_ON_A_STICK, 34010, "Stone Shield Plate", new JsonParser().parse("{\"ingredient\":\"ROCK\", \"amount\":\"3\"}").getAsJsonObject()),

    RUBY_HELMET(Material.LEATHER_HELMET, 101, "Ruby Helmet", new JsonParser().parse("{\"durability\":\"1652\", \"armor\":\"8\", \"armorToughness\":\"2\"}").getAsJsonObject()),
    RUBY_CHESTPLATE(Material.LEATHER_CHESTPLATE, 101, "Ruby Chestplate", new JsonParser().parse("{\"durability\":\"1652\", \"armor\":\"8\", \"armorToughness\":\"2\"}").getAsJsonObject()),
    RUBY_LEGGINGS(Material.LEATHER_LEGGINGS, 101, "Ruby Leggings", new JsonParser().parse("{\"durability\":\"1652\", \"armor\":\"8\", \"armorToughness\":\"2\"}").getAsJsonObject()),
    RUBY_BOOTS(Material.LEATHER_BOOTS, 101, "Ruby Boots", new JsonParser().parse("{\"durability\":\"1652\", \"armor\":\"8\", \"armorToughness\":\"2\"}").getAsJsonObject()),

    RUBY_PICKAXE(Material.DIAMOND_PICKAXE, 101, "Ruby Pickaxe", new JsonParser().parse("{\"durability\":\"1652\"}").getAsJsonObject()),
    RUBY_SWORD(Material.DIAMOND_SWORD, 101, "Ruby Sword", new JsonParser().parse("{\"durability\":\"1652\",\"attackDamage\":\"8\",\"attackSpeed\":\"2\"}").getAsJsonObject()),
    RUBY_SHOVEL(Material.DIAMOND_PICKAXE, 101, "Ruby Shovel", new JsonParser().parse("{\"durability\":\"1652\"}").getAsJsonObject()),
    RUBY_AXE(Material.DIAMOND_PICKAXE, 101, "Ruby Axe", new JsonParser().parse("{\"durability\":\"1652\"}").getAsJsonObject()),

    SAPPHIRE_HELMET(Material.LEATHER_HELMET, 102, "Sapphire Helmet", new JsonParser().parse("{\"durability\":\"1652\", \"armor\":\"8\", \"armorToughness\":\"2\"}").getAsJsonObject()),
    SAPPHIRE_CHESTPLATE(Material.LEATHER_CHESTPLATE, 102, "Sapphire Chestplate", new JsonParser().parse("{\"durability\":\"1652\", \"armor\":\"8\", \"armorToughness\":\"2\"}").getAsJsonObject()),
    SAPPHIRE_LEGGINGS(Material.LEATHER_LEGGINGS, 102, "Sapphire Leggings", new JsonParser().parse("{\"durability\":\"1652\", \"armor\":\"8\", \"armorToughness\":\"2\"}").getAsJsonObject()),
    SAPPHIRE_BOOTS(Material.LEATHER_BOOTS, 102, "Sapphire Boots", new JsonParser().parse("{\"durability\":\"1652\", \"armor\":\"8\", \"armorToughness\":\"2\"}").getAsJsonObject()),

    SAPPHIRE_PICKAXE(Material.DIAMOND_PICKAXE, 102, "Sapphire Pickaxe", new JsonParser().parse("{\"durability\":\"1652\"}").getAsJsonObject()),
    SAPPHIRE_SWORD(Material.DIAMOND_SWORD, 102, "Sapphire Sword", new JsonParser().parse("{\"durability\":\"1652\",\"attackDamage\":\"8\",\"attackSpeed\":\"2\"}").getAsJsonObject()),
    SAPPHIRE_SHOVEL(Material.DIAMOND_PICKAXE, 102, "Sapphire Shovel", new JsonParser().parse("{\"durability\":\"1652\"}").getAsJsonObject()),
    SAPPHIRE_AXE(Material.DIAMOND_PICKAXE, 102, "Sapphire Axe", new JsonParser().parse("{\"durability\":\"1652\"}").getAsJsonObject()),

    INOLASHITE_HELMET(Material.LEATHER_HELMET, 103, "Inolashite Helmet", new JsonParser().parse("{\"durability\":\"1652\", \"armor\":\"8\", \"armorToughness\":\"2\"}").getAsJsonObject()),
    INOLASHITE_CHESTPLATE(Material.LEATHER_CHESTPLATE, 103, "Inolashite Chestplate", new JsonParser().parse("{\"durability\":\"1652\", \"armor\":\"8\", \"armorToughness\":\"2\"}").getAsJsonObject()),
    INOLASHITE_LEGGINGS(Material.LEATHER_LEGGINGS, 103, "Inolashite Leggings", new JsonParser().parse("{\"durability\":\"1652\", \"armor\":\"8\", \"armorToughness\":\"2\"}").getAsJsonObject()),
    INOLASHITE_BOOTS(Material.LEATHER_BOOTS, 103, "Inolashite Boots", new JsonParser().parse("{\"durability\":\"1652\", \"armor\":\"8\", \"armorToughness\":\"2\"}").getAsJsonObject()),

    INOLASHITE_PICKAXE(Material.DIAMOND_PICKAXE, 103, "Inolashite Pickaxe", new JsonParser().parse("{\"durability\":\"1652\"}").getAsJsonObject()),
    INOLASHITE_SWORD(Material.DIAMOND_SWORD, 103, "Inolashite Sword", new JsonParser().parse("{\"durability\":\"1652\",\"attackDamage\":\"8\",\"attackSpeed\":\"2\"}").getAsJsonObject()),
    INOLASHITE_SHOVEL(Material.DIAMOND_PICKAXE, 103, "Inolashite Shovel", new JsonParser().parse("{\"durability\":\"1652\"}").getAsJsonObject()),
    INOLASHITE_AXE(Material.DIAMOND_PICKAXE, 103, "Inolashite Axe", new JsonParser().parse("{\"durability\":\"1652\"}").getAsJsonObject()),

    METEORITE_HELMET(Material.LEATHER_HELMET, 104, "Meteorite Helmet", new JsonParser().parse("{\"durability\":\"1652\", \"armor\":\"8\", \"armorToughness\":\"2\"}").getAsJsonObject()),
    METEORITE_CHESTPLATE(Material.LEATHER_CHESTPLATE, 104, "Meteorite Chestplate", new JsonParser().parse("{\"durability\":\"1652\", \"armor\":\"8\", \"armorToughness\":\"2\"}").getAsJsonObject()),
    METEORITE_LEGGINGS(Material.LEATHER_LEGGINGS, 104, "Meteorite Leggings", new JsonParser().parse("{\"durability\":\"1652\", \"armor\":\"8\", \"armorToughness\":\"2\"}").getAsJsonObject()),
    METEORITE_BOOTS(Material.LEATHER_BOOTS, 104, "Meteorite Boots", new JsonParser().parse("{\"durability\":\"1652\", \"armor\":\"8\", \"armorToughness\":\"2\"}").getAsJsonObject()),

    METEORITE_PICKAXE(Material.DIAMOND_PICKAXE, 104, "Meteorite Pickaxe", new JsonParser().parse("{\"durability\":\"1652\"}").getAsJsonObject()),
    METEORITE_SWORD(Material.DIAMOND_SWORD, 104, "Meteorite Sword", new JsonParser().parse("{\"durability\":\"1652\",\"attackDamage\":\"8\",\"attackSpeed\":\"2\"}").getAsJsonObject()),
    METEORITE_SHOVEL(Material.DIAMOND_PICKAXE, 104, "Meteorite Shovel", new JsonParser().parse("{\"durability\":\"1652\"}").getAsJsonObject()),
    METEORITE_AXE(Material.DIAMOND_PICKAXE, 104, "Meteorite Axe", new JsonParser().parse("{\"durability\":\"1652\"}").getAsJsonObject()),

    AREDRITE_HELMET(Material.LEATHER_HELMET, 105, "Meteorite Helmet", new JsonParser().parse("{\"durability\":\"1652\", \"armor\":\"8\", \"armorToughness\":\"2\"}").getAsJsonObject()),
    AREDRITE_CHESTPLATE(Material.LEATHER_CHESTPLATE, 105, "Meteorite Chestplate", new JsonParser().parse("{\"durability\":\"1652\", \"armor\":\"8\", \"armorToughness\":\"2\"}").getAsJsonObject()),
    AREDRITE_LEGGINGS(Material.LEATHER_LEGGINGS, 105, "Meteorite Leggings", new JsonParser().parse("{\"durability\":\"1652\", \"armor\":\"8\", \"armorToughness\":\"2\"}").getAsJsonObject()),
    AREDRITE_BOOTS(Material.LEATHER_BOOTS, 105, "Meteorite Boots", new JsonParser().parse("{\"durability\":\"1652\", \"armor\":\"8\", \"armorToughness\":\"2\"}").getAsJsonObject()),

    AREDRITE_PICKAXE(Material.DIAMOND_PICKAXE, 105, "Meteorite Pickaxe", new JsonParser().parse("{\"durability\":\"1652\"}").getAsJsonObject()),
    AREDRITE_SWORD(Material.DIAMOND_SWORD, 105, "Meteorite Sword", new JsonParser().parse("{\"durability\":\"1652\",\"attackDamage\":\"8\",\"attackSpeed\":\"2\"}").getAsJsonObject()),
    AREDRITE_SHOVEL(Material.DIAMOND_PICKAXE, 105, "Meteorite Shovel", new JsonParser().parse("{\"durability\":\"1652\"}").getAsJsonObject()),
    AREDRITE_AXE(Material.DIAMOND_PICKAXE, 105, "Meteorite Axe", new JsonParser().parse("{\"durability\":\"1652\"}").getAsJsonObject()),

    MYTHRIL_HELMET(Material.LEATHER_HELMET, 106, "Mythril Helmet", new JsonParser().parse("{\"durability\":\"1652\", \"armor\":\"8\", \"armorToughness\":\"2\"}").getAsJsonObject()),
    MYTHRIL_CHESTPLATE(Material.LEATHER_CHESTPLATE, 106, "Mythril Chestplate", new JsonParser().parse("{\"durability\":\"1652\", \"armor\":\"8\", \"armorToughness\":\"2\"}").getAsJsonObject()),
    MYTHRIL_LEGGINGS(Material.LEATHER_LEGGINGS, 106, "Mythril Leggings", new JsonParser().parse("{\"durability\":\"1652\", \"armor\":\"8\", \"armorToughness\":\"2\"}").getAsJsonObject()),
    MYTHRIL_BOOTS(Material.LEATHER_BOOTS, 106, "Mythril Boots", new JsonParser().parse("{\"durability\":\"1652\", \"armor\":\"8\", \"armorToughness\":\"2\"}").getAsJsonObject()),

    MYTHRIL_PICKAXE(Material.DIAMOND_PICKAXE, 106, "Mythril Pickaxe", new JsonParser().parse("{\"durability\":\"1652\"}").getAsJsonObject()),
    MYTHRIL_SWORD(Material.DIAMOND_SWORD, 106, "Mythril Sword", new JsonParser().parse("{\"durability\":\"1652\",\"attackDamage\":\"8\",\"attackSpeed\":\"2\"}").getAsJsonObject()),
    MYTHRIL_SHOVEL(Material.DIAMOND_PICKAXE, 106, "Mythril Shovel", new JsonParser().parse("{\"durability\":\"1652\"}").getAsJsonObject()),
    MYTHRIL_AXE(Material.DIAMOND_PICKAXE, 106, "Mythril Axe", new JsonParser().parse("{\"durability\":\"1652\"}").getAsJsonObject()),

    PALLADIUM_HELMET(Material.LEATHER_HELMET, 107, "Palladium Helmet", new JsonParser().parse("{\"durability\":\"1652\", \"armor\":\"8\", \"armorToughness\":\"2\"}").getAsJsonObject()),
    PALLADIUM_CHESTPLATE(Material.LEATHER_CHESTPLATE, 107, "Palladium Chestplate", new JsonParser().parse("{\"durability\":\"1652\", \"armor\":\"8\", \"armorToughness\":\"2\"}").getAsJsonObject()),
    PALLADIUM_LEGGINGS(Material.LEATHER_LEGGINGS, 107, "Palladium Leggings", new JsonParser().parse("{\"durability\":\"1652\", \"armor\":\"8\", \"armorToughness\":\"2\"}").getAsJsonObject()),
    PALLADIUM_BOOTS(Material.LEATHER_BOOTS, 107, "Palladium Boots", new JsonParser().parse("{\"durability\":\"1652\", \"armor\":\"8\", \"armorToughness\":\"2\"}").getAsJsonObject()),

    PALLADIUM_PICKAXE(Material.DIAMOND_PICKAXE, 107, "Palladium Pickaxe", new JsonParser().parse("{\"durability\":\"1652\"}").getAsJsonObject()),
    PALLADIUM_SWORD(Material.DIAMOND_SWORD, 107, "Palladium Sword", new JsonParser().parse("{\"durability\":\"1652\",\"attackDamage\":\"8\",\"attackSpeed\":\"2\"}").getAsJsonObject()),
    PALLADIUM_SHOVEL(Material.DIAMOND_PICKAXE, 107, "Palladium Shovel", new JsonParser().parse("{\"durability\":\"1652\"}").getAsJsonObject()),
    PALLADIUM_AXE(Material.DIAMOND_PICKAXE, 107, "Palladium Axe", new JsonParser().parse("{\"durability\":\"1652\"}").getAsJsonObject()),

    LUMINITE_HELMET(Material.LEATHER_HELMET, 108, "Luminite Helmet", new JsonParser().parse("{\"durability\":\"1652\", \"armor\":\"8\", \"armorToughness\":\"2\"}").getAsJsonObject()),
    LUMINITE_CHESTPLATE(Material.LEATHER_CHESTPLATE, 108, "Luminite Chestplate", new JsonParser().parse("{\"durability\":\"1652\", \"armor\":\"8\", \"armorToughness\":\"2\"}").getAsJsonObject()),
    LUMINITE_LEGGINGS(Material.LEATHER_LEGGINGS, 108, "Luminite Leggings", new JsonParser().parse("{\"durability\":\"1652\", \"armor\":\"8\", \"armorToughness\":\"2\"}").getAsJsonObject()),
    LUMINITE_BOOTS(Material.LEATHER_BOOTS, 108, "Luminite Boots", new JsonParser().parse("{\"durability\":\"1652\", \"armor\":\"8\", \"armorToughness\":\"2\"}").getAsJsonObject()),

    LUMINITE_PICKAXE(Material.DIAMOND_PICKAXE, 108, "Luminite Pickaxe", new JsonParser().parse("{\"durability\":\"1652\"}").getAsJsonObject()),
    LUMINITE_SWORD(Material.DIAMOND_SWORD, 108, "Luminite Sword", new JsonParser().parse("{\"durability\":\"1652\",\"attackDamage\":\"8\",\"attackSpeed\":\"2\"}").getAsJsonObject()),
    LUMINITE_SHOVEL(Material.DIAMOND_PICKAXE, 108, "Luminite Shovel", new JsonParser().parse("{\"durability\":\"1652\"}").getAsJsonObject()),
    LUMINITE_AXE(Material.DIAMOND_PICKAXE, 108, "Luminite Axe", new JsonParser().parse("{\"durability\":\"1652\"}").getAsJsonObject()),

    SACRIFICE_DAGGER(Material.DIAMOND_SWORD, 304, "Sacrifice Dagger", new JsonParser().parse("{\"durability\":\"1652\",\"attackDamage\":\"8\",\"attackSpeed\":\"2\"}").getAsJsonObject()),

    SOUL_FIRE(Material.IRON_NUGGET, 3001, "Soul Of Fire", null),
    SOUL_AIR(Material.IRON_NUGGET, 3002, "Soul Of Air", null),
    SOUL_EARTH(Material.IRON_NUGGET, 3003, "Soul Of Earth", null),
    SOUL_WATER(Material.IRON_NUGGET, 3004, "Soul Of Water", null),
    SOUL_VOID(Material.IRON_NUGGET, 3005, "Soul Of Void", null),
    SOUL_MAGIC(Material.IRON_NUGGET, 3006, "Soul Of Magic", null),

    DRAGON_SCALE(Material.IRON_NUGGET, 3021, "Dragon Scale", null),
    WITHER_BONE(Material.IRON_NUGGET, 3022, "Wither Bone", null),
    BAT_WING(Material.IRON_NUGGET, 3023, "Bat Wing", null),
    CURSED_FLAMME(Material.IRON_NUGGET, 3024, "Cursed Flame", null),
    FORBIDDEN_FRAGMENT(Material.IRON_NUGGET, 3025, "Forbidden Fragment", null),
    FROST_CORE(Material.IRON_NUGGET, 3026, "Frost Core", null),
    SPIDER_EGG(Material.IRON_NUGGET, 3027, "Spider Egg", null),
    ROCK(Material.IRON_NUGGET, 3028, "Rock", null),

    /*
    BACKPACK(Material.IRON_NUGGET, 1000, "Backpack", new JsonParser().parse("{ \"type\": \"item\"}").getAsJsonObject()),
    RUBY, /give @p minecraft:leather_chestplate{display:{Name:'{"text":"Ruby Chestplate"}',color:16722217}} 1
    SAPPHIRE, /give @p minecraft:leather_chestplate{display:{Name:'{"text":"Sapphire Chestplate"}',color:1246207}} 1
    INOLASHITE, /give @p minecraft:leather_chestplate{display:{Name:'{"text":"Inolashite Chestplate"}',color:16769574}} 1
    METEORITE, /give @p minecraft:leather_chestplate{display:{Name:'{"text":"Meterotite Chestplate"}',color:2883338}} 1
    AREDRITE, /give @p minecraft:leather_chestplate{display:{Name:'{"text":"Aredrite Chestplate"}',color:11927516}} 1
    MYRTHRIL, /give @p minecraft:leather_chestplate{display:{Name:'{"text":"Mythril Chestplate"}',color:7157439}} 1
    PALLADIUM, /give @p minecraft:leather_chestplate{display:{Name:'{"text":"Palladium Chestplate"}',color:16711680}} 1
    TARTARITE, /give @p minecraft:leather_chestplate{display:{Name:'{"text":"Tartarite Chestplate"}',color:862}} 1

*/
    NULL(null, 0, null, null);

    private Material material;
    private int customModelData;
    private String title;
    private JsonObject data;

    CustomItems(Material material, int customModelData, String title, JsonObject data)
    {
        this.material = material;
        this.customModelData = customModelData;
        this.title = title;
        this.data = data;
    }
    
    public JsonObject getData()
    {
        return data;
    }

    public static ItemStack getFromValue(CustomItems customItems)
    {
        ItemStack item = new ItemStack(customItems.material);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName("§r" + customItems.title);
        meta.setCustomModelData(customItems.customModelData);

        meta.setLocalizedName(customItems.name());
        item.setItemMeta(meta);
        return item;
    }
}

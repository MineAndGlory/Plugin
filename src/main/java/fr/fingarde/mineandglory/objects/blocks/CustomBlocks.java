package fr.fingarde.mineandglory.objects.blocks;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.bukkit.Material;

public enum CustomBlocks
{
    CARROTS_STAGE0(Material.CARROTS, new JsonParser().parse("{\"age\":\"1\"}").getAsJsonObject()),
    CARROTS_STAGE1(Material.CARROTS, new JsonParser().parse("{\"age\":\"3\"}").getAsJsonObject()),
    CARROTS_STAGE2(Material.CARROTS, new JsonParser().parse("{\"age\":\"5\"}").getAsJsonObject()),
    CARROTS_STAGE3(Material.CARROTS, new JsonParser().parse("{\"age\":\"7\"}").getAsJsonObject()),

    TOMATO_STAGE0(Material.CARROTS, new JsonParser().parse("{\"age\":\"0\"}").getAsJsonObject()),
    TOMATO_STAGE1(Material.CARROTS, new JsonParser().parse("{\"age\":\"2\"}").getAsJsonObject()),
    TOMATO_STAGE2(Material.CARROTS, new JsonParser().parse("{\"age\":\"4\"}").getAsJsonObject()),
    TOMATO_STAGE3(Material.CARROTS, new JsonParser().parse("{\"age\":\"6\"}").getAsJsonObject()),

    POTATOES_STAGE0(Material.POTATOES, new JsonParser().parse("{\"age\":\"1\"}").getAsJsonObject()),
    POTATOES_STAGE1(Material.POTATOES, new JsonParser().parse("{\"age\":\"3\"}").getAsJsonObject()),
    POTATOES_STAGE2(Material.POTATOES, new JsonParser().parse("{\"age\":\"5\"}").getAsJsonObject()),
    POTATOES_STAGE3(Material.POTATOES, new JsonParser().parse("{\"age\":\"7\"}").getAsJsonObject()),

    LETTUCE_STAGE0(Material.POTATOES, new JsonParser().parse("{\"age\":\"0\"}").getAsJsonObject()),
    LETTUCE_STAGE1(Material.POTATOES, new JsonParser().parse("{\"age\":\"2\"}").getAsJsonObject()),
    LETTUCE_STAGE2(Material.POTATOES, new JsonParser().parse("{\"age\":\"4\"}").getAsJsonObject()),
    LETTUCE_STAGE3(Material.POTATOES, new JsonParser().parse("{\"age\":\"6\"}").getAsJsonObject()),

    WHEAT_STAGE0(Material.WHEAT, new JsonParser().parse("{\"age\":\"1\"}").getAsJsonObject()),
    WHEAT_STAGE1(Material.WHEAT, new JsonParser().parse("{\"age\":\"3\"}").getAsJsonObject()),
    WHEAT_STAGE2(Material.WHEAT, new JsonParser().parse("{\"age\":\"5\"}").getAsJsonObject()),
    WHEAT_STAGE3(Material.WHEAT, new JsonParser().parse("{\"age\":\"7\"}").getAsJsonObject()),

    RICE_STAGE0(Material.WHEAT, new JsonParser().parse("{\"age\":\"0\"}").getAsJsonObject()),
    RICE_STAGE1(Material.WHEAT, new JsonParser().parse("{\"age\":\"2\"}").getAsJsonObject()),
    RICE_STAGE2(Material.WHEAT, new JsonParser().parse("{\"age\":\"4\"}").getAsJsonObject()),
    RICE_STAGE3(Material.WHEAT, new JsonParser().parse("{\"age\":\"6\"}").getAsJsonObject()),

    STRAWBERRY_STAGE0(Material.CARROTS, new JsonParser().parse("{\"age\":\"0\"}").getAsJsonObject()),
    STRAWBERRY_STAGE1(Material.CARROTS, new JsonParser().parse("{\"age\":\"2\"}").getAsJsonObject()),

    RASPBERRY_STAGE0(Material.CARROTS, new JsonParser().parse("{\"age\":\"1\"}").getAsJsonObject()),
    RASPBERRY_STAGE1(Material.CARROTS, new JsonParser().parse("{\"age\":\"3\"}").getAsJsonObject());

    private Material material;
    private JsonObject data;

    CustomBlocks(Material material, JsonObject data)
    {
        this.material = material;
        this.data = data;
    }

    public JsonObject getData()
    {
        return data;
    }

    public Material getMaterial()
    {
        return material;
    }
}

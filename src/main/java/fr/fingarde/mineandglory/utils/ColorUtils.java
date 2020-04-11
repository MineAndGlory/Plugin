package fr.fingarde.mineandglory.utils;

public class ColorUtils
{
    public static String removeColor(String str) {
        return str.replaceAll("§.", "");
    }

    public static String encodeAmperstamp(String str) {
        return str.replaceAll("&", "§");
    }
}

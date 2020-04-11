package fr.fingarde.mineandglory.utils;

public class ColorUtils
{
    public static String removeColor(String str) {
        return str.replaceAll("§.", "");
    }

    public static String encodeAmperstamp(String str) {
        return str.replaceAll("&", "§");
    }

    public static String hideChars(String line)
    {
        String serialized = "";
        for (char c : line.toCharArray())
        {
            serialized += "§" + c;
        }

        return serialized;
    }

    public static String unhideChars(String line)
    {
        return line.replaceAll("§", "");
    }
}

package fr.fingarde.mineandglory.utils;

public class LoreSerializer {
    public static String serialize(String line) {
        String serialized = "";
        for(char c : line.toCharArray()) {
            serialized += "§" + c;
        }

        return serialized;
    }

    public static String deserialize(String line) {
        return  line.replaceAll("§", "");
    }
}

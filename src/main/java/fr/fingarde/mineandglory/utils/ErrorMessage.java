package fr.fingarde.mineandglory.utils;

public class ErrorMessage
{
    public static String noPermissionMessage(String permission) {
        return "Vous n'avez pas la permission: ";
    }

    public static String onlyPlayer() {
        return "Cette command est uniquement utilisable par les joueurs ";
    }
}

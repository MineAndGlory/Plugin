package fr.fingarde.mineandglory.utils;

public class ErrorMessage
{
    public static String noPermissionMessage(String permission) {
        return "Vous n'avez pas la permission: ";
    }

    public static String onlyPlayer() {
        return "Cette command est uniquement utilisable par les joueurs ";
    }

    public static String onlyOnPlayer() {
        return "Cette command est uniquement utilisable sur des joueurs ";
    }

    public static String playerNotFound() {
        return "Joueur introuvable";
    }

    public static String emptyHand()
    {
        return "Vous devez tenir un item en main";
    }

    public static String invalidPrice()
    {
        return "Ce prix n'est pas correct";
    }

    public static String inventoryFull()
    {
        return "Vous n'avez plus de place dans votre inventaire";
    }
}

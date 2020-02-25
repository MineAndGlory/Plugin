package fr.fingarde.mineandglory.objects.jobs;

public enum Miner {
    BREAK_STONE(1);

    private int xp;

    Miner(int xp) {
        this.xp = xp;
    }

    public int getXp() {
        return xp;
    }
}

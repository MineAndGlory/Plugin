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

    public static int getXp(String value) {
        for (Miner miner : Miner.values()) {
            if (miner.name().equals(value)) {
                return miner.xp;
            }
        }

        return 0;
    }
}

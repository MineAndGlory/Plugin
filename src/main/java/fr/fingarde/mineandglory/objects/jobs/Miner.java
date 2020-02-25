package fr.fingarde.mineandglory.objects.jobs;

public enum Miner {
    BREAK_STONE(2),
    BREAK_COAL_ORE(50),
    BREAK_IRON_ORE(75),
    BREAK_GOLD_ORE(100),
    BREAK_DIAMOND_ORE(200),
    BREAK_EMERALD_ORE(300);

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
